package Tests;

import Pages.ItemListPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CheckoutPageTests {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ItemListPage itemListPage = new ItemListPage(driver);
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

    }
    @AfterMethod
    public void afterMetod(){
        driver.quit();
    }

}
