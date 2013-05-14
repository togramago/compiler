package assignment.visitor;


import org.antlr.runtime.tree.CommonTree;

import assignment.generated.MiniJavaLexer;
import assignment.scope.Record;
import assignment.scope.VariableRecord;

/**
 * Parent class for all visitor classes.
 */
public class AbstractVisitor {

    Object visitFile(final CommonTree node) {
        visitChildren(node); // Default action
        return null;
    }

    Object visitClass(final CommonTree node) {
        visitChildren(node); // Default action
        return null;
    }

    Object visitVarList(final CommonTree node) {
        visitChildren(node); // Default action
        return null;
    }

    void visitChildren(final CommonTree node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            visit((CommonTree) node.getChild(i));
        }
    }

    Object visitExtends(final CommonTree node) {
        visitChildren(node); // Default action
        return null;
    }

    Object visitIf(final CommonTree node) {
        // expression, statement, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitWhile(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitThis(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitUnaryNot(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitSysout(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitTrueFalse(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitLt(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitLogicAnd(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitLogicOr(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitPlus(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitMinus(final CommonTree node) {
        // expression, statement;
        visitChildren(node); // Default action
        return null;
    }

    Object visitMult(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMainClass(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMainMethod(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitParam(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitParamList(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitVarDecl(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitVarRef(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitTypeRef(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitArrayType(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMethodList(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMethodDecl(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMethodBody(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitReturn(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitStmntList(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitAssign(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitArrayAssign(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitArrayLengthReference(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitArrayRead(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitIntArrayNew(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitNew(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitMethodCall(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitSuffixPart(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitExprList(final CommonTree node) {
        visitChildren(node);
        return null;
    }

    Object visitConst(final CommonTree node) {
        final String name = node.getChild(0).getText();

        VariableRecord result;

        if (name.equals(Record.TRUE) || name.equals(Record.FALSE)) {
            result = new VariableRecord(name, Record.BOOLEAN);
        } else {
            result = new VariableRecord(name, Record.INT);
        }
        return result;
    }

    public Object visit(final CommonTree tree) {
        // TODO: map + command pattern
        Object result = null;
        switch (tree.getType()) {
            case MiniJavaLexer.FILE:
                result = visitFile(tree);
                break;
            case MiniJavaLexer.CLASS:
                result = visitClass(tree);
                break;
            case MiniJavaLexer.VAR_LIST:
                result = visitVarList(tree);
                break;
            case MiniJavaLexer.EXTENDS:
                result = visitExtends(tree);
                break;
            case MiniJavaLexer.IF:
                result = visitIf(tree);
                break;
            case MiniJavaLexer.WHILE:
                result = visitWhile(tree);
                break;
            case MiniJavaLexer.THIS:
                result = visitThis(tree);
                break;
            case MiniJavaLexer.UNARY_NOT:
                result = visitUnaryNot(tree);
                break;
            case MiniJavaLexer.SYSOUT:
                result = visitSysout(tree);
                break;
            case MiniJavaLexer.TRUE:
            case MiniJavaLexer.FALSE:
                result = visitTrueFalse(tree);
                break;
            case MiniJavaLexer.LT:
                result = visitLt(tree);
                break;
            case MiniJavaLexer.LOGIC_AND:
                result = visitLogicAnd(tree);
                break;
            case MiniJavaLexer.LOGIC_OR:
                result = visitLogicOr(tree);
                break;
            case MiniJavaLexer.PLUS:
                result = visitPlus(tree);
                break;
            case MiniJavaLexer.MINUS:
                result = visitMinus(tree);
                break;
            case MiniJavaLexer.MULT:
                result = visitMult(tree);
                break;
            case MiniJavaLexer.MAIN_CLASS:
                result = visitMainClass(tree);
                break;
            case MiniJavaLexer.PARAM_LIST:
                result = visitParamList(tree);
                break;
            case MiniJavaLexer.MAIN_METHOD:
                result = visitMainMethod(tree);
                break;
            case MiniJavaLexer.PARAM:
                result = visitParam(tree);
                break;
            case MiniJavaLexer.VAR_DECL:
                result = visitVarDecl(tree);
                break;
            case MiniJavaLexer.VAR_REF:
                result = visitVarRef(tree);
                break;
            case MiniJavaLexer.TYPE_REF:
                result = visitTypeRef(tree);
                break;
            case MiniJavaLexer.ARRAY_TYPE:
                result = visitArrayType(tree);
                break;
            case MiniJavaLexer.METHOD_LIST:
                result = visitMethodList(tree);
                break;
            case MiniJavaLexer.METHOD_DECL:
                result = visitMethodDecl(tree);
                break;
            case MiniJavaLexer.METHOD_BODY:
                result = visitMethodBody(tree);
                break;
            case MiniJavaLexer.RETURN:
                result = visitReturn(tree);
                break;
            case MiniJavaLexer.STMNT_LIST:
                result = visitStmntList(tree);
                break;
            case MiniJavaLexer.ASSIGN:
                result = visitAssign(tree);
                break;
            case MiniJavaLexer.ARRAY_ASSIGN:
                result = visitArrayAssign(tree);
                break;
            case MiniJavaLexer.ARRAYLENGTH_REFERENCE:
                result = visitArrayLengthReference(tree);
                break;
            case MiniJavaLexer.ARRAY_READ:
                result = visitArrayRead(tree);
                break;
            case MiniJavaLexer.INTARRAY_NEW:
                result = visitIntArrayNew(tree);
                break;
            case MiniJavaLexer.NEW:
                result = visitNew(tree);
                break;
            case MiniJavaLexer.METHOD_CALL:
                result = visitMethodCall(tree);
                break;
            case MiniJavaLexer.SUFFIX_PART:
                result = visitSuffixPart(tree);
                break;
            case MiniJavaLexer.EXPR_LIST:
                result = visitExprList(tree);
                break;
            case MiniJavaLexer.CONST:
                result = visitConst(tree);
                break;
            default:
        }
        return result;
    }
}

