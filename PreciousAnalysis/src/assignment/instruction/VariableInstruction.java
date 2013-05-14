package assignment.instruction;

import java.io.Serializable;

/**
 * Serializable representation for variable analogous to VariableRecord
 */
public class VariableInstruction implements Serializable {

    private static final long serialVersionUID = 4655953718359146586L;
    private int number;
    private String name;
    private int value;
    private int type;

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

    public void setNumber(final int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }
}
