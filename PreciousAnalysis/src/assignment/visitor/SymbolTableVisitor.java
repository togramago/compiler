package assignment.visitor;

import org.antlr.runtime.tree.CommonTree;

import assignment.scope.ClassRecord;
import assignment.scope.MethodRecord;
import assignment.scope.Record;
import assignment.scope.SymbolTable;
import assignment.scope.VariableRecord;
import assignment.Error;

/**
 * 
 * Traverses the tree twice: constructs symbol table and performs check for
 * misdeclared identifiers
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 * 
 */
public class SymbolTableVisitor extends AbstractVisitor {

	private transient ClassRecord currentClass;
	private transient MethodRecord currentMethod;
	private final transient SymbolTable symbolTable;
	private transient boolean isLookup;
	private final transient StringBuilder log;

	/**
	 * @param log
	 *            StringBuilder variable for error log
	 */
	public SymbolTableVisitor(final StringBuilder log) {
		super();
		symbolTable = new SymbolTable();
		isLookup = false;
		this.log = log;
	}

	/**
	 * Visits method declaration, sets currentMethod field.
	 */
	@Override
	public Object visitMethodDecl(final CommonTree node) {

		final CommonTree child = (CommonTree) node.getChild(0);
		final String retType = (String) visit(child);
		final String mName = node.getChild(1).getText();
		boolean canContinue = true;
		final MethodRecord foundRecord = (MethodRecord) symbolTable.lookup(
				mName, Record.METHOD);
		if (isLookup) {
			symbolTable.enterScope();
			currentMethod = foundRecord;
		} else {
			if (foundRecord == null) { // if method is unique
				currentMethod = new MethodRecord(mName, retType, node.getChild(
						2).getChildCount(), currentClass.getName());
				symbolTable.put(mName, currentMethod);
				currentClass.putMethod(mName, currentMethod);
				symbolTable.addScope(currentClass);
			} else { // if method is a duplicate
				canContinue = false;
				Error.complain(Error.DUPLICATE_DECLARATION_EXCEPTION, mName,
						currentMethod, log);
			}
		}
		if (canContinue) {
			visit((CommonTree) node.getChild(2));
			visit((CommonTree) node.getChild(3));
			symbolTable.exitScope();
		}

		return null;
	}

	/**
	 * Visits variable declaration. <br>
	 * In regular mode checks for duplicate declarations and puts new
	 * VariableRecord to symbol table. <br>
	 * In look up mode checks for undeclared type of variables.
	 */
	@Override
	public Object visitVarDecl(final CommonTree node) {
		final String type = (String) visit((CommonTree) node.getChild(0));
		final String mName = node.getChild(1).getText();
		final VariableRecord var = new VariableRecord(mName, type);
		if (isLookup) {
			if (!(type.equals(Record.INT) || type.equals(Record.BOOLEAN) || type
					.equals(Record.ARRAY_TYPE))) {
				final VariableRecord record = (VariableRecord) symbolTable
						.lookup(type, Record.VARIABLE);
				if (record == null) {
					Error.complain(Error.IDENTIFIER_EXCEPTION, type, null, log);
				}
			}
		} else {
			final VariableRecord ref = (VariableRecord) symbolTable.lookup(
					mName, Record.VARIABLE);
			if (ref == null) {
				symbolTable.put(mName, var);
				if (currentMethod != null) {
					currentMethod.addVariable(var);
				}
			} else {
				Error.complain(Error.DUPLICATE_DECLARATION_EXCEPTION, mName,
						currentMethod, log);
			}
		}
		return var;
	}

	/**
	 * Visits type reference
	 * 
	 * @return string with type name
	 */
	@Override
	public String visitTypeRef(final CommonTree node) {
		// only int array is possible
		return node.getChild(0).getText();
	}

	/**
	 * Visits class. <br>
	 * In regular mode adds new ClassRecord and scope to the symbol table. <br>
	 * In look up mode enters scope and looks for new value for currentClass
	 * field.
	 */
	@Override
	public Object visitClass(final CommonTree node) {
		final String mName = node.getChild(0).getText();
		final ClassRecord foundRecord = (ClassRecord) symbolTable.lookup(mName,
				Record.CLASS);
		boolean canContinue = true;
		if (isLookup) {
			symbolTable.enterScope();
			currentClass = foundRecord;
			if (currentClass == null) {
				Error.complain(Error.NULL_POINTER_EXCEPTION, mName,
					null, log);
			}
		} else {
			if (foundRecord == null) {
				currentClass = new ClassRecord(mName);
				symbolTable.put(mName, currentClass);
				symbolTable.addScope(currentClass);
			} else {
				canContinue = false;
				Error.complain(Error.DUPLICATE_DECLARATION_EXCEPTION, mName,
						null, log);
			}
		}
		if (canContinue) {
			CommonTree child = (CommonTree) node.getChild(1);
			visit(child); // varDeclarationList
			child = (CommonTree) node.getChild(2);
			visit(child); // methodDeclarationList
			symbolTable.exitScope();
		}
		return null;
	}

	/**
	 * Visits main class. <br>
	 * In regular mode adds new scope and ClassRecord to symbol table. <br>
	 * In look up mode enters scope and looks for new value for currentClass
	 * field.
	 */
	@Override
	public Object visitMainClass(final CommonTree node) {
		final String mName = node.getChild(0).getText();
		if (isLookup) {
			symbolTable.enterScope();
			currentClass = (ClassRecord) symbolTable
					.lookup(mName, Record.CLASS);
		} else {
			currentClass = new ClassRecord(mName);
			symbolTable.put(mName, currentClass);
			symbolTable.addScope(currentClass);
		}

		final CommonTree child = (CommonTree) node.getChild(1);
		visit(child); // mainMethod
		symbolTable.exitScope();
		return null;
	}

	/**
	 * Visits main method. <br>
	 * In regular mode adds new MethodRecord and scope to symbol table. <br>
	 * In look up mode enters scope and looks for new value for currentMethod
	 * field.
	 */
	@Override
	public Object visitMainMethod(final CommonTree node) {
		final String main = Record.MAIN;
		if (isLookup) {
			symbolTable.enterScope();
			currentMethod = (MethodRecord) symbolTable.lookup(main,
					Record.METHOD);
		} else {
			currentMethod = new MethodRecord(main, "void",
					currentClass.getName());
			symbolTable.put(main, currentMethod);
			currentClass.putMethod(main, currentMethod);
			symbolTable.addScope(currentClass);
		}
		visit((CommonTree) node.getChild(0)); // paramlist
		visit((CommonTree) node.getChild(1)); // statements
		symbolTable.exitScope();
		return null;
	}

	public SymbolTable getSymbolTable() {
		return symbolTable;
	}

	/**
	 * Visits parameter in method parameter list. Puts parameters to symbol
	 * table and currentMethod's parameter list. Works only in regular mode.
	 */
	@Override
	public Object visitParam(final CommonTree node) {
		final String type = (String) visit((CommonTree) node.getChild(0));
		final String mName = node.getChild(1).getText();
		final VariableRecord var = new VariableRecord(mName, type);
		if (!isLookup) {
			symbolTable.put(mName, var);
			currentMethod.addParam(var);
		}
		return null;
	}

	/**
	 * Visits variable reference. In look up mode checks for undeclared
	 * identifier.
	 * 
	 * @return null in regular mode, VariableRecord with checked variable in
	 *         look up mode.
	 */
	@Override
	public VariableRecord visitVarRef(final CommonTree node) {
		VariableRecord varref = null;
		if (isLookup) {
			final String nodeId = node.getChild(0).getText();
			varref = ((VariableRecord) symbolTable.lookup(nodeId,
					Record.VARIABLE));

			if (varref == null) {
				Error.complain(Error.IDENTIFIER_EXCEPTION, nodeId,
						currentMethod, log);
			}
		}
		return varref;
	}

	/**
	 * Changes regular mode to look up mode.
	 */
	public void setLookupMode() {
		isLookup = true;
		symbolTable.resetTable();
	}

	/**
	 * Visits method call. <br>
	 * In look up mode checks for undeclared methods in an other class.
	 */
	@Override
	public Object visitMethodCall(final CommonTree node) {
		if (isLookup) {
			final VariableRecord varref = (VariableRecord) visit((CommonTree) node
					.getChild(0));
			final MethodRecord method = (MethodRecord) visit((CommonTree) node
					.getChild(1));
			if (varref != null) {
				final String className = varref.getType();
				final Record curRecord = (Record) symbolTable.lookup(className,
						Record.CLASS);
				if (curRecord instanceof ClassRecord) {
					final ClassRecord curClass = (ClassRecord) curRecord;
					if ((curClass != null)
							&& (curClass.getMethodIfExists(method) == null)) {
						Error.complain(Error.METHOD_EXCEPTION,
								method.getName(), currentMethod, log);
					}
				} else {
					Error.complain(Error.UNEXPECTED_ERROR, curRecord.getName(),
							currentMethod, log);
				}
			}
		}

		return null;
	}

	/**
	 * Visits suffix part of method call.
	 * 
	 * @return MethodRecord with name but without further details.
	 */
	@Override
	public MethodRecord visitSuffixPart(final CommonTree node) {
		final String name = (String) node.getChild(0).getText();
		final MethodRecord method = new MethodRecord(name, null,
				currentClass.getName());
		visit((CommonTree) node.getChild(1));
		return method;
	}

	/**
	 * Visits new node. <br>
	 * In look up node forms new VariableRecord with required type.
	 * 
	 * @return VariableRecord(new, required type) or null (in regular mode).
	 */
	@Override
	public VariableRecord visitNew(final CommonTree node) {
		VariableRecord ref = null;
		if (isLookup) {
			final String type = node.getChild(0).getText();
			ref = new VariableRecord("new", type);
		} else {
			visitChildren(node);
		}
		return ref;
	}

}
