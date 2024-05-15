Feature: Login to SauceDemo

Scenario: Login Field with empty Username
    Given I am on the SauceDemo login page
    When I enter username "" and password "secret_sauce"
    And I click the login button
    Then I should see an error message Username is required
