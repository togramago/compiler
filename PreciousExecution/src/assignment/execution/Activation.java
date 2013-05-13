package assignment.execution;

import java.util.List;

import assignment.instruction.ClassInstruction;
import assignment.instruction.MethodInstruction;

/**
 * Representation of method invocation for stack machine execution
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin   gh
 */
public class Activation {
	private ClassInstruction currentClass;
	private MethodInstruction currentMethod;
	private final List<ClassInstruction> classes;
	private final StringBuilder log;

	public Activation(final List<ClassInstruction> classes,
			final StringBuilder log) {
		this.classes = classes;
		this.log = log;
	}

	public Activation(final ClassInstruction currentClass,
			final MethodInstruction currentMethod,
			final List<ClassInstruction> classes, final StringBuilder log) {
		this.classes = classes;
		this.log = log;
		this.currentClass = currentClass;
		this.currentMethod = currentMethod;
	}

	/**
	 * Set currentMethod to main method value, currentClass to class that
	 * contains main()
	 */
	public void setMain() {
		for (final ClassInstruction classInstruction : classes) {
			final MethodInstruction methodInstruction = classInstruction
					.getMainMethod();
			if (methodInstruction != null) {
				currentMethod = methodInstruction;
				currentClass = classInstruction;
				continue;
			}
		}
	}

	public ClassInstruction getCurrentClass() {
		return currentClass;
	}

	public MethodInstruction getCurrentMethod() {
		return currentMethod;
	}

	/**
	 * Find and set inner Activation's variables due to invoked method's name
	 * 
	 * @param activationName
	 *            name of method to invoke
	 */
	public void setActivation(final String activationName) {
		final String className = activationName.split("\\.")[0];
		currentClass = findClass(className);
		if (currentClass != null) {
			currentMethod = findMethod(activationName);
		}
	}

	/**
	 * Find class with given name from class' repository
	 * 
	 * @param className
	 *            class to find
	 * @return found class if exists, null in other case
	 */
	private ClassInstruction findClass(final String className) {
		ClassInstruction classInstruction = null;
		if (className.equals(currentClass.getName())) {
			classInstruction = currentClass;
		} else {
			for (final ClassInstruction instruction : classes) {
				if (className.equals(instruction.getName())) {
					classInstruction = instruction;
				}
			}
			errorMessage(classInstruction==null, "Class");
		}
		return classInstruction;
	}

	/**
	 * Find method in class
	 * 
	 * @param methodName
	 *            method to find
	 * @return found method or null
	 */
	private MethodInstruction findMethod(final String methodName) {
		MethodInstruction methodInstruction = currentClass
				.getMethod(methodName);
		errorMessage(methodInstruction==null, "Method");
		return methodInstruction;
	}

	/**
	 * Error message display
	 * 
	 * @param condition
	 *            to fire message log
	 * @param whatIsNotFound
	 *            type of instruction that's not found
	 */
	private void errorMessage(final boolean condition,
			final String whatIsNotFound) {
		if (condition) {
			final String error = "EXECUTION ERROR! " + whatIsNotFound
					+ " not found!\n";
			log.append(error);
			if (Interpreter.debug()) {
				System.out.println(error);
			}
		}
	}

}
