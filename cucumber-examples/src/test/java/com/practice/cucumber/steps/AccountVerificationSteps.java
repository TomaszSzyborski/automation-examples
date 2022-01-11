package com.practice.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountVerificationSteps extends AbstractSteps implements En {

    @Then("^(?:|I|user) should see error message (.*)$")
    public void checkErrorMessage(String expectedErrorMessage){
        Assertions.assertThat(testContext().getErrorMessage())
                .as("thrown error message")
                .isEqualTo(expectedErrorMessage);
    }

    @Then("^last deposited amount should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkLastDepositedAmount(BigDecimal expectedDeposit){
        Assertions.assertThat(testContext().getAccount().getLastDeposit())
                .as("Last deposit")
                .isEqualTo(expectedDeposit);
    }

    @Then("^last withdrawn amount should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkLastWithdrawnAmount(BigDecimal expectedWithdrawal){
        Assertions.assertThat(testContext().getAccount().getLastWithdrawal())
                .as("Last withdrawal")
                .isEqualTo(expectedWithdrawal);
    }

    @Then("^current account balance should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkAccountBalance(String expectedBalance){
        Assertions.assertThat(testContext().getAccount().getAccountBalance())
                .as("Account balance")
                .isEqualTo(expectedBalance);
    }
}
