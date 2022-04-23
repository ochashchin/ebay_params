package tests.view_item.ui.product_panel.enlage_view;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class EnlargeViewIntegrationSystem {

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_focus_to_viewport(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsEnlargeViewIntegrationFocusToViewport();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_view_integration_color_dropdown(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsEnlargeViewIntegrationColorDropdown();
            quit();
        }};
    }
}
