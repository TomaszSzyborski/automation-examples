package com.practice.cucumber.mocks;

import com.google.inject.AbstractModule;

import java.math.BigDecimal;

public class Account extends AbstractModule {
    private static final String ZERO = "0.00";
    private BigDecimal accountBalance;
    private BigDecimal lastDeposit = new BigDecimal(ZERO);
    private BigDecimal lastWithdrawal = new BigDecimal(ZERO);


    public Account(BigDecimal amount) {
        accountBalance = amount;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void withdraw(BigDecimal amount) throws NotEnoughMoneyError {
        if (accountBalance.compareTo(amount) >= 0) {
            accountBalance = accountBalance.subtract(amount);
            lastWithdrawal = amount;
        } else {
            throw new NotEnoughMoneyError();
        }
    }

    public void deposit(BigDecimal amount) {
        accountBalance = accountBalance.add(amount);
        lastDeposit = amount;
    }

    public BigDecimal getLastDeposit() {
        return lastDeposit;
    }

    public BigDecimal getLastWithdrawal() {
        return lastWithdrawal;
    }
}
