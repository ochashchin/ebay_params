package objects;

import org.testng.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnSkipTestListener implements IMethodInterceptor, ITestListener  {

    private File testFile = new File(System.getProperty("user.dir") + "/src/test/resources/");
    private String output = "";
    private PrintWriter writeFile;

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext context) {

        String testName = context.getCurrentXmlTest().getName();
        testFile = new File(testFile.getAbsolutePath() + "/" + testName.substring(0, testName.lastIndexOf('_')) + "/" + testName + ".txt");

        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            IMethodInstance instns = list.get(i);

            List<String> grps = Arrays.asList(instns.getMethod().getConstructorOrMethod().getMethod().getName());

            try {
                if (testFile.isFile()) {
                    if (Files.lines(Paths.get(testFile.getAbsolutePath())).anyMatch(grps::contains)) {
                        result.add(instns);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        output += result.getMethod().getMethodName() + "\n";
    }

    @Override
    public void onFinish(ITestContext context) {
        String s = context.getCurrentXmlTest().getName();
        File testDir = new File(testFile.getParent());

        File file = new File(testDir.getAbsolutePath() + "/" + context.getCurrentXmlTest().getName() + "_retest.txt");

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
        } else {
            if (testFile.isFile()) {
                try {
                    Files.delete(Paths.get(testFile.getAbsolutePath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


