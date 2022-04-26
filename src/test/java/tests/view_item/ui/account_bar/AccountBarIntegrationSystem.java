package tests.view_item.ui.account_bar;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.ProductPanel;
import pages.SignInPage;

import static objects.Config.*;

public class AccountBarIntegrationSystem {

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyWatchlistDropDownIntegrationTransitionAtoB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_item_in_watchlist_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyWatchlistDropDownIntegrationTransitionB();
            click("//*[@*='vi-atl-lnk']");
            refresh();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]");
            waitAnimToPlay();
            verifyWatchlistDropDownItemInVisibility(true);
            click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]");
            verifyWatchlistDropDownItemInVisibility(false);
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifySummaryRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyRecentlyViewedRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyBidOfferRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyWatchListRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyPurchaseHistoryRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifySavedSearchesRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSellers_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifySavedSellersRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyMyGarageRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyMessagesRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyCollectionRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyBuyAgainRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyCollectSpendRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyPunkteRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new AccountBar(driver) {{
            open(local);
            verifyCartRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMin();
            click(actPanelAddToCartBtn);
            click("//*[@*='clzBtn viicon-close']");
        }};
        new AccountBar(driver) {{
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationItemsVisibility();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationTransitionB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new ProductPanel(driver) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMin();
            click(actPanelAddToCartBtn);
            click("//*[@*='clzBtn viicon-close']");
        }};
        new AccountBar(driver) {{
            verifyCartDropDownIntegrationTransitionB();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationItemsVisibility();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationTransitionB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMin();
            click(actPanelAddToCartBtn);
            click("//*[@*='clzBtn viicon-close']");
        }};
        new AccountBar(driver) {{
            verifyCartLabelMinNumberVisibility();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver) {{
            open(local);
            verifyIsSystemSignInWithEmailOrUserNamePositive();
        }};
        new ProductPanel(driver) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMin();
            click(actPanelAddToCartBtn);
            click("//*[@*='clzBtn viicon-close']");
        }};
        new AccountBar(driver) {{
            verifyCartLabelMinNumberVisibility();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION_SYSTEM, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_max_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver) {{
            open(local);
            scroll();
            selectDropDown();
            verifyIsActionDetailsSystemQuantityBoundaryMax();
            click(actPanelAddToCartBtn);
            click("//*[@*='clzBtn viicon-close']");
        }};
        new AccountBar(driver) {{
            verifyCartLabelMaxNumberVisibility();
            quit();
        }};
    }
}
