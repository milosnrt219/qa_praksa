package e2e;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class e2ePerformanseGlitchUser {
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options.setHeadless(true));
    LoginPage loginPage = new LoginPage(driver);

    ItemListPage itemListPage = new ItemListPage(driver);

    CartPage cartPage = new CartPage(driver);

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @BeforeMethod
    public void setupClass()
    {
        String loginpageUrl = "https://saucedemo.com";
        driver.get(loginpageUrl);
    }

    @AfterMethod
    public void testDown(){
        driver.quit();
    }
    @Test
    public void glitchedUserE2E(){
        loginPage.loginToSauceDemo("performance_glitch_user","secret_sauce");
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
