package PracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DefaultTest {

    public static WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setupClass(){
        driver.get("https://www.saucedemo.com/");

    }
    @AfterMethod
        public void DropDown(){
        driver.close();
    }

@Test
    public void loginTest(){

    }
    @Test
    public void testDrugi(){
        driver.get("https://www.saucedemo.com/");
        loginTest();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void addToCart(){
        loginTest();
        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();
        WebElement shoppingCartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(shoppingCartBadge.getText(),"1");
    }
}