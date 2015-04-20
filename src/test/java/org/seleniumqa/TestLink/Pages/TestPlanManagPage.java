package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumqa.TestLink.Model.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagPage extends AbstractPage {

    private static final By createTestPlanButton = By.name("create_testplan");
    private static final By deleteYesButton = By.id("ext-gen20");
    int index;

    public TestPlanManagPage(WebDriver driver) {
        super(driver);
    }

    public TestPlanEditPage createTestPlan() {
        driver.findElement(createTestPlanButton).submit();
        return new TestPlanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan) {
//        WebElement testPlansTable = driver.findElement(By.id("item_view"));
//        // Create list of all rows from the table
//        List<WebElement> testPlansTableRows = testPlansTable.findElements(By.tagName("tr"));
//        // Checking all 1st columns from the returned list of rows
//        for (int i = 1; i < testPlansTableRows.size(); i++) {
//            WebElement testPlanLink = testPlansTableRows.get(i).findElement(By.xpath("td/a"));
//            //If find out name of Test Plan remmember index of the row for future using
//            if (testPlanLink.getText().equals(testPlan.name)) {
//                index = i;
//                return true;
//            }
//        }
//        return false;
        return driver.findElements(By.linkText(testPlan.name)).size() >0;
    }

    public void DeleteTestPlan(TestPlan testPlan) {
//        WebElement testPlansTable = driver.findElement(By.id("item_view"));
//        //locating row to delete (by index of created item)
//        WebElement rowToDelete = testPlansTable.findElement(By.xpath("tbody/tr[position() = " + index + "]"));
//        //locating delete button in the row (eighth column)
//        WebElement deleteButton = rowToDelete.findElement(By.xpath("td[position()=8]/img"));
//        deleteButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'"+testPlan.name+"')]/ancestor::tr/td/img[@alt='Delete the test plan?']")).click();
        driver.findElement(deleteYesButton).click();
    }
}
