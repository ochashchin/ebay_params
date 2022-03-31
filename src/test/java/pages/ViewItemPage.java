package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class ViewItemPage extends BasePage {

    public static final String baseURL = "https://www.ebay.com/itm/175037940958";
    public static final String viewPortList = "(//ul[@id='vertical-align-items-viewport']//ancestor::a[@class='pic pic1'])";
    public static final String viewPortDown = "//button[@class='v-pic-down']";
    public static final String viewPortUp = "//button[@class='v-pic-up']";
    public static final String viewPortProgress = "//ul[@id='vertical-align-items-viewport']";
    public static final String actionDetailsColors = "//select[@id='msku-sel-3']";
    private String text;

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

    public ViewItemPage verifyIsViewPortScrollStateDown() throws Exception {
        scrollToElement(viewPortDown);
        Point a = waitElement(viewPortProgress).getLocation();
        click(viewPortDown);
        waitAnimToPlay();
        Point b = waitElement(viewPortProgress).getLocation();
        Assert.assertNotSame(a, b);
        return this;
    }

    public ViewItemPage verifyIsViewPortScrollStateUp() throws Exception  {
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
        switch (color){
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
        click( viewPortList + "[" + index + "]");
        waitAnimToPlay();
        text = new Select(waitElement(actionDetailsColors)).getFirstSelectedOption().getText();
        Assert.assertTrue(color.contains(text));
        return this;
    }

}
