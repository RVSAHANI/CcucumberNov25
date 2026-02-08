package com.vtiger.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver(String browser)
    {

        if(browser.equals("headless")) {
            // ===== Headless Configuration =====
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);

        }
        else if(browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }

//        if(prop.getProperty("browser").equals("headless")) {
//            // ===== Headless Configuration =====
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new");
//            driver = new ChromeDriver(options);
//
//        }
//        else if(prop.getProperty("browser").equals("firefox")) {
//            driver = new FirefoxDriver();
//        }
//        else if(prop.getProperty("browser").equals("edge")) {
//            driver = new EdgeDriver();
//        }
//        else
//        {
//            driver = new ChromeDriver();
//        }



        driver.manage().window().maximize();
        return driver;
    }
}
