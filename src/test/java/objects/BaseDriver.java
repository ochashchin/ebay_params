package objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseDriver {

    private static final BaseDriver instance = new BaseDriver();
    private static ThreadLocal<WebDriver> webdrivers = new ThreadLocal<>();
    public final List<WebDriver> close = new ArrayList<>();
    static int i = 1;

    private BaseDriver() {
    }

    public WebDriver getDriver(String browser) {

        if (browser == null) browser = System.getProperty("testBrowser");

        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("--disable-infobars"); // disabling infobars
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--no-sandbox"); // bypass OS security model
                options.addArguments("--single-process");
                webdrivers.set(new ChromeDriver(options));
                break;
            case "opera":
                File path = new File(System.getProperty("user.dir") + "/src/test/resources/opera_settings");
                File newPath = new File(path.getParent() + "/opera_settings_copy/" + i++);
                try {
                    if (!newPath.exists()) {
                        FileUtils.copyDirectory(path, newPath);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments("user-data-dir=" + newPath.getAbsolutePath());
                webdrivers.set(new OperaDriver(operaOptions));
                break;
        }

        return webdrivers.get();
    }

    public static BaseDriver getInstance() {
        return instance;
    }
}
