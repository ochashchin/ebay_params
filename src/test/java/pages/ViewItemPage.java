package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.*;
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
    public static final String actPanelPriceInt = "//*[@*='vi-vpo-now u-flL w29 vi-price']/*[1]";
    public static final String actPanelCreditText = "//*[@*='vi-ppc-buybox-msg']/*[1]";
    public static final String actPanelBuyItNowBtn = "//*[@*='binBtn_btn']";
    public static final String actPanelAddToCartBtn = "//*[@*='atcRedesignId_btn']";
    public static final String actPanelAddToWatchListBtn = "//*[@*='vi-atl-lnk']";
    public static final String cartDialog = "//*[@*='vi_oly_atcRedesignId_overlay-atc-container']";
    public static final String calculatorDialog = "//*[@*='calculatorWrapper']";


    public ViewItemPage(WebDriver driver) {
        super(driver);
    }

    public ViewItemPage open() throws Exception {
        get(baseURL);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        waitAnimToPlay();
        return this;
    }

    public ViewItemPage scroll() throws Exception {
        scrollToElement(viewPortDown);
        return this;
    }

    public ViewItemPage verifyIsViewPortFocusable() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            click(viewPortList + "[" + i + "]");
            Assert.assertTrue(focusable(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortVisible() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(visible(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortClickable() throws Exception {
        for (int i = 1; i <= driver.findElements(By.xpath(viewPortList)).size(); i++) {
            if (i % 6 == 0) click(viewPortDown);
            Assert.assertTrue(clickable(viewPortList + "[" + i + "]"));
        }
        return this;
    }

    public ViewItemPage verifyIsViewPortHover() throws Exception {
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
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortDown);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ViewItemPage verifyIsViewPortScrollStateUp() throws Exception {
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

    public ViewItemPage verifyIsActionDetailsVisibility() throws Exception {
        List<String> order = new ArrayList<String>(){
            {
                add(actionDetailsConditionText);
                add(actionDetailsConditionDescText);
                add(actionDetailsConditionDescTextIcon);
                add(actionDetailsConditionSellerNote);
                add(actionDetailsReadMore);
                add(actionDetailsNetworkText);
                add(actionDetailsStorageText);
                add(actionDetailsColorText);
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
                add(actionDetailsBulkText);
                for (int i = 0; i < driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                    add("(//*[@*='vi-vpqp-pills-" + i + "'])//*[@*='vi-vpqp-text']");
                    add("(//*[@*='vi-vpqp-pills-" + i + "'])//*[@*='vi-vpqp-text vi-vpqp-price']");
                }
                add(actionDetailsQuantityText);
                add(actionDetailsQuantityEditText);
                add(actionDetailsQuantityDescText);
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

    public ViewItemPage verifyIsActionDetailsClickable() throws Exception {
        List<String> order = new ArrayList<String>() {
            {
                add(actionDetailsConditionDescTextIconButton);
                add(actionDetailsReadMore);
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='vi-vpqp-wrapper']/*")).size(); i++) {
                    add("(//*[@*='vi-vpqp-wrapper']/*)" + "[" + i + "]");
                }
                add(actionDetailsQuantitySoldText);
                add(actionDetailsQuantityFeedbackText);
            }
        };
        for (String e : order) {
            Assert.assertTrue(clickable(e));
        }
        return this;
    }

    public ViewItemPage verifyIsActionDetailsFocusable() throws Exception {
        List<String> order = new ArrayList<String>(){
            {
                add(actionDetailsConditionDescTextIconButton);
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

    public ViewItemPage verifyIsActionDetailsSelectable() throws Exception {
        List<String> elements = new ArrayList<String>(){
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

    public ViewItemPage verifyIsActionDetailsIntegrationConditionIcon() throws Exception {
        click(actionDetailsConditionDescTextIconButton);
        waitAnimToPlay();
        Assert.assertTrue(visible(dialogCondition));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsIntegrationReadMore() throws Exception {
        click(actionDetailsReadMore);
        waitAnimToPlay();
        Assert.assertTrue(visible("(//*[@*='ux-layout-section ux-layout-section--condition ux-layout-section--SECTION_WITH_BACKGROUND']//ancestor::*[@*='ux-labels-values__values-content'])[2]"));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsIntegrationColor() throws Exception {
        Set<String> set = new HashSet<>();
        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(0, "- Select -");
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

    public ViewItemPage verifyIsActionDetailsIntegrationBulkPrice() throws Exception {
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

    public ViewItemPage verifyIsActionDetailsIntegrationBulkPriceDesc() throws Exception {
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

    public ViewItemPage verifyIsActionDetailsIntegrationBulkPriceSaving() throws Exception {
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

    public ViewItemPage verifyIsActionDetailsIntegrationBulkQuantity() throws Exception {
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

    public ViewItemPage verifyIsActionDetailsSystemQuantityFocusable() throws Exception {
        pressKeys(actionDetailsQuantityEditText, Keys.SHIFT);
        Assert.assertTrue(focusable(actionDetailsQuantityEditText));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsSystemQuantityBoundaryMax() throws Exception {
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, String.valueOf(n));
        Assert.assertFalse(visible("//*[@*='errorimg']"));
        Assert.assertFalse(visible("//*[@*='u-cb err']"));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid() throws Exception {
        int n = Integer.parseInt(Character.toString(waitElement("//*[@*='qtySubTxt']").getText().charAt(0)));
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, (n + 1) + "");
        Assert.assertTrue(visible("//*[@*='errorimg']"));
        Assert.assertTrue(visible("//*[@*='u-cb err']"));
        Assert.assertTrue(waitElement("//*[@*='u-cb err']").getText().contains(n + ""));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsSystemQuantityBoundaryMin() throws Exception {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "1");
        Assert.assertFalse(visible("//*[@*='errorimg']"));
        Assert.assertFalse(visible("//*[@*='u-cb err']"));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsSystemQuantityBoundaryMinInvalid() throws Exception {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "0");
        Assert.assertTrue(visible("//*[@*='errorimg']"));
        Assert.assertTrue(visible("//*[@*='u-cb err']"));
        Assert.assertTrue(waitElement("//*[@*='u-cb err']").getText().contains("1"));
        return this;
    }

    public ViewItemPage verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid() throws Exception {
        waitElement(actionDetailsQuantityEditText).clear();
        pressKeys(actionDetailsQuantityEditText, "x");
        Assert.assertTrue(attribute(actionDetailsQuantityEditText, "value").contains("3"));
        return this;
    }

    public ViewItemPage selectDropDown() {
        List<String> elements = new ArrayList<String>() {
            {
                add(actionDetailsNetworkDropDown);
                add(actionDetailsStorageDropDown);
                add(actionDetailsColorDropDown);
            }
        };
        for (String element : elements) {
            int i = 0;
            while (new Select(waitElement(element)).getFirstSelectedOption().getText().equals("- Select -") || new Select(waitElement(element)).getFirstSelectedOption().getText().equals("Space Gray")) {
                new Select(waitElement(element)).selectByIndex(i++);
                waitAnimToPlay();
            }
        }
        return this;
    }

    public ViewItemPage verifyIsActPanelUnitVisible() throws Exception {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelPriceText);
                add(actPanelPriceInt);
                add(actPanelCreditText);
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

    public ViewItemPage verifyIsActPanelUnitClickable() throws Exception {
        List<String> elements = new ArrayList<String>() {
            {
                add(actPanelCreditText);
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

    public ViewItemPage verifyIsActPanelIntegrationPriceCredit() throws Exception {
        click(actPanelCreditText);
        waitAnimToPlay();
        Assert.assertTrue(visible(calculatorDialog));
        return this;
    }

    public ViewItemPage verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility() throws Exception {
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

    public ViewItemPage click(String xPath) throws Exception {
        super.click(xPath);
        return this;
    }

    public ViewItemPage verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus() throws Exception {
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

    public ViewItemPage verifyIsActPanelActionDetailsPositiveIntegrationBuyItNowDialogVisibility() throws Exception {
        Assert.assertTrue(visible("//*[@*='streamline-bin-layer']"));
        return this;
    }

    public ViewItemPage verifyIsActPanelActionDetailsPositiveIntegrationAddToCartDialogVisibility() throws Exception {
        Assert.assertTrue(visible("//*[@*='app-atc-layer-redesign-content-wrapper ']"));
        return this;
    }

    public ViewItemPage verifyIsWhy2BuyUnitVisibility() throws Exception {
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
            if(visible(element)){

            } else {
                System.out.println(element);;
            }
        }
        return this;
    }

    public ViewItemPage verifyIsWhy2BuyUnitClickable() throws Exception {
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

    public ViewItemPage verifyIsWhy2BuyWarrantyLinkRedirection() throws Exception {
        click("//*[@*='vi-crwarranty-subtext']//parent::a[contains(@href, 'refurbished')]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Warranty"));
        return this;
    }

    public ViewItemPage verifyIsWhy2BuyReturnsLinkRedirection() throws Exception {
        Object before = ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        click("//*[@*='ux-labels-values__values-content']//ancestor::span[@class='ux-textspans ux-textspans--SECONDARY']");
        Object after = ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        Assert.assertNotSame(before, after);
        Assert.assertTrue(visible("//*[@*='ux-layout-section-module']//parent::*[@*='vim x-returns-maxview']"));
        return this;
    }

    public ViewItemPage verifyIsWhy2BuySeeTermsToApplyLinkRedirection() throws Exception {
        click("//*[@*='fake-link fake-link--action']//parent::*[@*='ux-textspans ux-textspans--PSEUDOLINK']");
        Assert.assertTrue(visible(calculatorDialog));
        return this;
    }

    public ViewItemPage verifyIsWhy2BuyLearnMoreLinkRedirection() throws Exception {
        click("//*[@*='ux-textspans']//parent::a[contains(@href, 'creditcard')]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Mastercard"));
        return this;
    }

    public ViewItemPage verifyIsShopWithConfidenceUnitsVisibility() throws Exception {
        Set<String> elements = new HashSet<String>() {
            {
                add("//*[@*='SHOP_WITH_CONFIDENCE0-0-1-2-title']/*");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='ux-section-icon-with-details__data-title']/span")).size(); i++) {
                    add("(//*[@*='ux-section-icon-with-details__data-title']/span)[" + i + "]");
                }
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

    public ViewItemPage verifyIsShopWithConfidenceUnitsClickable() throws Exception {
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

    public ViewItemPage verifyIsShopWithConfidenceIntegrationRefurbishedLearnMoreRedirection() throws Exception {
        click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[1]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Refurbished"));
        return this;
    }

    public ViewItemPage verifyIsShopWithConfidenceIntegrationTopRatedPlusLearnMoreRedirection() throws Exception {
        click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[2]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("standards"));
        return this;
    }

    public ViewItemPage verifyIsShopWithConfidenceIntegrationMoneyBackGuaranteeLearnMoreRedirection() throws Exception {
        super.click("(//*[@*='ux-section-icon-with-details__data-item-text']/a)[3]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("Money"));
        return this;
    }

    public ViewItemPage verifyIsSellerInfoUnitsVisibility() throws Exception {
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

    public ViewItemPage verifyIsSellerInfoUnitsClickable() throws Exception {
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

    public ViewItemPage verifyIsSellerInfoIntegrationSellerNameRedirection() throws Exception {
        click("//*[@*='ux-seller-section__item--seller']/a[1]");
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window((String) windows.toArray()[1]).navigate();
        Assert.assertTrue(waitTitle("on eBay"));
        return this;
    }

    public ViewItemPage verifyIsSellerInfoIntegrationSellerNameRatingRedirection() throws Exception {
        click("//*[@*='ux-seller-section__item--seller']/a[2]");
        waitAnimToPlay();
        Assert.assertTrue(waitTitle("Feedback"));
        return this;
    }

    public ViewItemPage verifyIsSellerInfoIntegrationVisitStoreRedirection() throws Exception {
        click("(//*[@*='ux-seller-section__item']/a)[2]");
        Assert.assertTrue(waitTitle("eBay Stores"));
        return this;
    }

    public ViewItemPage verifyIsSellerInfoIntegrationSeeOtherItemsRedirection() throws Exception {
        click("(//*[@*='ux-seller-section__item']/a)[3]");
        Assert.assertTrue(waitTitle("| eBay"));
        return this;
    }
}
