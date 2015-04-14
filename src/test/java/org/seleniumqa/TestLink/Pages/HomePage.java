package org.seleniumqa.TestLink.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by admin on 08.04.2015.
 */
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public TestPlanManagPage openTestPlanManagPage(){

        System.out.println(driver.getPageSource());
        WebDriverWait wdw = new WebDriverWait(driver, 5);
        wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("test_plan_mgmt_topics")));
        WebElement testPlanButton = driver.findElement(By.linkText("lib/plan/planView.php"));

        testPlanButton.click();
        return null;

    }
}
