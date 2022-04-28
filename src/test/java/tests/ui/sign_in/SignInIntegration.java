package tests.ui.sign_in;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

import static objects.Config.*;

public class SignInIntegration {

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_logo_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsIntegrationLogoRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_createAnAccount_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsIntegrationCreateAnAccountRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_signInWithEmailOrUserName_system_AtoB_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNameAtoBTransition();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_signInWithEmailOrUserName_system_BtoA_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNameAtoBTransition();
            verifyIsSystemSignInWithEmailOrUserNameBtoATransition();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_signInWithMobile_system_AtoB_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsSystemSignInWithMobileStateAtoBTransition()
                .quit();
    }

    @Test(groups = {INTEGRATION, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_signInWithMobile_system_BtoA_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsSystemSignInWithMobileStateAtoBTransition()
                .verifyIsSystemSignInWithMobileStateBtoATransition()
                .quit();
    }

}
