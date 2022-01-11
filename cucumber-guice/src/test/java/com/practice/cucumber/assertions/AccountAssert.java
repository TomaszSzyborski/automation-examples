package com.practice.cucumber.assertions;

import com.practice.cucumber.mocks.Account;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class AccountAssert extends AbstractAssert<AccountAssert, Account> {

    private static final String messageTemplate = "\nExpecting Account to have {} <%s>\nbut had:\n<%s>";
    private BigDecimal balance;
    private BigDecimal lastDeposit;
    private BigDecimal lastWithdrawal;

    public AccountAssert(Account actual) {
        super(actual, AccountAssert.class);
        balance = actual.getAccountBalance();
        lastDeposit = actual.getLastDeposit();
        lastWithdrawal = actual.getLastWithdrawal();
    }


    public AccountAssert hasBalance(BigDecimal expectedAmount) {
        failWithMessageIfNotEqual(expectedAmount,
                actual.getAccountBalance(),
                MessageFormat.format(messageTemplate, "balance"));
        return this;
    }

    public AccountAssert hasLastWithdrawal(BigDecimal expectedAmount) {
        failWithMessageIfNotEqual(expectedAmount,
                actual.getLastWithdrawal(),
                MessageFormat.format(messageTemplate, "last withdrawal"));
        return this;
    }

    public AccountAssert hasLastDeposit(BigDecimal expectedAmount) {
        failWithMessageIfNotEqual(expectedAmount,
                actual.getLastDeposit(),
                MessageFormat.format(messageTemplate, "last deposit"));
        return this;
    }

    private void failWithMessageIfNotEqual(BigDecimal expectedAmount, BigDecimal actualAmount, String assertjErrorMessage) {
        if (!Objects.areEqual(expectedAmount, actualAmount)) {
            failWithMessage(assertjErrorMessage, expectedAmount, actualAmount);
        }
    }
}
