package com.vtiger.utilities;

import com.vtiger.stepsdefinitions.basesteps;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonMethods(WebDriver driver)
    {
        this.driver = driver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(1));

    }




    public void setInput(WebElement elm, String value, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            basesteps.logger.pass(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            basesteps.logger.fail("Unable to Input text due to error "+e.getMessage()+getScreenshot());
        }
    }

    public void clickELement(WebElement elm, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            basesteps.logger.pass(msg);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            basesteps.logger.fail("Unable to click due to error "+e.getMessage()+getScreenshot());
        }
    }

    public void ElementDisplay(WebElement elm, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            basesteps.logger.pass(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            basesteps.logger.fail("Element not found due to error "+e.getMessage()+getScreenshot());
        }
    }

    public void verifyGetText(WebElement elm, String txt, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
           elm.getText().equals(txt);
            basesteps.logger.pass(msg);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            basesteps.logger.fail("Unable to retrive text due to error "+e.getMessage()+getScreenshot());
        }
    }


    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String imagepath = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+path+"'><span class='label time-taken grey lighten-1 white-text'>Screenshot</span><a>";
        return imagepath;
    }






}
