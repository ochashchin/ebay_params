package tests.ui.sign_in;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

import static objects.Config.*;

public class SignInUnit {

    @Test(groups = {UNIT, US, UK, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsUnitsVisibility();
            quit();
        }};
    }

    @Test(groups = {UNIT, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_au_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsUnitsVisibilityAu();
            quit();
        }};
    }

    @Test(groups = {UNIT, US, UK, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsUnitsClickable();
            quit();
        }};
    }

    @Test(groups = {UNIT, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_sign_in_au_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new SignInPage(BaseDriver.getInstance().getDriver(browser)) {{
            open(local);
            verifyIsUnitsClickableAu();
            quit();
        }};
    }

}
