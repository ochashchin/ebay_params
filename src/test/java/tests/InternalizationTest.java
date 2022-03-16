package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class InternalizationTest extends BaseTest {

    @Test(priority = 0)
    @Parameters("url")
    public void Test_Home_Internalization(@Optional(HomePage.baseUrl) String URL) throws Exception {
        new HomePage(driver)
                .open(URL)
                .verifyCountry(URL);
    }

}
