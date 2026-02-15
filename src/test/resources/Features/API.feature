
Feature: API Testing


  Scenario: Get_All_Employee_TC06
    Given enpoint "/api/v1/employees"
    When user perform GET operation
    Then user can validate the response code 200
    And user can validate the response data

  Scenario: Get_Employee_TC07
    Given enpoint "/api/v1/employee/1"
    When user perform GET operation
    Then user can validate the response code 200
    And user can validate the response data
    And validate employee id

  @chetana
  Scenario: Create_Employee_TC08
    Given enpoint "/api/v1/create"
    When user perform POST operation
    And user can validate post response data

