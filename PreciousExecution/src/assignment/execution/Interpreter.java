package assignment.execution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import assignment.instruction.ClassInstruction;
import assignment.interaction.ExecutionConsole;
import assignment.output.ClassRepository;

public class Interpreter {

    private final StringBuilder log;
    private final List<ClassInstruction> classes;
    private static boolean debug;

    public Interpreter(final String fileName) throws FileNotFoundException {
        log = new StringBuilder();
        /* file to interpret */
        File file = new File(fileName);
        if (file.exists()) {
            final ClassRepository repo = new ClassRepository(file, log);
            classes = repo.getClassInstructions();
        } else {
            throw new FileNotFoundException();
        }
    }

    public String showLog() {
        return log.toString();
    }

    public void execute() {
        final StackMachine stackMachine = new StackMachine(classes, log);
        stackMachine.execute();
    }

    public static void setDebug(final boolean debug) {
        Interpreter.debug = debug;
    }

    public static boolean debug() {
        return debug;
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            helpAndExit();
        } else {
            try {
                Interpreter.setDebug((new ExecutionConsole(args)).isDebug());
                Interpreter interpreter = new Interpreter(args[0]);
                interpreter.execute();
                System.out.println(interpreter.showLog());
            } catch (FileNotFoundException ffe) {
                System.out.println("EXCEPTION");
                ffe.printStackTrace();
            }
        }
    }

    private static void helpAndExit() {
        System.out
                .println("Use: java -jar <application> <input file> [arguments]");
        System.out
                .println("  <application>  - execute.jar");
        System.out.println("  <input file> - .tjr-input file");
        System.out.println("  arguments (unix like - '-fF' = '-f -F'):");
        System.out.println("    -d  debug mode");
        System.out.println();
        System.out.println("Example of execution may be: ");
        System.out
                .println("  java -jar execute.jar MyApp.tjr");
        System.out.println();
        System.exit(1);
    }

}
