package npctools.utils;

public class Logger {

	private static boolean verboseMode = false;

	public Logger() {

	}

	public static void log(Object m) {
		if (verboseMode) {
			System.out.println("[LOG] " + m);
		}
	}
	
	public static void log(Object m, String tag) {
		if(verboseMode) {
			System.out.println("[" + tag + "] " + m);
		}
	}

	public static void logError(Object m) {
		if (verboseMode) {
			System.out.println("\033[0;31m[ERROR]\033[0m " + m);
		}
	}

	public static void setVerbose(boolean verbose) {
		verboseMode = verbose;
	}

}
