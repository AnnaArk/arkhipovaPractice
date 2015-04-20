package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumqa.TestLink.Model.TestCase;
import org.seleniumqa.TestLink.Model.TestSuite;

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
    private static final By searchTestSuite = By.xpath(".//*[@id='filters']/table/tbody/tr[3]/td[2]/select");

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

    public void openTestSuite(TestSuite suite){
        switchToMainFrame();
        switchToTreeFrame();
        driver.findElements(searchTestSuite)

    }

    public void createTestCase(TestSuite testCase){
        switchToWorkFrame();
        driver.findElement(actionsBtn).click();
        driver.findElement(createTestCaseBtn).click();
        driver.findElement(testCaseName).sendKeys(testCase.name);

    }
}
