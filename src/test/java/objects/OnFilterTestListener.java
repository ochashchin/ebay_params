package objects;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class OnFilterTestListener implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext context) {

        String[] search = context.getIncludedGroups();

        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance iMethodInstance : list) {
            String[] now = iMethodInstance.getMethod().getGroups();

            boolean pass = false;
            boolean[] conditions = new boolean[search.length];

            int i = 0;
            for (String arg : search) {
                for (String arg2 : now) {
                    if (arg.equals(arg2)) {
                        conditions[i++] = true;
                    }
                }
            }
            for (boolean b : conditions) {
                if(b){
                    pass = true;
                } else {
                    pass = false;
                    break;
                }
            }
            if(pass){
                result.add(iMethodInstance);
            }
        }

        return result;
    }
}
