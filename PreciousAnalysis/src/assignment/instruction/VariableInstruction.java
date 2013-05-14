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
    private final int type;

    public static final int PARAM = 522;
    public static final int VAR = 523;

    /**
     * @param number instruction's number
     * @param name   instruction's argument - variable name
     * @param value  of variable
     * @param type   parameter or local variable
     */
    public VariableInstruction(final int number, final String name,
                               final int value, final int type) {
        this.number = number;
        this.name = name;
        this.type = type;
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
