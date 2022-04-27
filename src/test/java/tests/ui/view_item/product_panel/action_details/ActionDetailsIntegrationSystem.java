package tests.ui.view_item.product_panel.action_details;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActionDetailsIntegrationSystem {

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_viewport_color_dropdown_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsViewPortSetColor("Space Gray");
            verifyIsViewPortSetColor("Green");
            verifyIsViewPortSetColor("Gold");
            verifyIsViewPortSetColor("Silver");
            verifyIsViewPortSetColor("select");
            quit();
        }};
    }


    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsColorDropdownIntegrationEnlageView();
            quit();
        }};
    }

}
