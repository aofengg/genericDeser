package genericDeser.util;

public class Logger {

	public static enum DebugLevel {
		NUMBERS
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.NUMBERS;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
