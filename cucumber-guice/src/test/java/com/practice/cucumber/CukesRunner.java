package com.practice.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@accounting" ,"not @wip"},
        glue = "classpath:com/billennium/cucumber/steps")
@Test
public class CukesRunner extends AbstractTestNGCucumberTests {

    @Before
    public void scenarioSetup() {

    }

    @After
    public void scenarioTeardown() {
    }
}