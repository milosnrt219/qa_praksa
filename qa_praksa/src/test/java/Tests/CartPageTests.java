package Tests;

import Pages.CartPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CartPageTests {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);
    CartPage cartPage = new CartPage(driver);
    final static String loginPageUrl="https://saucedemo.com";
    public void loginUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");

    }


    @BeforeMethod
    public void refreshPage(){
        driver = new ChromeDriver();
        driver.get(loginPageUrl);
        loginPage = new LoginPage(driver);
        itemListPage = new ItemListPage(driver);
        cartPage = new CartPage(driver);
    }
    @AfterMethod
    public void afterMetod(){
        driver.quit();
    }

    @Test
    public void samePriceOnItemPageAndCartPage(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addToCartItem1();
        itemListPage.openItemPage();
        cartPage.checkPriceIsSameInCart();
    }
    @Test
    public void itemQuantityInCartPage(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addToCartItem1();
        itemListPage.openItemPage();
        cartPage.checkItemQuantity();
    }
    @Test
    public void continueShoppingFromCartPage(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addToCartItem1();
        itemListPage.openItemPage();
        cartPage.continueShopping();
    }
    @Test
    public void removeItemFromCart(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        itemListPage.addToCartItem1();
        itemListPage.openItemPage();
        cartPage.checkRemovingItemFromCart();
    }
}
