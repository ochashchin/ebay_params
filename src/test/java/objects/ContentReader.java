package objects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class ContentReader {

    public static FileInputStream getPropertyFile(String testName, String... values) throws IOException {

        for (String value : values) {
            testName += "_" + value.toLowerCase();
        }

        String path = System.getProperty("user.dir");

        path = path + "/src/test/resources/" + testName + ".properties";

        return new FileInputStream(path);
    }

    public static String getMethodName(int n) {
        return Thread.currentThread().getStackTrace()[n].getMethodName();
    }

    public static String getClassName(int n) {
        String s = Thread.currentThread().getStackTrace()[n].getFileName();
        return s.substring(0, s.lastIndexOf('.'));
    }
}