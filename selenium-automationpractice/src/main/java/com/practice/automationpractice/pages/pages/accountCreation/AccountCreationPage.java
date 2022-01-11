package com.practice.automationpractice.pages.pages.accountCreation;

import com.practice.automationpractice.pages.pages.BasePage;
import com.practice.automationpractice.utils.Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountCreationPage extends BasePage {

    private PersonalInformationFragment personalInformationFragment;
    private AddressFragment addressFragment;

    @FindBy(css = "#submitAccount")
    private WebElement registerButton;

    @FindBy(css = ".alert.alert-danger")
    private WebElement errorBox;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        personalInformationFragment = new PersonalInformationFragment(driver);
        addressFragment = new AddressFragment(driver);
    }

    @Override
    public void isAt() {

    }

    public void fillPersonalInformation(Client client) {
        personalInformationFragment.fillPersonalInformation(client);
    }

    public void fillAddressInformation(Client client) {
        addressFragment.fillAddressInformation(client);
    }

    public void submitRegistrationForm() {
        registerButton.click();
    }

    public void checkforErrorText(String expectedErrorText) {
        assertThat(errorBox.getText())
                .as("Error box content")
                .contains(expectedErrorText);
    }
}
