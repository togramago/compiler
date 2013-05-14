import assignment.scope.MethodRecord;

public class CompilerException extends Exception {

    public static final String NULL_POINTER_EXCEPTION = "Null pointer exception";
    public static final String CLASS_EXCEPTION = "Class not found";
    public static final String IDENTIFIER_EXCEPTION = "Identifier not found";
    public static final String METHOD_EXCEPTION = "Method not found";
    public static final String DUPLICATE_DECLARATION_EXCEPTION = "duplicate declaration";
    public static final String LENGTH_EXCEPTION = ".length set after wrong type";
    public static final String NOT_INTEGER_EXCEPTION = "only integers allowed";
    public static final String TYPE_BRACES_EXCEPTION = "[ ] set after wrong type";
    public static final String TYPE_MISMATCH_EXCEPTION = "type mismatch";
    public static final String DECLARATION_MISMATCH_EXCEPTION = "declaration mismatch";

    // Generation code errors that should not be in release
    public static final String GC_OUT_OF_METHOD_EXCEPTION = "current method not found";
    public static final String UNEXPECTED_ERROR = "unexpected error";
    public static final String ERROR_STRING = "ERROR ";
    private static int errors;

    public CompilerException(final String message, final StringBuilder logger) {
        logger.append(message);
    }

    private CompilerException() {
        reset();
    }

    public CompilerException(final String message, final String name,
                             final MethodRecord method, final StringBuilder logger) {
        errors++;

        String methodString;
        if (method == null) {
            methodString = "";
        } else {
            methodString = " in " + method.getSignature();
        }

        if (message.equals(NULL_POINTER_EXCEPTION)) {
            logger.append(ERROR_STRING).append(message).append(methodString);
        } else {
            logger.append(ERROR_STRING).append(message).append(": ").append(name).append(methodString);
        }
        logger.append('\n');
    }

    /**
     * @return number of errors at the moment
     */
    static public int getErrors() {
        return errors;
    }

    /**
     * reset the number of errors
     */
    static public void reset() {
        errors = 0;
    }
}
