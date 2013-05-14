package assignment.scope;

import java.util.ArrayList;
import java.util.List;

import assignment.instruction.Instruction;
import assignment.instruction.MethodInstruction;
import assignment.instruction.VariableInstruction;

/**
 * Representation for methods. Used for recording methods in the symbol table.
 * Method details: list of parameters, method name and returned type.
 */

public class MethodRecord implements Record {

    private final List<VariableRecord> parameters;
    private String name;
    private String returnType;
    private int paramListSize;
    private int varIndex;
    private int instructionIndex;
    private final String className;

    private final List<VariableRecord> variables;
    private final List<Instruction> instructions;

    /**
     * @param name       of the method
     * @param returnType type of returned variable
     */
    public MethodRecord(final String name, final String returnType,
                        final String className) {
        this.parameters = new ArrayList<VariableRecord>();
        this.variables = new ArrayList<VariableRecord>();
        this.instructions = new ArrayList<Instruction>();
        this.name = name;
        this.returnType = returnType;
        this.paramListSize = 0;
        this.varIndex = 0;
        this.instructionIndex = 0;
        this.className = className;
    }

    /**
     * @param name          of method
     * @param returnType    type of returned variable
     * @param paramListSize number of parameters
     */
    public MethodRecord(final String name, final String returnType,
                        final int paramListSize, final String className) {
        this.parameters = new ArrayList<VariableRecord>();
        this.variables = new ArrayList<VariableRecord>();
        this.instructions = new ArrayList<Instruction>();
        this.name = name;
        this.returnType = returnType;
        this.paramListSize = paramListSize;
        this.instructionIndex = 0;
        this.className = className;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param param to be added
     */
    public void addParam(final VariableRecord param) {

        param.setIndex(varIndex);
        parameters.add(param);
        paramListSize = parameters.size();
        varIndex++;
    }

    @Override
    public String toString() {
        final StringBuilder string = new StringBuilder(className);
        string.append('.');
        string.append(name);
        int i = 0;
        string.append('(');
        for (final VariableRecord param : parameters) {
            string.append(param.toString());
            if (i < paramListSize - 1) {
                string.append(", ");
            }
            i++;
        }
        string.append(")\n{");
        for (final VariableRecord var : variables) {
            string.append(var.toString());
            string.append('\n');
        }
        string.append('}');
        return string.toString();
    }

    @Override
    public String getType() {
        return returnType;
    }

    public int getParamListSize() {
        return paramListSize;
    }

    /**
     * @param number of parameters in the list
     * @return string with type of parameter
     */
    public String getParameterType(final int number) {
        String result = null;
        if (number < parameters.size()) {
            result = parameters.get(number).getType();
        }
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setType(final String returnType) {
        this.returnType = returnType;
    }

    @Override
    public int getRecordType() {
        return Record.METHOD;
    }

    /**
     * @param variable to add to list of inner variables
     */
    public void addVariable(final VariableRecord variable) {
        if (variable != null) {

            variable.setIndex(varIndex);
            variables.add(variable);
            varIndex++;
        }
    }

    /**
     * @param instruction to add to list of instructions for stack machine
     */
    public void addInstruction(final Instruction instruction) {
        if (instruction != null) {
            instruction.setIndex(instructionIndex++);
            instructions.add(instruction);
        }
    }

    private int findIndex(final String name, final List<VariableRecord> list) {
        int index = -1;
        for (final VariableRecord var : list) {
            if (var.getName().equals(name)) {
                index = var.getIndex();
            }
        }
        return index;
    }

    public int getIndexOf(final String name) {
        int index = findIndex(name, parameters);
        if (index == -1) {
            index = findIndex(name, variables);
        }
        return index;
    }

    public List<VariableInstruction> getVariablesAndParameters() {
        final List<VariableInstruction> vars = new ArrayList<VariableInstruction>();
        for (final VariableRecord parRecord : parameters) {
            final VariableInstruction variableInstruction = new VariableInstruction(
                    parRecord.getIndex(), parRecord.getName(), 0);
            vars.add(variableInstruction);
        }
        for (final VariableRecord varRecord : variables) {
            final VariableInstruction variableInstruction = new VariableInstruction(
                    varRecord.getIndex(), varRecord.getName(), 0);
            vars.add(variableInstruction);
        }
        return vars;
    }

    public int getInstructionIndex() {
        return instructionIndex;
    }

    public String getSignature() {
        final StringBuilder result = new StringBuilder(256);
        result.append(returnType).append(" ").append(className).append(".").append(name).append(" (");
        for (int i = 0; i < paramListSize; i++) {
            result.append(parameters.get(i).getType());
            if (i != paramListSize - 1) {
                result.append(", ");
            }
        }
        result.append(')');
        return result.toString();
    }

    public MethodInstruction getMethodInstruciton() {
        return new MethodInstruction(className + "." + name, instructions, getVariablesAndParameters());
    }
}
