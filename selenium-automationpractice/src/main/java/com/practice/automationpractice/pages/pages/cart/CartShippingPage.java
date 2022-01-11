package com.practice.automationpractice.pages.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartShippingPage extends BaseCartPage {

    @FindBy(css = ".delivery_options_address")
    private WebElement deliveryOptionsTable;

    @FindBy(css = "#cgv")
    private WebElement agreeToTermsCheckbox;

    CartShippingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        hasStepsBar();
        checkoutStepsFragment.hasNavigationButtons();
    }

    public void agreeToShippingTerms(){
        agreeToTermsCheckbox.click();
    }
}
