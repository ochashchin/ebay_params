package tests;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SingInTest extends BaseTest {

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsUnitsVisibility()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsUnitsClickable()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_logo_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsIntegrationLogoRedirection()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_createAnAccount_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsIntegrationCreateAnAccountRedirection()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_signInWithEmailOrUserName_system_AtoB_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNameAtoBTransition()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_signInWithEmailOrUserName_system_BtoA_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNameBtoATransition()
                .quit();
    }

    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
    @Parameters({"browser", "local"})
    public void test_sign_in_signInWithEmailOrUserName_system_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive()
                .quit();
    }
}
