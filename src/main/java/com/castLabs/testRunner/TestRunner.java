package com.castLabs.testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

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
        private static String[] defaultOptions = {
                "src\\main\\java\\com\\castLabs\\features",
                "--glue", "com.castLabs.stepDefinitions",
                "--plugin", "pretty",
                "--plugin", "html:test-output"
        };

        public static void main(String[] args) throws Throwable {
                Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
                io.cucumber.core.cli.Main.main(cucumberOptions.toArray(String[]::new));
        }
}
