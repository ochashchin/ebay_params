package tests.view_item.ui.product_panel.act_panel;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActPanelIntegration {

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_us_integration_price_credit(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelIntegrationPriceCreditVisibility();
            quit();
        }};
    }



}
