package tests.ui.view_item.sign_in;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;
import pages.SignInPage;

import static objects.Config.*;

public class SignInIntegrationSystem {

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_contactSeller_system_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver)
                .open(local)
                .click("(//*[@*='ux-seller-section__content']//ancestor::*[@*='ux-seller-section__item']/*)[3]");
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemIntegrationSignInRedirection()
                .quit();
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_sell_now_system_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver)
                .open(local)
                .click("(//*[contains(@*,'vi-slt-c vi-slt-instSale')]//child::span[2])[1]");
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemIntegrationSignInRedirection()
                .quit();
    }
}

