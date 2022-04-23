package tests.view_item.ui.product_panel.act_panel;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;


public class ActPanelIntegrationSystem {

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_integration_system_action_details_buy_it_now_negative(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            click(actPanelBuyItNowBtn);
            verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility();
            verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_and_action_details_negative_integration_add_to_cart(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            click(actPanelAddToCartBtn);
            verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility();
            verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus();
            quit();
        }};
    }
}
