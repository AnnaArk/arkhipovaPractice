package org.seleniumqa.TestLink.Pages;
import org.openqa.selenium.*;
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

    public WebElement elementIsLocated(By element){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        catch (StaleElementReferenceException se){
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        catch (NoSuchElementException nse){
            return wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
    }

    public void openTestPlanManagPage(){

        driver.switchTo().frame("mainframe");
        System.out.println(driver.getPageSource());
        WebElement testPlanButton = elementIsLocated(By.xpath("//*[@id=\"test_plan_mgmt_topics\"]/a[1]"));
        testPlanButton.click();
//        return null;

    }
}
