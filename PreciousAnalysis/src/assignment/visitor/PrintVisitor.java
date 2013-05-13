package assignment.visitor;

import org.antlr.runtime.tree.CommonTree;

/**
 * 
 * Traverses the tree once and prints its contents.
 * 
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 * 
 */
public class PrintVisitor extends AbstractVisitor {
	private transient int indent;
	private transient final StringBuilder printResult;
	private transient final CommonTree root;

	public PrintVisitor(final CommonTree root) {
		super();
		indent = 0;
		printResult = new StringBuilder();
		printResult.append('\n');
		this.root = root;

	}

	/**
	 * Traverses the tree and saves it's contents to inner StringBuilder
	 * variable
	 */
	@Override
	public Object visit(final CommonTree tree) {
		Object result = tree;
		if (tree != null) {
			indent++;
			print(tree);
			final Object object = super.visit(tree);
			indent--;
			result = object;
		}
		return result;
	}

	private void print(final CommonTree node) {
		if (node != null) {
			int iindent = indent;
			while (iindent > 0) {
				printResult.append("      ");
				iindent--;
			}
			printResult.append(node);
			printResult.append('\n');
		}
	}

	/**
	 * @return printResult's string with contents of the tree
	 */
	public String getResult() {
		visit(root);
		printResult.append('\n');
		return printResult.toString();
	}
}
