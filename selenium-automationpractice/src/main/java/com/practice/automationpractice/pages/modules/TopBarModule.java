package com.practice.automationpractice.pages.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class TopBarModule extends BaseModule {

    @FindBy(css = ".shop-phone")
    private WebElement callUsNow;

    @FindBy(css = ".shop-phone i")
    private WebElement callUsNowPhoneIcon;

    @FindBy(css = "#contact-link a")
    private WebElement contactLink;

    @FindBy(css = ".login")
    private WebElement loginButon;

    @FindBy(css = ".account")
    private WebElement myAccountButton;

    @FindBy(css = ".logout")
    private WebElement logoutButton;

    public TopBarModule(WebDriver driver) {
        super(driver);
    }

    public void checkPhoneNumber(String expectedPhoneNumber) {
        assertThat(callUsNow.getText()).as(
                "Displayed phone number"
        ).isEqualToNormalizingWhitespace("Call us now: " + expectedPhoneNumber);

        assertThat(callUsNowPhoneIcon.isDisplayed()).as(
                "Phone icon"
        ).isTrue();
    }

    public void checkMyAccountButtonAvailability(){
        assertThat(
                invisibilityOfElementLocated(new By.ByCssSelector(".account")).apply(driver))
                .as("Account button not visible")
                .isTrue();
    }

    public void goToContactUsPage() {
        contactLink.click();
    }

    public void goToSignInPage(){
        loginButon.click();
    }

    public void goToMyAccount(){
        myAccountButton.click();
    }

    public String getMyAccountButtonText(){
        return myAccountButton.getText();
    }

    public void logOut(){
        logoutButton.click();
    }
}
