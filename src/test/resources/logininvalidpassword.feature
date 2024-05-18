Feature: Login with incorrect Password SauceDemo

Scenario: Login with incorrect password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "bukanpassword"
    And I click the login button
    Then I should see an error message
