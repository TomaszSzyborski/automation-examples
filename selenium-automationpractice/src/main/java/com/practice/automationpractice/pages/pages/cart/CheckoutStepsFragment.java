package com.practice.automationpractice.pages.pages.cart;

import com.practice.automationpractice.pages.modules.BaseModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutStepsFragment extends BaseModule {

    @FindBy(css = "li[class^='step_']")
    private List<WebElement> stepsList;

    @FindBy(css = "a.btn[title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(css = "a.btn[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    CheckoutStepsFragment(WebDriver driver) {
        super(driver);
    }

    List<String> getStepsTexts() {
        return stepsList.stream().map(WebElement::getText).collect(toList());
    }

    protected void hasNavigationButtons(){
        Map.of(
                "Continue shopping", continueShoppingButton,
                "Proceed to checkout", proceedToCheckoutButton
        ).forEach( (description, element) ->
                assertThat(continueShoppingButton.isDisplayed())
                        .as("Continue shopping")
                        .isTrue()
                );
    }

    protected void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
