package pageUIs;

public class DashboardPageUI {
	public static final String TODAY_DEAL_LINK = "//a[contains(text(),\"Today's Deals\")]";
	public static final String SEARCH_TEXTBOX = "//input[@id='twotabsearchtextbox']";
	public static final String SEARCH_ICON = "//input[@id='nav-search-submit-button']";
	public static final String SORT_DROPDOWN = "//span[contains(text(),'Sort by:')]";
	public static final String SORT_OPTION = "//li//a[text()='%s']";
	public static final String BATTERY_ITEM = "//div[@data-index='%s']//span[@class='a-size-base-plus a-color-base a-text-normal']";
	public static final String LEFT_FEW_IN_STOCK = "//span[contains(text(),'left in stock.')]";
	public static final String ITEM_LIST = "//div[contains(@data-component-type,'search-result')]";
	public static final String ITEM_TITLE = "(//div[contains(@data-component-type,'search-result')])[%s]//span[contains(@class,'a-text-normal')]";
	public static final String OUT_OF_STOCK_TEXT = "//span[contains(text(),'Temporarily out of stock.')]";


}
