package pages;

import objects.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public abstract class BasePage<T> {

    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait fWait;
    public Actions action;
    Properties config = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        fWait = new FluentWait(driver);
        action = new Actions(driver);
    }

    public abstract T click(String xPath) throws Exception;

    public abstract T open(String local) throws Exception;

    public abstract T hover(String xPath) throws Exception;

    public abstract T pressKeys(String xPath, CharSequence keys) throws Exception;

    public abstract T doubleClick(String xPath) throws Exception;

    public abstract T waitAnimToPlay() throws Exception;

    public abstract T waitLongAnimToPlay() throws Exception;

    public abstract T refresh() throws Exception;

    public abstract T quit() throws Exception;

    public void get(String URL) throws Exception {
        try {
            driver.get(URL);
            Log.printLn("Navigated to " + URL);
        } catch (Exception e) {
            Log.printLn("Cannot navigate " + URL + ", because: " + e);
            e.printStackTrace();
        }
    }

    public void onClick(String xPath) throws Exception {
        try {
            WebElement result = waitElement(xPath);
            result.click();
            Log.printLn("Clicked on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot click on " + " because: " + e);
            throw new Exception();
        }
    }

    public void onHover(String xPath) throws Exception {
        try {
            WebElement result = waitElement(xPath);
            action.moveToElement(result).perform();
            Log.printLn("Hover on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot Hover to element, because: " + e);
            throw new Exception();
        }
    }

    public void onPressKeys(String xPath, CharSequence keys) throws Exception {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            result.sendKeys(keys);
            Log.printLn("Key pressed on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot press on key, because: " + e);
            throw new Exception();
        }
    }

    public void onDoubleClick(String xPath) throws Exception {
        try {
            action.doubleClick(waitElement(xPath)).doubleClick(waitElement(xPath)).perform();
            Log.printLn("Double click");
        } catch (Exception e) {
            Log.printLn("Cannot double click, because" + e);
            throw new Exception();
        }
    }

    public void onWaitAnimToPlay(int time) throws Exception {
        fWait.withTimeout(Duration.ofMillis(time));
        fWait.pollingEvery(Duration.ofMillis(time));
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

    public void onRefresh() throws Exception {
        driver.navigate().refresh();
    }

    public void onQuit() throws Exception {
        driver.quit();
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

    public boolean clickable(String xPath) throws Exception {
        try {
            WebElement result = wait.until(ExpectedConditions.elementToBeClickable(waitElement(xPath)));
            if (result != null) {
                Log.printLn("Element clickable " + result.toString());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.printLn("Element not clickable, because: " + e);
            return false;
        }
    }

    public boolean visible(String xPath) throws Exception {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOf(waitElement(xPath)));
            if (result.isDisplayed()) {
                Log.printLn("Element visible " + result.toString());
                return true;
            } else {
                Log.printLn("Element not visible");
                return false;
            }
        } catch (Exception e) {
            Log.printLn("Element not visible, because: " + e);
            return false;
        }
    }

    public boolean visibleLayout(String xPath) throws Exception {
        try {
            int w = Integer.parseInt((((JavascriptExecutor) driver)
                    .executeScript("return document.evaluate(\"" + xPath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetWidth", waitElement(xPath))).toString());
            int h = Integer.parseInt((((JavascriptExecutor) driver)
                    .executeScript("return document.evaluate(\"" + xPath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.offsetHeight", waitElement(xPath))).toString());
            if (w > 0 && h > 0) {
                Log.printLn("Resource visible");
                return true;
            } else {
                Log.printLn("Resource not visible");
                return false;
            }
        } catch (Exception e) {
            Log.printLn("Resource not visible, because: " + e);
            throw new Exception();
        }
    }

    public String attribute(String xPath, String attribute) throws Exception {
        try {
            WebElement result = waitElement(xPath);
            Log.printLn("Getting attribute " + result.getAttribute(attribute));
            return result.getAttribute(attribute);
        } catch (Exception e) {
            Log.printLn("Cannot get attribute, because: " + e);
            throw new Exception();
        }
    }

    public boolean focusable(String xPath) throws Exception {
        try {
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

    public boolean waitTitle(String title) throws Exception {
        try {
            wait.until(ExpectedConditions.titleContains(title));
            Log.printLn("Title: " + driver.getTitle());
            return true;
        } catch (Exception e) {
            Log.printLn("Cannot match title, because: " + e);
            throw new Exception();
        }
    }

    public void pressCopy() {
        ((JavascriptExecutor) driver).executeScript("document.execCommand('copy')");
    }

    public void scrollToElement(String xPath) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + waitElement(xPath).getLocation().y / 2 + ")");
    }

}
