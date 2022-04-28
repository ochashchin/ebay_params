package pages;

import objects.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait fWait;
    public Actions action;
    public Properties config = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        fWait = new FluentWait(driver);
        action = new Actions(driver);
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
            Log.printLn("Clicked on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot click on " + " because: " + e);
            throw new Exception();
        }
    }

    public void hover(String xPath) throws Exception {
        try {
            WebElement result = waitElement(xPath);
            action.moveToElement(result).perform();
            Log.printLn("Hover on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot Hover to element, because: " + e);
            throw new Exception();
        }
    }

    public void pressKeys(String xPath, CharSequence keys) throws Exception {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            result.sendKeys(keys);
            Log.printLn("Key pressed on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot press on key, because: " + e);
            throw new Exception();
        }
    }

    public void doubleClick(String xPath) throws Exception {
        try {
            action.doubleClick(waitElement(xPath)).doubleClick(waitElement(xPath)).perform();
            Log.printLn("Double click");
        } catch (Exception e) {
            Log.printLn("Cannot double click, because" + e);
            throw new Exception();
        }
    }

    public void waitAnimToPlay() throws Exception {
        int time = 600;
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

    public void refresh() throws Exception {
        driver.navigate().refresh();
    }

    public void quit() throws Exception {
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

    public boolean compareImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public BufferedImage buildImage(String id) throws IOException {

        Point location = driver.findElement(By.xpath("//*[@id='" + id + "']")).getLocation();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        final BufferedImage source = ImageIO.read(scrFile);

        String height = ((JavascriptExecutor) driver)
                .executeScript("return $('#" + id + "').height()").toString();
        String width = ((JavascriptExecutor) driver)
                .executeScript("return $('#" + id + "').width()").toString();

        BufferedImage subimage = source.getSubimage(location.x, location.y, Integer.parseInt(width), Integer.parseInt(height));
//        ImageIO.write(subimage, "png", new File("C:\\Users\\Administrator\\Desktop\\screen.png"));
        return subimage;
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
