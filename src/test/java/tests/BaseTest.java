package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    Properties config = new Properties();


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        BaseDriver.getInstance().quit();
    }
}
