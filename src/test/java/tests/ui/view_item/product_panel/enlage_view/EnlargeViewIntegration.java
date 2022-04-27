package tests.ui.view_item.product_panel.enlage_view;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class EnlargeViewIntegration {

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_enlarge_integration_expand(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsEnlargeViewResourceExpandable();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_enlarge_integration_right(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsEnlargeViewIntegrationRight();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_enlarge_integration_left(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsEnlargeViewIntegrationLeft();
            quit();
        }};
    }

}
