package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.List;
import java.util.*;

import static objects.ContentReader.getClassName;
import static objects.ContentReader.getPropertyFile;

public class ProductPanel extends BasePage {

    public static final String baseURL = "itm/175037940958";
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
    public static final String actionDetailsConditionText = "//*[@*='d-item-condition-label']/span";
    public static final String actionDetailsConditionDescText = "//*[@*='d-item-condition-text']//ancestor::*[@*='ux-textspans']";
    public static final String actionDetailsConditionDescTextIconButton = "//*[@*='nonActPanel ']/descendant::*[@class='fake-link fake-link--action']";
    public static final String actionDetailsConditionDescTextIcon = "//*[@class='ux-icon-text__icon']//ancestor::*[@class='icon icon--information-small']";
    public static final String actionDetailsConditionSellerNote = "//*[@*='nonActPanel ']//ancestor::*[@*='ux-textspans ux-textspans--ITALIC']";
    public static final String actionDetailsReadMore = "//*[@*='nonActPanel ']//ancestor::*[@*='ux-textspans ux-textspans--PSEUDOLINK']";
    public static final String actionDetailsNetworkText = "//label[@*='msku-sel-1']";
    public static final String actionDetailsStorageText = "//label[@*='msku-sel-2']";
    public static final String actionDetailsColorText = "//label[@*='msku-sel-3']";
    public static final String actionDetailsNetworkDropDown = "//select[@*='msku-sel-1']";
    public static final String actionDetailsStorageDropDown = "//select[@*='msku-sel-2']";
    public static final String actionDetailsColorDropDown = "//select[@*='msku-sel-3']";
    public static final String actionDetailsBulkText = "//*[@*='vi-vpqp-lbl-mp']";
    public static final String actionDetailsQuantityText = "//label[@*='qtyTextBox']";
    public static final String actionDetailsQuantityEditText = "//input[@*='qtyTextBox']";
    public static final String actionDetailsQuantityDescText = "//*[@*='mskuQtySubTxt']";
    public static final String actionDetailsQuantityAvailableText = "//*[@*='qtySubTxt']";
    public static final String actionDetailsQuantitySoldText = "//*[@*='vi-txt-underline']";
    public static final String actionDetailsQuantityFeedbackText = "//*[@*='byrfdbk_atf_lnk_sm']";
    public static final String dialogCondition = "//*[@*='lightbox-dialog__window lightbox-dialog__window--fade keyboard-trap--active']";
    public static final String actPanelPriceText = "//*[@*='lbl-value-set']/*[1]";
    public static final String actPanelPriceInt = "//*[@*='mainPrice']/*[1]/*[1]";
    public static final String actPanelCreditText = "//*[@*='vi-ppc-buybox-msg']/*[1]";
    public static final String actPanelBuyItNowBtn = "//*[@*='binBtn_btn']";
    public static final String actPanelAddToCartBtn = "//*[@*='atcRedesignId_btn']";
    public static final String actPanelAddToWatchListBtn = "//*[@*='vi-atl-lnk']";
    public static final String cartDialog = "//*[@*='vi_oly_atcRedesignId_overlay-atc-container']";
    public static final String calculatorDialog = "//*[@*='calculatorWrapper']";

    Map<String, Object> data = new HashMap<>();

    public ProductPanel(WebDriver driver) {
        super(driver);
    }

    public ProductPanel open(String local) throws Exception, Error {
        if (local == null || local.equals(""))
            config.load(getPropertyFile(getClassName(2), System.getProperty("testLocal")));
        else
            config.load(getPropertyFile(getClassName(2), local));

        if (!driver.getCurrentUrl().contains("http"))
            get(config.getProperty("url") + baseURL);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        waitAnimToPlay();
        driver.navigate().refresh();

        return this;
    }

    public ProductPanel scroll() throws Exception, Error {
        scrollToElement(viewPortDown);
        return this;
    }

    public ProductPanel verifyIsViewPortFocusable() throws Exception, Error {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            click(viewPortList + "[" + i + "]");
            Assert.assertTrue(focusable(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ProductPanel verifyIsViewPortVisible() throws Exception, Error {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(visible(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public void verifyIsViewPortClickable() throws Exception, Error {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(clickable(viewPortList + "[" + i + "]"));
        }
    }

    public ProductPanel verifyIsViewPortHover() throws Exception, Error {
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

    public ProductPanel verifyIsViewPortScrollStateDown() throws Exception, Error {
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortDown);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ProductPanel verifyIsViewPortScrollStateUp() throws Exception, Error {
        click(viewPortDown);
        waitAnimToPlay();
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortUp);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ProductPanel verifyIsViewPortSetColor(String color) throws Exception, Error {
        int index;
        switch (color) {
            case "Space Gray":
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
        color = config.getProperty(color, color);
        Assert.assertTrue(color.contains(new Select(waitElement(actionDetailsColors)).getFirstSelectedOption().getText()));
        return this;
    }

    public ProductPanel verifyIsEnlargeViewResourceVisible() throws Exception, Error {
        String s = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
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

    public ProductPanel verifyIsEnlargeViewResourceClickable() throws Exception, Error {
        String s = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
        for (int i = 1; i <= size; i++) {
            Assert.assertTrue(clickable(enlargeView));
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ProductPanel verifyIsEnlargeViewResourceFocusable() throws Exception, Error {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
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

    public ProductPanel verifyIsEnlargeViewResourceExpandable() throws Exception, Error {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        for (int i = 1; i <= size; i++) {
            if (i >= 2) {
                click(enlargeViewFocus);
                waitAnimToPlay();
                Assert.assertTrue(visible(expandView));
                waitAnimToPlay();
                click(expandViewClose);
            }
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ProductPanel verifyIsEnlargeViewIntegrationLeft() throws Exception, Error {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
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

    public ProductPanel verifyIsEnlargeViewIntegrationRight() throws Exception, Error {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
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

    public ProductPanel verifyIsEnlargeViewIntegrationColorDropdown() throws Exception, Error {
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(1, config.getProperty("select"));
                put(4, "Space Gray");
                put(6, "Green");
                put(9, "Gold");
                put(11, "Silver");
            }
        };
        for (int i = 1; i <= size; i++) {
            if (map.containsKey(i)) {
                Assert.assertTrue(map.get(i).contains(new Select(waitElement(actionDetailsColors)).getFirstSelectedOption().getText()));
            }
            if (i != size) {
                click(enlargeViewRight);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ProductPanel verifyIsEnlargeViewIntegrationFocusToViewport() throws Exception, Error {
        String list = "(" + viewPortProgress + "/li)";
        String t = attribute(enlargeViewQuantity, "textContent");
        int size = Integer.parseInt(t.substring(t.lastIndexOf(" ") + 1));
        for (int i = 1; i <= size; i++) {
            String atr = attribute(list + "[" + i + "]", "class");
            Assert.assertTrue(atr.contains("selected"));
            if (atr.contains("selected")) {
                for (int j = 1; j <= size; j++) {
                    if (j != i) Assert.assertFalse(attribute(list + "[" + j + "]", "class")
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

    public ProductPanel verifyIsIconTitleVisible() throws Exception, Error {
        Assert.assertTrue(visible(itemTitleIcon));
        Assert.assertTrue(visibleLayout(itemTitleIcon));
        return this;
    }

    public ProductPanel verifyIsIconTitleTextVisible() throws Exception, Error {
        Assert.assertTrue(visible(itemTitleIconTitle));
        Assert.assertTrue(visibleLayout(itemTitleIconTitle));
        return this;
    }

    public ProductPanel verifyIsItemTitleVisible() throws Exception, Error {
        Assert.assertTrue(visible(itemTitle));
        Assert.assertTrue(visibleLayout(itemTitle));
        return this;
    }

    public ProductPanel verifyIsSubTitleVisible() throws Exception, Error {
        Assert.assertTrue(visible(itemTitleSub));
        Assert.assertTrue(visibleLayout(itemTitleSub));
        return this;
    }

    public ProductPanel verifyIsTitleHighlightCopy() throws Exception, Error {
        doubleClick(itemTitle);
        pressCopy();
        String buffer = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
        Assert.assertTrue(buffer.contains(waitElement(itemTitle).getText()));
        return this;
    }

    public ProductPanel verifyIsActionDetailsUSVisibility() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsConditionDescTextIcon);
                add(actionDetailsBulkText);
                for (int i = 0; i < driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                    add("(//*[@*='vi-vpqp-pills-" + i + "'])//*[@*='vi-vpqp-text']");
                    add("(//*[@*='vi-vpqp-pills-" + i + "'])//*[@*='vi-vpqp-text vi-vpqp-price']");
                }
                add(actionDetailsQuantityDescText);
            }
        };
        for (String e : order) {
            Assert.assertTrue(visible(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsVisibility() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsConditionText);
                add(actionDetailsConditionDescText);
                add(actionDetailsConditionSellerNote);
                add(actionDetailsReadMore);
                add(actionDetailsNetworkText);
                add(actionDetailsStorageText);
                add(actionDetailsColorText);
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
                add(actionDetailsQuantityText);
                add(actionDetailsQuantityEditText);
                add(actionDetailsQuantityAvailableText);
                add(actionDetailsQuantitySoldText);
                add(actionDetailsQuantityFeedbackText);
            }
        };
        for (String e : order) {
            Assert.assertTrue(visible(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsUSClickable() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsConditionDescTextIconButton);
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                    add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
                }
            }
        };
        for (String e : order) {
            Assert.assertTrue(clickable(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsClickable() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsReadMore);
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
                add(actionDetailsQuantitySoldText);
                add(actionDetailsQuantityFeedbackText);
            }
        };
        for (String e : order) {
            Assert.assertTrue(clickable(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsUSFocusable() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsConditionDescTextIconButton);
            }
        };
        for (String e : order) {
            pressKeys(e, Keys.SHIFT);
            Assert.assertTrue(focusable(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsFocusable() throws Exception, Error {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
            }
        };
        for (String e : order) {
            pressKeys(e, Keys.SHIFT);
            Assert.assertTrue(focusable(e));
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsSelectable() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
            }
        };
        for (String e : elements) {
            Assert.assertTrue(new Select(waitElement(e)).getOptions().size() > 1);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationConditionIcon() throws Exception, Error {
        click(actionDetailsConditionDescTextIconButton);
        waitAnimToPlay();
        Assert.assertTrue(visible(dialogCondition));
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationReadMore() throws Exception, Error {
        click(actionDetailsReadMore);
        waitAnimToPlay();
        Assert.assertTrue(visible("(//*[@*='ux-layout-section ux-layout-section--condition ux-layout-section--SECTION_WITH_BACKGROUND']//ancestor::*[@*='ux-labels-values__values-content'])[2]"));
        return this;
    }

    public ProductPanel verifyIsColorDropdownIntegrationEnlageView() throws Exception, Error {
        Set<String> set = new HashSet<>();
        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(0, config.getProperty("select"));
                put(1, "Space Gray");
                put(2, "Green");
                put(3, "Gold");
                put(4, "Silver");
            }
        };
        for (int i = 0; i < map.size(); i++) {
            Select s = new Select(waitElement(actionDetailsColorDropDown));
            s.selectByVisibleText(map.get(i));
            String atr = attribute(enlargeViewImage, "src");
            Assert.assertFalse(set.contains(atr));
            set.add(atr);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationBulkPrice() throws Exception, Error {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<String>() {{
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
            }
        }};
        for (int i = 0; i < list.size(); i++) {
            click(list.get(i));
            waitAnimToPlay();
            String atr = attribute("//*[@*='price']", "textContent");
            Assert.assertFalse(set.contains(atr));
            set.add(atr);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationBulkPriceDesc() throws Exception, Error {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<String>() {{
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
            }
        }};
        for (int i = 1; i < list.size(); i++) {
            click(list.get(i));
            waitAnimToPlay();
            String atr = attribute("//*[@*='vi-originalPrice']", "textContent");
            Assert.assertFalse(set.contains(atr));
            set.add(atr);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationBulkPriceSaving() throws Exception, Error {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<String>() {{
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
            }
        }};
        for (int i = 1; i < list.size(); i++) {
            click(list.get(i));
            waitAnimToPlay();
            for (int j = 1; j <= waitElement("//*[@*='vi-percent-off']").findElements(By.xpath("/*")).size(); j++) {
                Assert.assertTrue(visible("(//*[@*='vi-percent-off']/*)[" + i + "]"));
            }
            Assert.assertTrue(visible("//*[@*='vi-discountValue']"));
            String atr = attribute("//*[@*='is-saved']", "textContent");
            Assert.assertFalse(set.contains(atr));
            set.add(atr);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationBulkQuantity() throws Exception, Error {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<String>() {{
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
            }
        }};
        for (int i = 0; i < list.size(); i++) {
            click(list.get(i));
            waitAnimToPlay();
            String atr = attribute("//*[@*='qtyInput']", "value");
            Assert.assertFalse(set.contains(atr));
            set.add(atr);
        }
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityFocusable() throws Exception, Error {
        pressKeys(actionDetailsQuantityEditText, Keys.SHIFT);
        Assert.assertTrue(focusable(actionDetailsQuantityEditText));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityBoundaryMax() throws Exception, Error {
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, String.valueOf(n));
        Assert.assertFalse(visible("//*[@*='errorimg']"));
        Assert.assertFalse(visible("//*[@*='u-cb err']"));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid() throws Exception, Error {
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, (n + 1) + "");
        Assert.assertTrue(visible("//*[@*='errorimg']"));
        Assert.assertTrue(visible("//*[@*='u-cb err']"));
        Assert.assertTrue(waitElement("//*[@*='u-cb err']").getText().contains(n + ""));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityBoundaryMin() throws Exception, Error {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "1");
        Assert.assertFalse(visible("//*[@*='errorimg']"));
        Assert.assertFalse(visible("//*[@*='u-cb err']"));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityBoundaryMinInvalid() throws Exception, Error {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "0");
        Assert.assertTrue(visible("//*[@*='errorimg']"));
        Assert.assertTrue(visible("//*[@*='u-cb err']"));
        Assert.assertTrue(waitElement("//*[@*='u-cb err']").getText().contains("1"));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityUSBoundaryDefaultInvalid() throws Exception, Error {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "x");
        Assert.assertTrue(attribute(actionDetailsQuantityEditText, "value").contains("3"));
        return this;
    }

    public ProductPanel verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid() throws Exception, Error {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "x");
        Assert.assertTrue(attribute("//*[@*='qtyErrMsg']/div", "textContent").contains("1"));
        return this;
    }

    public ProductPanel selectDropDown() throws Exception {
        List<String> elements = new ArrayList<String>() {
            {
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
            }
        };
        for (String element : elements) {
            int i = 0;
            while (new Select(waitElement(element)).getFirstSelectedOption().getText().equals(config.getProperty("select")) || new Select(waitElement(element)).getFirstSelectedOption().getText().equals("Space Gray")) {
                new Select(waitElement(element)).selectByIndex(i++);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ProductPanel verifyIsActPanelUnitSpecificVisible() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add("//*[@*='mainPrice']/*[1]/*[5]");
                add("//*[@*='mainPrice']/*[1]/*[5]/*[1]");
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelUnitBasicVisible() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelPriceText);
                add(actPanelPriceInt);
                add(actPanelBuyItNowBtn);
                add(actPanelAddToCartBtn);
                add(actPanelAddToWatchListBtn);
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelUnitUSVisible() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelCreditText);
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelUnitBasicClickable() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelBuyItNowBtn);
                add(actPanelAddToCartBtn);
                add(actPanelAddToWatchListBtn);
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelUnitUSClickable() throws Exception, Error {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelCreditText);
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelIntegrationPriceCreditVisibility() throws Exception, Error {
        click(actPanelCreditText);
        waitAnimToPlay();
        Assert.assertTrue(visible(calculatorDialog));
        return this;
    }

    public ProductPanel verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility() throws Exception, Error {
        waitAnimToPlay();
        List<String> elements = new ArrayList<String>() {
            {
                for (int i = 1; i <= 3; i++) {
                    add("(//*[@*='errorIcon'])[" + i + "]");
                    add("(//*[@*='u-cb err'])[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus() throws Exception, Error {
        waitAnimToPlay();
        List<String> elements = new ArrayList<String>() {
            {
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
            }
        };
        search:
        {
            for (String element : elements) {
                if (focusable(element)) break search;
            }
            Assert.assertFalse(false);
        }
        Assert.assertTrue(true);
        return this;
    }

    public ProductPanel verifyIsActionDetailsSytemIntegrationActPanelBuyItNowDialogVisibilityPositive() throws Exception, Error {
        Assert.assertTrue(visible("//*[@*='streamline-bin-layer']"));
        return this;
    }

    public ProductPanel verifyIsActionDetailsActPanelSystemIntegrationAddToCartDialogVisibilityPositive() throws Exception, Error {
        Assert.assertTrue(visible("//*[@*='app-atc-layer-redesign-content-wrapper ']"));
        return this;
    }

    public ProductPanel verifyIsWhy2BuyUnitVisibility() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='shippingSummary']//ancestor::*[@*='shippingPlaceHolderId']");
                add("//*[@*='shippingSummary']//ancestor::*[@*='sh_gr_bld_new']");
                add("//*[@*='shippingSummary']//ancestor::*[@*='vi-del-ship-txt']");
                add("//*[@*='itemLocation']//ancestor::*[@*='iti-eu-label vi-u-flL']");
                add("//*[@*='itemLocation']//ancestor::*[@*='availableAtOrFrom']");
                add("//*[@*='vim x-returns-minview']//ancestor::*[@*='ux-labels-values__labels-content']//*[@*='ux-textspans']");
                add("//*[@*='vim x-returns-minview']//ancestor::*[@*='ux-action']");
                add("//*[@*='vim d-payments-minview']//ancestor::*[@*='ux-labels-values__labels-content']//span");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vim x-returns-minview']//ancestor::*[@*='ux-textspans']")).size(); i++) {
                    add("(//*[@*='vim x-returns-minview']//ancestor::*[@*='ux-textspans'])[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vim d-payments-minview']//ancestor::*[@*='ux-labels-values__values-content']//*[@*='img']")).size(); i++) {
                    add("(//*[@*='vim d-payments-minview']//ancestor::*[@*='ux-labels-values__values-content']//*[@*='img'])[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsWhy2BuyUnitUSVisibility() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='vi-crwarranty-logo vi-crwarranty-image']");
                add("//*[@*='vi-crwarranty-title']");
                add("//*[@*='iti-eu-label vi-u-flL']");
                add("//*[@*='availableAtOrFrom']");
                add("//*[@*='ux-textspans']//parent::a[contains(@href, 'creditcard')]/span");
                add("//*[@*='ux-labels-values__values-content']//ancestor::span[@class='ux-textspans ux-textspans--SECONDARY']");
                add("//*[@*='fake-link fake-link--action']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK']");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-crwarranty-subtext']/*")).size(); i++) {
                    add("//*[@*='vi-crwarranty-subtext']/*[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='w2b-cnt w2b-3 w2b-brdr']/span")).size(); i++) {
                    add("(//*[@*='w2b-cnt w2b-3 w2b-brdr']/span)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-labels-values__labels col-3']//ancestor::*[@*='ux-textspans']")).size(); i++) {
                    add("(//*[@*='ux-labels-values__labels col-3']//ancestor::*[@*='ux-textspans'])[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-labels-values__values-content']//parent::*[@*='ux-labels-values__values col-9']//span[@*='img']")).size(); i++) {
                    add("(//*[@*='ux-labels-values__values-content']//parent::*[@*='ux-labels-values__values col-9']//span[@*='img'])[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-labels-values__values-content']//parent::*[@*='ux-labels-values__values col-9']//span[@*='ux-textspans']")).size(); i++) {
                    add("(//*[@*='ux-labels-values__values-content']//parent::*[@*='ux-labels-values__values col-9']//span[@*='ux-textspans'])[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsWhy2BuyUnitUSClickable() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='vi-crwarranty-subtext']//parent::a[contains(@href, 'refurbished')]");
                add("//*[@*='ux-labels-values__values-content']//ancestor::span[@class='ux-textspans ux-textspans--SECONDARY']");
                add("//*[@*='fake-link fake-link--action']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK']");
                add("//*[@*='ux-textspans']//parent::a[contains(@href, 'creditcard')]");
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsWhy2BuyUnitClickable() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='vim x-returns-minview']//ancestor::a");
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsWhy2BuyWarrantyLinkRedirection() throws Exception, Error {
        click("//*[@*='vi-crwarranty-subtext']//parent::a[contains(@href, 'refurbished')]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Warranty"));
        return this;
    }

    public ProductPanel verifyIsWhy2BuyReturnsLinkRedirection() throws Exception, Error {
        Object before = ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        click("//*[@*='vim x-returns-minview']//ancestor::span[contains(@*, 'SECONDARY')]");
        Object after = ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        Assert.assertNotSame(before, after);
        Assert.assertTrue(visible("//*[@*='ux-layout-section-module']//parent::*[@*='vim x-returns-maxview']"));
        return this;
    }

    public ProductPanel verifyIsWhy2BuySeeTermsToApplyLinkRedirection() throws Exception, Error {
        click("//*[@*='fake-link fake-link--action']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK']");
        Assert.assertTrue(visible(calculatorDialog));
        return this;
    }

    public ProductPanel verifyIsWhy2BuyLearnMoreLinkRedirection() throws Exception, Error {
        click("//*[@*='ux-textspans']//parent::a[contains(@href, 'creditcard')]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Mastercard"));
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceUnitsBasicVisibility() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='SHOP_WITH_CONFIDENCE0-0-1-2-title']/*");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__data-title']/span")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__data-title']/span)[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceUnitsUSVisibility() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__data-item-text']/span")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__data-item-text']/span)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__data-item-text']/a/span")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__data-item-text']/a/span)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__icon-wrapper']/span")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__icon-wrapper']/span)[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceUnitsClickable() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__data-item-text']/a")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceIntegrationRefurbishedLearnMoreRedirection() throws Exception, Error {
        click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[1]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Refurbished"));
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceIntegrationTopRatedPlusLearnMoreRedirection() throws Exception, Error {
        click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[2]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("standards"));
        return this;
    }

    public ProductPanel verifyIsShopWithConfidenceIntegrationMoneyBackGuaranteeLearnMoreRedirection(String local) throws Exception, Error {
        click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[" + (local.equals("US") ? "3" : "1") + "]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle(config.getProperty("money", "Money")));
        return this;
    }

    public ProductPanel verifyIsSellerInfoUnitsVisibility() throws Exception, Error {
        waitAnimToPlay();
        waitAnimToPlay();
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='section-title__title-container']//parent::*[@*='ux-textspans ux-textspans--BOLD']");
                add("//*[@*='ux-seller-section__item']/span");
                add("//*[@*='follow-ebay_text']");
                add("//*[@*='follow-heart-wrapper heartIcon ']");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-seller-section__item--seller']/a/span")).size(); i++) {
                    add("(//*[@*='ux-seller-section__item--seller']/a/span)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-seller-section__item--seller']/span")).size(); i++) {
                    add("(//*[@*='ux-seller-section__item--seller']/span)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-seller-section__item']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK']")).size(); i++) {
                    add("(//*[@*='ux-seller-section__item']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK'])[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsSellerInfoUnitsClickable() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='follow-ebay follow-ebay-fakeLink nounderline btn btn--large btn--primary']");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-seller-section__item--seller']/a")).size(); i++) {
                    add("(//*[@*='ux-seller-section__item--seller']/a)[" + i + "]");
                }
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-seller-section__item']/a")).size(); i++) {
                    add("(//*[@*='ux-seller-section__item']/a)[" + i + "]");
                }
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsSellerInfoIntegrationSellerNameRedirection() throws Exception, Error {
        click("//*[@*='ux-seller-section__item--seller']/a[1]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("on eBay"));
        return this;
    }

    public ProductPanel verifyIsSellerInfoIntegrationSellerNameRatingRedirection() throws Exception, Error {
        click("//*[@*='ux-seller-section__item--seller']/a[2]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle(config.getProperty("feedback", "Feedback")));
        return this;
    }

    public ProductPanel verifyIsActionDetailsIntegrationSeeFeedbackPrompt() throws Exception, Error {
        click("//*[@*='soldwithfeedback']//ancestor::*[@*='byrfdbk_atf_lnk']");
        waitAnimToPlay();
        Assert.assertTrue(visible("//*[@*='oly_container']//ancestor::*[@*='byrfdbk_modal']"));
        return this;
    }

    public ProductPanel verifyIsSellerInfoIntegrationVisitStoreRedirection() throws Exception, Error {
        click("(//*[@*='ux-seller-section__item']/a)[2]");
        Assert.assertTrue(waitTitle(config.getProperty("stores", "eBay Stores")));
        return this;
    }

    public ProductPanel verifyIsSellerInfoIntegrationSeeOtherItemsRedirection() throws Exception, Error {
        click("(//*[@*='ux-seller-section__item']/a)[3]");
        Assert.assertTrue(waitTitle("| eBay"));
        return this;
    }

    public ProductPanel verifyIsSellNowVisibility() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='inst_sale_msg']");
                add("(//*[contains(@*,'vi-slt-c vi-slt-instSale')]//child::span[2])[1]");
            }
        };
        for (String element : elements) {
            Assert.assertTrue(visible(element));
        }
        return this;
    }

    public ProductPanel verifyIsSellNowClickable() throws Exception, Error {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='inst_sale_msg']");
                add("(//*[contains(@*,'vi-slt-c vi-slt-instSale')]//child::span[2])[1]");
            }
        };
        for (String element : elements) {
            Assert.assertTrue(clickable(element));
        }
        return this;
    }

    public ProductPanel verifyIsSellerInfoSystemIntegrationContactSellerRedirection() throws Exception {
        click("(//*[@*='ux-seller-section__content']//ancestor::*[@*='ux-seller-section__item']/*)[3]");
        Assert.assertTrue(waitTitle(config.getProperty("contactSellerTitle")));
        return this;
    }

    public ProductPanel verifyIsWhyToBuyWatchersQuantityPersistence() throws Exception {
        int before = Integer.parseInt(attribute("(//*[@*='why2buy']//ancestor::*[@*='w2b-cnt w2b-3 w2b-brdr'])[2]", "textContent"));
        driver.navigate().refresh();
        int after = Integer.parseInt(attribute("(//*[@*='why2buy']//ancestor::*[@*='w2b-cnt w2b-3 w2b-brdr'])[2]", "textContent"));
        Assert.assertTrue(after > before);
        return this;
    }

    public ProductPanel setWhyToBuyWatchlistButtonStateA() throws Exception {
        data.put("setWhyToBuyWatchlistButtonStateA", Integer.parseInt(attribute("//*[@*='vi-atl-lnk']//ancestor::*[@*='vi-atw-txt']", "textContent")));
        return this;
    }

    public ProductPanel setWhyToBuyWatchlistButtonStateB() throws Exception {
        data.put("setWhyToBuyWatchlistButtonStateB", Integer.parseInt(attribute("//*[@*='vi-atl-lnk']//ancestor::*[@*='vi-atw-txt']", "textContent")));
        return this;
    }

    public ProductPanel verifyIsWhyToBuyWatchlistButtonStateAtoBTransfer() throws Exception {
        int before = (int) data.get("setWhyToBuyWatchlistButtonStateA");
        int after = (int) data.get("setWhyToBuyWatchlistButtonStateB");
        Assert.assertTrue(after > before);
        return this;
    }

    public ProductPanel verifyIsWhyToBuyWatchlistButtonStateBtoATransfer() throws Exception {
        int before = (int) data.get("setWhyToBuyWatchlistButtonStateB");
        int after = (int) data.get("setWhyToBuyWatchlistButtonStateA");
        Assert.assertTrue(after < before);
        return this;
    }

    public ProductPanel setIsWhyToBuyWatchersQuantityStateA() throws Exception {
        data.put("setIsWhyToBuyWatchersQuantityStateA", Integer.parseInt(attribute("(//*[@*='why2buy']//ancestor::*[@*='w2b-cnt w2b-3 w2b-brdr'])[2]", "textContent")));
        return this;
    }

    public ProductPanel setIsWhyToBuyWatchersQuantityStateB() throws Exception {
        data.put("setIsWhyToBuyWatchersQuantityStateB", Integer.parseInt(attribute("(//*[@*='why2buy']//ancestor::*[@*='w2b-cnt w2b-3 w2b-brdr'])[2]", "textContent")));
        return this;
    }

    public ProductPanel setIsWhyToBuyWatchersQuantityStateAtoBTransfer() {
        String before = (String) data.get("setIsWhyToBuyWatchersQuantityStateA");
        String after = (String) data.get("setIsWhyToBuyWatchersQuantityStateB");
        Assert.assertNotSame(before, after);
        return this;
    }

    public ProductPanel setIsWhyToBuyWatchersQuantityStateBtoATransfer() {
        int before = (int) data.get("setWhyToBuyWatchlistButtonStateB");
        int after = (int) data.get("setWhyToBuyWatchlistButtonStateA");
        Assert.assertNotSame(before, after);
        return this;
    }

    public ProductPanel verifyIsActionDetailsCartIconNumberTransition() throws Exception {
        verifyIsActionDetailsSystemQuantityBoundaryMin();
        click("//*[@*='clzBtn viicon-close']");
        return this;
    }

}
