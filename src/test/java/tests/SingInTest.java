package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.ViewItemPage;

import static objects.Config.*;

public class SingInTest extends BaseTest {
    private final String SignIn = "SignIn";

//    @Test(groups = {"SignIn", "US", "UK", "DE"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsUnitsVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_au_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsUnitsVisibilityAu()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver("opera"))
//                .open(local)
//                .verifyIsUnitsClickable()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_au_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsUnitsClickableAu()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_logo_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsIntegrationLogoRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_createAnAccount_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsIntegrationCreateAnAccountRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_signInWithEmailOrUserName_system_AtoB_transition(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsSystemSignInWithEmailOrUserNameAtoBTransition()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_signInWithEmailOrUserName_system_BtoA_transition(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsSystemSignInWithEmailOrUserNameAtoBTransition()
//                .verifyIsSystemSignInWithEmailOrUserNameBtoATransition()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "US", "UK", "DE", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_signInWithEmailOrUserName_system_positive(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsSystemSignInWithEmailOrUserNamePositive()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_signInWithMobile_system_AtoB_transition(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsSystemSignInWithMobileStateAtoBTransition()
//                .quit();
//    }
//
//    @Test(groups = {"SignIn", "AU"})
//    @Parameters({"browser", "local"})
//    public void test_sign_in_signInWithMobile_system_BtoA_transition(@Optional() String browser, @Optional() String local) throws Exception {
//        new SignInPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsSystemSignInWithMobileStateAtoBTransition()
//                .verifyIsSystemSignInWithMobileStateBtoATransition()
//                .quit();
//    }

//    @Test(groups = {SignIn, US, UK, DE, AU})
//    @Parameters({BROWSER, LOCAL})
//    public void test_sign_in_contactSeller_system_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
//        new ViewItemPage(driver)
//                .open(local)
//                .click("(//*[@*='ux-seller-section__content']//ancestor::*[@*='ux-seller-section__item']/*)[3]");
//        new SignInPage(driver)
//                .open(local)
//                .verifyIsSystemIntegrationSignInRedirection()
//                .quit();
//    }

    @Test(groups = {SignIn, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_sell_now_system_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver)
                .open(local)
                .click("(//*[contains(@*,'vi-slt-c vi-slt-instSale')]//child::span[2])[1]");
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemIntegrationSignInRedirection()
                .quit();
    }

}
