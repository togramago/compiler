package assignment.interaction;

public class ExecutionConsole {

	private final String[] args;
	private boolean debug;

	public static final String DEBUG = "-d";
	public static final String DEBUG_LONG = "--debug";

	public ExecutionConsole(final String[] args) {
		this.args = args;
		debug = false;
		parseArguments();
	}

	public void parseArguments() {
		for (int i = 1; i < args.length; i++) {
			if (DEBUG_LONG.equals(args[i]) || DEBUG.equals(args[i])) {
				debug = true;
			}
		}
	}

	public boolean isDebug() {
		return debug;
	}
}
