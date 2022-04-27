package tests.ui.view_item.account_bar;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.ProductPanel;

import static objects.Config.*;

public class AccountBarUnit {

    public WebDriver viewItemSetup(@Optional String browser, @Optional String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver).open(local);
        return driver;
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyClickable();
            quit();
        }};
    }

}
