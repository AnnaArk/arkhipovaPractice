package org.seleniumqa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumqa.ui_tests.TestData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver webDriver;

    protected static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws IOException

    {
        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 30);

    }

    @AfterSuite
    public void tearDown()

    {

        webDriver.quit();

    }


}