package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageUIs.ItemDetailPageUI;
import pageUIs.TodayDealPageUI;

public class TodayDealPO extends AbstractPage{
	WebDriver driver;
	
	
	public TodayDealPO(WebDriver driver) {
		this.driver = driver;
	}


	public void sort(String text) {
		waitToElementClickable(driver, TodayDealPageUI.SORT_DROPDOWN);
		clickToElement(driver, TodayDealPageUI.SORT_DROPDOWN);
		waitToElementClickable(driver, TodayDealPageUI.SORT_OPTION,text);
		clickToElement(driver, TodayDealPageUI.SORT_OPTION,text);

	}


	public ItemDetailPO clickToSecondItem() {

		for(int i =2;i<12;i++)
		{
			waitToElementClickable(driver, TodayDealPageUI.SECOND_ITEM,i+"");
			clickToElement(driver, TodayDealPageUI.SECOND_ITEM,i+"");
			sleepInSecond(5);

			if(isElementUndisplayed(driver, ItemDetailPageUI.QUANTITY_DROPDOWN)==true)
			{
				backToPage(driver);
			}
			else if(isElementUndisplayed(driver, ItemDetailPageUI.QUANTITY_DROPDOWN)==false)
			{

				WebElement element = getElement(driver, ItemDetailPageUI.QUANTITY_DROPDOWN);
				Select select = new Select(element);
				if(select.getOptions().size()>2)
				{
					break;
				}
				else
				{
					backToPage(driver);
				}
			}


		}
		return PageGeneratorManager.getItemDetailPage(driver);

	}




}
