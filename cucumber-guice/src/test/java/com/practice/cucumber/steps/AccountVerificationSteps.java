package com.practice.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java8.En;

import java.math.BigDecimal;

import static com.practice.cucumber.assertions.CustomAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountVerificationSteps extends AbstractSteps implements En {

    @Then("^(?:|I|user) should see error message (.*)$")
    public void checkErrorMessage(String expectedErrorMessage) {
        assertThat(world.caughtError)
                .hasMessage(expectedErrorMessage);
    }

    @Then("^last deposited amount should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkLastDepositedAmount(BigDecimal expectedDeposit) {
        assertThat(world.account)
                .hasLastDeposit(expectedDeposit);
    }

    @Then("^last withdrawn amount should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkLastWithdrawnAmount(BigDecimal expectedWithdrawal) {
        assertThat(world.account)
                .hasLastWithdrawal(expectedWithdrawal);
    }

    @Then("^current account balance should be: (-?\\d+\\.\\d{2}|<[a-zA-Z]{1,30}>)$")
    public void checkAccountBalance(BigDecimal expectedBalance) {
        assertThat(world.account)
                .hasBalance(expectedBalance);
    }
}
