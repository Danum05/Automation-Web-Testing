Feature: Login with Invalid Username and Password to SauceDemo

Scenario: Login with incorrect username and password
    Given I am on the SauceDemo login page
    When I enter username "bukan_user" and password "bukanpassword"
    And I click the login button
    Then I should see an error message
