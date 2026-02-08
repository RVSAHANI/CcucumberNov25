package com.vtiger.stepsdefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;


public class loginsteps extends basesteps  {


    @Before
    public void getScenario(Scenario scenario) throws Exception {
        if(htmlReporter==null) {
            createExtentReport();
        }
        ScenarioName = scenario.getName();
        logger = extent.createTest(ScenarioName);
        logger.info("Test Execution started");

    }
    @After
    public void tierdown()
    {
       logger.info("Test Execution Completed");
            extent.flush();


    }


    @Then("user can see the logout option")
    public void user_can_see_the_logout_option() {

        pom.getHomePage().verifylogout();
    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials() {
       // lp.login("admin123","admin");
        pom.getLoginPage().login(dt.get(ScenarioName).get("Userid"),dt.get(ScenarioName).get("Password"));

    }
    @Then("user should navigated to login page")
    public void user_should_navigated_to_login_page() throws InterruptedException {
        pom.getLoginPage().verifyUserName();
    }
    @Then("user can see the error message")
    public void user_can_see_the_error() {
        pom.getLoginPage().verifyErrorMsg();
    }

    @When("user enters invalid credentials as username {string} and password {string}")
    public void user_enters_invalid_credentials_as_username_and_password(String uid, String pwd) {
        pom.getLoginPage().login(uid,pwd);
    }



    @Given("user should be on login page")
    public void user_should_be_on_login_page() throws Exception {


            LaunchApp();

    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
           //  lp.login("admin","admin");
        pom.getLoginPage().login(dt.get(ScenarioName).get("Userid"),dt.get(ScenarioName).get("Password"));
    }
    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() {

        pom.getHomePage().verifyhome();

    }

}
