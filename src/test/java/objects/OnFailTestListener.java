package objects;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class OnFailTestListener implements ITestListener {

    private String path = System.getProperty("user.dir");
    private PrintWriter writeFile;
    private String output;

    @Override
    public void onTestStart(ITestResult result) {
        output = "";
    }

    @Override
    public void onTestFailure(ITestResult result) {
        output += result.getMethod().getMethodName() + "\n";
    }

    @Override
    public void onFinish(ITestContext context) {
        String s = context.getCurrentXmlTest().getName();
        File testDir = new File(path + "/src/test/resources/" + s.substring(0, s.lastIndexOf('_')));
        File file = new File(path + "/src/test/resources/" + s.substring(0, s.lastIndexOf('_')) + "/" + context.getCurrentXmlTest().getName() + ".txt");
        if (output.length() > 0) {
            if (!testDir.exists()) {
                testDir.mkdirs();
            }
            try {
                writeFile = new PrintWriter(file, "UTF-8");
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            writeFile.print(output);
            writeFile.close();
        }
    }
}


