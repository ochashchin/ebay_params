package tests.view_item.ui.product_panel.enlage_view;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;
import static objects.Config.AU;

public class EnlargeViewUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsEnlargeViewResourceVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsEnlargeViewResourceClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsEnlargeViewResourceFocusable();
            quit();
        }};
    }

}
