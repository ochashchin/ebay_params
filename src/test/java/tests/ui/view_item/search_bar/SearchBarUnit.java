package tests.ui.view_item.search_bar;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProductPanel;
import pages.SearchBar;
import tests.BaseTest;

import static objects.Config.*;

public class SearchBarUnit extends BaseTest {

    @Test(groups = {UNIT, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_search_bar_hint_text_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ProductPanel(driver){{
            open(local);
        }};
        new SearchBar(driver){{
            verifyHintTextVisibility();
            quit();
        }};
    }

}
