package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumqa.TestLink.Model.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage extends AbstractPage {

    //element on the page
    private static final By testPlanNameField =By.name("testplan_name");
    private static final By testPlanDescriptionField = By.className("cke_show_borders");
    private static final By activeCheckbox = By.name("active");
    private static final By publicCheckbox = By.name("is_public");


    //private static final By testPlanDescriptionField = By.xpath("/html/body");
    private static final By createTestPlanButton = By.name("do_create");

    public TestPlanEditPage(WebDriver driver){
        super(driver);
    }

    public void createTestPlan(TestPlan testPlan){


        driver.findElement(testPlanNameField).sendKeys(testPlan.name);

        driver.switchTo().frame(0);
        driver.findElement(testPlanDescriptionField).sendKeys(testPlan.description);
        driver.switchTo().parentFrame();
        driver.findElement(activeCheckbox).click();
        driver.findElement(publicCheckbox).click();

        driver.findElement(createTestPlanButton).click();
    }
}
