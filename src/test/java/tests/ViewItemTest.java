package tests;

import objects.BaseDriver;
import org.testng.annotations.Test;
import pages.ViewItemPage;

import static pages.ViewItemPage.actPanelAddToCartBtn;
import static pages.ViewItemPage.actPanelBuyItNowBtn;

public class ViewItemTest extends BaseTest {

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_visible() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_up() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortScrollStateUp();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_down() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortScrollStateDown();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_unit_hover() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsViewPortHover();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_viewport_integration_color() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
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
                .scroll()
                .verifyIsEnlargeViewResourceVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewResourceClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_unit_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewResourceFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_expand() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewResourceExpandable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_right() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewIntegrationRight();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_left() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewIntegrationLeft();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_color() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewIntegrationColor();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_enlarge_integration_focus_to_viewport() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsEnlargeViewIntegrationFocusToViewport();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_item_title_unit_visible() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsIconTitleVisible()
                .verifyIsIconTitleTextVisible()
                .verifyIsItemTitleVisible()
                .verifyIsSubTitleVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_title_unit_highlight() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .verifyIsTitleHighlightCopy();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_unit_visibility() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsVisibility();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_unit_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_unit_selectable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsSelectable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_integration_condition_icon() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsIntegrationConditionIcon();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_integration_read_more() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsIntegrationReadMore();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_integration_color() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsIntegrationColor();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_integration_bulk() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActionDetailsIntegrationBulkPrice()
                .verifyIsActionDetailsIntegrationBulkPriceDesc()
                .verifyIsActionDetailsIntegrationBulkPriceSaving()
                .verifyIsActionDetailsIntegrationBulkQuantity();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_system_quantity_focusable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityFocusable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_system_quantity_boundary_positive() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .verifyIsActionDetailsSystemQuantityBoundaryMax();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_action_details_system_quantity_boundary_negative() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMinInvalid()
                .verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid()
                .verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_units_visibility() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActPanelUnitVisible();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_units_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActPanelUnitClickable();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_integration_price_credit() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .verifyIsActPanelIntegrationPriceCredit();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_and_action_details_positive_integration_buy_it_now() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .selectDropDown()
                .click(actPanelBuyItNowBtn)
                .verifyIsActPanelActionDetailsPositiveIntegrationBuyItNowDialogVisibility();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_and_action_details_negative_integration_buy_it_now() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .click(actPanelBuyItNowBtn)
                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_and_action_details_positive_integration_add_to_cart() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .selectDropDown()
                .click(actPanelAddToCartBtn)
                .verifyIsActPanelActionDetailsPositiveIntegrationAddToCartDialogVisibility();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_act_panel_and_action_details_negative_integration_add_to_cart() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .click(actPanelAddToCartBtn)
                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_why2buy_units_visibility() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitVisibility();
    }

    @Test(groups = {"ViewItem"})
    public void test_view_item_why2buy_unit_clickable() throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(""))
                .open()
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitClickable();
    }

}
