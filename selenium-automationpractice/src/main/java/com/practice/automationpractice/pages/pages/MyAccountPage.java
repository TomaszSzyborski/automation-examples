package com.practice.automationpractice.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//a[@title='Orders']")
    private WebElement ordersButton;

    @FindBy(xpath = "//a[@title='Credit slips']")
    private WebElement creditSlipsButton;

    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressesButton;

    @FindBy(xpath = "//a[@title='Information']")
    private WebElement personalInformationButton;

    @FindBy(xpath = "//a[@title='My wishlists']")
    private WebElement myWishlistButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        Map<String, WebElement> elements = Map.of(
                "Orders", ordersButton,
                "Credit Slips", creditSlipsButton,
                "Addresses", addressesButton,
                "Personal Information", personalInformationButton,
                "My Wishlists", myWishlistButton
        );

        elements.forEach( (name, webElement) ->
            assertThat(webElement.isDisplayed())
                    .as(name)
                    .isTrue()
        );
    }

}
