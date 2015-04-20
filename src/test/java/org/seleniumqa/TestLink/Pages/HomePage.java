package org.seleniumqa.TestLink.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumqa.TestLink.Model.TestSuite;

/**
 * Created by admin on 08.04.2015.
 */
public class HomePage extends AbstractPage {

    private static final By testPlanButton = By.xpath("//*[@id=\"test_plan_mgmt_topics\"]/a[1]");
    private static final By logOutButton = By.xpath("/html/body/div[2]/span[2]/a[2]/img");



    public HomePage(WebDriver driver) {
        super(driver);
        goToHome();
    }

//    public void goToHome(){
//        driver.get("http://demo.testlink.org/latest/index.php");
//    }

    public TestPlanManagPage openTestPlanManagPage(){

//        driver.switchTo().frame("mainframe");
        switchToMainFrame();
//        System.out.println(driver.getPageSource());   // used for debugging
        driver.findElement(testPlanButton).click();

        return new TestPlanManagPage(driver);
    }

    public void logOut(){
        driver.switchTo().frame("titlebar");
        driver.findElement(logOutButton).click();
    }


}
