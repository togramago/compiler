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
     * <p/>
     * Maybe broken.
     *
     * @param outputString path to location
     */
    public static void setOutputString(final String outputString) {
        boolean hasNoOutput = (outputString == null);
        if   (!hasNoOutput) {
            final File file = new File(outputString);
            if (file.exists() && file.isDirectory()) {
                Driver.outputString = outputString;
            } else {
                hasNoOutput = true;
            }
        }
        if (hasNoOutput) {
            final File theDir = new File("repository/");
            if (!theDir.exists()) {
                theDir.mkdir();
            }

            Driver.outputString = theDir.getAbsolutePath()+ File.separator ;
            System.out.println("ERROR! Not valid path. Default path set.");
        }
        System.out.println("Path set to: " + Driver.outputString);
    }


    public void setFile(final String file) {
        this.file = file;
    }


    /**
     * Parse through the code with Lexer and Parser.  <br>
     * Initializes root. <br>
     *
     * @return true if parse finished correctly
     */
    private boolean parseWithGrammar() {
        boolean result = true;
        try {
            final ANTLRReaderStream input = new ANTLRReaderStream(
                    new FileReader(file));
            final MiniJavaLexer lexer = new MiniJavaLexer(input);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final MiniJavaParser parser = new MiniJavaParser(tokens);
            root = (CommonTree) parser.goal().getTree();
            Error.addError(parser.getNumberOfSyntaxErrors());
            if (Error.getErrors() > 0) {
                Error.fatalComplain(
                        "FATAL ERROR. " + parser.getNumberOfSyntaxErrors()
                                + " syntax error(s). Terminated.", log);
                result = false;
            }
        } catch (final Exception e) {
            log.append("Driver.compile() failed. ");
            result = false;
        }
        return result;
    }

    private boolean createSymbolTable() {
        final SymbolTableVisitor stVisitor = new SymbolTableVisitor(
                log);
        stVisitor.visit(root);
        symbolTable = stVisitor.getSymbolTable();

        stVisitor.setLookupMode();
        stVisitor.visit(root);

        return Error.getErrors() == 0;
    }

    private boolean checkTypes() {
        final TypeCheckVisitor tcVisitor = new TypeCheckVisitor(
                symbolTable, log);
        tcVisitor.visit(root);
        return Error.getErrors() == 0;
    }

    private boolean generateCode() {
        final GenerateCodeVisitor gcVisitor = new GenerateCodeVisitor(
                symbolTable, log);
        gcVisitor.visit(root);
        repository = gcVisitor.getClassRepository();
        return Error.getErrors() == 0;
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
            if (build = parseWithGrammar()) {
                build &= createSymbolTable();
                if (build)
                    build &= checkTypes();
                if (build && generateCode()) {
                    log.append("Build complete.\n\n");
                }
            }
            if (!build) {
                log.append("\nBuild failed. ");
                log.append(Error.getErrors());
                log.append(" error(s).\n");
            }
        }
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
