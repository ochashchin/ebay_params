package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static objects.ContentReader.getClassName;
import static objects.ContentReader.getPropertyFile;

public class AccountBar extends BasePage {

    public AccountBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountBar click(String xPath) throws Exception {
        onClick(xPath);
        return this;
    }

    @Override
    public AccountBar open(String local) throws Exception {
        if (local == null || local.equals(""))
            config.load(getPropertyFile(getClassName(2), System.getProperty("testLocal")));
        else
            config.load(getPropertyFile(getClassName(2), local));

        if (!driver.getCurrentUrl().contains("http"))
            get(config.getProperty("url"));

        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return this;
    }

    @Override
    public AccountBar hover(String xPath) throws Exception {
        onHover(xPath);
        return this;
    }

    @Override
    public AccountBar pressKeys(String xPath, CharSequence keys) throws Exception {
        onPressKeys(xPath, keys);
        return this;
    }

    @Override
    public AccountBar doubleClick(String xPath) throws Exception {
        onDoubleClick(xPath);
        return this;
    }

    @Override
    public AccountBar waitAnimToPlay() throws Exception {
        onWaitAnimToPlay(600);
        return this;
    }

    @Override
    public AccountBar waitLongAnimToPlay() throws Exception {
        onWaitAnimToPlay(1200);
        return this;
    }

    @Override
    public AccountBar refresh() throws Exception {
        onRefresh();
        return this;
    }

    @Override
    public AccountBar quit() throws Exception {
        onQuit();
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

    public AccountBar verifyWatchlistIntegrationDropDownTransitionA() throws Exception {
        for (String s : watchlist) {
            Assert.assertTrue(visible(s));
        }
        Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='rvi__title']/a"));
        return this;
    }

    public AccountBar verifyWatchlistIntegrationDropDownTransitionB() throws Exception {
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
        click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]");
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

    public AccountBar verifyCartIntegrationDropDownTransitionANoSignedIn() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*")).size(); i++) {
            Assert.assertTrue(visible("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
            Assert.assertTrue(clickable("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
        }
        return this;
    }

    public AccountBar verifyCartIntegrationDropDownTransitionBNoSignedIn() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*")).size(); i++) {
            Assert.assertFalse(visible("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
            Assert.assertFalse(clickable("//*[@*='gh-top']//ancestor::*[@*='gh-minicart-header gh-minicart-header-empty']/*" + "[" + i + "]"));
        }
        return this;
    }

    public AccountBar verifyCartIntegrationDropDownTransitionCNoSignedIn() throws Exception {
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
        Assert.assertTrue(waitTitle(config.getProperty("cartTitle")));
        return this;
    }

    public AccountBar verifyCartLabelMinNumberNoSignedIn() throws Exception {
        waitAnimToPlay();
        Assert.assertTrue(attribute("//*[@*='gh-top']//ancestor::*[@*='gh-cart-n']", "textContent").equals("1"));
        return this;
    }

    public AccountBar verifyCartLabelMaxNumberNoSignedIn() throws Exception {
        waitAnimToPlay();
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        Assert.assertTrue(attribute("//*[@*='gh-top']//ancestor::*[@*='gh-cart-n']", "textContent").equals(n+""));
        return this;
    }

}
