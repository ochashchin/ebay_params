package tests;

import objects.BaseDriver;
import org.testng.annotations.Test;
import pages.ViewItemPage;

public class ViewItemTest extends BaseTest {

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_visible() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_focusable() throws Exception {
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
    public void test_view_item_viewport_unit_hover() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsViewPortHover();
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

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_unit_visible() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewResourceVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewResourceClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_unit_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewResourceFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_expand() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewResourceExpandable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_right() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewIntegrationRight();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_left() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewIntegrationLeft();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_color() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsEnlargeViewIntegrationColor();
    }

}
