package pages;

import objects.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,2);
    }

    public void get(String URL) throws Exception {
        try {
            driver.get(URL);
            Log.printLn("Navigated to " + URL);
        } catch (Exception e) {
            Log.printLn("Cannot navigate " + URL + ", because: " + e);
            e.printStackTrace();
        }
    }

    public void click(String xPath) throws Exception {
        try {
            By.ByXPath byX = new By.ByXPath(xPath);
            wait.until(ExpectedConditions.elementToBeClickable(byX));
            driver.findElement(byX).click();
            Log.printLn("Clicked on " + driver.findElement(byX).getText());
        } catch (Exception e) {
            Log.printLn("Cannot click on " + " because: " + e);
            throw new Exception();
        }
    }

    public void type(String xPath, String text) throws Exception {
        try {
            By.ByXPath byXPath = new By.ByXPath(xPath);
            wait.until(ExpectedConditions.presenceOfElementLocated(byXPath));
            driver.findElement(byXPath).sendKeys(text);
            Log.printLn("Typed " + text);
        } catch (Exception e) {
            Log.printLn("Cannot type " + text + ", because: " + e);
            throw new Exception();
        }
    }

    public String attribute(String xPath, String attribute) throws Exception {
//        "textContent"
        try {
            By.ByXPath byXPath = new By.ByXPath(xPath);
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(byXPath));
            Log.printLn("Getting attribute " + result.getAttribute(attribute));
            return result.getAttribute(attribute);
        } catch (Exception e) {
            Log.printLn("Cannot get attribute, because: " + e);
            throw new Exception();
        }
    }
}
