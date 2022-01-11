package com.practice.automationpractice.pages.pages.cart;

import com.practice.automationpractice.pages.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseCartPage extends BasePage {
    protected CheckoutStepsFragment checkoutStepsFragment;

    private static final List<String> expectedSteps = List.of(
            "01. Summary",
            "02. Sign in",
            "03. Address",
            "04. Shipping",
            "05. Payment"
    );

    BaseCartPage(WebDriver driver) {
        super(driver);
        checkoutStepsFragment = new CheckoutStepsFragment(driver);
    }


    protected void hasStepsBar() {
        expectedSteps.forEach( step ->
                assertThat(
                        checkoutStepsFragment.getStepsTexts()
                ).as("Steps to checkout" + step)
                        .contains(step)
        );
    }

    public void proceedToCheckout(){
        checkoutStepsFragment.proceedToCheckout();
    }
}
