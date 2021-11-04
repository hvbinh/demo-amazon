package pageUIs;

public class ShoppingCartPageUI {
    public static final String ITEM_QUANTITY = "//span[contains(text(),'%s')]/ancestor::div[@class='sc-list-item-content']//span[@class='a-dropdown-prompt']";
    public static final String NUMBER_OPTION = "//a[@id='quantity_%s']";
    public static final String ITEM_PRICE = "//span[contains(text(),'%s')]/ancestor::div[@class='sc-list-item-content']//span[contains(@class,'sc-product-price')]";
    public static final String TOTAL_PRICE = "//div[@id='sc-buy-box']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']";
    public static final String DELETE_BUTTON = "//span[contains(text(),'%s')]/ancestor::div[@class='sc-list-item-content']//input[contains(@name,'submit.delete')]";
    public static final String PROCEED_TO_CHECKOUT_BUTTON = "//input[@name='proceedToRetailCheckout']";

}
