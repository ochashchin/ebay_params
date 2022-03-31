package pages;

import objects.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait fWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
        fWait = new FluentWait(driver);
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
            WebElement result = waitElement(xPath);
            result.click();
            Log.printLn("Clicked on " + result.getText());
        } catch (Exception e) {
            Log.printLn("Cannot click on " + " because: " + e);
            throw new Exception();
        }
    }


    public void type(String xPath, String text) throws Exception {
        try {
            WebElement result = waitElement(xPath);
            result.sendKeys(text);
            Log.printLn("Typed " + text);
        } catch (Exception e) {
            Log.printLn("Cannot type " + text + ", because: " + e);
            throw new Exception();
        }
    }

    public String attribute(String xPath, String attribute) throws Exception {
//        "textContent"
        try {
            WebElement result = waitElement(xPath);
            Log.printLn("Getting attribute " + result.getAttribute(attribute));
            return result.getAttribute(attribute);
        } catch (Exception e) {
            Log.printLn("Cannot get attribute, because: " + e);
            throw new Exception();
        }
    }

    public boolean clickable(String xPath) {
        try {
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(waitElement(xPath)));
            if (result != null){
                Log.printLn("Element clickable " + result.toString());
                return true;
            }
        } catch (Exception e) {
            Log.printLn("Element not clickable, because: " + e);
            return false;
        }
        return false;
    }

    public boolean visible(String xPath) throws Exception {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOf(waitElement(xPath))) ;
            if (result.isDisplayed()) {
                Log.printLn("Element visible " + result.toString());
                return true;
            } else {
                Log.printLn("Element not visible");
                return false;
            }
        } catch (Exception e) {
            Log.printLn("Element not visible, because: " + e);
            throw new Exception();
        }
    }

    public boolean focusable(String xPath) throws Exception {
        try {
            click(xPath);
            WebElement result = wait.until(ExpectedConditions.visibilityOf(waitElement(xPath)));

            if (result.equals(driver.switchTo().activeElement())) {
                Log.printLn("Element focused " + result.toString());
                return true;
            } else {
                Log.printLn("Element not focused");
                return false;
            }
        } catch (Exception e) {
            Log.printLn("Element not focused, because: " + e);
            throw new Exception();
        }
    }

    public void scrollToElement(String xPath) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + waitElement(xPath).getLocation().y / 2 + ")");
    }

    public WebElement waitElement(String xPath) {
        fWait.withTimeout(Duration.ofMillis(5000));
        fWait.pollingEvery(Duration.ofMillis(200));
        fWait.ignoring(NoSuchElementException.class);
        return (WebElement) fWait.until(new Function() {
            public WebElement apply(Object o) {
                return driver.findElement(By.xpath(xPath));
            }
        });
    }

    public void waitAnimToPlay() {
        fWait.withTimeout(Duration.ofMillis(1000));
        fWait.pollingEvery(Duration.ofMillis(1000));
        fWait.ignoring(NoSuchElementException.class);

        try {
            fWait.until(new Function() {
               public WebElement apply(Object o) {
                   return driver.findElement(By.xpath(""));
               }
           });
        } catch (Exception e) {
        }
    }
}
