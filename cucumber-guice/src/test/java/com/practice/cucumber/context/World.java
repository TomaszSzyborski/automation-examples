package com.practice.cucumber.context;

import com.practice.cucumber.mocks.Account;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class World {
    public Account account;
    public Error caughtError = new Error("My custom error not thrown (╯°□°）╯︵ ┻━┻) ");
}
