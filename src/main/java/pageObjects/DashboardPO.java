package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageUIs.DashboardPageUI;
import pageUIs.ItemDetailPageUI;
import pageUIs.TodayDealPageUI;

import java.util.List;

public class DashboardPO extends AbstractPage{
	WebDriver driver;
	
	
	public DashboardPO(WebDriver driver) {
		this.driver = driver;
	}


	public TodayDealPO clickToTodayDealLink() {
		clickToElementByJS(driver, DashboardPageUI.TODAY_DEAL_LINK);
		return PageGeneratorManager.getTodayDealPage(driver);
	}


	public void inputTextToSearchTextbox(String text) {
		waitToElementVisible(driver, DashboardPageUI.SEARCH_TEXTBOX);
		clickToElement(driver, DashboardPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, DashboardPageUI.SEARCH_TEXTBOX, text);
	}

	public void clickToSearchIcon() {
		waitToElementClickable(driver, DashboardPageUI.SEARCH_ICON);
		clickToElement(driver, DashboardPageUI.SEARCH_ICON);
	}

	public void sort(String text) {
		waitToElementClickable(driver, DashboardPageUI.SORT_DROPDOWN);
		scrollToElement(driver, DashboardPageUI.SORT_DROPDOWN);
		clickToElement(driver, DashboardPageUI.SORT_DROPDOWN);
		waitToElementClickable(driver, DashboardPageUI.SORT_OPTION,text);
		clickToElement(driver, DashboardPageUI.SORT_OPTION,text);
	}

	public ItemDetailPO clickToBatteryItem() {
		sleepInSecond(5);
		List<WebElement> listItem = getElements(driver,DashboardPageUI.ITEM_LIST);

		for(int i =1;i<listItem.size();i++)
		{
			waitToElementVisible(driver, DashboardPageUI.ITEM_TITLE, i+"");
			getElement(driver, DashboardPageUI.ITEM_TITLE, i+"").click();
			if(isElementUndisplayed(driver, ItemDetailPageUI.QUANTITY_DROPDOWN)==true)
			{
				backToPage(driver);
			}
			else if(isElementUndisplayed(driver, ItemDetailPageUI.QUANTITY_DROPDOWN)==false)
			{

				WebElement element = getElement(driver, ItemDetailPageUI.QUANTITY_DROPDOWN);
				Select select = new Select(element);
				if(select.getOptions().size()>4)
				{
					break;
				}
				else
				{
					backToPage(driver);
				}
			}
		}


//		for(int i =0;i<listItem.size();i++)
//		{
//
//			if(isElementUndisplayed(driver, ItemDetailPageUI.ITEM_PRICE)==true)
//			{
//				backToPage(driver);
//			}
//			if(isElementUndisplayed(driver, ItemDetailPageUI.QUANTITY_DROPDOWN)==true)
//			{
//				backToPage(driver);
//			}
//			else
//			{
//				//clickToElement(driver, ItemDetailPageUI.QUANTITY_DROPDOWN);
//				waitToElementVisible(driver, ItemDetailPageUI.QUANTITY_DROPDOWN );
//				WebElement element = getElement(driver, ItemDetailPageUI.QUANTITY_DROPDOWN);
//				Select select = new Select(element);
//				if(select.getOptions().size()>4) {
//					break;
//				}
//				else
//				{
//					backToPage(driver);
//				}
//
//			}
//
//			if(isElementUndisplayed(driver,DashboardPageUI.LEFT_FEW_IN_STOCK,i+"")==true)
//			{
//				clickToElement(driver, DashboardPageUI.BATTERY_ITEM,i+"");
//				return PageGeneratorManager.getItemDetailPage(driver);
//			}
//
//		}

		return PageGeneratorManager.getItemDetailPage(driver);
	}
}
