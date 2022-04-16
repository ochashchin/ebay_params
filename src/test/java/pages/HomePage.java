package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

import static objects.ContentReader.getClassName;
import static objects.ContentReader.getPropertyFile;

public class HomePage extends BasePage {

    private String COUNTRY = "//div[@class='gf-flags-wpr']/a";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String local) throws Exception {
        if (local == null || local.equals(""))
            config.load(getPropertyFile(getClassName(2), System.getProperty("testLocal")));
        else
            config.load(getPropertyFile(getClassName(2), local));

        get(config.getProperty("url"));
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        return this;
    }

    public HomePage verifyCountry() throws Exception {

        driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);

        Assert.assertEquals(attribute(COUNTRY, "href"), config.getProperty("url"));
        return this;
    }

    public T quit() {
        driver.quit();
        return null;
    }
}
