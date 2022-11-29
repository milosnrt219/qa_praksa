package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckoutPage {
    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By cancelButton = By.id("cancel");
    By finishButton = By.id("finish");

    By orderCompletedMessage = By.className("pony_express");
    public CheckoutPage(WebDriver driver){
        this.driver = driver   ;

    }
    public void inputUserData(String strFirstName, String strLastName, String strPostalCode){
        driver.findElement(firstName).sendKeys(strFirstName);
        driver.findElement(lastName).sendKeys(strLastName);
        driver.findElement(postalCode).sendKeys(strPostalCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
    public void checkOrderIsCompleted(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        softAssert.assertTrue(driver.findElement(orderCompletedMessage).isDisplayed());
        softAssert.assertAll();
    }

    public void continueButtonFailed(){
        driver.findElement(continueButton).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }
}
