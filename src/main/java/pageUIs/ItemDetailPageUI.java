package pageUIs;

public class ItemDetailPageUI {

	public static final String QUANTITY_DROPDOWN = "//div[@id='quantityRelocate_feature_div']//select[@id='quantity']";
	public static final String QUANTITY_OPTION = "//option[@value='%s']";
	public static final String ADD_TO_CART_BUTTON = "//input[@id='add-to-cart-button']";
	public static final String AMAZON_LOGO = "//a[@id='nav-logo-sprites']";
	public static final String CART_ICON = "//div[@id='nav-cart-count-container']";
	public static final String ITEM_TITLE = "//span[@id='productTitle']";
	public static final String ITEM_PRICE = "//td[contains(text(),'Price')]/parent::tr//span[@class='a-offscreen']";
	public static final String ITEM_HIDDEN_PRICE = "//td[contains(text(),'Price')]/parent::tr//span[@aria-hidden='true']";



}
