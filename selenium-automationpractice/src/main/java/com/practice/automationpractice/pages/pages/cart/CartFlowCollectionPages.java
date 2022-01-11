package com.practice.automationpractice.pages.pages.cart;

import com.practice.automationpractice.pages.BaseAbstraction;
import org.openqa.selenium.WebDriver;

public class CartFlowCollectionPages extends BaseAbstraction {

    public CartSummaryPage cartSummaryPage;
    public CartAddressPage cartAddressPage;
    public CartShippingPage cartShippingPage;
    public CartPaymentPage cartPaymentPage;
    public OrderConfirmationPage orderConfirmationPage;
    public ConfirmationCheckPage confirmationCheckPage;

    public CartFlowCollectionPages(WebDriver driver) {
        super(driver);
        cartSummaryPage = new CartSummaryPage(driver);
        cartAddressPage = new CartAddressPage(driver);
        cartShippingPage = new CartShippingPage(driver);
        cartPaymentPage = new CartPaymentPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        confirmationCheckPage = new ConfirmationCheckPage(driver);
    }
}
