package com.practice.automationpractice.pages.pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BaseCartPage {

    @FindBy(xpath = "//button/span[text()='I confirm my order']")
    private WebElement confirmOrderButton;

    OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
    }

    public void confirmOrder(){
        confirmOrderButton.click();
    }
}
