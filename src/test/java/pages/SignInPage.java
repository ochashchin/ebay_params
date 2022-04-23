package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static objects.ContentReader.getClassName;
import static objects.ContentReader.getPropertyFile;
import static objects.BaseDriver.*;

public class SignInPage extends BasePage {

    List<String> visible = new ArrayList<String>() {
        {
            add("//*[@*='banner']//ancestor::*[@*='m570.l2586']/*");
            add("//*[@*='signin-intro']//ancestor::*[@*='greeting-msg']");
            add("//*[@*='signin-intro']//ancestor::*[@*='signin-reg-msg']");
            add("//*[@*='floating-label']//ancestor::*[@*='userid']");
            add("//*[@*='floating-label']//ancestor::*[@*='textbox']");
            add("//*[@*='signin-form']//ancestor::*[@*='signin-continue-btn']");
            add("//*[@*='separator']//ancestor::*[@*='social-signin-wrapper-separator']/*");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_fb_btn']");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_ggl_btn']");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_appl_btn']");
            add("//*[@*='checkbox-label']/*[@*='checkbox custom']");
            add("//*[@*='kmsi-container']//ancestor::*[@*='ssip1']");
            add("//*[@*='kmsi-container']//ancestor::*[@*='ssip2']");
            add("//*[@*='kmsi-container']//ancestor::*[@*='button']");
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gf-t-box']//ancestor::*[@*='gf-legal']/*")).size(); i++) {
                add("(//*[@*='gf-t-box']//ancestor::*[@*='gf-legal']/*)" + "[" + i + "]");
            }
            add("//*[@*='top']//ancestor::*[@*='center']/*");
        }
    };

    List<String> clickable = new ArrayList<String>() {
        {
            add("//*[@*='banner']//ancestor::*[@*='m570.l2586']/*");
            add("//*[@*='signin-intro']//ancestor::*[@*='signin-reg-msg']/*");
            add("//*[@*='signin-form']//ancestor::*[@*='signin-continue-btn']");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_fb_btn']");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_ggl_btn']");
            add("//*[@*='social-signin-buttons-reg']//ancestor::*[@*='signin_appl_btn']");
            add("//*[@*='kmsi-checkbox-lbl']");
            add("//*[@*='kmsi-container']//ancestor::*[@*='button']");
            add("//*[@*='top']//ancestor::*[@*='center']/*");
            for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='gf-t-box']//ancestor::*[@*='gf-legal']/*")).size(); i++) {
                add("(//*[@*='gf-t-box']//ancestor::*[@*='gf-legal']/*)" + "[" + i + "]");
            }
        }
    };

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage open(String local) throws Exception {
        if (local == null || local.equals(""))
            config.load(getPropertyFile(getClassName(2), System.getProperty("testLocal")));
        else
            config.load(getPropertyFile(getClassName(2), local));

        if (!driver.getCurrentUrl().contains("http"))
            get(config.getProperty("url"));

        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        return this;
    }

    public SignInPage verifyIsUnitsVisibility() throws Exception {
        for (String e : visible) {
            Assert.assertTrue(visible(e));
        }
        return this;
    }

    public SignInPage verifyIsUnitsVisibilityAu() throws Exception {
        visible.add("//*[@*='signin-form']//ancestor::*[@*='sign-in-with-mobile-question']");
        visible.add("//*[@*='switch-to-mobile-link-container']//ancestor::*[@*='switch-to-mobile-link']");
        for (String e : visible) {
            Assert.assertTrue(visible(e));
        }
        return this;
    }

    public SignInPage verifyIsUnitsClickable() throws Exception {
        for (String e : clickable) {
            Assert.assertTrue(visible(e));
        }
        return this;
    }

    public SignInPage verifyIsUnitsClickableAu() throws Exception {
        clickable.add("//*[@*='signin-form']//ancestor::*[@*='switch-to-mobile-link']");
        for (String e : clickable) {
            Assert.assertTrue(clickable(e));
        }
        return this;
    }

    public SignInPage verifyIsIntegrationLogoRedirection() throws Exception {
        click("//*[@*='banner']//ancestor::*[@*='m570.l2586']/*");
        Assert.assertTrue(waitTitle(config.getProperty("homeTitle")));
        return this;
    }

    public SignInPage verifyIsIntegrationCreateAnAccountRedirection() throws Exception {
        click("//*[@*='signin-intro']//ancestor::*[@*='signin-reg-msg']/*");
        Assert.assertTrue(waitTitle(config.getProperty("registerTitle")));
        return this;
    }

    public SignInPage verifyIsSystemSignInWithEmailOrUserNameAtoBTransition() throws Exception {
        waitAnimToPlay();
        pressKeys("//*[@*='floating-label']//ancestor::*[@*='textbox']/*[@*='username']", "specifickarma@gmail.com");
        click("//*[@*='signin-form']//ancestor::*[@*='signin-continue-btn']");
        verifyIsUnitSignInWithEmailOrUserNameStateBVisibility();
        verifyIsUnitSignInWithEmailOrUserNameStateBClickable();
        return this;
    }

    public SignInPage verifyIsSystemSignInWithEmailOrUserNameBtoATransition() throws Exception {
        click("//*[@*='signin-intro']//ancestor::*[@*='switch-account-link']/a");
        verifyIsUnitsVisibility();
        return this;
    }

    public SignInPage verifyIsSystemSignInWithEmailOrUserNamePositive() throws Exception {
        verifyIsSystemSignInWithEmailOrUserNameAtoBTransition();
        pressKeys("//*[@*='password-box-wrapper']//ancestor::*[@*='textbox']/*[@*='pass']", "$pass1055");
        click("//*[@*='signin-form']//ancestor::*[@*='sgnBt']");
        Assert.assertTrue(waitTitle(config.getProperty("homeTitle")));
        return this;
    }

    private void verifyIsUnitSignInWithEmailOrUserNameStateBClickable() throws Exception {
        List<String> clickable = new ArrayList<String>() {
            {
                add("//*[@*='signin-intro']//ancestor::*[@*='switch-account-link']/a");
                add("//*[@*='need-help need-help-container']//ancestor::*[@*='accordion-head']/a");
            }};
        for (String e : clickable) {
            Assert.assertTrue(clickable(e));
        }
    }

    public SignInPage verifyIsSystemSignInWithMobileStateAtoBTransition() throws Exception {
        click("//*[@*='signin-form']//ancestor::*[@*='switch-to-mobile-link']");
        verifyIsUnitSignInWithMobileStateBVisibility();
        verifyIsUnitSignInWithMobileStateBClickable();
        verifyIsUnitSignInWithMobileStateBPersistence();
        return this;
    }

    public SignInPage verifyIsSystemSignInWithMobileStateBtoATransition() throws Exception {
        click("//*[@*='signin-form']//ancestor::*[@*='switch-to-email-or-username-link']");
        verifyIsUnitSignInWithMobileStateAVisibility();
        verifyIsUnitSignInWithMobileStateAClickable();
        return this;
    }

    private void verifyIsUnitSignInWithEmailOrUserNameStateAVisibility() throws Exception {
        verifyIsUnitsVisibility();
    }

    private void verifyIsUnitSignInWithEmailOrUserNameStateBVisibility() throws Exception {
        List<String> visible = new ArrayList<String>() {
            {
                add("//*[@*='signin-intro']//ancestor::*[@*='welcome-msg']");
                add("//*[@*='signin-intro']//ancestor::*[@*='user-info']");
                add("//*[@*='signin-intro']//ancestor::*[@*='switch-account-link']");
                add("//*[@*='password-box-wrapper']//ancestor::*[@*='pass']");
                add("//*[@*='password-box-wrapper']//ancestor::*[@*='textbox']/*[@*='pass']");
                add("//*[@*='need-help need-help-container']//ancestor::*[@*='accordion-head']/a");
                add("//*[@*='sgnBt']");
            }};
        for (String e : visible) {
            Assert.assertTrue(visible(e));
        }
    }

    private void verifyIsUnitSignInWithMobileStateAVisibility() throws Exception {
        List<String> visible = new ArrayList<String>() {
            {
                add("//*[@*='signin-form']//ancestor::*[@*='textbox']/*[@*='username']");
                add("//*[@*='signin-form']//ancestor::*[@*='sign-in-with-mobile-question']");
                add("//*[@*='signin-form']//ancestor::*[@*='switch-to-mobile-link-container']/*[@*='button']");
            }};
        for (String e : visible) {
            Assert.assertTrue(visible(e));
        }
    }

    private void verifyIsUnitSignInWithMobileStateBVisibility() throws Exception {
        List<String> visible = new ArrayList<String>() {
            {
                add("//*[@*='phone-id-view-container']//ancestor::*[@*='country-label']");
                add("//*[@*='mobile-number-container']//ancestor::*[@*='textbox']/*");
                add("//*[@*='country-code-container']//ancestor::*[@*='button']");
                add("//*[@*='mobile-number-container']//ancestor::*[@*='phone-number']");
                for (int i = 1; i <= driver.findElements(By.xpath("//*[@*='country-code-container']//ancestor::*[@*='expand-btn__cell menu-button__control--custom-label']/*/*")).size(); i++) {
                    add("//*[@*='country-code-container']//ancestor::*[@*='expand-btn__cell menu-button__control--custom-label']/*/*" + "[" + i + "]");
                }
            }};
        for (String e : visible) {
            Assert.assertTrue(visible(e));
        }
    }

    private void verifyIsUnitSignInWithMobileStateAClickable() throws Exception {
        List<String> clickable = new ArrayList<String>() {
            {
                add("//*[@*='signin-form']//ancestor::*[@*='textbox']/*[@*='username']");
                add("//*[@*='signin-form']//ancestor::*[@*='switch-to-mobile-link-container']/*[@*='button']");
            }};
        for (String e : clickable) {
            Assert.assertTrue(clickable(e));
        }
    }

    private void verifyIsUnitSignInWithMobileStateBClickable() throws Exception {
        List<String> clickable = new ArrayList<String>() {
            {
                add("//*[@*='mobile-number-container']//ancestor::*[@*='textbox']/*");
                add("//*[@*='country-code-container']//ancestor::*[@*='button']");
            }};
        for (String e : clickable) {
            Assert.assertTrue(clickable(e));
        }
    }

    private void verifyIsUnitSignInWithMobileStateBPersistence() throws Exception {
        Assert.assertEquals(attribute("//*[@*='country-code-container']//ancestor::*[@*='expand-btn__cell menu-button__control--custom-label']/*/*[1]", "textContent"),
                config.getProperty("areaCode"));
    }

    public SignInPage verifyIsSystemIntegrationSignInRedirection() throws Exception {
        Assert.assertTrue(waitTitle(config.getProperty("signInOrRegisterTitle")));
        return this;
    }
}
