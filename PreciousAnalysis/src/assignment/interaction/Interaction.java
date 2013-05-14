package assignment.interaction;

import java.io.File;

import assignment.Driver;
import assignment.output.PathManager;

/**
 * UI management
 *
 * @author Margarita Litkevych
 * @author Tymur Maryokhin
 */
public class Interaction {

    /**
     * run Driver in graphical mode or in console mode. in long annotation:
     * --mode ARG, where ARG = 0 for console mode, else for window mode. in
     * short annotation: -c for console mode, -w for window mode.
     */
    private boolean windowMode;
    /**
     * Flag for showing symbol table in console mode. --showSymbolTable or -s
     */
    private boolean showSymbolTable;
    /**
     * Flag for showing AS-tree of test program. --showAST or -a
     */
    private boolean showAST;
    private final String[] args;

    public Interaction(final String[] args) {
        this.args = args;
        showSymbolTable = false;
        showAST = false;

        new Console(args, this).parseArguments();
    }

    public void setShowSymbolTable(final boolean showSymbolTable) {
        this.showSymbolTable = showSymbolTable;
    }

    public void setShowAST(final boolean showAST) {
        this.showAST = showAST;
    }

    /**
     * Runs interaction routine: choose console or window mode, run Driver and so on.
     */
    public void execute() {
        PathManager.getInstance().setPath(null);

        if (isAllowedName()) {
            final Driver driver = new Driver();
            driver.setFile(args[0]);
            System.out.println("Compiling " + args[0]);
            driver.compile();
            if (showSymbolTable) {
                System.out.println(driver.printSymbolTable());
            }
            if (showAST) {
                System.out.println(driver.printTree());
            }
            if (driver.isValidBuild()) {
                System.out.println(driver.printInstructions());
            }
            System.out.println(driver.getLog());
        } else {
            helpAndExit();
        }


    }

    private static void helpAndExit() {
        System.out
                .println("Use: java -jar <application> <input file> [arguments] [-o|--output <output file>]");
        System.out
                .println("  <application>  - generate.jar");
        System.out.println("  <input file> -  .java-input file");
        System.out.println("  <output path> - path to the folder with tracing /");
        System.out.println("  arguments (unix like - '-fF' = '-f -F'):");
        System.out.println("    -w | --mode n, n>0           window mode");
        System.out.println("    -c | --mode 0                console mode");
        System.out.println("    -s | --showSymbolTable       show symbol table");
        System.out.println("    -a | --showAST               show AS-tree");
        System.out.println("    -o | --output <output path>  explicitly set output path");
        System.out.println();
        System.out.println("Example of execution may be: ");
        System.out
                .println("  java -jar execute.jar MyApp.tjr");
        System.out.println();
        System.exit(1);
    }

    /**
     * checks if specified java file exists
     * @return true if it exists
     */
    private boolean isAllowedName() {
        return new File(args[0]).exists();
    }
}
