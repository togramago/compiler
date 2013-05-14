package assignment.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * The semantics of Record depends on its context. Each context is referred to
 * as a Scope.
 */
public class Scope {
    private int next;
    private Scope parent;
    private final List<Scope> children;
    private final Map<String, Record> records;
    private ClassRecord containClass;
    private int indent;

    /**
     * Copy constructor. Does not copy records and children.
     *
     * @param scope to copy
     */
    public Scope(final Scope scope) {
        records = new HashMap<String, Record>();
        children = new ArrayList<Scope>();
        next = 0;
        indent = 0;
        if (scope != null) {
            parent = scope.getParent();
            indent = scope.getIndent();
            containClass = scope.getContainClass();
        }
    }

    /**
     * @return class that contains this scope
     */
    ClassRecord getContainClass() {
        return containClass;
    }

    public void setContainClass(final ClassRecord containClass) {
        this.containClass = containClass;
    }

    int getIndent() {
        return indent;
    }

    /**
     * method for incrementing indents for printScope() method
     * * }
     */
    void incIndent() {
        indent++;
    }

    /**
     * print routine for scopes
     *
     * @return string with current scope
     */
    public String printScope() {
        // TODO: sort set
        final StringBuilder print = new StringBuilder();
        final Set<Entry<String, Record>> entries = records.entrySet();
        int scopeMeter = 0;
        int i = indent;
        for (final Entry<String, Record> entry : entries) {
            while (i > 0) {
                print.append('\t');
                i--;
            }

            if (entry.getValue().getClass().equals(VariableRecord.class)) {
                if (entry.getValue().getType().equals(Record.ARRAY_TYPE)) {
                    entry.getValue().setType(Record.INT + "[]");
                }
            }

            print.append(entry.getValue().toString());
            print.append('\n');

            if ((entry.getValue().getClass() == ClassRecord.class)
                    || (entry.getValue().getClass() == MethodRecord.class)) {
                print.append(children.get(scopeMeter).printScope());
                scopeMeter++;
                print.append('\n');
            }

        }
        return print.toString();
    }

    /**
     * adds new scope in children list
     *
     * @return new child of scope
     */
    public Scope addChild() {
        Scope nextC;
        nextC = new Scope(this);
        nextC.incIndent();
        children.add(nextC);
        nextC.setParent(this);
        next++;
        return nextC;
    }

    /**
     * @return entered child with next child index
     */
    public Scope enterChild() {
        Scope nextC = null;
        if (next < children.size()) {
            nextC = children.get(next);
        }
        next++;
        return nextC;
    }

    /**
     * @param key name of the record to look uo
     * @return found record or null
     */
    public Record lookup(final String key, final int type) {
        Record result = null;
        if (records.containsKey(key)) { // Check if in current scope
            final Record foundRecord = records.get(key);
            if (foundRecord.getRecordType() == type)
                result = foundRecord;
        } else {
            if (parent != null) {
                result = parent.lookup(key, type);
            }
        }
        return result;
    }

    /**
     * @param key  name of the new record
     * @param item record to add
     */
    public void put(final String key, final Record item) {
        records.put(key, item);
    }

    /**
     * Resets next child index to 0. Resets all child scopes
     */
    public void resetScope() {
        next = 0;
        for (Scope aChildren : children) {
            aChildren.resetScope();
        }
    }

    public Scope getParent() {
        return parent;
    }

    void setParent(final Scope parent) {
        this.parent = parent;
    }
}
