package com.bootcamp;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/bootcamp/features",
        glue = "com.bootcamp.steps",
        plugin = {"pretty", "html:report/cucumber-report.html"},
        publish = true
)

public class TestRunner {

}
