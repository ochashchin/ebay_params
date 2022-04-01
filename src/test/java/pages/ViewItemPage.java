package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewItemPage extends BasePage {

    public static final String baseURL = "https://www.ebay.com/itm/175037940958";
    public static final String viewPortList = "(//ul[@id='vertical-align-items-viewport']//ancestor::a[@class='pic pic1'])";
    public static final String viewPortDown = "//button[@class='v-pic-down']";
    public static final String viewPortUp = "//button[@class='v-pic-up']";
    public static final String viewPortProgress = "//ul[@id='vertical-align-items-viewport']";
    public static final String actionDetailsColors = "//select[@id='msku-sel-3']";
    public static final String enlargeView = "//div[@id='mainImgHldr']";
    public static final String enlargeViewFocus = "//button[@id='linkMainImg']";
    public static final String enlargeViewImage = "//div[@id='mainImgHldr']/img[@id='icImg']";
    public static final String enlargeViewButton = "//div[@id='vi-img-overlay--trans']";
    public static final String enlargeViewQuantity = "//h4[@id='mainImageHeader']";
    public static final String enlargeViewRight = "//button[@class='next-arr navigation-image-arr']";
    public static final String enlargeViewLeft = "//button[@class='prev-arr navigation-image-arr']";
    public static final String expandView = "//div[@id='viEnlargeImgLayer']";
    public static final String expandViewClose = "//button[@class='vi_pl_cls_btn']";

    public ViewItemPage(WebDriver driver) {
        super(driver);
    }

    public ViewItemPage open() throws Exception {
        get(baseURL);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        return this;
    }

    public ViewItemPage verifyIsViewPortFocusable() throws Exception {
        scrollToElement(viewPortDown);
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            click(viewPortList + "[" + i + "]");
            Assert.assertTrue(focusable(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortVisible() throws Exception {
        scrollToElement(viewPortDown);
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(visible(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortClickable() throws Exception {
        scrollToElement(viewPortDown);
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(clickable(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortHover() throws Exception {
        scrollToElement(viewPortDown);
        List<String> src = new ArrayList<>();
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) {
                click(viewPortDown);
                waitAnimToPlay();
            }
            hover(viewPortList + "[" + i + "]");
            waitAnimToPlay();
            String atr = attribute(enlargeViewImage, "src");
            Assert.assertFalse(src.contains(atr));
            src.add(atr);
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortScrollStateDown() throws Exception {
        scrollToElement(viewPortDown);
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortDown);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ViewItemPage verifyIsViewPortScrollStateUp() throws Exception {
        scrollToElement(viewPortDown);
        click(viewPortDown);
        waitAnimToPlay();
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortUp);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ViewItemPage verifyIsViewPortSetColor(String color) throws Exception {
        int index;
        switch (color) {
            case "Space Gray":
                scrollToElement(viewPortDown);
                index = 4;
                break;
            case "Green":
                index = 6;
                break;
            case "Gold":
                click(viewPortDown);
                index = 9;
                break;
            case "Silver":
                click(viewPortDown);
                index = 11;
                break;
            default:
                click(viewPortUp);
                index = 1;
                break;
        }
        waitAnimToPlay();
        click(viewPortList + "[" + index + "]");
        waitAnimToPlay();
        Assert.assertTrue(color.contains(new Select(waitElement(actionDetailsColors)).getFirstSelectedOption().getText()));
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewResourceVisible() throws Exception {
        String s = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        for (int i = 1; i <= size; i++) {
            boolean resourceVisibility = (Boolean) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", waitElement(enlargeViewImage));
            Assert.assertTrue(resourceVisibility);
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewResourceClickable() throws Exception {
        String s = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        for (int i = 1; i <= size; i++) {
            Assert.assertTrue(clickable(enlargeView));
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewResourceFocusable() throws Exception {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        for (int i = 1; i <= size; i++) {
            pressKeys(enlargeViewFocus, Keys.SHIFT);
            Assert.assertTrue((enlargeViewFocus).contains((String) ((JavascriptExecutor) driver).executeScript("return document.activeElement.id")));
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewResourceExpandable() throws Exception {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        click(enlargeViewRight);
        for (int i = 2; i <= size; i++) {
            click(enlargeViewButton);
            waitAnimToPlay();
            Assert.assertTrue(visible(expandView));
            click(expandViewClose);
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewIntegrationLeft() throws Exception {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        List<String> src = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        for (int i = 1; i <= size; i++) {
            String atr = attribute(enlargeViewImage, "src");
            Assert.assertFalse(src.contains(atr));
            src.add(atr);
            if (i != size) {
                click(enlargeViewLeft);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewIntegrationRight() throws Exception {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        List<String> src = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            String atr = attribute(enlargeViewImage, "src");
            Assert.assertFalse(src.contains(atr));
            src.add(atr);
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsEnlargeViewIntegrationColor() throws Exception {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(1, "- Select -");
                put(4, "Space Gray");
                put(6, "Green");
                put(9, "Gold");
                put(11, "Silver");
            }
        };
        for (int i = 1; i <= size; i++) {
            if(map.containsKey(i)){
                Assert.assertTrue(map.get(i).contains(new Select(waitElement(actionDetailsColors)).getFirstSelectedOption().getText()));
            }
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

}
