package com.vtiger.runner;


import com.vtiger.manager.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(


        features="src/test/resources/Features/"
        ,glue={"com.vtiger.stepsdefinitions"}

        ,dryRun = false
        ,plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
        ,tags = "@chetana"
        ,monochrome = false







)
public class TestRunner extends AbstractTestNGCucumberTests {
    public static String browserName;

    @BeforeClass
    @Parameters({"browser"})
    public void defineBrowser(String browser) {
        browserName = browser;
    }


}
