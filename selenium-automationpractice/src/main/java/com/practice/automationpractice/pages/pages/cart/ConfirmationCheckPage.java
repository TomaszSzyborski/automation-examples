package com.practice.automationpractice.pages.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmationCheckPage extends BaseCartPage {

    @FindBy(css = ".box .cheque-indent")
    private WebElement confirmationMessage;

    ConfirmationCheckPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
    }

    public void checkIfOrderConfirmed(){
        assertThat(confirmationMessage.getText())
                .as("Confirmation message")
                .contains("Your order on My Store is complete.");
    }
}
