package assignment.instruction;

import java.io.Serializable;

/**
 * Serializable representation for variable analogous to VariableRecord
 */
public class VariableInstruction implements Serializable {

    private static final long serialVersionUID = 4655953718359146586L;
    private final int number;
    private final String name;
    private int value;

    /**
     * @param number instruction's number
     * @param name   instruction's argument - variable name
     * @param value  of variable
     */
    public VariableInstruction(final int number, final String name,
                               final int value) {
        this.number = number;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return (number + "=" + name);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }
}
