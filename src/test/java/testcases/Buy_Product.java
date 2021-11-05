package testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.*;

public class Buy_Product extends AbstractTest{
	
	WebDriver driver;
	String itemTitle1, itemTitle2;
	double itemPrice1, itemPrice2;
	
	DashboardPO dashboardPage;
	TodayDealPO todayDealPage;
	ItemDetailPO itemDetailPage;
	ShoppingCartPO shoppingCartPage;


	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser,String url) {
		driver = getBrowserDriver(browser,url);
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		
		
	}


	@Test
	public void TC_01_Buy_Product() {
		todayDealPage = dashboardPage.clickToTodayDealLink();

		todayDealPage.sort("Discount - high to low");

		itemDetailPage = todayDealPage.clickToSecondItem();

        itemTitle1 = itemDetailPage.getItemTitle();

        itemPrice1 = itemDetailPage.getItemPrice();

		itemDetailPage.selectNumberItem("2");

		itemDetailPage.clickToAddToCartButton();

		dashboardPage = itemDetailPage.clickToAmazonLogo();

		dashboardPage.inputTextToSearchTextbox("AAA Batteries");

		dashboardPage.clickToSearchIcon();

		dashboardPage.sort("Newest Arrivals");

		itemDetailPage = dashboardPage.clickToBatteryItem();

		itemTitle2 = itemDetailPage.getItemTitle();

		itemPrice2 = itemDetailPage.getItemPrice();

		itemDetailPage.selectNumberItem("5");

		itemDetailPage.clickToAddToCartButton();

		shoppingCartPage = itemDetailPage.clickToCartIcon();

		//verify quantity,price of item 1
		Assert.assertEquals(shoppingCartPage.getItemQuantity(itemTitle1), "2");
		Assert.assertEquals(shoppingCartPage.getItemPrice(itemTitle1), itemPrice1);

		//verify quantity,price of item 2
		Assert.assertEquals(shoppingCartPage.getItemQuantity(itemTitle2), "5");
		Assert.assertEquals(shoppingCartPage.getItemPrice(itemTitle2), itemPrice2);

		//verify total price
        double total = (itemPrice1*2)+(itemPrice2*5);
        System.out.println("total:" +total);
		Assert.assertEquals(shoppingCartPage.getTotalPrice(), shoppingCartPage.formatNumber(total));

		//edit first item to 1
		shoppingCartPage.EditItemQuantity(itemTitle1,"1");

		//edit second item to 3
		shoppingCartPage.refreshPage();
		shoppingCartPage.EditItemQuantity(itemTitle2,"3");

		//verify quantity,price of item 1
		Assert.assertEquals(shoppingCartPage.getItemQuantity(itemTitle1), "1");
		Assert.assertEquals(shoppingCartPage.getItemPrice(itemTitle1), itemPrice1);

		//verify quantity,price of item 2
		Assert.assertEquals(shoppingCartPage.getItemQuantity(itemTitle2), "3");
		Assert.assertEquals(shoppingCartPage.getItemPrice(itemTitle2), itemPrice2);

		//verify total price
		total = itemPrice1+(itemPrice2 * 3);
		Assert.assertEquals(shoppingCartPage.getTotalPrice(), shoppingCartPage.formatNumber(total));

		//delete item 1
		shoppingCartPage.deleteItem(itemTitle1);

		//verify quantity,price of item 2
		Assert.assertEquals(shoppingCartPage.getItemQuantity(itemTitle2), "3");
		Assert.assertEquals(shoppingCartPage.getItemPrice(itemTitle2), itemPrice2);

		//verify total price
		total = itemPrice2* 3;
		Assert.assertEquals(shoppingCartPage.getTotalPrice(), shoppingCartPage.formatNumber(total));

		//click to proceed to checkout
		shoppingCartPage.clickToProceedToCheckoutButton();

	}
	public int getRandomNumber()
	{
		Random random = new Random();
		return random.nextInt(9999);
	}

	public void sleepInSecond(long second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}

}
