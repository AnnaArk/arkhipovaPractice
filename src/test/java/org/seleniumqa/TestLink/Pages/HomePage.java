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
    private static final By specPage = By.xpath("//a[@accesskey='t']");
    private static final By logOutButton = By.xpath("/html/body/div[2]/span[2]/a[2]/img");
    private static final By actionsButton = By.xpath("//img[@title='Actions']");
    private static final By createSuiteBtn = By.id("new_testsuite");
    private static final By suiteName = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By saveSuiteButton = By.name("add_testsuite_button");
    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");


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

    public void open(){
        driver.switchTo().frame("titlebar");
        driver.findElement(specPage).click();
    }

    public boolean isOpened(){
        driver.switchTo().frame("titlebar");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return !driver.findElements(version).isEmpty();
    }

    public void createSuite(TestSuite suite){
        driver.switchTo().frame("workframe");
        driver.findElement(actionsButton).click();
        driver.findElement(createSuiteBtn).click();
        driver.findElement(suiteName).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(suite.details);
        driver.findElement(saveSuiteButton).click();
    }

}
