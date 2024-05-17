package com.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

    private WebDriver driver;

    public WebDriver setUp() {
        String currentDirectory = System.getProperty("user.dir");
        String msedgedriverPath = currentDirectory + "\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", msedgedriverPath);
        driver = new EdgeDriver();
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}