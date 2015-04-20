package org.seleniumqa.TestLink.Tests;

//import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumqa.TestLink.Model.TestPlan;
import org.seleniumqa.TestLink.Model.TestSuite;
import org.seleniumqa.TestLink.Model.User;
import org.seleniumqa.TestLink.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 08.04.2015.
 */
public class TestCases {

    WebDriver driver;

    @BeforeTest
    public void login() {

        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        User myuser = new User();
        loginPage.open();
        loginPage.login(myuser.name, myuser.password);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void createTestPlanTest() {
        HomePage homePage = new HomePage(driver);

        TestPlanManagPage testPlanManagPage = homePage.openTestPlanManagPage();
        TestPlanEditPage editPage = testPlanManagPage.createTestPlan();

        TestPlan testPlan = new TestPlan();
        editPage.createTestPlan(testPlan);
        // checking if test plan exists on the page
        Assert.assertTrue(testPlanManagPage.isTestPlanPresent(testPlan));
    }

    @Test
    public void createTestSpecification() {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();

        TestSuite testSuite = new TestSuite();
        specificationPage.createSuite(testSuite);

        specificationPage.openTestSuite(testSuite);
    }


    public void createTestCase(){
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();

        TestSuite testSuite = new TestSuite();
        specificationPage.createTestCase(testSuite);

    }

    public void createTestStep(){

    }

    @Test
    public void deleteTestPlanTest() {
        HomePage homePage = new HomePage(driver);

        TestPlanManagPage testPlanManagPage = homePage.openTestPlanManagPage();

        TestPlan testPlan = new TestPlan();
        testPlanManagPage.DeleteTestPlan(testPlan);
        // checking if test plan was deleted
        Assert.assertFalse(testPlanManagPage.isTestPlanPresent(testPlan));
    }

    @AfterTest
    public void shutEnv() {
        logout();
        if (driver == null) {
            driver.quit();
        }
    }

    public void logout() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHome();
        homePage.logOut();
    }


}


