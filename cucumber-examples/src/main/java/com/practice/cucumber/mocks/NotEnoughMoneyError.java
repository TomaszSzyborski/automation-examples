package com.practice.cucumber.mocks;

public class NotEnoughMoneyError extends Error {
    public NotEnoughMoneyError() {
        super("You don't have enough money to withdraw");
    }
}
