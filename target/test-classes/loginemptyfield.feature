Feature: Login to SauceDemo

Scenario: Login with Empty Field
    Given I am on the SauceDemo login page
    When I enter username "" and password ""
    And I click the login button
    Then I should see an error message Username is required
