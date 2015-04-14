package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumqa.TestLink.Model.TestPlan;

import java.util.List;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagPage {

    WebDriver driver;

    WebElement createTestPlanButton;

    public TestPlanManagPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestPlanEditPage createTestPlan(){

        createTestPlanButton = driver.findElement(By.name("create_testplan"));
        createTestPlanButton.submit();

        return new TestPlanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan){
        int index = 0;

        WebElement testPlansTable = driver.findElement(By.id("item_view"));

        List<WebElement> testPlansTableRows = testPlansTable.findElements(By.tagName("tr"));

        for (int i = 1; i < testPlansTableRows.size(); i++) {
            WebElement testPlanLink = testPlansTableRows.get(i).findElement(By.xpath("td/a"));

            if (testPlanLink.getText().equals(testPlan.name)){
                return true;
            }
        }

        return false;

    }
}
