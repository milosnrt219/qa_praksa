package Tests;

import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemListStandardUserTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);
    final static String loginPageUrl="https://saucedemo.com";
    public void loginUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");

    }


    @BeforeClass
    public void setupClass(){
        String loginPage = loginPageUrl;
        driver.get(loginPage);
    }
    @BeforeMethod
    public void refreshPage(){

        driver.get(loginPageUrl);
    }
    @AfterClass
    public void shutDown(){
        driver.quit();
    }
    @Test
    public void addItemToCart(){
        loginUser();
        itemListPage.addToCartItem1();
        itemListPage.itemIsAddedToCart();
    }

    @Test
    public void removeItemFromCart(){
        loginUser();
        itemListPage.addToCartItem1();
        itemListPage.removeFromCartItem1();
        itemListPage.itemIsRemovedFromCart();
    }


}
