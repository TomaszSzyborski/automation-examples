package com.practice.cucumber;

import com.practice.cucumber.contextStorage.ContextNames;
import com.practice.cucumber.contextStorage.TestContext;
import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.testng.TestNGCourgette;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        showTestOutput = true,
        reportTargetDir = "target",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "com.billennium.cucumber.steps",
                tags = {"@regression", "not @wip"},
                plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html"},
                strict = true
        ))
public class CourgetteRegressionSuiteRunner extends TestNGCourgette {
    @Before
    public void scenarioSetup() {
        TestContext.testContext().set(ContextNames.ERROR_MESSAGE, "");
    }

    @After
    public void scenarioTeardown() {
        TestContext.testContext().reset();
    }
}