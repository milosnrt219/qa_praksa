package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ItemListPage {

    WebDriver driver;

    By addToCartbtn1 = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartbtn2 = By.id("add-to-cart-sauce-labs-bike-light");
    By addToCartbtn3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartbtn4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By addToCartbtn5 = By.id("add-to-cart-sauce-labs-onesie");
    By addToCartbtn6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public ItemListPage(WebDriver driver){
        this.driver=driver;
    }
    public void addToCartItem1(){
        driver.findElement(addToCartbtn1).click();
    }
    public void addToCartItem2(){
        driver.findElement(addToCartbtn2).click();
    }
    public void addToCartItem3(){
        driver.findElement(addToCartbtn3).click();
    }
    public void addToCartItem4(){
        driver.findElement(addToCartbtn4).click();
    }
    public void addToCartItem5(){
        driver.findElement(addToCartbtn5).click();
    }
    public void addToCartItem6(){
        driver.findElement(addToCartbtn6).click();
    }
    public void removeFromCartItem1(){
        driver.findElement(By.cssSelector("#remove-sauce-labs-backpack")).click();

    }
    public void itemIsAddedToCart(){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals(cart.getText(),"1");
    }

    public void itemIsRemovedFromCart(){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals(cart.getText(),"");
    }

}
//#add-to-cart-sauce-labs-backpack
//#remove-sauce-labs-backpack