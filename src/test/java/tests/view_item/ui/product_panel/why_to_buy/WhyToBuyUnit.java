package tests.view_item.ui.product_panel.why_to_buy;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class WhyToBuyUnit {

    @Test(groups = {UNIT, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsWhy2BuyUnitVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_us_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsWhy2BuyUnitUSVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_us_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitUSClickable()
                .quit();
    }

    @Test(groups = {UNIT, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitClickable()
                .quit();
    }

}
