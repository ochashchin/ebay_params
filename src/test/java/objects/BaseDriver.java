package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

        switch (browser){
            case "chrome":
                webdrivers.set(new ChromeDriver());
                break;
            case "opera" :
                File path = new File(System.getProperty("user.dir") + "/src/test/resources/opera_settings");
                File newPath = new File(path.getParent() + "/opera_settings_copy/" + i++);
                try {
                    Files.copy(path.toPath(), newPath.toPath());
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
