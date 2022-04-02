package pages;

import com.sun.deploy.util.SystemUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.security.Key;
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
    public static final String itemTitleIcon = "//div[@class='ux-icon-text__icon']/span";
    public static final String itemTitleIconTitle = "(//div[@class='ux-icon-text__text']/span)[1]";
    public static final String itemTitle = "//h1[@class='x-item-title__mainTitle']/span";
    public static final String itemTitleSub = "//div[@class='x-item-title__subTitle']/span";

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

    public ViewItemPage verifyIsEnlargeViewIntegrationFocusToViewport() throws Exception {
        String list = "(" + viewPortProgress + "/li)";
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        scrollToElement(viewPortDown);
        for (int i = 1; i <= size; i++) {
            String atr = attribute(list + "[" + i + "]", "class");
            Assert.assertTrue(atr.contains("selected"));
            if(atr.contains("selected")){
                for (int j = 1; j <= size; j++) {
                    if(j != i) Assert.assertFalse(attribute(list + "[" + j + "]", "class")
                            .contains("selected"));
                }
            }
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsIconTitleVisible() throws Exception {
        Assert.assertTrue(visible(itemTitleIcon));
        Assert.assertTrue(visibleLayout(itemTitleIcon));
        return this;
    }

    public ViewItemPage verifyIsIconTitleTextVisible() throws Exception {
        Assert.assertTrue(visible(itemTitleIconTitle));
        Assert.assertTrue(visibleLayout(itemTitleIconTitle));
        return this;
    }

    public ViewItemPage verifyIsItemTitleVisible() throws Exception {
        Assert.assertTrue(visible(itemTitle));
        Assert.assertTrue(visibleLayout(itemTitle));
        return this;
    }

    public ViewItemPage verifyIsSubTitleVisible() throws Exception {
        Assert.assertTrue(visible(itemTitleSub));
        Assert.assertTrue(visibleLayout(itemTitleSub));
        return this;
    }

    public ViewItemPage verifyIsTitleHighlightCopy() throws Exception {
        doubleClick(itemTitle);
        pressCopy();
        String buffer = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        Assert.assertTrue(buffer.contains(waitElement(itemTitle).getText()));
        return this;
    }

//    public ViewItemPage verifyIsActionDetailsVisibility() throws Exception {
//        scrollToElement(viewPortDown);
//        List<String> condition = new ArrayList<String>(){
//            {
//                add("//*[@*='d-item-condition-label']/span");
//                add("//*[@*='d-item-condition-text']//ancestor::*[@*='ux-textspans']");
//                add("//*[@class='ux-icon-text__icon']//ancestor::*[@class='icon icon--information-small']");
//                add("//*[@*='nonActPanel ']//ancestor::*[@*='ux-textspans ux-textspans--ITALIC']");
//                add("//*[@*='nonActPanel ']//ancestor::*[@*='ux-textspans ux-textspans--PSEUDOLINK']");
//                add("//label[@*='msku-sel-1']");
//                add("//label[@*='msku-sel-2']");
//                add("//label[@*='msku-sel-3']");
//                add("//select[@*='msku-sel-1']");
//                add("//select[@*='msku-sel-2']");
//                add("//select[@*='msku-sel-3']");
//                add("//*[@*='vi-vpqp-lbl-mp']");
//                add("//label[@*='qtyTextBox']");
//                for (int i = 0; i < waitElement("//*[@*='vi-vpqp-wrapper']").findElements(By.xpath("/*")).size(); i++) {
//                    add("(//*[@*='vi-vpqp-pills-0']/*)[" + i + "]//*[@*='vi-vpqp-text']");
//                    add("(//*[@*='vi-vpqp-pills-0']/*)[" + i + "]//*[@*='vi-vpqp-text vi-vpqp-price']");
//                }
//                add("//label[@*='qtyTextBox']");
//                add("//input[@*='qtyTextBox']");
//                add("//*[@*='mskuQtySubTxt']");
//                add("//*[@*='qtySubTxt']");
//                add("//*[@*='vi-txt-underline']");
//                add("//*[@*='byrfdbk_atf_lnk_sm']");
//            }
//        };
//        for (String e : condition) {
//            Assert.assertTrue(visible(e));
//            Assert.assertTrue(visibleLayout(e));
//        }
//        return this;
//    }
}
