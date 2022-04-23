package tests.view_item.ui.product_panel.view_port;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;
import static objects.Config.AU;

public class ViewPortIntegration {

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_up(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsViewPortScrollStateUp();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_down(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsViewPortScrollStateDown();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_hover(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsViewPortHover();
            quit();
        }};
    }

}
