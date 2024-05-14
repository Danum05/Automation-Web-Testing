Feature: Login to SauceDemo

Scenario: Login with incorrect password
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password "wrong_password"
    And I click the login button
    Then I should see an error message
