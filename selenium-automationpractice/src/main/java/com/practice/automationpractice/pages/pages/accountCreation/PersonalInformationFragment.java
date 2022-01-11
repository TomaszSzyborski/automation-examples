package com.practice.automationpractice.pages.pages.accountCreation;

import com.practice.automationpractice.pages.BaseAbstraction;
import com.practice.automationpractice.utils.Client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformationFragment extends BaseAbstraction {

    @FindBy(css = "#customer_firstname")
    private WebElement firstNameInputField;

    @FindBy(css = "#customer_lastname")
    private WebElement lastNameInputField;

    @FindBy(css = "#email")
    private WebElement emailInputField;

    @FindBy(css = "#passwd")
    private WebElement passwordInputfield;

    @FindBy(css = "#days")
    private WebElement dateOfBirthDaysDropdown;

    @FindBy(css = "#months")
    private WebElement dateOfBirthMonthsDropdown;

    @FindBy(css = "#years")
    private WebElement dateOfBirthYearsDropdown;

    @FindBy(css = "#newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = "#optin")
    private WebElement optInCheckbox;

    PersonalInformationFragment(WebDriver driver) {
        super(driver);
    }


    void fillPersonalInformation(Client client){
        driver.findElement(
                By.xpath("//*[normalize-space(.)='"+client.getTitle()+"']//*[@type='radio']"))
                .click();
        firstNameInputField.sendKeys(client.getFirstName());
        lastNameInputField.sendKeys(client.getLastName());
        emailInputField.clear();
        emailInputField.sendKeys(client.getEmail());
        passwordInputfield.sendKeys(client.getPassword());

        new Select(dateOfBirthDaysDropdown).selectByValue(client.getDateOfBirthDays());
        new Select(dateOfBirthMonthsDropdown).selectByValue(client.getDateOfBirthMonth());
        new Select(dateOfBirthYearsDropdown).selectByValue(client.getDateOfBirthYear());

        if (client.getNewsletterConsent()){
            newsletterCheckbox.click();
        }

        if (client.getOptinConsent()) {
            optInCheckbox.click();
        }
    }
}
