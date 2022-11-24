package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTests {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public void setupClass(){
        driver.get("https://saucedemo.com");
    }
    @BeforeMethod
    public void refreshPage(){
        driver.get("https://saucedemo.com");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void loginStandardUser(){
        loginPage.loginToSauceDemo("standard_user","secret_sauce");
        loginPage.checkUserIsLoggedIn();
    }
    @Test
    public void loginLockedOutUser(){
        loginPage.loginToSauceDemo("locked_out_user","secret_sauce");
        loginPage.checkUserLoginFailed();
    }
    @Test
    public void loginProblemUser(){
        loginPage.loginToSauceDemo("problem_user","secret_sauce");
        loginPage.checkUserIsLoggedIn();
    }
    @Test
    public void loginPerformanceGlitchUser(){
        loginPage.loginToSauceDemo("performance_glitch_user","secret_sauce");
        loginPage.checkUserIsLoggedIn();
    }
    @Test
    public void loginInvalidCredentials(){
        loginPage.loginToSauceDemo("korisnik","sifra");
        loginPage.checkUserLoginFailed();
    }
    @Test
    public void loginBlankUsername(){
        loginPage.loginToSauceDemo("","secret_sauce");
        loginPage.checkUserLoginFailed();
    }
    @Test
    public void loginBlankPassword(){
        loginPage.loginToSauceDemo("standard_user","");
        loginPage.checkUserLoginFailed();
    }
    @Test
    public void pageTitle(){
        loginPage.checkTitle();
    }
}
