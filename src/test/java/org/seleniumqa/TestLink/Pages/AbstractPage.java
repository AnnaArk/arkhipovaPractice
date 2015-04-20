package org.seleniumqa.TestLink.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by 1 on 24.03.2015.
 */
public class AbstractPage {

    protected WebDriver driver;

    private static final By headerFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By workFrame = By.name("workframe");
    private static final By iFrame = By.xpath("//iframe[@aria-describedby='cke_43']");

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToHome(){
        driver.get("http://demo.testlink.org/latest/index.php");
    }

    protected void switchToTitleBar(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headerFrame));
    }

    protected void switchToTreeFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

    protected void switchToWorkFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }

    protected void switchToMainFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
    }

    protected void switchToIFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(iFrame));
    }
}
