package tests;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    @Test(groups = {"internalization"})
    @Parameters({"browser", "local"})
    public void test_home_internalization(@Optional() String browser, @Optional() String local) throws Exception {
        new HomePage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyCountry()
                .quit();
    }

}
