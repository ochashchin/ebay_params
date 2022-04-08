package objects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FailListener implements ITestListener {

    String path = System.getProperty("user.dir");
    PrintWriter writeFile;
    private File file;

    @Override
    public void onTestStart(ITestResult result) {
        file = new File(path + "/src/test/resources/" + result.getTestContext().getCurrentXmlTest().getName() + ".txt");
        if (file.isFile()) {
            try {
                Files.delete(Paths.get(file.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                writeFile = new PrintWriter(file, "UTF-8");
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        writeFile.println(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        writeFile.close();
    }
}


