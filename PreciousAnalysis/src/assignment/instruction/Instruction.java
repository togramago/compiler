package assignment.instruction;

import java.io.Serializable;

import assignment.scope.Code;

/**
 * Serializable representation of an instruction for stack machine execution.
 */
public class Instruction implements Serializable {

    private static final long serialVersionUID = 838455167905548050L;
    private final Code code;
    private Object argument;
    private int instructionIndex;

    /**
     * @param code     of instruction
     * @param argument strings (invokevirtual), null (operators like mult) or integers (otherwise).
     */
    public Instruction(final Code code, final Object argument) {
        this.code = code;
        this.argument = argument;
        this.instructionIndex = -1;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(instructionIndex);
        builder.append(" ").append(getName()).append(" ");
        if (argument != null) {
            if ((code == Code.ISTORE) || (code == Code.ILOAD)) {
                builder.append('#');
            }
            builder.append(argument.toString());
        }
        return builder.toString();
    }

    /**
     * @return String representation of instruction's code
     */
    private String getName() {
        String name;
        switch (code) {
            case ILOAD:
                name = "ILOAD";
                break;
            case ICONST:
                name = "ICONST";
                break;
            case ISTORE:
                name = "ISTORE";
                break;
            case IADD:
                name = "IADD";
                break;
            case IMUL:
                name = "IMUL";
                break;
            case ISUB:
                name = "ISUB";
                break;
            case ILT:
                name = "ILT";
                break;
            case IAND:
                name = "IAND";
                break;
            case INOT:
                name = "INOT";
                break;
            case GOTO:
                name = "GOTO";
                break;
            case IF_FALSE:
                name = "IF_FALSE";
                break;
            case INVOKEVIRTUAL:
                name = "INVOKEVIRTUAL";
                break;
            case RETURN:
                name = "RETURN";
                break;
            case PRINT:
                name = "PRINT";
                break;
            case STOP:
                name = "STOP";
                break;
            default:
                name = "error";
        }
        return name;
    }

    public void setIndex(final int index) {
        instructionIndex = index;
    }

    public void setArgument(final Object argument) {
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public Code getCode() {
        return code;
    }
}
