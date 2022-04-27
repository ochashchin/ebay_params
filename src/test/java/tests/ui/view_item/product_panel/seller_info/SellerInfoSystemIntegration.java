package tests.ui.view_item.product_panel.seller_info;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;
import pages.SignInPage;

import static objects.Config.*;
import static objects.Config.LOCAL;

public class SellerInfoSystemIntegration {

    @Test(groups = {SYSTEM_INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sell_now_system_integration_contact_seller_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new ProductPanel(driver) {{
            open(local);
            verifyIsSellerInfoSystemIntegrationContactSellerRedirection();
            quit();
        }};
    }


}
