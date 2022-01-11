package com.practice.cucumber.steps;

import com.practice.cucumber.contextStorage.TestContext;

import static com.practice.cucumber.contextStorage.TestContext.CONTEXT;

public abstract class AbstractSteps {

    public TestContext testContext() {
        return CONTEXT;
    }

}
