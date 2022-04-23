package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.SignInPage;
import pages.ProductPanel;

import static objects.Config.*;
import static pages.ProductPanel.*;

public class ViewItemTest extends BaseTest {

    private final String ViewItem = "ViewItem";

    private WebDriver viewItemSetup(@Optional String browser, @Optional String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver).open(local);
        return driver;
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_dailyDeals_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyDailyDealsIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_outlet_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyBrandOutletIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_help_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyHelpAndContactIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_sell_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifySellIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_no_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_item_in_watchlist_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyWatchlistDropDownIntegrationTransitionB()
                .click("//*[@*='vi-atl-lnk']")
                .refresh()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownItemInVisibility(true)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .verifyWatchlistDropDownItemInVisibility(false)
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyWatchListIntegrationRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("summaryTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySummaryRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("recentlyViewedTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyRecentlyViewedRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("bidOfferTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyBidOfferRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("watchListTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyWatchListRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("purchaseHistoryTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyPurchaseHistoryRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("sellingTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySavedSearchesRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSearches_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("savedSellersTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSellers_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySavedSellersRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("myGarageTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyMyGarageRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("messagesTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyMessagesRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("collectionTitle").split(" ")[0] + "')]")
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyCollectionRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("buyAgainTitle").split(" ")[0] + "')]")
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyBuyAgainRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[@*='gh-eb-nectar']")
                .quit();
    }

    @Test(groups = {ViewItem, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyCollectSpendRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Punkte')]")
                .quit();
    }

    @Test(groups = {ViewItem, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyPunkteRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]")
                .waitAnimToPlay()
                .verifyMyEbayIntegrationDropDownTransitionA()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyMyEbayIntegrationDropDownTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_notification_no_signed_in_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[4]")
                .verifyNotificationIntegrationDropDownTransitionANoSignedIn()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyNotificationIntegrationDropDownTransitionBNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionANoSignedIn()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartDropDownIntegrationTransitionB()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationItemsVisibility()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartDropDownIntegrationTransitionB()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationItemsVisibility()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyCartRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMinNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMinNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_max_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMax()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMaxNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_max_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ProductPanel(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMax()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMaxNumberVisibility()
                .quit();
    }

}
