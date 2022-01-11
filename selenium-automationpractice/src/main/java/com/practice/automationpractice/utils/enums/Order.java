package com.practice.automationpractice.utils.enums;

public enum Order {
    ASC("asc"),
    DESC("desc");

    private final String order;

    Order(String order) {
        this.order = order;
    }

    public String toString() {
        return order;
    }
}
