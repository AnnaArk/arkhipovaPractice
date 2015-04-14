package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumqa.TestLink.Model.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage {

    public WebDriver driver;

    //element on the page
    WebElement testPlanNameField;
    WebElement testPlanDescriptionField;
    WebElement createTestPlanButton;

    public TestPlanEditPage(WebDriver driver){
        this.driver = driver;
    }

    public void createTestPlan(TestPlan testPlan){

        testPlanNameField = driver.findElement(By.name("testplan_name"));
        testPlanNameField.sendKeys(testPlan.name);
//        testPlanDescriptionField = driver.findElement(By.name(""))
        createTestPlanButton = driver.findElement(By.name("do_create"));
        createTestPlanButton.click();

    }
}
