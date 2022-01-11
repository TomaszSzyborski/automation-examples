package com.practice.automationpractice;

import com.practice.automationpractice.pages.pages.MyAccountPage;
import com.practice.automationpractice.pages.pages.accountCreation.AccountCreationPage;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    private MyAccountPage myAccountPage;

    /*
    * Usually setup creating new user is done by API calls
    * to minimize usage of time consuming  UI steps
    * */
    @BeforeMethod
    public void loginSetUp() {
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage.goToLoginPage();
        loginPage.createAnAccountWithEmail(client.getEmail());
        accountCreationPage.fillPersonalInformation(client);
        accountCreationPage.fillAddressInformation(client);
        accountCreationPage.submitRegistrationForm();
        myAccountPage.isAt();
        myAccountPage.logOut();
    }

    @Test
    public void validLoginTest() {
        homePage.goToLoginPage();
        loginPage.loginWithCredentials(client.getEmail(), client.getPassword());
        myAccountPage.isAt();
        homePage.checkIfUserIsLoggedIn(client);
    }

}
