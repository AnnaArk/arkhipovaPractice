package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumqa.TestLink.Model.TestCase;
import org.seleniumqa.TestLink.Model.TestSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by gadget on 20.04.2015.
 */
public class SpecificationPage extends AbstractPage {

    private static final By specPage = By.xpath("//a[@accesskey='t']");
    private static final By actionsBtn = By.xpath("//img[@title='Actions']");
    private static final By createSuiteBtn = By.id("new_testsuite");
    private static final By suiteName = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By frameBody = By.tagName("body");
    private static final By saveSuiteButton = By.name("add_testsuite_button");
    private static final By createTestCaseBtn = By.xpath(".//*[@id='create_tc']");
    private static final By testCaseName = By.id("testcase_name");
    private static final By testCaseDescriptionField = By.className("cke_show_borders");
    //private static final By saveCaseBtn = By.id("do_create_button");
    private static final By saveCaseBtn = By.xpath(".//*[@id='do_create_button']");
    private static final By createStepBtn = By.name("create_step");
    private static final By testStepDescription = By.id("cke_contents_steps");
    private static final By testStepSaveBtn = By.id("do_update_step_and_exit");

    //private static final By createCaseButton = By.id("create_tc");
//    private static final By searchTestSuite = By.xpath(".//*[@id='filters']/table/tbody/tr[3]/td[2]/select");


    public SpecificationPage (WebDriver driver){
        super(driver);
    }

    public void open(){
        switchToTitleBar();
        driver.findElement(specPage).click();
    }

    public void createSuite(TestSuite suite){
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createSuiteBtn).click();
        driver.findElement(suiteName).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(frameBody).sendKeys(suite.details);
        driver.switchTo().parentFrame();
        driver.findElement(saveSuiteButton).click();
    }

    public void openTestSuite(TestSuite suite){   //test
        switchToMainFrame();
        switchToTreeFrame();
        driver.findElement(By.partialLinkText(suite.name)).click();
    }

    public void createTestCase(TestSuite testCase){
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createTestCaseBtn).click();
        driver.findElement(testCaseName).sendKeys(testCase.name);
        driver.switchTo().frame(0);
        driver.findElement(testCaseDescriptionField).sendKeys(testCase.description);
        switchToWorkFrame();
        driver.findElement(saveCaseBtn).click();
        driver.findElement(createStepBtn).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//td[@id='cke_contents_steps']/iframe")));
        driver.findElement(By.xpath("/html/body")).sendKeys(testCase.testStepDescription);
        switchToWorkFrame();
        driver.findElement(testStepSaveBtn).click();

    }

}

