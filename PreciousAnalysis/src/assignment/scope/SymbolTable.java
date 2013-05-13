package assignment.scope;


/**
 * Symbol table constructing and managing tools.
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 * 
 */
public class SymbolTable {

	private final Scope root; // Root of scope tree
	private transient Scope current; // Current scope

	/**
	 * Set root and current scopes.
	 */
	public SymbolTable() {
		root = new Scope(null);
		current = root;
	}

	/**
	 * Adds new child scope to current scope.
	 * 
	 * @param classRec
	 *            containg class of child scope
	 */
	public void addScope(final ClassRecord classRec) {
		current = current.addChild();
		current.setContainClass(classRec);
	}

	/**
	 * Enters child of current scope
	 */
	public void enterScope() {
		current = current.enterChild();
	}

	/**
	 * Enters current scope's parent
	 */
	public void exitScope() {
		if ((current != null) && (!current.equals(root))) {
			current = current.getParent();
		}
	}

	/**
	 * Puts new record to current scope
	 * 
	 * @param key
	 *            name of the item
	 * @param item
	 *            record to put
	 */
	public void put(final String key, final Record item) {
		current.put(key, item);
	}

	/**
	 * Performs lookup of record with specified name from current scope to root
	 * scope
	 * 
	 * @param key
	 *            name of the record to find
	 * @return found Record or null
	 */
	public Record lookup(final String key, final int type) {
		if (current == null) {
			current = root;
		}
		return current.lookup(key, type);
	}


	/**
	 * printing routing for symbol table
	 * 
	 * @return string with symbol table contents
	 */
	public String printTable() {
		final StringBuilder table = new StringBuilder(256);
		table.append("\n----------------------------SYMBOL TABLE----------------------------\n");
		table.append(root.printScope());
		table.append("\n--------------------------------------------------------------------\n");
		return table.toString();
	}

	/**
	 * Resets symbol table and all it's scopes
	 */
	public void resetTable() {
		root.resetScope();
	}

	public Scope getCurrent() {
		return current;
	}

	public Scope getRoot() {
		return root;
	}

}
