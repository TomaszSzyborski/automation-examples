package com.practice.automationpractice.pages.pages;

import com.practice.automationpractice.pages.BaseAbstraction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductAddedToCartModal extends BaseAbstraction {

    @FindBy(css = ".layer_cart_product h2")
    private WebElement modalMessage;

    @FindBy(css = ".layer_cart_product #layer_cart_product_title")
    private WebElement addedProductName;

    @FindBy(css = ".layer_cart_product .continue.btn")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    public ProductAddedToCartModal(WebDriver driver) {
        super(driver);
    }

    public ProductAddedToCartModal checkModalMessage() {
        assertThat(modalMessage.getText())
                .as("Added item to cart - message")
                .isEqualToNormalizingWhitespace("Product successfully added to your shopping cart");
        return this;
    }

    public ProductAddedToCartModal addedProductShouldHaveName(String productName) {
        assertThat(addedProductName.getText())
                .as("Added product name")
                .isEqualToNormalizingWhitespace(productName);
        return this;
    }

    public ProductAddedToCartModal proceedToCheckout() {
        proceedToCheckoutButton.click();
        return this;
    }
}
