package tests.ui.view_item.product_panel.why_to_buy;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;

import static objects.Config.*;

public class WhyToBuyIntegration {

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_integration_warranty_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            scroll();
            verifyIsWhy2BuyWarrantyLinkRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_integration_returns_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            scroll();
            verifyIsWhy2BuyReturnsLinkRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_integration_learn_more_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            scroll();
            verifyIsWhy2BuyLearnMoreLinkRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_why2buy_integration_see_terms_to_apply_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ProductPanel(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            scroll();
            scroll();
            verifyIsWhy2BuySeeTermsToApplyLinkRedirection();
            quit();
        }};
    }

}
