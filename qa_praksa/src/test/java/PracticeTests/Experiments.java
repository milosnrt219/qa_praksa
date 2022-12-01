package PracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Experiments {
    WebDriver driver = new ChromeDriver();
    WebElement element;

    @BeforeClass
    public void setupClass(){
        driver.get("https://the-internet.herokuapp.com/");
        //driver.get("https://https://www.saucedemo.com/");
    }
    @AfterClass
    public void dropDown(){
        driver.quit();
    }
    @Test
    public void prviTest(){
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }
    @Test
    public void drugiTest() {
        WebElement link1 = driver.findElement(By.cssSelector("#content > ul > li:nth-child(1) > a"));
        link1.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/abtest");
    }

    @Test
    public void testInput(){
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputNumber = driver.findElement(By.cssSelector("#content > div > div > div > input[type=number]"));

        inputNumber.sendKeys("23");
        System.out.println(inputNumber.getText());


    }
    @Test
    public void rightClick() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }
    @Test
    public void dropdown()  {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }
    @Test
    public void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//*[contains(text(), 'name: user1')]"));
        Assert.assertTrue(element.isDisplayed(), "user1 expected because of the hover");
    }
}
