package tests.ui.view_item.account_bar;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.SignInPage;

import static objects.Config.*;

public class AccountBarIntegration extends AccountBarUnit {

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_dailyDeals_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyDailyDealsIntegrationRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_outlet_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyBrandOutletIntegrationRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_help_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyHelpAndContactIntegrationRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_sell_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifySellIntegrationRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_no_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyWatchlistDropDownIntegrationTransitionAtoB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyWatchListIntegrationRedirectionNoSignedIn();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_in_state_transition_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]");
            waitAnimToPlay();
            verifyMyEbayIntegrationDropDownTransitionB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationRedirectionNoSignedIn();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("summaryTitle") + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("recentlyViewedTitle") + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("bidOfferTitle") + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("watchListTitle") + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("purchaseHistoryTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("sellingTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSearches_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("savedSellersTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("myGarageTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("messagesTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("collectionTitle").split(" ")[0] + "')]");
            verifyCollectionRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
            waitAnimToPlay();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("buyAgainTitle").split(" ")[0] + "')]");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[@*='gh-eb-nectar']");
            verifySignInRedirection();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            verifyMyEbayIntegrationDropDownTransitionA();
            click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Punkte')]");
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_notification_dropdown_no_signed_in_state_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[4]");
            verifyNotificationIntegrationDropDownTransitionANoSignedIn();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]");
            waitAnimToPlay();
            verifyNotificationIntegrationDropDownTransitionBNoSignedIn();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_state_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)){{
            open(local);
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationTransitionANoSignedIn();
            hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]");
            waitAnimToPlay();
            verifyCartDropDownIntegrationTransitionB();
            quit();
        }};
    }

    @Test(groups = {INTEGRATION, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local)) {{
            open(local);
            verifyCartRedirectionNoSignedIn();
            quit();
        }};
    }
}
