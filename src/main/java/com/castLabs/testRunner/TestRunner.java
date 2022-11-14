package com.castLabs.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\java\\com\\castLabs\\features",
        glue = "com.castLabs.stepDefinitions",
        monochrome = true,
        plugin = {
                "pretty",
                "html:test-output"
        }
)
public class TestRunner {
}
