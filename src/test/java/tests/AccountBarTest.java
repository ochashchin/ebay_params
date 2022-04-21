package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.ViewItemPage;

import static objects.Config.*;
import static objects.Config.LOCAL;
import static pages.ViewItemPage.actPanelAddToCartBtn;

public class AccountBarTest {

    private final String AccountBar = "AccountBar";

    @Test(groups = {AccountBar, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_c_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartDropDownIntegrationTransitionB()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationItemsVisibility()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }
}
