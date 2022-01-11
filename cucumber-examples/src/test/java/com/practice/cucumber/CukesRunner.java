package com.practice.cucumber;

import com.practice.cucumber.contextStorage.ContextNames;
import com.practice.cucumber.contextStorage.TestContext;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@accounting",
        glue = "classpath:com/billennium/cucumber/steps")
@Test
public class CukesRunner extends AbstractTestNGCucumberTests {

    @Before
    public void scenarioSetup() {
        TestContext.testContext().set(ContextNames.ERROR_MESSAGE, "");
    }

    @After
    public void scenarioTeardown() {
        TestContext.testContext().reset();
    }
}