@xyz
Feature: login functionality

  Background:
    Given user should be on login page

  @smoke @regression @defect32344 @chetana @abc
  Scenario: valid_login_TC01
    When user enters valid credentials
    Then user should navigated to home page
    And user can see the logout option

    @sanity @invalid
  Scenario: Invalid_login_TC02
    When user enters invalid credentials
    Then user should navigated to login page
    And user can see the error message

  @DF
  Scenario Outline: Invalid_login_TC03
    When user enters invalid credentials as username "<userid>" and password "<password>"
    Then user should navigated to login page
    And user can see the error message
    Examples:
      | userid | password |
      | admin1 | pwd1     |
      | admin2 | pwd2     |
      | admin3 | pwd3     |




