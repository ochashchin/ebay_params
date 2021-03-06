package pages;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.image.BufferedImage;
import java.time.Duration;

import static pages.ProductPanel.baseURL;

public class SearchBar extends BasePage {

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void open(String local) throws Exception, Error {
        loadProps(local);

        if (!driver.getCurrentUrl().contains("http"))
            get(config.getProperty("url") + baseURL);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        waitAnimToPlay();
        driver.navigate().refresh();
    }

    public void verifyHintTextVisibility() throws Exception {
        BufferedImage before = buildImage("gh-ac-box2");

        Assert.assertTrue(attribute("//*[@id='gh-ac']", "placeholder").contains("Search for anything"));

        click("//*[@id='gh-ac-box2']");
        waitAnimToPlay();

        BufferedImage after = buildImage("gh-ac-box2");

        Assert.assertFalse(compareImagesEqual(before, after));
    }

}
