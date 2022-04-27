package tests.ui.view_item.product_panel.seller_info;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class SellerInfoIntegration {

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_seller_info_integration_sell_name_rating_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellerInfoIntegrationSellerNameRatingRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_seller_info_integration_visit_store_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellerInfoIntegrationVisitStoreRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_seller_info_integration_see_other_items_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsSellerInfoIntegrationSeeOtherItemsRedirection();
            quit();
        }};
    }
}
