package assignment.scope;

import java.util.ArrayList;
import java.util.List;

import assignment.instruction.ClassInstruction;
import assignment.instruction.MethodInstruction;
import assignment.output.ClassFile;

/**
 * Representation for classes. Used for recording classes in the symbol table.
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 * 
 */

public class ClassRecord implements Record {

	private String name;
	private final List<MethodRecord> methods = new ArrayList<MethodRecord>();

	/**
	 * @param name
	 *            of the class
	 */
	public ClassRecord(final String name) {
		this.name = name;
	}

	/**
	 * adds method to the class method list
	 * 
	 * @param name
	 *            of the method
	 * @param record
	 *            with method details
	 */
	public void putMethod(final String name, final MethodRecord record) {
		record.setName(name);
		methods.add(record);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * checks if method exists in class method list
	 * 
	 * @param method
	 *            to check
	 * @return found MethodRecord or null
	 */
	public MethodRecord getMethodIfExists(final MethodRecord method) {
		final String methodName = method.getName();
		MethodRecord finalMethod = null;
		if (methodName != null) {
			for (int i = 0; (i < methods.size()) && (finalMethod == null); i++) {
				final String mName = methods.get(i).getName();
				if (methodName.equals(mName)) {
					finalMethod = methods.get(i);
				}
			}
		}
		return finalMethod;
	}

	@Override
	public String toString() {
		return "class " + name;
	}

	@Override
	public String getType() {
		return name;
	}

	@Override
	public int getRecordType() {
		return Record.CLASS;
	}

	@Override
	public void setType(final String type) {
		throw new IllegalStateException(
				"Type of ClassRecord cannot be changed.");
	}

	/**
	 * @return ClassFile object with all methods of this class
	 */
	public ClassFile getClassFile(final StringBuilder log) {
		final ClassInstruction instruction = new ClassInstruction(name,
				getInstructions());
		final ClassFile classfile = new ClassFile(instruction, log);
		classfile.save();
		return classfile;
	}

	public List<MethodRecord> getMethods() {
		return methods;
	}

	public void setMethods(final List<MethodRecord> list) {
		methods.clear();
		methods.addAll(list);
	}

	public String printInstructions() {
		final StringBuilder out = new StringBuilder();

		for (final MethodRecord entry : methods) {
			out.append(entry.getMethodInstruciton());
			out.append('\n');
		}
		return out.toString();

	}

	public List<MethodInstruction> getInstructions() {
		List<MethodInstruction> instructions = new ArrayList<MethodInstruction>();
		for (final MethodRecord method : methods) {
			instructions.add(method.getMethodInstruciton());
		}
		return instructions;
	}

}
