package com.practice.cucumber.steps;

import com.practice.cucumber.mocks.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;

import java.math.BigDecimal;

public class AccountCreationSteps extends AbstractSteps implements En {

    @Given("^(?:|I|user) ha(?:|ve|s) account with initial balance (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void createAccountWithBalance(BigDecimal amount){
        world.account = new Account(amount);
    }

}
