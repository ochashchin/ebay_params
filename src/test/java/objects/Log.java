package objects;

import org.testng.Reporter;

public class Log {
    private static int steps = 1;

    public Log() {
    }

    public static void printLn(String message) {
        Reporter.log( message + "<br>");
    }
}
