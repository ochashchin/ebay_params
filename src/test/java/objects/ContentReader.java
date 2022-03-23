package objects;

import java.io.FileInputStream;
import java.io.IOException;

public class ContentReader {

    public static FileInputStream getPropertyFile(String testName, String... values) throws IOException {

        for (String value : values) {
            testName += "_" + value;
        }

        String path = System.getProperty("user.dir");

        path = path + "/src/test/resources/" + testName + ".properties";

        return new FileInputStream(path);
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}