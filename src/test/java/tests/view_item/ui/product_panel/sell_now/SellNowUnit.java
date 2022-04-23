package tests.view_item.ui.product_panel.sell_now;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class SellNowUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sell_now_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellNowVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sell_now_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellNowClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_product_listing_integration_see_feedback_prompt(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsActionDetailsIntegrationSeeFeedbackPrompt()
                .quit();
    }
}
