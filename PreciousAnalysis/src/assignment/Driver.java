package assignment;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import assignment.instruction.ClassInstruction;
import assignment.interaction.Interaction;
import assignment.output.ClassRepository;
import assignment.scope.SymbolTable;
import assignment.visitor.GenerateCodeVisitor;
import assignment.visitor.PrintVisitor;
import assignment.visitor.SymbolTableVisitor;
import assignment.visitor.TypeCheckVisitor;

//TODO: IF enough time: Fix grammar for new A().foo()[0];
//TODO: Fix grammar for no or multiple statements in methods;

/**
 * The class that started it all. Uses ANTLR-generated MiniJavaLexer and
 * MiniJavaParser tools. Traverses the AST of the test program, builds the
 * symbol table from received AST nodes. Calls checking methods.
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 * @see SymbolTableVisitor
 * @see TypeCheckVisitor
 */

public class Driver {
    private StringBuilder log;

    private transient String file;
    private transient CommonTree root;
    private boolean build;
    private transient SymbolTable symbolTable;
    private ClassRepository repository;

    private static String outputString;

    /**
     * @param file name of the test program
     */
    public Driver(final String file) {
        this.file = file;
        log = new StringBuilder();
        build = false;
    }

    public Driver() {
        log = new StringBuilder();
        build = false;
    }

    /**
     * @return String with path to storage location
     */
    public static String outputString() {
        return outputString;
    }

    /**
     * Sets new output path
     *
     * @param outputString path to location
     */
    public static void setOutputString(final String outputString) {
        boolean should = outputString == null;
        if (!should) {
            final File file = new File(outputString);
            if (file.exists() && file.isDirectory()) {
                Driver.outputString = outputString;
            } else {
                should = true;
            }
        }
        if (should) {
            final File theDir = new File("input");
            if (!theDir.exists()) {
                theDir.mkdir();
            }
            Driver.outputString = theDir.getAbsolutePath();
            if (Driver.outputString.charAt(Driver.outputString.length() - 1) != '/') {
                Driver.outputString += "/";
            }
            System.out.println("ERROR! Not valid path. Default path set.");
        }
        System.out.println("Path set to: " + Driver.outputString);
    }

    public void setFile(final String file) {
        this.file = file;
    }

    /**
     * This is where the magic happens. Error handling included. Terminated on
     * syntax errors.
     */
    public void compile() {
        if (file == null) {
            log.append("File not set.");
        } else {
            log = new StringBuilder();
            Error.reset();
            int errors = 0;
            try {
                final ANTLRReaderStream input = new ANTLRReaderStream(
                        new FileReader(file));
                final MiniJavaLexer lexer = new MiniJavaLexer(input);
                final CommonTokenStream tokens = new CommonTokenStream(lexer);
                final MiniJavaParser parser = new MiniJavaParser(tokens);
                root = (CommonTree) parser.goal().getTree();
                errors += parser.getNumberOfSyntaxErrors();
                if (errors > 0) {
                    Error.fatalComplain(
                            "FATAL ERROR. " + parser.getNumberOfSyntaxErrors()
                                    + " syntax error(s). Terminated.", log);
                    build = false;
                } else {

					/* Symbol table construction */
                    final SymbolTableVisitor stVisitor = new SymbolTableVisitor(
                            log);
                    stVisitor.visit(root);
                    symbolTable = stVisitor.getSymbolTable();

                    stVisitor.setLookupMode();
                    stVisitor.visit(root);

					/* Type checking */
                    final TypeCheckVisitor tcVisitor = new TypeCheckVisitor(
                            symbolTable, log);
                    tcVisitor.visit(root);

                    errors += Error.getErrors();
                    if (checkForErrors(errors, false)) {
                        final GenerateCodeVisitor gcVisitor = new GenerateCodeVisitor(
                                symbolTable, log);
                        gcVisitor.visit(root);
                        repository = gcVisitor.getClassRepository();
                        checkForErrors(errors, true);
                    }
                }
            } catch (Exception e) {
                log.append("Driver.compile() failed. ");
            }
        }
    }

    private boolean checkForErrors(final int errors, final boolean finalCheck) {
        boolean result;
        if (errors > 0) {
            log.append("\nBuild failed. " + errors + " error(s).\n");
            result = false;
            build = false;
        } else {
            result = true;
            build = true;
            if (finalCheck) {
                log.append("Build complete.\n\n");
            }
        }
        return result;
    }

    /**
     * @return true if build is complete, false if errors exist
     */
    public boolean isValidBuild() {
        return build;
    }

    /**
     * @return string with AST contents
     */
    public String printTree() {
        String result = null;
        if (root != null) {
            // print tree
            final PrintVisitor dfsPrint = new PrintVisitor(root);
            result = dfsPrint.getResult();
        }
        return result;
    }

    /**
     * @return string with symbol table contents
     */
    public String printSymbolTable() {
        String print = null;
        if (symbolTable != null) {
            print = symbolTable.printTable();
        }
        return print;
    }

    /**
     * @return string with instructions list of classes from class repository
     */
    public String printInstructions() {
        final List<ClassInstruction> list = repository.getClassInstructions();
        final StringBuilder builder = new StringBuilder();
        for (final ClassInstruction instruction : list) {
            builder.append(instruction);
            builder.append('\n');
        }
        return builder.toString();
    }

    /**
     * @return string with log contents: list of errors and build message
     */
    public String getLog() {
        return log.toString();
    }

    public static void main(final String[] args) {
        new Interaction(args).execute();
    }

}
