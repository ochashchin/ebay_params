package tests.view_item.ui.product_panel.item_title;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ItemTitleUnit {

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_item_title_refurbished_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsIconTitleVisible();
            verifyIsIconTitleTextVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_item_title_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsItemTitleVisible();
            verifyIsSubTitleVisible();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_title_unit_highlight(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsTitleHighlightCopy();
            quit();
        }};
    }
}
