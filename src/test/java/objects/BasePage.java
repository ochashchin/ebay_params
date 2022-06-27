package objects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

import static objects.ContentReader.getClassName;
import static objects.ContentReader.getPropertyFile;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public FluentWait fWait;
    public Actions action;
    public Properties config = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        fWait = new FluentWait(driver);
        action = new Actions(driver);
    }

    public void loadProps(String local) {
        try {
            if (local == null || local.equals(""))
                config.load(getPropertyFile(getClassName(3), System.getProperty("testLocal")));
            else
                config.load(getPropertyFile(getClassName(3), local));
        } catch (IOException e) {
            Log.printLn("Cannot load properties, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void get(String URL) {
        try {
            driver.get(URL);
            Log.printLn("Navigated to " + URL);
        } catch (Exception e) {
            Log.printLn("Cannot navigate " + URL + ", because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void click(String xPath) {
        try {
            WebElement result = waitElement(xPath);
            result.click();
            Log.printLn("Clicked on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot click on " + " because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public Select select(String xPath) {
        try {
            Log.printLn("Select the " + waitElement(xPath).toString());
            return new Select(waitElement(xPath));
        } catch (Exception e) {
            Log.printLn("Cannot select the element, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void hover(String xPath) {
        try {
            WebElement result = waitElement(xPath);
            action.moveToElement(result).perform();
            Log.printLn("Hover on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot Hover to element, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void pressKeys(String xPath, CharSequence keys) {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            result.sendKeys(keys);
            Log.printLn("Key pressed on " + result.toString());
        } catch (Exception e) {
            Log.printLn("Cannot press on key, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void doubleClick(String xPath) {
        try {
            action.doubleClick(waitElement(xPath)).doubleClick(waitElement(xPath)).perform();
            Log.printLn("Double click");
        } catch (Exception e) {
            Log.printLn("Cannot double click, because" + e);
            throw new BasePageException(e, driver);
        }
    }

    public void waitAnimToPlay() {
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

    public void refresh() {
        try {
            driver.navigate().refresh();
            Log.printLn("Refreshing");
        } catch (Exception e) {
            Log.printLn("Cannot refresh, because" + e);
            throw new BasePageException(e, driver);
        }
    }

    public void quit() {
        try {
            driver.quit();
        } catch (Exception e) {
            throw new BasePageException(e, driver);
        }
    }

    public WebElement waitElement(String xPath) {
        fWait.withTimeout(Duration.ofMillis(5000));
        fWait.pollingEvery(Duration.ofMillis(200));
        fWait.ignoring(Exception.class);
        return (WebElement) fWait.until(new Function() {
            public WebElement apply(Object o) {
                return driver.findElement(By.xpath(xPath));
            }
        });
    }

    public boolean clickable(String xPath) {
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
            throw new BasePageException(e, driver);
        }
    }

    public boolean visible(String xPath) {
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
            throw new BasePageException(e, driver);
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

    public boolean visibleLayout(String xPath) {
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
            throw new BasePageException(e, driver);
        }
    }

    public String attribute(String xPath, String attribute) {
        try {
            WebElement result = waitElement(xPath);
            Log.printLn("Getting attribute " + result.getAttribute(attribute));
            return result.getAttribute(attribute);
        } catch (Exception e) {
            Log.printLn("Cannot get attribute, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public boolean focusable(String xPath) {
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
            throw new BasePageException(e, driver);
        }
    }

    public boolean waitTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
            Log.printLn("Title: " + driver.getTitle());
            return true;
        } catch (Exception e) {
            Log.printLn("Cannot match title, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void pressCopy() {
        try {
            ((JavascriptExecutor) driver).executeScript("document.execCommand('copy')");
        } catch (Exception e) {
            Log.printLn("Cannot press copy to element, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

    public void scrollToElement(String xPath) {
        try {
            WebElement xy = waitElement(xPath);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + xy.getLocation().y / 2 + ")");
        } catch (Exception e) {
            Log.printLn("Cannot press copy to element, because: " + e);
            throw new BasePageException(e, driver);
        }
    }

}
