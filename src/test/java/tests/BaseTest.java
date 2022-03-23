package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    Properties config = new Properties();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("") String browser) {
        driver = BaseDriver.getDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
