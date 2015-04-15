package org.seleniumqa.TestLink.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by admin on 08.04.2015.
 */
public class HomePage {

    WebDriver driver;

    WebElement testPlanButton;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goToHome(){
        driver.get("http://demo.testlink.org/latest/index.php");
    }

    public TestPlanManagPage openTestPlanManagPage(){

        driver.switchTo().frame("mainframe");
//        System.out.println(driver.getPageSource());   // used for debugging
        testPlanButton = driver.findElement(By.xpath("//*[@id=\"test_plan_mgmt_topics\"]/a[1]"));
        testPlanButton.click();

        return new TestPlanManagPage(driver);
    }

    public void logOut(){
        driver.switchTo().frame("titlebar");
        driver.findElement(By.xpath("/html/body/div[2]/span[2]/a[2]/img")).click();
    }
}
