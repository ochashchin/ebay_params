package tests.ui.view_item.product_panel.why_to_buy;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;
import pages.SignInPage;

import static objects.Config.*;

public class WhyToBuySystemIntegration {

    @Test(groups = {SYSTEM_INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sign_in_watchers_quantity_state_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver){{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new ProductPanel(driver){{
            open(local);
            selectDropDown();
            setIsWhyToBuyWatchersQuantityStateA();
            click("//*[@*='vi-atl-lnk']");
            refresh();
            setIsWhyToBuyWatchersQuantityStateAtoBTransfer();
            setIsWhyToBuyWatchersQuantityStateB();
            click("//*[@*='vi-atl-lnk']");
            refresh();
            setIsWhyToBuyWatchersQuantityStateBtoATransfer();
            quit();
        }};
    }
}
