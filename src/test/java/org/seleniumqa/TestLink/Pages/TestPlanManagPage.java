package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagPage {

    WebDriver driver;

    public TestPlanManagPage(WebDriver driver) {
        this.driver=driver;
    }


    public TestPlanEditPage createTestPlan(){

        WebElement createTestPlanButton = driver.findElement(By.name("create_testplan"));
        createTestPlanButton.click();
        return null;

    }
}
