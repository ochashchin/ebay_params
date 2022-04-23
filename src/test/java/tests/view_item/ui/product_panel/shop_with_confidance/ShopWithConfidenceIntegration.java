package tests.view_item.ui.product_panel.shop_with_confidance;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class ShopWithConfidenceIntegration {

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_shop_with_integration_top_rated_plus_learn_more_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            verifyIsShopWithConfidenceIntegrationTopRatedPlusLearnMoreRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_shop_with_integration_money_back_guarantee_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)){{
            open(local);
            scroll();
            verifyIsShopWithConfidenceIntegrationMoneyBackGuaranteeLearnMoreRedirection(local);
            quit();
        }};
    }
}
