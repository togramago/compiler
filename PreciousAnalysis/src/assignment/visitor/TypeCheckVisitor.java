package assignment.visitor;

import org.antlr.runtime.tree.CommonTree;

import assignment.scope.ClassRecord;
import assignment.scope.MethodRecord;
import assignment.scope.Record;
import assignment.scope.SymbolTable;
import assignment.scope.VariableRecord;
import assignment.Error;

/**
 * Traverses the tree once and checks for type mismatch on the third turn.
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class TypeCheckVisitor extends AbstractVisitor {

    private static final String METHOD_CALL = "method call";

    private transient final SymbolTable symbolTable;
    private transient MethodRecord currentMethod;
    private transient ClassRecord currentClass;
    private transient final StringBuilder log;

    /**
     * @param symbolTable already filled
     * @param log         for errors
     */
    public TypeCheckVisitor(final SymbolTable symbolTable,
                            final StringBuilder log) {
        super();
        this.symbolTable = symbolTable;
        symbolTable.resetTable();
        this.log = log;
    }

    /**
     * Visits method declarations
     */
    public Object visitMethodDecl(final CommonTree node) {
        final String mName = node.getChild(1).getText();

        currentMethod = (MethodRecord) symbolTable.lookup(mName, Record.METHOD);
        if (currentMethod == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, mName, null, log);
        } else {
            symbolTable.enterScope();
            visit((CommonTree) node.getChild(2));
            visit((CommonTree) node.getChild(3));
            symbolTable.exitScope();
        }
        return null;
    }

    /**
     * @return VariableRecord from the node
     */
    @Override
    public VariableRecord visitVarDecl(final CommonTree node) {
        final String type = (String) visit((CommonTree) node.getChild(0));
        final String mName = node.getChild(1).getText();
        return new VariableRecord(mName, type);
    }

    @Override
    public String visitTypeRef(final CommonTree node) {
        return node.getChild(0).getText();
    }

    /**
     * Visits class.
     */
    @Override
    public Object visitClass(final CommonTree node) {
        final String mName = node.getChild(0).getText();
        currentClass = (ClassRecord) symbolTable.lookup(mName, Record.CLASS);
        if (currentClass == null) {
            Error.complain(Error.CLASS_EXCEPTION, mName, null, log);
        } else {
            symbolTable.enterScope();
            CommonTree child = (CommonTree) node.getChild(1);
            visit(child); // varDeclarationList
            child = (CommonTree) node.getChild(2);
            visit(child); // methodDeclarationList
            symbolTable.exitScope();
        }
        return null;
    }

    /**
     * Visits the main class.
     */
    @Override
    public Object visitMainClass(final CommonTree node) {
        final String mName = node.getChild(0).getText();
        currentClass = (ClassRecord) symbolTable.lookup(mName, Record.CLASS);
        if (currentClass == null) {
            Error.complain(Error.CLASS_EXCEPTION, mName, null, log);
        } else {
            symbolTable.enterScope();
            visit((CommonTree) node.getChild(1)); // mainMethod
            symbolTable.exitScope();
        }
        return null;
    }

    /**
     * Visits main method in main class
     */
    @Override
    public Object visitMainMethod(final CommonTree node) {

        currentMethod = (MethodRecord) symbolTable.lookup(Record.MAIN,
                Record.METHOD);
        if (currentMethod == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, Record.MAIN, null, log);
        } else {
            symbolTable.enterScope();
            visit((CommonTree) node.getChild(0)); // parameter list
            visit((CommonTree) node.getChild(1)); // statements
            symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public VariableRecord visitParam(final CommonTree node) {
        final String type = (String) visit((CommonTree) node.getChild(0));
        final String mName = node.getChild(1).getText();
        return new VariableRecord(mName, type);
    }

    /**
     * Visits and validates plus operation
     *
     * @return VariableRecord (name, integer)
     */
    @Override
    public VariableRecord visitPlus(final CommonTree node) {
        checkExpression(node, Record.INT);
        return new VariableRecord("addExpr", Record.INT);
    }

    /**
     * Visits and validates minus operation
     *
     * @return VariableRecord (name, integer)
     */
    @Override
    public VariableRecord visitMinus(final CommonTree node) {
        checkExpression(node, Record.INT);
        return new VariableRecord("subExpr", Record.INT);
    }

    /**
     * Validates arithmetic or logical expression nodes. Visits their children
     * and checks their types.
     *
     * @param node arithmetic or logical expression
     * @param type correct type of node's children
     */
    private void checkExpression(final CommonTree node, final String type) {
        final int childCount = node.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final CommonTree child = (CommonTree) node.getChild(i);
            final Record var = (Record) visit(child);
            if (var == null) {
                Error.complain(Error.NULL_POINTER_EXCEPTION, null,
                        currentMethod, log);
            } else if (!var.getType().equals(type)) {
                Error.complain(Error.TYPE_MISMATCH_EXCEPTION, var.getName(),
                        currentMethod, log);
            }
        }
    }

    /**
     * Visits multiply expression node.
     *
     * @return VariableRecord (name, integer).
     */
    @Override
    public VariableRecord visitMult(final CommonTree node) {
        checkExpression(node, Record.INT);
        return new VariableRecord("multExpr", Record.INT);
    }

    /**
     * @return VariableRecord found variable from the symbol table
     */
    @Override
    public VariableRecord visitVarRef(final CommonTree node) {
        final String childText = node.getChild(0).getText();
        final VariableRecord var = (VariableRecord) symbolTable.lookup(
                childText, Record.VARIABLE);
        if (var == null) {
            Error.complain(Error.UNEXPECTED_ERROR, childText, currentMethod,
                    log);
        }
        return var;
    }

    @Override
    public Object visitUnaryNot(final CommonTree node) {
        checkExpression(node, Record.BOOLEAN);
        return new VariableRecord("unaryNotExpr", Record.BOOLEAN);
    }

    /**
     * Visits '<' expression node.
     *
     * @return VariableRecord (name, boolean).
     */
    @Override
    public VariableRecord visitLt(final CommonTree node) {
        checkExpression(node, Record.INT);
        return new VariableRecord("ltExpr", Record.BOOLEAN);
    }

    /**
     * Visits '&&' expression node.
     *
     * @return VariableRecord (name, boolean).
     */
    @Override
    public VariableRecord visitLogicAnd(final CommonTree node) {
        checkExpression(node, Record.BOOLEAN);
        return new VariableRecord("logicAndExpr", Record.BOOLEAN);
    }

    /**
     * Visits '||' expression node.
     *
     * @return VariableRecord (name, boolean).
     */
    @Override
    public VariableRecord visitLogicOr(final CommonTree node) {
        checkExpression(node, Record.BOOLEAN);
        return new VariableRecord("ltExpr", Record.BOOLEAN);
    }

    /**
     * Visits '=' node. <br>
     * Checks for type equality.
     *
     * @return VariableRecord(name, left assign type) or null.
     */
    @Override
    public VariableRecord visitAssign(final CommonTree node) {
        final VariableRecord varL = (VariableRecord) visit((CommonTree) node
                .getChild(0));
        final CommonTree tree = (CommonTree) node.getChild(1);
        final Record varR = (Record) visit(tree);
        VariableRecord result;
        if ((varL == null) || (varR == null)) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
            result = new VariableRecord("assignExpr", Record.INT);
        } else {
            String ltype = varL.getType();
            String rtype = varR.getType();
            if (varL.getType().equals("ARRAY_TYPE")) {
                ltype = Record.INT;
            }

            if (varR.getType().equals("ARRAY_TYPE")) {
                rtype = Record.INT;
            }

            if (!ltype.equals(rtype)) {
                Error.complain(Error.TYPE_MISMATCH_EXCEPTION, varR.getName()
                        + " != " + varL.getName(), currentMethod, log);
            }
            result = new VariableRecord("assignExpr", varL.getType());
        }

        return result;
    }

    @Override
    public Object visitIntArrayNew(final CommonTree node) {
        return visit((CommonTree) node.getChild(0));
    }

    /**
     * @return VariableRecord(name, new node type);
     */
    @Override
    public VariableRecord visitNew(final CommonTree node) {
        return new VariableRecord("new", node.getChild(0).getText());
    }

    /**
     * Visits method call. <br>
     * Checks if method exist and method's parameter list size.
     *
     * @return MethodRecord found in symbol table.
     */
    @Override
    public MethodRecord visitMethodCall(final CommonTree node) {
        final VariableRecord varref = (VariableRecord) visit((CommonTree) node
                .getChild(0));
        final MethodRecord method = (MethodRecord) visit((CommonTree) node
                .getChild(1));
        MethodRecord result = null;
        if (varref == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, METHOD_CALL, null, log);
        } else {
            final ClassRecord record = (ClassRecord) symbolTable.lookup(
                    varref.getType(), Record.CLASS);
            if (record == null) {
                Error.complain(Error.CLASS_EXCEPTION, METHOD_CALL, null, log);
            } else {
                result = verifyMethod(varref, (CommonTree) node.getChild(1)
                        .getChild(1), method, record);
            }
        }
        return result;
    }

    /**
     * Verifies method's parameter list.
     *
     * @param varref    variable on which method was called
     * @param childNode method's detail node
     * @param method    called method
     * @param curClass  method's class
     * @return found MethodRecord with details from curClass
     */
    private MethodRecord verifyMethod(final VariableRecord varref,
                                      final CommonTree childNode, final MethodRecord method,
                                      final ClassRecord curClass) {

        final MethodRecord foundMethod = curClass.getMethodIfExists(method);
        if (foundMethod == null) {
            Error.complain(Error.METHOD_EXCEPTION, METHOD_CALL, null, log);
        } else {
            final int childSize = childNode.getChildCount();
            if (childSize == foundMethod.getParamListSize()) {
                for (int i = 0; i < childSize; i++) {
                    final VariableRecord varChild = (VariableRecord) visit((CommonTree) childNode
                            .getChild(i));
                    if (varChild == null) {
                        Error.complain(
                                Error.NULL_POINTER_EXCEPTION,
                                varref.getName() + "." + foundMethod.toString(),
                                null, log);
                    } else {
                        final String parameterType = foundMethod
                                .getParameterType(i);
                        if (parameterType == null) {
                            Error.complain(Error.NULL_POINTER_EXCEPTION,
                                    METHOD_CALL, null, log);
                        } else if (!varChild.getType().equals(parameterType)) {
                            Error.complain(
                                    Error.DECLARATION_MISMATCH_EXCEPTION,
                                    varChild.getName() + " in "
                                            + varref.getName() + "."
                                            + foundMethod.toString(), null, log);
                        }
                    }
                }
            } else {
                Error.complain(
                        Error.DECLARATION_MISMATCH_EXCEPTION,
                        "parameter list size of " + method.toString() + " in "
                                + currentClass.toString() + "." + currentMethod,
                        null, log);
            }
        }
        return foundMethod;
    }

    /**
     * Visits suffix part of method call.
     *
     * @return MethodRecord with name and no details
     */
    @Override
    public MethodRecord visitSuffixPart(final CommonTree node) {
        final String name = node.getChild(0).getText();
        final MethodRecord method = new MethodRecord(name, null, null);
        visit((CommonTree) node.getChild(1));
        return method;
    }

    /**
     * Visits return statement and checks return type.
     *
     * @return Record that contains return statement details
     */
    @Override
    public Record visitReturn(final CommonTree node) {
        final Record returnVar = (Record) visit((CommonTree) node.getChild(0));
        if (returnVar == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
        } else {
            if ((currentMethod != null)
                    && (!returnVar.getType().equals(currentMethod.getType()))) {
                Error.complain(Error.DECLARATION_MISMATCH_EXCEPTION,
                        "return expression", currentMethod, log);
            }
        }

        return returnVar;
    }

    /**
     * Visits 'if' construction.
     *
     * @return Record that contains condition details
     */
    @Override
    public Record visitIf(final CommonTree node) {
        return checkCondition((Record) visit((CommonTree) node.getChild(0)));
    }

    /**
     * Validates condition statement and type equality of it's children.
     *
     * @param ifvar condition statement
     * @return Record (name, boolean)
     */
    private Record checkCondition(final Record ifvar) {
        Record result = ifvar;
        if (ifvar == null) {
            result = new VariableRecord("condition", Record.BOOLEAN);
        } else {
            if (!ifvar.getType().equals(Record.BOOLEAN)) {
                Error.complain(Error.TYPE_MISMATCH_EXCEPTION, ifvar.getName(),
                        currentMethod, log);
                result.setType(Record.BOOLEAN);
            }
        }
        return result;
    }

    /**
     * Validates 'while' condition statement and type equality of it's children.
     *
     * @return Record (name, boolean)
     */
    @Override
    public Record visitWhile(final CommonTree node) {
        return checkCondition((Record) visit((CommonTree) node.getChild(0)));
    }

    /**
     * Visits System.out.println calls and makes sure it's parameter is integer.
     *
     * @return Record(name, integer)
     */
    @Override
    public Record visitSysout(final CommonTree node) {
        final Record record = (Record) visit((CommonTree) node.getChild(0));
        if (record == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
        } else {
            if (!record.getType().equals(Record.INT)) {
                Error.complain(Error.NOT_INTEGER_EXCEPTION, record.getName(),
                        currentMethod, log);
                record.setType(Record.INT);
            }
        }
        return record;
    }

    /**
     * Visits array call. Make sure array index is integer.
     *
     * @return VariableRecord(name, integer)
     */
    @Override
    public VariableRecord visitArrayRead(final CommonTree node) {
        final VariableRecord record = (VariableRecord) visit((CommonTree) node
                .getChild(1));
        checkBraces(record);
        final VariableRecord varref = (VariableRecord) visit((CommonTree) node
                .getChild(0)); // ARRAY_TYPE
        if (!varref.getType().equals(Record.ARRAY_TYPE)) {
            Error.complain(Error.TYPE_BRACES_EXCEPTION, varref.getName(),
                    currentMethod, log);
        }
        return new VariableRecord("arrayRead", Record.INT);
    }

    /**
     * Visits array assign node. Make sure array index is integer. Check right
     * part of assign statement to be integer.
     *
     * @return VariableRecord (name, integer)
     */
    @Override
    public VariableRecord visitArrayAssign(final CommonTree node) {
        final VariableRecord varref = (VariableRecord) visit((CommonTree) node
                .getChild(0)); // ARRAY_TYPE
        final VariableRecord record = (VariableRecord) visit((CommonTree) node
                .getChild(1)); // INT
        checkBraces(record);
        final VariableRecord assign = (VariableRecord) visit((CommonTree) node
                .getChild(2));// INT
        if ((varref == null) || (assign == null)) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
        } else {
            if (!assign.getType().equals(Record.INT)) {
                Error.complain(Error.TYPE_MISMATCH_EXCEPTION, assign.getName(),
                        currentMethod, log);
            }
            if (!varref.getType().equals(Record.ARRAY_TYPE)) {
                Error.complain(Error.TYPE_BRACES_EXCEPTION, varref.getName(),
                        currentMethod, log);
            }
        }
        return new VariableRecord("arrayAssign", Record.INT);
    }

    /**
     * Make sure that array index in '[ ]' is integer.
     *
     * @param record array index to check
     */
    private void checkBraces(final VariableRecord record) {
        if (record == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
        } else {
            if (!record.getType().equals(Record.INT)) {
                Error.complain(Error.NOT_INTEGER_EXCEPTION, record.getName(),
                        currentMethod, log);
                record.setType(Record.INT);
            }
        }
    }

    /**
     * Visits length call on arrays. Make sure that it is applied only to
     * arrays.
     *
     * @return VariableRecord (name, integer)
     */
    @Override
    public VariableRecord visitArrayLengthReference(final CommonTree node) {
        final VariableRecord varref = (VariableRecord) visit((CommonTree) node
                .getChild(0));
        if (varref == null) {
            Error.complain(Error.NULL_POINTER_EXCEPTION, null, currentMethod,
                    log);
        } else {
            if (!varref.getType().equals(Record.ARRAY_TYPE)) {
                Error.complain(Error.LENGTH_EXCEPTION, varref.getName(),
                        currentMethod, log);
            }
        }
        return new VariableRecord("length", Record.INT);
    }

    /**
     * Visits 'this' calls. Assigns type of call to current class.
     *
     * @return VariableRecord(name, current class type)
     */
    @Override
    public VariableRecord visitThis(final CommonTree node) {
        String type;
        if (currentClass == null) {
            type = Record.INT;
        } else {
            type = currentClass.getName();
        }

        return new VariableRecord("this", type);
    }

}
