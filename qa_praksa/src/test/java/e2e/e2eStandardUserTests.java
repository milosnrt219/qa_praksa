package e2e;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class e2eStandardUserTests {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    ItemListPage itemListPage = new ItemListPage(driver);

    CartPage cartPage = new CartPage(driver);

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @BeforeMethod
    public void refreshPage(){
        driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        loginPage = new LoginPage(driver);
        itemListPage = new ItemListPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
    @AfterMethod
    public void afterMetod(){
        driver.quit();
    }
    @Test
    public void standardUserE2E(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        loginPage.checkUserIsLoggedIn();
        itemListPage.addToCartItem1();
        itemListPage.itemIsAddedToCart();
        itemListPage.openItemPage();
        cartPage.cartItemCheckoutProcess();
        checkoutPage.inputUserData("Ime","prezime","11001");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        checkoutPage.checkOrderIsCompleted();

    }
}
