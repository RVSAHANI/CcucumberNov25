package com.vtiger.stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class leadsteps extends basesteps{


    @When("user click on new lead link")
    public void user_click_on_new_lead_link() {
     pom.getHomePage().clickNewLead();
    }
    @When("user enters lastname and company and click on save button")
    public void user_enters_lastname_and_company_and_click_on_save_button() {
        pom.getLeadPage().createlead(dt.get(ScenarioName).get("FirstName"),dt.get(ScenarioName).get("LastName"),dt.get(ScenarioName).get("Company"));

    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {
        pom.getLeadPage().verifyLastNameText(dt.get(ScenarioName).get("LastName"));
        pom.getLeadPage().verifyCompanyText(dt.get(ScenarioName).get("Company"));
    }

    @When("click on new lead and fill mandatory info and save and validate lead creation")
    public void click_on_new_lead_and_fill_mandatory_info_and_save_and_validate_lead_creation(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> lst  = dataTable.asMaps();
        for(Map<String,String> m : lst)
        {

            pom.getHomePage().clickNewLead();
            pom.getLeadPage().createlead("Mr",m.get("lastname"),m.get("company"));
            pom.getLeadPage().verifyLastNameText(m.get("lastname"));
            pom.getLeadPage().verifyCompanyText(m.get("company"));

        }


    }
    @When("click on logout and close the browser")
    public void click_on_logout_and_close_the_browser() {

        pom.getHomePage().clickLogout();
       // driver.quit();
    }
}
