package com.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/",
    glue = {"com.automation"},
    plugin = {"html:target/cucumber-reports"}
)

public class RunCucumberTestValid {
}
