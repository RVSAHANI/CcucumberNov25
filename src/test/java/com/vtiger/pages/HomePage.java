package com.vtiger.pages;

import com.vtiger.utilities.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {

    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(linkText="Logout")
    WebElement lnk_logout;

    @FindBy(linkText="New Lead")
    WebElement lnk_newlead;

    @FindBy(linkText="Home")
    WebElement lnk_home;




    public void clickNewLead()
    {
        clickELement(lnk_newlead,"Link New Lead clicked");
    }

    public void clickLogout()
    {
         clickELement(lnk_logout,"Link Logout Clicked");
    }

    public void verifylogout()
    {

        ElementDisplay(lnk_logout,"Link Logout exist");
    }

    public void verifyhome()
    {
        ElementDisplay(lnk_home,"Menu Home is displaying");
    }







}
