package assignment.instruction;

import java.io.Serializable;
import java.util.List;

import assignment.scope.Record;

/**
 * Serializable representation for instruction list of method
 */
public class MethodInstruction implements Serializable {

    private static final long serialVersionUID = -3974770645423048866L;
    private final String name;
    private final List<Instruction> instructions;
    private final List<VariableInstruction> variables;

    public MethodInstruction(final String name,
                             final List<Instruction> instructions,
                             final List<VariableInstruction> variables) {
        this.name = name;
        this.instructions = instructions;
        this.variables = variables;
    }

    public String getName() {
        return name;
    }

    public int getInstructionNumber() {
        return instructions.size();
    }

    public Instruction getInstruction(final int number) {
        return instructions.get(number);
    }

    /**
     * @param number index of variable
     * @return value of variable if exists
     */
    public int getVariableValue(final int number) {
        int result = 0;
        for (final VariableInstruction var : variables) {
            if (var.getNumber() == number) {
                result = var.getValue();
            }
        }
        return result;
    }

    /**
     * Set value of variable found by index to new value
     *
     * @param varIndex index of variable
     * @param value    new value
     */
    public void setVariable(final int varIndex, final Integer value) {
        for (final VariableInstruction var : variables) {
            if (var.getNumber() == varIndex) {
                var.setValue(value);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(name).append("\n( ");
        for (final VariableInstruction var : variables) {
            builder.append(var);
            builder.append(" ");
        }
        builder.append(")\n");
        for (final Instruction instruction : instructions) {
            builder.append(instruction);
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Check if this method is main
     *
     * @param className name of method's class
     * @return true if method is main
     */
    public boolean isMain(final String className) {
        return name.equals(className + "." + Record.MAIN);
    }
}
