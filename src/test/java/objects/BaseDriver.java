package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

    public static ThreadLocal<WebDriver> webdrivers = new ThreadLocal<>();
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if(browser.equals("")) browser = System.getProperty("testBrowser");

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }

        webdrivers.set(driver);
        return webdrivers.get();
    }

}
