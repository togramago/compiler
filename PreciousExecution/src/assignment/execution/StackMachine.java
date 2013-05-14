package assignment.execution;

import java.util.List;
import java.util.Stack;

import assignment.instruction.ClassInstruction;
import assignment.instruction.Instruction;
import assignment.instruction.MethodInstruction;

class StackMachine {

    private final Stack<Integer> data;
    private final Stack<Activation> activations;
    private final List<ClassInstruction> classes;
    private final StringBuilder log;


    public StackMachine(final List<ClassInstruction> classes,
                        final StringBuilder log) {
        data = new Stack<Integer>();
        activations = new Stack<Activation>();
        this.classes = classes;
        this.log = log;
    }

    public void execute() {
        final Activation initialActivation = new Activation(classes, log);
        initialActivation.setMain();
        activations.push(initialActivation);
        executeActivation(activations.pop());
    }

    void executeActivation(final Activation activation) {
        int counter = 0;
        final MethodInstruction currentMethod = activation.getCurrentMethod();
        while (counter < currentMethod.getInstructionNumber()) {
            final Instruction instruction = currentMethod
                    .getInstruction(counter);
            final Object argument = instruction.getArgument();
            if (Interpreter.debug()) {
                System.out.println(instruction);
                System.out.println(data);
            }
            switch (instruction.getCode()) {
                case ILOAD: {
                    final Integer variableValue = currentMethod
                            .getVariableValue((Integer) argument);
                    data.push(variableValue);
                }
                break;
                case ICONST:
                    data.push((Integer) argument);
                    break;
                case ISTORE: {
                    currentMethod.setVariable((Integer) argument, data.pop());
                }
                break;
                case IADD:
                    data.push(data.pop() + data.pop());
                    break;
                case IMUL:
                    data.push(data.pop() * data.pop());
                    break;
                case ISUB: {
                    Integer val1 = data.pop();
                    Integer val2 = data.pop();
                    data.push(val2 - val1);
                }
                break;
                case ILT: // Push 1 if v2 < v1 else Push 0
                    data.push(data.pop() > data.pop() ? 1 : 0);
                    break;
                case IAND: // Push 0 if v1 * v2 = 0 else Push 1
                    data.push(data.pop() * data.pop() == 0 ? 0 : 1);
                    break;
                case INOT: // Push 1 if v = 0 else Push 0
                    data.push(data.pop() == 0 ? 1 : 0);
                    break;
                case GOTO:
                    counter = ((Integer) argument) - 1;
                    break;
                case IF_FALSE:
                    if (data.pop() == 0) {
                        counter = ((Integer) argument) - 1;
                    }
                    break;
                case INVOKEVIRTUAL: {
                    final Activation newActivation = new Activation(activation.getCurrentClass(), currentMethod, classes, log);
                    newActivation.setActivation((String) argument);
                    activations.push(newActivation);
                    executeActivation(newActivation);
                }
                break;
                case RETURN:
                    activations.pop();
                    break;
                case PRINT:
                    System.out.println(data.pop());
                    break;
                case STOP:
                    return;
                default:

            }
            counter++;
        }
    }
}
