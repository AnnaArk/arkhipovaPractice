package org.seleniumqa.TestLink.Tests;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumqa.TestLink.Model.TestPlan;
import org.seleniumqa.TestLink.Model.User;
import org.seleniumqa.TestLink.Pages.HomePage;
import org.seleniumqa.TestLink.Pages.LoginPage;
import org.seleniumqa.TestLink.Pages.TestPlanEditPage;
import org.seleniumqa.TestLink.Pages.TestPlanManagPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by admin on 08.04.2015.
 */
public class TestCases {

    WebDriver driver;

    @BeforeTest

    public void login(User user){

        driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new User());

    };


    @Test

    public void positiveTest(){


        HomePage homePage = new HomePage(driver);
        TestPlanManagPage testPlanManagPage = homePage.openTestPlanManagPage();
        TestPlanEditPage editPage = testPlanManagPage.createTestPlan();

        TestPlan testPlan = new TestPlan();

        editPage.createTestPlan(testPlan);

        Assert.assertTrue(testPlanManagPage.isTestPlanPresent(testPlan));
        //*Функция удалить однозначно зависит от ассерт,
        // если ассерт тру, тогда означает, что тест план создался
        // Можно писать несколько асертов, если нужно пошаговое выполнения и проверка(если он фейл дальше не пойдёт)
        // Можно писать, когда каждый след шаг зависит от предыдущего
        //
        deleteTestPLan(testPlan);

    }

    @AfterTest

    //выполняется, когда тест выполняется как-угодно

    public void shutEnv(){
        logout();
        if(driver == null){
            driver.quit();
        }
    }

    public void deleteTestPLan(TestPlan testPlan){
        TestPlanManagPage managmentPage = new TestPlanManagPage(driver);
        managmentPage.deleteTestPlan(testPlan);

    }

    public void logout(){

        HomePage homePage = new HomePage();
        homePage.logout();

    }


}


