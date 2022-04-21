package tests;

import objects.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountBar;
import pages.SignInPage;
import pages.ViewItemPage;

import static objects.Config.*;
import static pages.ViewItemPage.*;

public class ViewItemTest extends BaseTest {

    private final String ViewItem = "ViewItem";

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortVisible()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortFocusable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_up(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortScrollStateUp()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_down(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortScrollStateDown()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_unit_hover(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortHover()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_viewport_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsViewPortSetColor("Space Gray")
                .verifyIsViewPortSetColor("Green")
                .verifyIsViewPortSetColor("Gold")
                .verifyIsViewPortSetColor("Silver")
                .verifyIsViewPortSetColor("select")
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewResourceVisible()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewResourceClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewResourceFocusable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_expand(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewResourceExpandable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_right(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewIntegrationRight()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_left(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewIntegrationLeft()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewIntegrationColor()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_enlarge_integration_focus_to_viewport(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsEnlargeViewIntegrationFocusToViewport()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_item_title_refurbished_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsIconTitleVisible()
                .verifyIsIconTitleTextVisible()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_item_title_unit_visible(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsItemTitleVisible()
                .verifyIsSubTitleVisible()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_title_unit_highlight(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsTitleHighlightCopy()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_us_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsUSVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsFocusable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_us_unit_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsUSFocusable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_us_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsUSClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_unit_selectable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsSelectable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_integration_condition_icon(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsIntegrationConditionIcon()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_integration_read_more(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsIntegrationReadMore()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_integration_color(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsIntegrationColor()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_integration_bulk(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActionDetailsIntegrationBulkPrice()
                .verifyIsActionDetailsIntegrationBulkPriceDesc()
                .verifyIsActionDetailsIntegrationBulkPriceSaving()
                .verifyIsActionDetailsIntegrationBulkQuantity()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_system_quantity_focusable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityFocusable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_system_quantity_boundary_positive(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .verifyIsActionDetailsSystemQuantityBoundaryMax()
                .quit();
    }

    @Test(groups = {ViewItem, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_system_quantity_boundary_negative(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMinInvalid()
                .verifyIsActionDetailsSystemQuantityBoundaryDefaultInvalid()
                .verifyIsActionDetailsSystemQuantityBoundaryMaxInvalid()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_action_details_us_system_quantity_boundary_negative(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityUSBoundaryDefaultInvalid()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_basic_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelUnitBasicVisible()
                .quit();
    }

    @Test(groups = {ViewItem, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_spec_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelUnitSpecificVisible()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_us_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelUnitUSVisible()
                .quit();
    }

    @Test(groups = {ViewItem, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_basic_units_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelUnitBasicClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_us_units_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelUnitUSClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_us_integration_price_credit(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsActPanelIntegrationPriceCredit()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_and_action_details_positive_integration_buy_it_now(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .click(actPanelBuyItNowBtn)
                .verifyIsActPanelActionDetailsPositiveIntegrationBuyItNowDialogVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_and_action_details_negative_integration_buy_it_now(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .click(actPanelBuyItNowBtn)
                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_and_action_details_positive_integration_add_to_cart(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .selectDropDown()
                .click(actPanelAddToCartBtn)
                .verifyIsActPanelActionDetailsPositiveIntegrationAddToCartDialogVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_act_panel_and_action_details_negative_integration_add_to_cart(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .click(actPanelAddToCartBtn)
                .verifyIsActPanelActionDetailsNegativeIntegrationErrorIconAndMessageVisibility()
                .verifyIsActPanelActionDetailsNegativeIntegrationDropDownFocus()
                .quit();
    }

    @Test(groups = {ViewItem, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsWhy2BuyUnitVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_us_units_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsWhy2BuyUnitUSVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_us_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitUSClickable()
                .quit();
    }

    @Test(groups = {ViewItem, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyUnitClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_integration_warranty_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyWarrantyLinkRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_integration_returns_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyReturnsLinkRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_integration_learn_more_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuyLearnMoreLinkRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_why2buy_integration_see_terms_to_apply_link_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .scroll()
                .verifyIsWhy2BuySeeTermsToApplyLinkRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_confidence_us_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceUnitsUSVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_confidence_basic_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceUnitsBasicVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_confidence_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceUnitsClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_integration_refurbished_learn_more_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceIntegrationRefurbishedLearnMoreRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_integration_top_rated_plus_learn_more_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceIntegrationTopRatedPlusLearnMoreRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_shop_with_integration_money_back_guarantee_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsShopWithConfidenceIntegrationMoneyBackGuaranteeLearnMoreRedirection(local)
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_seller_info_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellerInfoUnitsVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_seller_info_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellerInfoUnitsClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_seller_info_integration_sell_name_rating_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellerInfoIntegrationSellerNameRatingRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_seller_info_integration_visit_store_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellerInfoIntegrationVisitStoreRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_seller_info_integration_see_other_items_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellerInfoIntegrationSeeOtherItemsRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_sell_now_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellNowVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({"browser", "local"})
    public void test_view_item_sell_now_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .scroll()
                .verifyIsSellNowClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_product_listing_integration_see_feedback_prompt(@Optional() String browser, @Optional() String local) throws Exception {
        new ViewItemPage(BaseDriver.getInstance().getDriver(browser))
                .open(local)
                .verifyIsProductListingIntegrationSeeFeedbackPrompt()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sign_in_sell_now_contact_seller_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .verifyIsSellerInfoSystemIntegrationContactSellerRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sign_in_watchers_quantity_state_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .selectDropDown()
                .setIsWhyToBuyWatchersQuantityStateA()
                .click("//*[@*='vi-atl-lnk']")
                .refresh()
                .setIsWhyToBuyWatchersQuantityStateAtoBTransfer()
                .setIsWhyToBuyWatchersQuantityStateB()
                .click("//*[@*='vi-atl-lnk']")
                .refresh()
                .setIsWhyToBuyWatchersQuantityStateBtoATransfer()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_sign_in_add_watchlist_button_state_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .selectDropDown()
                .setWhyToBuyWatchlistButtonStateA()
                .click("//*[@*='vi-atl-lnk']")
                .setWhyToBuyWatchlistButtonStateB()
                .verifyIsWhyToBuyWatchlistButtonStateAtoBTransfer()
                .click("//*[@*='vi-atl-lnk']")
                .setWhyToBuyWatchlistButtonStateA()
                .verifyIsWhyToBuyWatchlistButtonStateBtoATransfer()
                .quit();
    }

    private WebDriver viewItemSetup(@Optional String browser, @Optional String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver).open(local);
        return driver;
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_unit_clickable(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyClickable()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_dailyDeals_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyDailyDealsIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_outlet_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyBrandOutletIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_help_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyHelpAndContactIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_sell_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifySellIntegrationRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_no_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_integration_transition(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_dropdown_signed_in_item_in_watchlist_unit_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyWatchlistDropDownIntegrationTransitionB()
                .click("//*[@*='vi-atl-lnk']")
                .refresh()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .waitAnimToPlay()
                .verifyWatchlistDropDownItemInVisibility(true)
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[2]")
                .verifyWatchlistDropDownItemInVisibility(false)
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_watchlist_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyWatchListIntegrationRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("summaryTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_summary_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySummaryRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("recentlyViewedTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_recentlyViewed_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyRecentlyViewedRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("bidOfferTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_bidOffer_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyBidOfferRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("watchListTitle") + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_watchList_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyWatchListRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("purchaseHistoryTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_purchaseHistory_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyPurchaseHistoryRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("sellingTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_selling_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySavedSearchesRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSearches_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("savedSellersTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_savedSellers_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifySavedSellersRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("myGarageTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_myGarage_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyMyGarageRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("messagesTitle").split(" ")[0] + "')]")
                .verifySignInRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_messages_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyMessagesRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("collectionTitle").split(" ")[0] + "')]")
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collection_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyCollectionRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[contains(text(), '" + config.getProperty("buyAgainTitle").split(" ")[0] + "')]")
                .quit();
    }

    @Test(groups = {ViewItem, US})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_buyAgain_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyBuyAgainRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::*[@*='gh-ul-nav']//ancestor::a[@*='gh-eb-nectar']")
                .quit();
    }

    @Test(groups = {ViewItem, UK})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_collectSpend_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyCollectSpendRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyMyEbayIntegrationDropDownTransitionA()
                .click("//*[@*='gh-top']//ancestor::a[contains(text(), 'Punkte')]")
                .quit();
    }

    @Test(groups = {ViewItem, DE})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_punkte_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new AccountBar(driver)
                .open(local)
                .verifyPunkteRedirection()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_myEbay_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[3]")
                .waitAnimToPlay()
                .verifyMyEbayIntegrationDropDownTransitionA()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyMyEbayIntegrationDropDownTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_notification_no_signed_in_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[4]")
                .verifyNotificationIntegrationDropDownTransitionANoSignedIn()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyNotificationIntegrationDropDownTransitionBNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_transition(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionANoSignedIn()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartDropDownIntegrationTransitionB()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationItemsVisibility()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_signed_in_item_in_cart_visibility(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartDropDownIntegrationTransitionB()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[5]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationItemsVisibility()
                .hover("//*[@*='gh-top']//ancestor::*[@*='gh-eb']/*[1]")
                .waitAnimToPlay()
                .verifyCartDropDownIntegrationTransitionB()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_no_signed_in_integration_redirection(@Optional() String browser, @Optional() String local) throws Exception {
        new AccountBar(viewItemSetup(browser, local))
                .open(local)
                .verifyCartRedirectionNoSignedIn()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMinNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_min_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMin()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMinNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_max_no_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMax()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMaxNumberVisibility()
                .quit();
    }

    @Test(groups = {ViewItem, US, UK, DE, AU})
    @Parameters({BROWSER, LOCAL})
    public void test_view_item_account_bar_cart_dropdown_label_max_signed_in_integration(@Optional() String browser, @Optional() String local) throws Exception {
        WebDriver driver = BaseDriver.getInstance().getDriver(browser);
        new SignInPage(driver)
                .open(local)
                .verifyIsSystemSignInWithEmailOrUserNamePositive();
        new ViewItemPage(driver)
                .open(local)
                .scroll()
                .selectDropDown()
                .verifyIsActionDetailsSystemQuantityBoundaryMax()
                .click(actPanelAddToCartBtn)
                .click("//*[@*='clzBtn viicon-close']");
        new AccountBar(driver)
                .verifyCartLabelMaxNumberVisibility()
                .quit();
    }

}
