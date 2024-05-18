Feature: Login With Empty Username and Password to SauceDemo

Scenario: Login with Empty Field
    Given I am on the SauceDemo login page
    When I enter username "" and password ""
    And I click the login button
    Then I should see an error message needed
