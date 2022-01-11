package com.practice.automationpractice.pages.pages.cart;

import com.practice.automationpractice.utils.enums.PaymentOptions;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPaymentPage extends BaseCartPage {

    @FindBy(css = "a.bankwire")
    private WebElement payByBankWireButton;

    @FindBy(css = "a.cheque")
    private WebElement payByCheckButton;

    CartPaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        hasStepsBar();
        Map.of(
                "Bank wire", payByBankWireButton,
                "Check", payByCheckButton
        ).forEach((description, element) ->
                assertThat(element.isDisplayed()).as(description).isTrue()
        );
    }

    public void payBy(PaymentOptions option){
        driver.findElement(new ByCssSelector("a[title='"+option.toString()+"']")).click();
    }
}
