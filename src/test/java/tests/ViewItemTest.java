package tests;

import objects.BaseDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ViewItemPage;

import static pages.ViewItemPage.actPanelAddToCartBtn;
import static pages.ViewItemPage.actPanelBuyItNowBtn;

public class ViewItemTest extends BaseTest {
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortVisible()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortFocusable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_integration_up(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortScrollStateUp()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_integration_down(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortScrollStateDown()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_unit_hover(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortHover()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_viewport_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsViewPortSetColor("Space Gray")
//                .verifyIsViewPortSetColor("Green")
//                .verifyIsViewPortSetColor("Gold")
//                .verifyIsViewPortSetColor("Silver")
//                .verifyIsViewPortSetColor("- Select -")
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewResourceVisible()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewResourceClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewResourceFocusable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_integration_expand(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewResourceExpandable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_integration_right(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewIntegrationRight();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_integration_left(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewIntegrationLeft()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewIntegrationColor()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_enlarge_integration_focus_to_viewport(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsEnlargeViewIntegrationFocusToViewport()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_item_title_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsIconTitleVisible()
//                .verifyIsIconTitleTextVisible()
//                .verifyIsItemTitleVisible()
//                .verifyIsSubTitleVisible()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_title_unit_highlight(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .verifyIsTitleHighlightCopy()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsFocusable();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_unit_selectable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsSelectable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_integration_condition_icon(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsIntegrationConditionIcon()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_integration_read_more(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsIntegrationReadMore()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsIntegrationColor()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_integration_bulk(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActionDetailsIntegrationBulkPrice()
//                .verifyIsActionDetailsIntegrationBulkPriceDesc()
//                .verifyIsActionDetailsIntegrationBulkPriceSaving()
//                .verifyIsActionDetailsIntegrationBulkQuantity()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_system_quantity_focusable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .selectDropDown()
//                .verifyIsActionDetailsSystemQuantityFocusable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_system_quantity_boundary_positive(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .selectDropDown()
//                .verifyIsActionDetailsSystemQuantityBoundaryMin()
//                .verifyIsActionDetailsSystemQuantityBoundaryMax()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_action_details_system_quantity_boundary_negative(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .selectDropDown()
//                .verifyIsActionDetailsSystemQuantityBoundaryMinInvalid()
//                .verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid()
//                .verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActPanelUnitVisible()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_units_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActPanelUnitClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_integration_price_credit(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsActPanelIntegrationPriceCredit()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_and_action_details_positive_integration_buy_it_now(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .selectDropDown()
//                .click(actPanelBuyItNowBtn)
//                .verifyIsActPanelActionDetailsPositiveIntegrationBuyItNowDialogVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_and_action_details_negative_integration_buy_it_now(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .click(actPanelBuyItNowBtn)
//                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
//                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_and_action_details_positive_integration_add_to_cart(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .selectDropDown()
//                .click(actPanelAddToCartBtn)
//                .verifyIsActPanelActionDetailsPositiveIntegrationAddToCartDialogVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_act_panel_and_action_details_negative_integration_add_to_cart(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .click(actPanelAddToCartBtn)
//                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
//                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsWhy2BuyUnitVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .scroll()
//                .verifyIsWhy2BuyUnitClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_integration_warranty_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .scroll()
//                .verifyIsWhy2BuyWarrantyLinkRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_integration_returns_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .scroll()
//                .verifyIsWhy2BuyReturnsLinkRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_integration_learn_more_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .scroll()
//                .verifyIsWhy2BuyLearnMoreLinkRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_why2buy_integration_see_terms_to_apply_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .scroll()
//                .verifyIsWhy2BuySeeTermsToApplyLinkRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_shop_with_confidence_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsShopWithConfidenceUnitsVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_shop_with_confidence_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsShopWithConfidenceUnitsClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_shop_with_integration_refurbished_learn_more_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsShopWithConfidenceIntegrationRefurbishedLearnMoreRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_shop_with_integration_top_rated_plus_learn_more_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsShopWithConfidenceIntegrationTopRatedPlusLearnMoreRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_shop_with_integration_money_back_guarantee_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsShopWithConfidenceIntegrationMoneyBackGuaranteeLearnMoreRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_seller_info_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsSellerInfoUnitsVisibility()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_seller_info_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsSellerInfoUnitsClickable()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_seller_info_integration_sell_name_rating_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsSellerInfoIntegrationSellerNameRatingRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    public void test_view_item_seller_info_integration_visit_store_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsSellerInfoIntegrationVisitStoreRedirection()
//                .quit();
//    }
//
//    @Test(groups = {"ViewItem"})
//    @Parameters({"browser", "local"})
//    public void test_view_item_seller_info_integration_see_other_items_redirection(@Optional() String browser, @Optional() String local) throws Exception {
//        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
//                .open(local)
//                .scroll()
//                .verifyIsSellerInfoIntegrationSeeOtherItemsRedirection()
//                .quit();
//    }

    @Test(groups = {"ViewItem"})
    @Parameters({"browser", "local"})
    public void test_view_item_sell_now_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellNowVisibility()
                .quit();
    }

}
