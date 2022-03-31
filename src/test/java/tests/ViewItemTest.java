package tests;

import objects.BaseDriver;
import org.testng.annotations.Test;
import pages.ViewItemPage;

public class ViewItemTest extends BaseTest {

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_visible() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_up() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortScrollStateUp();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_down() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortScrollStateDown();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_color() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortSetColor("Space Gray")
                .verifyIsViewPortSetColor("Green")
                .verifyIsViewPortSetColor("Gold")
                .verifyIsViewPortSetColor("Silver")
                .verifyIsViewPortSetColor("- Select -");
    }

}
