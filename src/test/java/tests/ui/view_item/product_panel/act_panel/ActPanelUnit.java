package tests.ui.view_item.product_panel.act_panel;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ActPanelUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_basic_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelUnitBasicVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_spec_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelUnitSpecificVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_us_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelUnitUSVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_basic_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelUnitBasicClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_act_panel_us_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsActPanelUnitUSClickable();
            quit();
        }};
    }

}
