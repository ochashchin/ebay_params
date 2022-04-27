package tests.ui.view_item.product_panel.action_details;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActionDetailsUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_us_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsUSVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_us_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsUSClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsFocusable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_action_details_unit_selectable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActionDetailsSelectable();
            quit();
        }};
    }


}
