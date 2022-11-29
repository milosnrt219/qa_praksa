package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPage {
    WebDriver driver;

    ItemListPage itemListPage = new ItemListPage(driver);


    By checkoutButton = By.id("checkout");
    By continueShoppingButton = By.id("continue-shopping");
    By removeBackpackButton = By.id("remove-sauce-labs-backpack");
    By itemPrice = By.className("inventory_item_price");
    By itemPriceItemPage = By.className("inventory_item_price");


    public void  cartPage(WebDriver driver){
        this.driver = driver;
    }
    public CartPage(WebDriver driver){
        this.driver = driver   ;

    }
    public void cartItemCheckoutProcess(){
        driver.findElement(checkoutButton).click();
    }


    public void checkPriceIsSameInCart(){
       // itemListPage.addToCartItem1();
       // itemListPage.itemIsAddedToCart();
        //itemListPage.openItemPage();
        Assert.assertEquals(driver.findElement(itemPriceItemPage),driver.findElement(itemPrice));
    }
}
