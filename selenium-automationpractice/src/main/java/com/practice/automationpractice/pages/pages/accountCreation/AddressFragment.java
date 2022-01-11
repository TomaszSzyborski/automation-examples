package com.practice.automationpractice.pages.pages.accountCreation;

import com.practice.automationpractice.pages.BaseAbstraction;
import com.practice.automationpractice.utils.Client;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressFragment extends BaseAbstraction {

    @FindBy(css = ".account_creation #firstname")
    private WebElement firstNameInputField;

    @FindBy(css = ".account_creation #lastname")
    private WebElement lastNameInputField;

    @FindBy(css = "#company")
    private WebElement companyInputField;

    @FindBy(css = "#address1")
    private WebElement addressFirstLineInputField;

    @FindBy(css = "#address2")
    private WebElement addressSecondLineInputField;

    @FindBy(css = "#city")
    private WebElement cityInputField;

    @FindBy(css = "#id_state")
    private WebElement stateDropdown;

    @FindBy(css = "#postcode")
    private WebElement postalCodeInputField;

    @FindBy(css = "#id_country")
    private WebElement countryDropdown;

    @FindBy(css = "#other")
    private WebElement otherInformationInputField;

    @FindBy(css = "#phone")
    private WebElement homePhoneInputfield;

    @FindBy(css = "#phone_mobile")
    private WebElement mobilePhoneInputField;

    @FindBy(css = "#alias")
    private WebElement addressAliasInputField;

    AddressFragment(WebDriver driver) {
        super(driver);
    }

    void fillAddressInformation(Client client) {
        firstNameInputField.clear();
        firstNameInputField.sendKeys(client.getFirstName());

        lastNameInputField.clear();
        lastNameInputField.sendKeys(client.getLastName());

        companyInputField.sendKeys(client.getCompany());
        addressFirstLineInputField.sendKeys(client.getAddress1());
        addressSecondLineInputField.sendKeys(client.getAddress2());
        cityInputField.sendKeys(client.getCity());

        new Select(stateDropdown).selectByVisibleText(client.getState());

        postalCodeInputField.sendKeys(client.getZipcode());

        new Select(countryDropdown).selectByValue("21");

        otherInformationInputField.sendKeys(client.getOther());
        homePhoneInputfield.sendKeys(client.getPhone());
        mobilePhoneInputField.sendKeys(client.getMobile());
        addressAliasInputField.sendKeys(client.getAlias());
    }
}
