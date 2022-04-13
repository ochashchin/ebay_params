package objects;

import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnSkipTestListener implements IMethodInterceptor, ITestListener  {

    private String path = System.getProperty("user.dir");
    private File testFile;
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext context) {

        String testName = context.getCurrentXmlTest().getName();
        testFile = new File(path + "/src/test/resources/" + testName.substring(0, testName.lastIndexOf('_')) + "/" + testName + ".txt");

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
    public void onTestSuccess(ITestResult result) {
        if (testFile.isFile()) {
            try {
                Files.delete(Paths.get(testFile.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


