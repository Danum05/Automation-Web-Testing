Feature: Login to SauceDemo

Scenario: Login with Password Field is Unfilled
    Given I am on the SauceDemo login page
    When I enter username "standard_user" and password ""
    And I click the login button
    Then I should see an error message Password is required
