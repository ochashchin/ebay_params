package objects;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkipListener implements IMethodInterceptor {

    String path = System.getProperty("user.dir");

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext context) {
        File file = new File(path + "/src/test/resources/" + context.getCurrentXmlTest().getName() + ".txt");
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            IMethodInstance instns = list.get(i);

            List<String> grps = Arrays.asList(instns.getMethod().getConstructorOrMethod().getMethod().getName());

            try {
                if (file.isFile()) {
                    if (Files.lines(Paths.get(file.getAbsolutePath())).anyMatch(grps::contains)) {
                        result.add(instns);
                    }
                } else {
                    result.add(instns);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}


