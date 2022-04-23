package tests.view_item.ui.product_panel.view_port;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ViewPortUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsViewPortVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
                open(local);
                scroll();
                verifyIsViewPortClickable();
                quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
                open(local);
                scroll();
                verifyIsViewPortFocusable();
                quit();
        }};
    }

}
