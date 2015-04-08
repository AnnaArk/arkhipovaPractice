package org.seleniumqa.ui_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.seleniumqa.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by admin on 16.03.2015.
 */
public class SmarphoneSearchTest extends TestBase {



    @Test
    public void searchTest(){

        webDriver.get("http://rozetka.com.ua/");

        WebElement searchField = webDriver.findElement(By.className("header-search-input-text"));
        searchField.sendKeys(TestData.SAMSUNG_G900H_GALAXY_S5);
        WebElement searchButton = webDriver.findElement(By.className("btn-link-i"));
        searchButton.click();

        WebElement seleniumLink = webDriver.findElement(By.xpath(".//*[@id='head_banner_container']/div[3]/div/div[1]/div/div/div[3]/div[4]/div[2]/div[1]/a"));


        Assert.assertEquals((seleniumLink.getText().toString().toString().contains(TestData.SAMSUNG_PROCESSOR)), true);

    }
}
