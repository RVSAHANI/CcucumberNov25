@xyz
Feature: All Lead functionality



@lead @chetana
 Scenario: Create_lead_with_mandatory_fields_TC04
  Given user should be on login page
  When user enters valid credentials
   When user click on new lead link
   And user enters lastname and company and click on save button
   Then lead should be created successfully
  And click on logout and close the browser


 @swati
  Scenario: Multi_lead_creation_TC05
    Given user should be on login page
    When user enters valid credentials
    And click on new lead and fill mandatory info and save and validate lead creation
      | lastname | company |
      | shah     | BJP     |
 #  | Gandhi   | Congress |
  #    | Pawar    | NCP     |
   And click on logout and close the browser
