package tests.ui.view_item.product_panel.action_details;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActionDetailsIntegration {

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_condition_icon_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsIntegrationConditionIcon();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_read_more_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsIntegrationReadMore();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_us_bulk_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsIntegrationBulkPrice();
            verifyIsActionDetailsIntegrationBulkPriceDesc();
            verifyIsActionDetailsIntegrationBulkPriceSaving();
            verifyIsActionDetailsIntegrationBulkQuantity();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_product_listing_integration_see_feedback_prompt(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsActionDetailsIntegrationSeeFeedbackPrompt();
            quit();
        }};
    }
}
