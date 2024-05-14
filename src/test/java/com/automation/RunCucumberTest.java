package com.automation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/login.feature",
    glue = {"com.automation"},
    plugin = {"html:target/cucumber-reports"}
)

public class RunCucumberTest {
}
