package org.seleniumqa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;

/**
 * Created by admin on 16.03.2015.
 */
public class WebDriverFactory {

    static {
        try {
            System.setProperty("webDriver.firefox.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/windows/firefox.exe").getPath());
        } catch (Exception e) {

            System.out.println("Cannot launch FireFox or Chrome driver \n" + e.getMessage());
        }
    }

    public static WebDriver getWebDriver(BrowserTypes browserType) throws IOException {


        switch (browserType) {

            case FIRE_FOX:
                return new FirefoxDriver();

            case CHROME:
                return new ChromeDriver();

            case IE:
                return new InternetExplorerDriver();

            default:
                throw new IllegalArgumentException("Browser is not supported" + browserType);

        }
    }

}


