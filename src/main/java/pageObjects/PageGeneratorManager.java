package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static DashboardPO getDashboardPage(WebDriver driver)
	{
		return new DashboardPO(driver);
	}
	public static TodayDealPO getTodayDealPage(WebDriver driver)
	{
		return new TodayDealPO(driver);
	}
	public static ItemDetailPO getItemDetailPage(WebDriver driver)
	{
		return new ItemDetailPO(driver);
	}
	public static ShoppingCartPO getShoppingCartPage(WebDriver driver)
	{
		return new ShoppingCartPO(driver);
	}

}
