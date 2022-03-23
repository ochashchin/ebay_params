package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import static objects.ContentReader.getMethodName;
import static objects.ContentReader.getPropertyFile;

public class HomeTest extends BaseTest {

    @Test(groups = {"internalization"})
    @Parameters("local")
    public void test_home_internalization(@Optional("") String local) throws Exception {

        if (local.equals("")) local = System.getProperty("testLocal");

        config.load(getPropertyFile(getMethodName(), local));

        new HomePage(driver)
                .open(config.getProperty("url"))
                .verifyCountry(config.getProperty("url"));
    }

}