package pages;

import objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AccountBar extends BasePage {

    public AccountBar(WebDriver driver) {
        super(driver);
    }

    public AccountBar open(String local) throws Exception {
        loadProps(local);

        if (!driver.getCurrentUrl().contains("http"))
            get(config.getProperty("url"));

        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return this;
    }

    List<String> visible = new ArrayList<String>() {
        {
            add("//*[@*='gh-top']//ancestor::*[@*='gh-eb-u']/span");
            add("//*[@*='gh-top']//ancestor::*[@*='gh-eb-u']/span/span");
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-t gh-divider-l']")).size(); i++) {
                add("(//*[@*='gh-top']//ancestor::*[@*='gh-t gh-divider-l'])" + "[" + i + "]");
            }
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*")).size(); i++) {
                add("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*" + "[" + i + "]");
            }
        }
    };

    List<String> clickable = new ArrayList<String>() {
        {
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-eb-u']//ancestor::a")).size(); i++) {
                add("(//*[@*='gh-top']//ancestor::*[@*='gh-eb-u']//ancestor::a)" + "[" + i + "]");
            }
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*")).size(); i++) {
                add("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*" + "[" + i + "]");
            }
        }
    };

    List<String> watchlist = new ArrayList<String>() {
        {
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/*")).size(); i++) {
                add("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/*" + "[" + i + "]");
            }
        }
    };

    List<String> myEbay = new ArrayList<String>() {
        {
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']/*/a")).size(); i++) {
                add("(//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']/*/a)" + "[" + i + "]");
            }
        }
    };

    public AccountBar verifyClickable() throws Exception {
        for (String s : clickable) {
            Assert.assertTrue(clickable(s));
        }
        return this;
    }

    public AccountBar verifyVisibility() throws Exception {
        for (String s : visible) {
            Assert.assertTrue(visible(s));
        }
        return this;
    }

    public AccountBar verifyDailyDealsIntegrationRedirection() throws Exception {
        click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Deals')]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("deals")));
        return this;
    }

    public AccountBar verifyBrandOutletIntegrationRedirection() throws Exception {
        click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Outlet')]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("outlet")));
        return this;
    }

    public AccountBar verifyHelpAndContactIntegrationRedirection() throws Exception {
        click("//*[@*='gh-top']//ancestor::a[contains(text(), '" + config.getProperty("help") + "')]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("helpTitle")));
        return this;
    }

    public AccountBar verifySellIntegrationRedirection() throws Exception {
        click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Sell')]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("sell")));
        return this;
    }

    public void verifyWatchlistDropDownIntegrationTransitionAtoB() throws Exception {
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]");
        waitAnimToPlay();
        verifyWatchlistDropDownIntegrationTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]");
        waitAnimToPlay();
        verifyWatchlistDropDownIntegrationTransitionB();
    }

    public AccountBar verifyWatchlistDropDownIntegrationTransitionA() throws Exception {
        for (String s : watchlist) {
            Assert.assertTrue(visible(s));
        }
        Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/a"));
        return this;
    }

    public AccountBar verifyWatchlistDropDownIntegrationTransitionB() throws Exception {
        for (String s : watchlist) {
            Assert.assertFalse(visible(s));
        }
        Assert.assertFalse(clickable("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/a"));
        return this;
    }

    public AccountBar verifyMyEbayIntegrationDropDownTransitionA() throws Exception {
        for (String s : myEbay) {
            Assert.assertTrue(visible(s));
            Assert.assertTrue(clickable(s));
        }
        return this;
    }

    public AccountBar verifyMyEbayIntegrationDropDownTransitionB() throws Exception {
        for (String s : myEbay) {
            Assert.assertFalse(visible(s));
            Assert.assertFalse(clickable(s));
        }
        return this;
    }

    public AccountBar verifyMyEbayIntegrationRedirectionNoSignedIn() throws Exception {
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifySignInRedirection();
        return this;
    }

    public AccountBar verifySignInRedirection() throws Exception {
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("signTitle")));
        return this;
    }

    public AccountBar verifyWatchListIntegrationRedirectionNoSignedIn() throws Exception {
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("signTitle")));
        return this;
    }

    public AccountBar verifyNotificationIntegrationDropDownTransitionANoSignedIn() throws Exception {
        Assert.assertTrue(visible("//*[@*='gh-top']//ancestor::*[@*='ghn-errb ghn-errb-a']/a"));
        Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='ghn-errb ghn-errb-a']/a"));
        return this;
    }
    public AccountBar verifyNotificationIntegrationDropDownTransitionBNoSignedIn() throws Exception {
        Assert.assertFalse(visible("//*[@*='gh-top']//ancestor::*[@*='ghn-errb ghn-errb-a']/a"));
        Assert.assertFalse(clickable("//*[@*='gh-top']//ancestor::*[@*='ghn-errb ghn-errb-a']/a"));
        return this;
    }

    public void verifyCartDropDownIntegrationTransitionANoSignedIn() throws Exception {
        Assert.assertTrue(visible("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-hover-gen-error gh-flyout-error']"));
        Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-hover-gen-error gh-flyout-error']/a"));
    }

    public AccountBar verifyCartDropDownIntegrationTransitionA() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*")).size(); i++) {
            Assert.assertTrue(visible("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
            Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
        }
        return this;
    }

    public AccountBar verifyCartDropDownIntegrationTransitionB() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*")).size(); i++) {
            Assert.assertFalse(visible("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
            Assert.assertFalse(clickable("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
        }
        return this;
    }

    public AccountBar verifyCartDropDownIntegrationItemsVisibility() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='minicart']/*")).size(); i++) {
            Assert.assertTrue(visible("//*[@*='minicart']/*" + "[" + i + "]"));
        }
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='minicart']//ancestor::a")).size(); i++) {
            Assert.assertTrue(clickable("(//*[@*='minicart']//ancestor::a)" + "[" + i + "]"));
        }
        return this;
    }

    public AccountBar verifyCartRedirectionNoSignedIn() throws Exception {
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("registrationTitle")));
        return this;
    }

    public AccountBar verifyCartRedirection() throws Exception {
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("cartTitle")));
        return this;
    }

    public AccountBar verifyCartLabelMinNumberVisibility() throws Exception {
        waitAnimToPlay();
        Assert.assertTrue(attribute("//*[@*='gh-top']//ancestor::*[@*='gh-cart-n']", "textContent").equals("1"));
        return this;
    }

    public AccountBar verifyCartLabelMaxNumberVisibility() throws Exception {
        waitAnimToPlay();
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        Assert.assertTrue(attribute("//*[@*='gh-top']//ancestor::*[@*='gh-cart-n']", "textContent").equals(n+""));
        return this;
    }

    public AccountBar verifyWatchlistDropDownItemInVisibility(boolean visibility) throws Exception {
        List<String> watchlist = new ArrayList<String>() {
            {
                add("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/a");
                add("//*[@*='gh-top']//ancestor::*[@*='carousel__list']//ancestor::*[@*='gh-img__wrapper']");
                add("//*[@*='gh-top']//ancestor::*[@*='carousel__list']//ancestor::*[@*='gh-info__title']");
                add("//*[@*='gh-top']//ancestor::*[@*='carousel__list']//ancestor::*[@*='gh-info__row--displayPrice']");
            }
        };
        for (String s : watchlist) {
            if (visibility) {
                Assert.assertTrue(visible(s));
            } else {
                Assert.assertFalse(visible(s));
            }
        }
        return this;
    }

    public AccountBar verifySummaryRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("summaryTitle") + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("summaryTitle")));
        return this;
    }

    public AccountBar verifyRecentlyViewedRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("recentlyViewedTitle") + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("recentlyViewedTitle")));
        return this;
    }

    public AccountBar verifyBidOfferRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("bidOfferTitle") + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("bidOfferTitle")));
        return this;
    }

    public AccountBar verifyWatchListRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("watchListTitle") + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("watchListTitle")));
        return this;
    }

    public AccountBar verifyPurchaseHistoryRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("purchaseHistoryTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("purchaseHistoryTitle")));
        return this;
    }

    public AccountBar verifySellingRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("sellingTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("sellingTitle")));
        return this;
    }

    public AccountBar verifySavedSearchesRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("savedSearchesTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("savedSearchesTitle")));
        return this;
    }

    public AccountBar verifySavedSellersRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("savedSellersTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("savedSellersTitle")));
        return this;
    }

    public AccountBar verifyMyGarageRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("myGarageTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("myGarageTitle")));
        return this;
    }

    public AccountBar verifyMessagesRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("messagesTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("messagesTitle")));
        return this;
    }

    public AccountBar verifyCollectionRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("collectionTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("collectionTitle")));
        return this;
    }

    public AccountBar verifyBuyAgainRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("buyAgainTitle").split(" ")[0] + "')]");
        Assert.assertTrue(waitTitle(config.getProperty("buyAgainTitle")));
        return this;
    }

    public AccountBar verifyCollectSpendRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[@*='gh-eb-nectar']");
        Assert.assertTrue(waitTitle("Nectar"));
        return this;
    }

    public AccountBar verifyPunkteRedirection() throws Exception {
        hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
        waitAnimToPlay();
        verifyMyEbayIntegrationDropDownTransitionA();
        click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Punkte')]");
        Assert.assertTrue(waitTitle("Punkte"));
        return this;
    }
}
