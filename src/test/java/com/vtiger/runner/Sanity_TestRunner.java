package com.vtiger.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(


        features="src/test/resources/Features/"
        ,glue="com.vtiger.stepsdefinitions"
        ,dryRun = false
        ,plugin = {"pretty","html:target/cucumber-reports.html"}
        ,tags = "@sanity"
        ,monochrome = false







)
public class Sanity_TestRunner extends AbstractTestNGCucumberTests {
}
