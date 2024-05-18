package com.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import com.automation.hooks.Hooks;
import com.automation.pages.*;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private Hooks hooks;

    @Before
    public void setUp() {
        hooks = new Hooks();
        driver = hooks.setUp();
    }

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        // Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message needed")
    public void i_should_see_an_error_message_needed() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: You need Username & Password !";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message username")
    public void i_should_see_an_error_message_username() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: Error Username doesn't match";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message Password is required")
    public void i_should_see_an_error_message_Password_is_required() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: You need Password !";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message Username is required")
    public void i_should_see_an_error_message_Username_is_required() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: You need Username !";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @When("I click the menu button")
    public void i_click_the_menu_button() {
        productsPage = new ProductsPage(driver);
        productsPage.clickMenuButton();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ProductsPage.LOGOUT_BUTTON))
                .click();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        // Assert that the URL is the expected login page URL
        assertTrue(driver.getCurrentUrl().contains("www.saucedemo.com"));
    }

    @After
    public void tearDown() {
        hooks.tearDown();
    }
}
