package assignment.interaction;

import assignment.output.PathManager;


/**
 * Console UI management
 */
public class Console {

    private final String[] args;
    private final Interaction interaction;

    public static final String SHOW_SYMBOL_TABLE_LONG = "--showSymbolTable";
    public static final String SHOW_SYMBOL_TABLE = "-s";
    public static final String SHOW_AST_LONG = "--showAST";
    public static final String SHOW_AST = "-a";
    public static final String OUTPUT = "-o";
    public static final String OUTPUT_LONG = "--output";

    private static final int NUM_FREE_RESULT = 2;
    private static final int NUM_OUTPUT = 3;

    public Console(final String[] args, final Interaction interaction) {
        this.args = args;
        this.interaction = interaction;
    }

    /**
     * Parse arguments and set modes
     */
    public void parseArguments() {
        for (int i = 1; i < args.length; i++) {
            if (checkArgument(args[i]) == NUM_OUTPUT) {
                if ((args.length - 1 > i)
                        && (checkArgument(args[i + 1]) == NUM_FREE_RESULT)) {
                    PathManager.getInstance().setPath(args[i + 1]);
                }
            }
        }
    }

    /**
     * Check argument to set mode or to go to next argument
     *
     * @param arg argument to check
     * @return 0 if flag is set,
     *         <br>NUM_OUTPUT for output path,
     *         <br>NUM_FREE_RESULT to show that it's that next expected argument for NUM_MODE or NUM_OUTPUT
     */
    private int checkArgument(final String arg) {
        int result = 0;
        final int length = arg.length();
        if (OUTPUT_LONG.equals(arg) || OUTPUT.equals(arg)) {
            result = NUM_OUTPUT;
        } else if (SHOW_SYMBOL_TABLE_LONG.equals(arg)
                || SHOW_SYMBOL_TABLE.equals(arg)) {
            interaction.shouldShowSymbolTable();
        } else if (SHOW_AST_LONG.equals(arg) || SHOW_AST.equals(arg)) {
            interaction.shouldShowAST();
        } else {
            if ((arg.charAt(0) == '-') && (length >= 2)) {
                int counter = 1;
                while ((counter < length) && checkSetting(arg.charAt(counter))) {
                    ++counter;
                }
            } else {
                result = NUM_FREE_RESULT;
            }
        }
        return result;
    }

    /**
     * Check concatenation of short flags
     *
     * @param character from concatenation
     * @return true if flag is valid
     */
    private boolean checkSetting(final char character) {
        boolean canContinue = true;
        switch (character) {
            case 's':
                interaction.shouldShowSymbolTable();
                break;
            case 'a':
                interaction.shouldShowAST();
                break;
            default:
                canContinue = false;
        }
        return canContinue;
    }
}
