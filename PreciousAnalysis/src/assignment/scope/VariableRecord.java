package assignment.scope;


/**
 * Representation for variables. Used for recording variables in the symbol
 * table.
 */

public class VariableRecord implements Record {

    private final String name;
    private String type;
    private int index;

    public VariableRecord(final String name, final String type) {
        this.name = name;
        this.type = type;
        this.index = 0;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setIndex(final int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getRecordType() {
        return Record.VARIABLE;
    }

}
