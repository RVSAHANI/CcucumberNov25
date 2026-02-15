package com.vtiger.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;

public class API_steps extends basesteps {

    public String endpoint;
    public Response resp;

    @Given("enpoint {string}")
    public void enpoint(String endpoint) {
       this.endpoint = prop.getProperty("APIUrl")+dt.get(ScenarioName).get("path");
       logger.info("Given endpoint is "+endpoint);
    }
    @When("user perform GET operation")
    public void user_perform_get_operation() {
        resp = RestAssured.get(endpoint);
        resp.getBody().prettyPrint();
        logger.info("Response "+resp.getBody().prettyPrint());
    }

    @When("user perform DELETE operation")
    public void user_perform_delete_operation() {
        resp = RestAssured.delete(endpoint);
        resp.getBody().prettyPrint();
        logger.info("Response "+resp.getBody().prettyPrint());
    }

    @When("user perform POST operation")
    public void user_perform_post_operation() {
       // String requestBody = "{ \"name\":\"test\", \"salary\":\"123\", \"age\":\"23\" }";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", dt.get(ScenarioName).get("name"));
        requestBody.put("salary", dt.get(ScenarioName).get("salary"));
        requestBody.put("age", dt.get(ScenarioName).get("age"));
        logger.info("Request "+requestBody);

        resp =
                RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .post(endpoint);

        resp.then().statusCode(200);
        resp.getBody().prettyPrint();
        logger.info("Response "+resp.getBody().prettyPrint());
    }

    @When("user perform PUT operation")
    public void user_perform_put_operation() {
        // String requestBody = "{ \"name\":\"test\", \"salary\":\"123\", \"age\":\"23\" }";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "test");
        requestBody.put("salary", "123");
        requestBody.put("age", "23");
        logger.info("Request "+requestBody);

        resp =
                RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .put(endpoint);

        resp.then().statusCode(200);
        resp.getBody().prettyPrint();
        logger.info("Response "+resp.getBody().prettyPrint());
    }

    @When("user perform PATCH operation")
    public void user_perform_patch_operation() {
        // String requestBody = "{ \"name\":\"test\", \"salary\":\"123\", \"age\":\"23\" }";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "test");
        requestBody.put("salary", "123");
        requestBody.put("age", "23");

        resp =
                RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .when()
                        .patch(endpoint);

        resp.then().statusCode(200);
        resp.getBody().prettyPrint();
    }

    @Then("user can validate post response data")
    public void user_can_validate_the_post_response_data() {
        System.out.println(resp.getStatusCode());
        JsonPath jp = resp.jsonPath();

        assertEquals("success", jp.getString("status"));
       // assertEquals("test", jp.getString("data.name"));
       // assertEquals("123", jp.getString("data.salary"));
        if( jp.getString("status").equals("success"))
        {
            logger.pass("status : Success" );
        }
        else
        {
            logger.pass("Status did not match " +jp.getString("status"));
        }

        System.out.println("Json path="+jp.getString("data.name"));
        System.out.println("Data ="+dt.get(ScenarioName).get("name"));

        if( jp.getString("data.name").equals(dt.get(ScenarioName).get("name")))
        {
            logger.pass("name : " +dt.get(ScenarioName).get("name"));
        }
        else
        {
            logger.pass("Status did not match " +dt.get(ScenarioName).get("name"));
        }

        if( jp.getString("data.salary").equals(dt.get(ScenarioName).get("salary")))
        {
            logger.pass("salary : " +dt.get(ScenarioName).get("salary"));
        }
        else
        {
            logger.pass("Status did not match " +dt.get(ScenarioName).get("salary"));
        }




    }


    @Then("user can validate the response code {int}")
    public void user_can_validate_the_response_code(Integer int1) {
        System.out.println(resp.getStatusCode());
        JsonPath jp = resp.jsonPath();

        assertEquals("19", jp.getString("data[18].id"));

        System.out.println("ID="+jp.getString("data[18].id"));
        assertEquals(24, jp.getList("data").size());
    }
    @Then("user can validate the response data")
    public void user_can_validate_the_response_data() {
        resp.then()
                .body(matchesJsonSchemaInClasspath("schema/employee-schema.json"));



    }

    @Then("validate employee id")
    public void user_can_validate_id() {

        JsonPath jp = resp.jsonPath();

        assertEquals("1", jp.getString("data.id"));

        System.out.println("ID="+jp.getString("data.id"));

    }

}
