package com.vtiger.manager;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private LoginPage lp;
    private HomePage hp;
    private LeadPage ldp;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (lp == null) {
            lp = new LoginPage(driver);
        }
        return lp;
    }

    public HomePage getHomePage() {
        if (hp == null) {
            hp = new HomePage(driver);
        }
        return hp;
    }

    public LeadPage getLeadPage() {
        if (ldp == null) {
            ldp = new LeadPage(driver);
        }
        return ldp;
    }
}
