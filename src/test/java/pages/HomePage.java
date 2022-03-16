package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    public static final String baseUrl = "https://www.ebay.com/";

    private String COUNTRY = "//div[@class='gf-flags-wpr']/a";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open(String URL) throws Exception {
        get(URL);
        return this;
    }

    public HomePage verifyCountry(String parameter) throws Exception {

        driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);

        Assert.assertEquals(attribute(COUNTRY, "href"), parameter);
        return this;
    }

}
