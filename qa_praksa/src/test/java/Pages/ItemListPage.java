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

    By shoppingCart = By.className("shopping_cart_link");
    By sortButton = By.className("product_sort_container");

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
    public void openItemPage(){
        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();
    }
    public void checkSortAtoZ(){
        driver.findElement(sortButton).click();
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(1)")).click();
        Assert.assertEquals(driver.findElement(By.id("item_4_title_link")).getText(),"Sauce Labs Backpack");
    }
    public void checkSortZtoA(){
        driver.findElement(sortButton).click();
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(2)")).click();
        Assert.assertEquals(driver.findElement(By.id("item_3_title_link")).getText(),"Test.allTheThings() T-Shirt (Red)");
    }

    public void checkSortPriceLowToHigh(){
        driver.findElement(sortButton).click();
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(3)")).click();
        Assert.assertEquals(driver.findElement(By.id("item_2_title_link")).getText(),"Sauce Labs Onesie");

    }

    public void checkSortPriceHighToLow(){
        driver.findElement(sortButton).click();
        driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(4)")).click();
        Assert.assertEquals(driver.findElement(By.id("item_5_title_link")).getText(),"Sauce Labs Fleece Jacket");
    }
}
//#add-to-cart-sauce-labs-backpack
//#remove-sauce-labs-backpack