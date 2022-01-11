package com.practice.cucumber.steps;

import com.practice.cucumber.mocks.NotEnoughMoneyError;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;

import java.math.BigDecimal;


public class AccountAmountManipulationSteps extends AbstractSteps implements En {

    @When("^(?:|I|user) deposits? amount (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void depositAmount(BigDecimal amount){
        world.account.deposit(amount);
    }

    @When("^(?:I|user) tr(?:|y|ies) to withdraw amount (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void withdrawAmount(BigDecimal amount){
        try {
            world.account.withdraw(amount);
        } catch (NotEnoughMoneyError error) {
            world.caughtError = error;
        }
    }
}
