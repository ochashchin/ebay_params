package tests.ui.view_item.sign_in;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

import static objects.Config.*;

public class SignInSystem {

    @Test(groups = {SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_signInWithEmailOrUserName_system_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
            quit();
        }};
    }

}
