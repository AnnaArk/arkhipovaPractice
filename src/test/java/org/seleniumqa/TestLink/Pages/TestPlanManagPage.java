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
    int index;

    public TestPlanManagPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestPlanEditPage createTestPlan(){

        createTestPlanButton = driver.findElement(By.name("create_testplan"));
        createTestPlanButton.submit();

        return new TestPlanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan){

        WebElement testPlansTable = driver.findElement(By.id("item_view"));

        List<WebElement> testPlansTableRows = testPlansTable.findElements(By.tagName("tr"));

        for (int i = 1; i < testPlansTableRows.size(); i++) {
            WebElement testPlanLink = testPlansTableRows.get(i).findElement(By.xpath("td/a"));

            if (testPlanLink.getText().equals(testPlan.name)){
                index = i;
                return true;
            }
        }
        return false;
    }

    public void DeleteTestPlan(){

        WebElement testPlansTable = driver.findElement(By.id("item_view"));

        //locating row to delete (by index of created item)
        WebElement rowToDelete = testPlansTable.findElement(By.xpath("tbody/tr[position() = " + index + "]"));

        //locating delete button in the row (eighth column)
        WebElement deleteButton = rowToDelete.findElement(By.xpath("td[position()=8]/img"));
        deleteButton.click();

        WebElement deleteYesButton = driver.findElement(By.id("ext-gen20"));
        deleteYesButton.click();
    }
}
