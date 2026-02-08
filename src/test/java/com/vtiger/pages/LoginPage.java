package com.vtiger.pages;

import com.vtiger.stepsdefinitions.basesteps;
import com.vtiger.utilities.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonMethods {


    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //public String userid = "//input[@name='user_name']";

    //By userid = By.xpath("//input[@name='user_name']");

    @FindBy(xpath="//input[@name='user_name']")
    WebElement tb_userid;

    @FindBy(how = How.XPATH, using = "//input[@name='user_password']")
    WebElement tb_pwd;

    @FindBy(xpath="//input[@name='Login']")
    WebElement btn_login;

    @FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
    WebElement img_logo;

    @FindBy(xpath="//td[contains(text(),'123You must specify a valid username and password.')]")
    WebElement msg_error;






    public void login(String uid,String pwd)
    {
      setUsername(uid);
      setPassword(pwd);
        basesteps.logger.info("Screenshot capture of login page"+getScreenshot());
      clickLogin();
    }

    public void setUsername(String uid)
    {
        setInput(tb_userid,uid,uid+" has been entered into Username field");
    }

    public void setPassword(String pwd)
    {
      setInput(tb_pwd,pwd,pwd+" has been entered into Password field");
    }

    public void clickLogin()
    {
        clickELement(btn_login,"Login button clicked");
    }

    public void verifyUserName()
    {

        ElementDisplay(tb_userid,"Username field is displaying");
    }

    public void verifyLogo()
    {
       ElementDisplay(img_logo,"Logo is present");
    }

    public void verifyErrorMsg()
    {
        ElementDisplay(msg_error,"Error message validated successfully");
    }





}
