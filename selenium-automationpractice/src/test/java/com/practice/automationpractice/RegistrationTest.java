package com.practice.automationpractice;

import com.practice.automationpractice.pages.pages.MyAccountPage;
import com.practice.automationpractice.pages.pages.accountCreation.AccountCreationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void registrationSetup(){
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test
    public void validRegistration(){
        homePage.goToLoginPage();
        loginPage.createAnAccountWithEmail(client.getEmail());
        accountCreationPage.fillPersonalInformation(client);
        accountCreationPage.fillAddressInformation(client);
        accountCreationPage.submitRegistrationForm();
        myAccountPage.isAt();
    }
}
