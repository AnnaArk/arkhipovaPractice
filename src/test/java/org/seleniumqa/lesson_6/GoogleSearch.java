package org.seleniumqa.lesson_6;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 04.03.2015.
 */
public class GoogleSearch {

    WebDriver driver = new FirefoxDriver();

    @BeforeClass
     public void setUp(){

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
        System.out.println("Hello World");
    driver.get("https://www.google.com.ua");
}

    @Test
    public void searchTest(){

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");

        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div/li[1]/div/h3/a"));

        Assert.assertEquals((seleniumLink.getText().toString().toString().contains("Selenium")),true);

    }

   @AfterClass

   public void tearDown(){driver.quit();}
}



