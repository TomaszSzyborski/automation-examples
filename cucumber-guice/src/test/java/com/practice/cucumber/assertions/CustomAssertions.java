package com.practice.cucumber.assertions;

import com.practice.cucumber.mocks.Account;

public class CustomAssertions {

    public static AccountAssert assertThat(Account actual) {
        return new AccountAssert(actual);
    }
}
