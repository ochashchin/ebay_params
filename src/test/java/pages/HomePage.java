package pages;

import objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends BasePage {

    private String COUNTRY = "//div[@class='gf-flags-wpr']/a";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String local) throws Exception {
        loadProps(local);

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

}
