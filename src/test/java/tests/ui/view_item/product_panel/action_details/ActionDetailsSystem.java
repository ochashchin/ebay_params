package tests.ui.view_item.product_panel.action_details;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActionDetailsSystem {

    @Test(groups = {SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_system_quantity_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityFocusable();
            quit();
        }};
    }

    @Test(groups = {SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_system_quantity_boundary_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMin();
            verifyIsActionDetailsSystemQuantityBoundaryMax();
            quit();
        }};
    }

    @Test(groups = {SYSTEM, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_system_quantity_boundary_negative(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMinInvalid();
            verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid();
            verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid();
            quit();
        }};
    }

    @Test(groups = {SYSTEM, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_us_system_quantity_boundary_negative(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityUSBoundaryDefaultInvalid();
            quit();
        }};
    }
}
