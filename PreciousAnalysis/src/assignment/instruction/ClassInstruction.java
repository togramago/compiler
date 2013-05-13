package assignment.instruction;

import java.io.Serializable;
import java.util.List;

/**
 * Serializable representation for instructions lists of class
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class ClassInstruction implements Serializable {

	private static final long serialVersionUID = -549053887353370728L;
	private final String className;
	private final List<MethodInstruction> instructions;

	public ClassInstruction(final String className,
			final List<MethodInstruction> instructions) {
		this.className = className;
		this.instructions = instructions;
	}

	/**
	 * @return main method if class contains it, null in other case.
	 */
	public MethodInstruction getMainMethod() {
		MethodInstruction method = null;
		for (final MethodInstruction instruction : instructions) {
			if (instruction.isMain(className)) {
				method = instruction;
				continue;
			}
		}
		return method;
	}

	public List<MethodInstruction> getInstructions() {
		return instructions;
	}

	public String getName() {
		return className;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append('\n');
		for (final MethodInstruction method : instructions) {
			builder.append(method);
			builder.append('\n');
		}
		return builder.toString();
	}

	/**
	 * @param methodName (in format methodClassName.methodName)
	 * @return method with given qualified name
	 */
	public MethodInstruction getMethod(final String methodName) {
		MethodInstruction result = null;
		for (final MethodInstruction instruction : instructions) {
			if (methodName.equals(instruction.getName())) {
				result = instruction;
				continue;
			}
		}
		return result;
	}
}
