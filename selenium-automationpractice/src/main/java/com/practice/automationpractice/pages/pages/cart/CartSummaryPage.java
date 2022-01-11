package com.practice.automationpractice.pages.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class CartSummaryPage extends BaseCartPage {

    @FindBy(css = "#cart_summary")
    private WebElement cartSummaryTable;

    CartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        hasStepsBar();
        checkoutStepsFragment.hasNavigationButtons();

        assertThat(cartSummaryTable.isDisplayed())
                .as("Cart summary table")
                .isTrue();
    }
}
