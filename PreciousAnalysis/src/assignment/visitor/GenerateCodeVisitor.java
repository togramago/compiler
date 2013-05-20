package assignment.visitor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import assignment.Error;
import assignment.instruction.Instruction;
import assignment.output.ClassFile;
import assignment.output.ClassRepository;
import assignment.scope.ClassRecord;
import assignment.scope.Code;
import assignment.scope.MethodRecord;
import assignment.scope.Record;
import assignment.scope.SymbolTable;

/**
 * Traverses the tree once: generates code instructions. Fourth traversal.
 */
public class GenerateCodeVisitor extends AbstractVisitor {

    private final SymbolTable symbolTable;
    private MethodRecord currentMethod;
    private ClassRecord currentClass;
    private final List<ClassFile> classfileList;
    private final StringBuilder log;
    private boolean inExpression;
    private final ClassRepository repository;

    /**
     * @param symbolTable already filled
     * @param log         for errors
     */
    public GenerateCodeVisitor(final SymbolTable symbolTable,
                               final StringBuilder log) {
        super();
        this.symbolTable = symbolTable;
        symbolTable.resetTable();
        this.log = log;
        inExpression = false;
        classfileList = new ArrayList<ClassFile>();
        repository = new ClassRepository("GenerateCodeVisitor", log);
    }

    /**
     * Visits method declarations
     */
    public Object visitMethodDecl(final CommonTree node) {
        final String mName = node.getChild(1).getText();
        currentMethod = (MethodRecord) symbolTable.lookup(mName, Record.METHOD);
        symbolTable.enterScope();
        visit((CommonTree) node.getChild(2));
        visit((CommonTree) node.getChild(3));
        symbolTable.exitScope();
        return null;
    }

    /**
     * Visits class.
     */
    @Override
    public Object visitClass(final CommonTree node) {
        final String mName = node.getChild(0).getText();
        currentClass = (ClassRecord) symbolTable.lookup(mName, Record.CLASS);
        symbolTable.enterScope();
        CommonTree child = (CommonTree) node.getChild(1);
        visit(child); // varDeclarationList
        child = (CommonTree) node.getChild(2);
        visit(child); // methodDeclarationList
        symbolTable.exitScope();
        manageClassFile();
        return null;
    }

    /**
     * Add new classfile to the list and to the repository.
     */
    private void manageClassFile() {
        final ClassFile classFile = currentClass.getClassFile(log);
        classfileList.add(classFile);
        repository.addClassFile(classFile);
    }

    /**
     * Visits the main class.
     */
    @Override
    public Object visitMainClass(final CommonTree node) {
        final String mName = node.getChild(0).getText();
        currentClass = (ClassRecord) symbolTable.lookup(mName, Record.CLASS);

        symbolTable.enterScope();
        visit((CommonTree) node.getChild(1)); // mainMethod
        symbolTable.exitScope();
        manageClassFile();
        repository.setMainName(mName);
        return null;
    }

    /**
     * Visits main method in main class
     */
    @Override
    public Object visitMainMethod(final CommonTree node) {
        symbolTable.enterScope();
        currentMethod = (MethodRecord) symbolTable.lookup(Record.MAIN,
                Record.METHOD);
        visit((CommonTree) node.getChild(0)); // parameter list
        visit((CommonTree) node.getChild(1)); // statements
        symbolTable.exitScope();
        addInstrToCurMethod(new Instruction(Code.STOP, null), "main method");
        return null;
    }

    /**
     * Visits variable reference
     *
     * @return index of variable
     */
    @Override
    public Integer visitVarRef(final CommonTree node) {
        if (inExpression) {
            final String mName = node.getChild(0).getText();
            final int index = currentMethod.getIndexOf(mName);
            addInstrToCurMethod(new Instruction(Code.ILOAD, index), "varref");
        } else {
            super.visitVarRef(node);
        }
        return null;
    }

    @Override
    public Object visitPlus(final CommonTree node) {
        return expression(node, new Instruction(Code.IADD, null), "plus");
    }

    @Override
    public Object visitMinus(final CommonTree node) {
        return expression(node, new Instruction(Code.ISUB, null), "minus");
    }

    @Override
    public Object visitMult(final CommonTree node) {
        return expression(node, new Instruction(Code.IMUL, null), "multiply");
    }

    @Override
    public Object visitAssign(final CommonTree node) {
        inExpression = true;
        visit((CommonTree) node.getChild(1));
        inExpression = false;
        visit((CommonTree) node.getChild(0));
        final String varL = node.getChild(0).getChild(0).getText();
        addInstrToCurMethod(
                new Instruction(Code.ISTORE, currentMethod.getIndexOf(varL)),
                "assign");
        return null;
    }

    @Override
    public Object visitConst(final CommonTree node) {
        String childText = node.getChild(0).getText();
        if (Record.TRUE.equals(childText)) {
            childText = "1";
        } else if (Record.FALSE.equals(childText)) {
            childText = "0";
        }
        addInstrToCurMethod(new Instruction(Code.ICONST, Integer.valueOf(childText)), childText);
        return null;
    }

    @Override
    public Object visitSysout(final CommonTree node) {
        inExpression = true;
        super.visitSysout(node);
        addInstrToCurMethod(new Instruction(Code.PRINT, null), node.getChild(0)
                .getText());
        inExpression = false;
        return null;
    }

    @Override
    public Object visitMethodCall(final CommonTree node) {
        super.visitMethodCall(node);
        final String className = getGrandChildName((CommonTree) node
                .getChild(0));
        final String methodName = getGrandChildName((CommonTree) node
                .getChild(1));
        addInstrToCurMethod(new Instruction(Code.INVOKEVIRTUAL, className + "."
                + methodName), node.getChild(0).getText());
        return null;
    }

    /**
     * Get name of grandchild node
     *
     * @param child used to get grandchild
     * @return name of grandchild node
     */
    private String getGrandChildName(final CommonTree child) {
        String childName = null;
        if (child != null) {
            if ("this".equals(child.getText())) {
                childName = currentClass.getName();
            } else {
                final CommonTree grandChild = (CommonTree) child.getChild(0);
                if (grandChild != null) {
                    childName = grandChild.getText();
                }
            }
        }
        return childName;
    }

    @Override
    Object visitParamList(CommonTree node) {
        for (int i = node.getChildCount()-1; i >= 0; i--){
            visit((CommonTree) node.getChild(i));
        }
        return null;
    }

    @Override
    public Object visitParam(final CommonTree node) {
        super.visitParam(node);
        final String paramName = node.getChild(1).getText();
        final int index = currentMethod.getIndexOf(paramName);
        addInstrToCurMethod(new Instruction(Code.ISTORE, index), paramName);
        return null;
    }


    @Override
    public Object visitVarDecl(final CommonTree node) {
        super.visitVarDecl(node);
        return null;
    }

    /**
     * Add instruction to current method's instruction list
     *
     * @param instruction  to add
     * @param errorMessage in case of failure
     */
    private void addInstrToCurMethod(final Instruction instruction,
                                     final String errorMessage) {
        if (currentMethod == null) {
            Error.complain(Error.GC_OUT_OF_METHOD_EXCEPTION, errorMessage,
                    null, log);
        } else {
            currentMethod.addInstruction(instruction);
        }
    }

    @Override
    public Object visitLt(final CommonTree node) {
        return expression(node, new Instruction(Code.ILT, null), "lt");
    }

    /**
     * Standard actions for expressions with 2 children (+, -, *, <, &&)
     *
     * @param node parent node
     */
    private Object expression(final CommonTree node,
                              final Instruction instruction, final String errorMessage) {
        inExpression = true;
        visit((CommonTree) node.getChild(0));
        visit((CommonTree) node.getChild(1));
        addInstrToCurMethod(instruction, errorMessage);
        inExpression = false;
        return null;
    }

    @Override
    public Object visitIf(final CommonTree node) {
        visit((CommonTree) node.getChild(0));
        final Instruction if_false = new Instruction(Code.IF_FALSE, null);
        final Instruction last = new Instruction(Code.GOTO, null);
        currentMethod.addInstruction(if_false);
        visit((CommonTree) node.getChild(1));
        if_false.setArgument(currentMethod.getInstructionIndex());
        currentMethod.addInstruction(last);
        visit((CommonTree) node.getChild(2));
        last.setArgument(currentMethod.getInstructionIndex());
        return null;
    }

    @Override
    public Object visitWhile(final CommonTree node) {
        final int index = currentMethod.getInstructionIndex();
        visit((CommonTree) node.getChild(0));
        final Instruction if_false = new Instruction(Code.IF_FALSE, null);
        currentMethod.addInstruction(if_false);
        visit((CommonTree) node.getChild(1));

        currentMethod.addInstruction(new Instruction(Code.GOTO, index));
        if_false.setArgument(currentMethod.getInstructionIndex());
        return null;
    }

    @Override
    public Object visitReturn(final CommonTree node) {
        inExpression = true;
        visit((CommonTree) node.getChild(0));
        inExpression = false;
        currentMethod.addInstruction(new Instruction(Code.RETURN, null));
        return null;
    }

    @Override
    public Object visitUnaryNot(final CommonTree node) {
        inExpression = true;
        visit((CommonTree) node.getChild(0));
        inExpression = false;
        currentMethod.addInstruction(new Instruction(Code.INOT, null));
        return null;
    }

    @Override
    public Object visitLogicAnd(final CommonTree node) {
        return expression(node, new Instruction(Code.IAND, null), "and");
    }

    /**
     * Save class files list to repository.
     *
     * @return class repository with list of class files
     */
    public ClassRepository getClassRepository() {
        repository.save();
        return repository;
    }

}
