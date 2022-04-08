package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseDriver {

    private static final BaseDriver instance = new BaseDriver();
    private static ThreadLocal<WebDriver> webdrivers = new ThreadLocal<>();
    public final List<WebDriver> close = new ArrayList<>();

    private BaseDriver() {
    }

    public WebDriver getDriver(String browser) {

        if (browser.equals("")) browser = System.getProperty("testBrowser");

        if (browser.equals("chrome")) {
            webdrivers.set(new ChromeDriver());
        }

        return webdrivers.get();
    }

    public static BaseDriver getInstance() {
        return instance;
    }
}
