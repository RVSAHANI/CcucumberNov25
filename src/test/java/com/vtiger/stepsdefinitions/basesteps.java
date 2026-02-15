package com.vtiger.stepsdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.manager.DriverManager;
import com.vtiger.manager.PageObjectManager;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import com.vtiger.runner.TestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class basesteps {

    public static Properties prop;
    public static Map<String, Map<String,String>> dt;
    public  WebDriver driver;


    public static String ScenarioName;

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    public static PageObjectManager pom;


    public void LaunchApp() throws Exception {

        String browser = TestRunner.browserName;
        DriverManager dm = new DriverManager();
        if(browser!=null) {

            driver = dm.getDriver(browser);
        }
        else
        {

            driver = dm.getDriver(prop.getProperty("browser"));
        }

        pom = new PageObjectManager(driver);
        driver.get(prop.getProperty("Appurl"));
        int timeout = Integer.parseInt(prop.getProperty("globaltimeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));




    }

    public void readsetting() throws Exception {
        prop = new Properties();
        FileInputStream fis  = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/setting.properties");
        prop.load(fis);
    }

    public void readdata() throws FilloException {

        dt = new HashMap<>();

        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/TestData/data.xlsx");
        String strQuery="Select * from Sheet1";
        Recordset recordset=connection.executeQuery(strQuery);
        List<String> ls = recordset.getFieldNames();

        while(recordset.next()){

            Map<String,String> m = new HashMap<>();
            for(String colm : ls) {
               m.put(colm,recordset.getField(colm));
            }
            dt.put(recordset.getField("Scenario Name"),m);
        }

        recordset.close();
        connection.close();
    }

    public void createExtentReport()
    {
        //report_13042025104034.html
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
         htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport_"+fileName+".html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Automation Test Hub");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User Name", "Rajesh U");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
        // Name of the report
        htmlReporter.config().setReportName("Name of the Report Comes here ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);

    }
}
