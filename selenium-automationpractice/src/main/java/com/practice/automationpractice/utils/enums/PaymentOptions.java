package com.practice.automationpractice.utils.enums;

public enum PaymentOptions {
    BY_BANK("Pay by bank wire."),
    BY_CHECK("Pay by check.");

    private final String option;

    PaymentOptions(String option) {
        this.option = option;
    }

    public String toString() {
        return option;
    }
}
