package tests.view_item.ui.product_panel.act_panel;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActPanelSystemIntegration {

    @Test(groups = {SYSTEM_INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_system_integration_buy_it_now_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            click(actPanelBuyItNowBtn);
            verifyIsActionDetailsSytemIntegrationActPanelBuyItNowDialogVisibilityPositive();
            quit();
        }};
    }

    @Test(groups = {SYSTEM_INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_system_integration_add_to_cart_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            click(actPanelAddToCartBtn);
            verifyIsActionDetailsActPanelSystemIntegrationAddToCartDialogVisibilityPositive();
            quit();
        }};
    }

}
