package org.seleniumqa.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by admin on 04.03.2015.
 */
public class StylusSearchTest {

    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    public void setUp(){

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.stylus.com.ua");
        String tableTrTd = "//tbody/tr[%s]/td[%s]";
    }


    @Test
    public void searchTest(){

        WebElement searchField = driver.findElement(By.id("search_text"));
        searchField.sendKeys("Sony");
        WebElement searchButton = driver.findElement((By.id("button")));
        searchButton.click();

        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a"));


        Assert.assertEquals((seleniumLink.getText().toString().toString().contains("Sony")), true);

    }

    @AfterClass

    public void tearDown(){driver.quit();}
}
