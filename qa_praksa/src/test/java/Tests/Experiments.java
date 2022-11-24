package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Experiments {
    WebDriver driver = new ChromeDriver();

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
    public void dropdownTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
       // WebElement option1= driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)"))
        Select drpList = new Select(driver.findElement(By.id("dropdown")));
        drpList.selectByVisibleText("Option 2");
        String text = driver.findElement(By.cssSelector("#dropdown")).getText();

        Assert.assertEquals(text,"Option 1");
    }
    @Test
    public void test4(){
        driver.findElement(By.xpath("/html/body/div[2]/a/img")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://github.com/tourdedave/the-internet");
    }
    @Test
    public void testInput(){
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputNumber = driver.findElement(By.cssSelector("#content > div > div > div > input[type=number]"));

        inputNumber.sendKeys("23");
        System.out.println(inputNumber.getText());


    }
}
