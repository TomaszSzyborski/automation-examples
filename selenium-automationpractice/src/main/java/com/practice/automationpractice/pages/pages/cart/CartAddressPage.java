package com.practice.automationpractice.pages.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CartAddressPage extends BaseCartPage {

    @FindBy(css = "#id_address_delivery")
    private WebElement selectAddressByAliasDropdown;

    @FindBy(css = "p.address_add a.button")
    private WebElement addNewAddressButton;

    CartAddressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        hasStepsBar();
        checkoutStepsFragment.hasNavigationButtons();

        Map.of(
                "Alias dropdown", selectAddressByAliasDropdown,
                "Add a new address button", addNewAddressButton
        ).forEach( (description, element) ->
            assertThat(element.isDisplayed()).as(description).isTrue()
        );
    }


}
