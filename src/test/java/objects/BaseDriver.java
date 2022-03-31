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

        if (webdrivers.get() == null) {
            if (browser.equals("chrome")) {
                webdrivers.set(new ChromeDriver());
            }
        }

        WebDriver e = webdrivers.get();
        close.add(e);
        return e;
    }

    public void quit() {
        for (WebDriver webDriver: close) {
            webDriver.quit();
        }
    }

    public static BaseDriver getInstance() {
        return instance;
    }
}
