package pageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.ItemDetailPageUI;
import pageUIs.ShoppingCartPageUI;
import pageUIs.TodayDealPageUI;

public class ShoppingCartPO extends AbstractPage{
	WebDriver driver;

	public ShoppingCartPO(WebDriver driver) {
		this.driver = driver;
	}


	public String getItemQuantity(String itemTitle) {
		waitToElementVisible(driver, ShoppingCartPageUI.ITEM_QUANTITY,itemTitle);
		return getElementText(driver, ShoppingCartPageUI.ITEM_QUANTITY,itemTitle);
	}


	public double getItemPrice(String itemTitle) {
		waitToElementVisible(driver, ShoppingCartPageUI.ITEM_PRICE,itemTitle);
		return getPrice(getElementText(driver, ShoppingCartPageUI.ITEM_PRICE,itemTitle));
	}

	public double getTotalPrice() {
		waitToElementVisible(driver, ShoppingCartPageUI.TOTAL_PRICE);
		return getPrice(getElementText(driver, ShoppingCartPageUI.TOTAL_PRICE));

	}

	public void EditItemQuantity(String itemTitle, String number) {
		waitToElementClickable(driver, ShoppingCartPageUI.ITEM_QUANTITY,itemTitle);
		clickToElement(driver, ShoppingCartPageUI.ITEM_QUANTITY,itemTitle);
		waitToElementVisible(driver, ShoppingCartPageUI.NUMBER_OPTION,number);
		clickToElement(driver, ShoppingCartPageUI.NUMBER_OPTION,number);
	}

	public void deleteItem(String itemTitle) {
		waitToElementClickable(driver, ShoppingCartPageUI.DELETE_BUTTON, itemTitle);
		clickToElement(driver, ShoppingCartPageUI.DELETE_BUTTON, itemTitle);
	}

	public void clickToProceedToCheckoutButton() {
		waitToElementClickable(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);
	}

    public double formatNumber(double total) {
		return getFormatPrice(total);
    }
}
