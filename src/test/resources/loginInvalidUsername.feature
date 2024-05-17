Feature: Login With Invalid Username to SauceDemo

Scenario: Login with incorrect username
    Given I am on the SauceDemo login page
    When I enter username "bukan_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message
