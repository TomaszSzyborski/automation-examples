package com.practice.jsonplaceholder.enums;

public enum Extremum {
    MAX(".max()"),
    MIN(".min()");

    private final String extremum;

    Extremum(String extremum) {
        this.extremum = extremum;
    }

    public String toString() {
        return extremum;
    }
}
