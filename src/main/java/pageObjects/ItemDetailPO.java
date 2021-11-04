package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.ItemDetailPageUI;
import pageUIs.TodayDealPageUI;

public class ItemDetailPO extends AbstractPage{
	WebDriver driver;
	
	
	public ItemDetailPO(WebDriver driver) {
		this.driver = driver;
	}


	public void selectNumberItem(String number) {
		waitToElementClickable(driver, ItemDetailPageUI.QUANTITY_DROPDOWN);
		selectItemInDropdown(driver, ItemDetailPageUI.QUANTITY_DROPDOWN, ItemDetailPageUI.QUANTITY_OPTION, number);
		
	}


	public void clickToAddToCartButton() {
		waitToElementClickable(driver, ItemDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ItemDetailPageUI.ADD_TO_CART_BUTTON);
	}


	public DashboardPO clickToAmazonLogo() {
		waitToElementClickable(driver, ItemDetailPageUI.AMAZON_LOGO);
		clickToElement(driver, ItemDetailPageUI.AMAZON_LOGO);
		return PageGeneratorManager.getDashboardPage(driver);
		
	}


	public ShoppingCartPO clickToCartIcon() {
		waitToElementClickable(driver, ItemDetailPageUI.CART_ICON);
		clickToElement(driver, ItemDetailPageUI.CART_ICON);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}

	public String getItemTitle() {
		waitToElementVisible(driver, ItemDetailPageUI.ITEM_TITLE);
		return getElementText(driver, ItemDetailPageUI.ITEM_TITLE);
	}

	public double getItemPrice() {

		return getPrice(getinnerHTMLbyJS(driver, ItemDetailPageUI.ITEM_PRICE));
	}
}
