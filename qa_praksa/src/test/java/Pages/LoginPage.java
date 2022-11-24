package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void setUserName(String struserName){
        driver.findElement(username).sendKeys(struserName);
    }
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }
    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }
    public void loginToSauceDemo(String struserName, String strPassword){
        this.setUserName(struserName);
        this.setPassword(strPassword);
        this.clickLoginButton();
    }
    public void checkUserIsLoggedIn(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    public void checkUserLoginFailed(){
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
}
