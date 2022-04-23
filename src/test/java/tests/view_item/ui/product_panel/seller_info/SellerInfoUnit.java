package tests.view_item.ui.product_panel.seller_info;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class SellerInfoUnit {

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_seller_info_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellerInfoUnitsVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_seller_info_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
                    scroll();
                    verifyIsSellerInfoUnitsClickable();
                    quit();
        }};
    }

}
