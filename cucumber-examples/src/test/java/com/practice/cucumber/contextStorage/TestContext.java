package com.practice.cucumber.contextStorage;

import com.practice.cucumber.mocks.Account;

import java.util.HashMap;
import java.util.Map;

import static com.practice.cucumber.contextStorage.ContextNames.ACCOUNT;
import static com.practice.cucumber.contextStorage.ContextNames.ERROR_MESSAGE;
import static java.lang.ThreadLocal.withInitial;

public enum TestContext {
    CONTEXT;

    private final ThreadLocal<Map<Enum, Object>> testContexts = withInitial(HashMap::new);

    public <T> T get(Enum name) {
        return (T) testContexts.get()
                .get(name);
    }

    public <T> T set(Enum name, T object) {
        testContexts.get()
                .put(name, object);
        return object;
    }

    public static TestContext testContext() {
        return CONTEXT;
    }

    public void setAccount(Account account){
        set(ACCOUNT, account);
    }

    public Account getAccount(){
        return get(ACCOUNT);
    }

    public void setErrorMessage(String errorMessage){
        set(ERROR_MESSAGE, errorMessage);
    }

    public String getErrorMessage(){
        return get(ERROR_MESSAGE);
    }

    public void reset() {
        testContexts.get().clear();
    }
}
