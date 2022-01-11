package com.practice.automationpractice.utils.enums;

public enum SearchOption {
    PRICE("price"),
    POSITION("position"),
    NAME("name"),
    QUANTITY("quantity"),
    REFERENCE("reference");

    private final String option;

    SearchOption(String option) {
        this.option = option;
    }

    public String toString() {
        return option;
    }
}
