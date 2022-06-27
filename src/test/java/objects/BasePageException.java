package objects;

import org.openqa.selenium.WebDriver;

public class BasePageException extends RuntimeException {

    public BasePageException() {
    }

    public BasePageException(Exception e, WebDriver driver) {
        e.printStackTrace();
        driver.close();
    }

}
