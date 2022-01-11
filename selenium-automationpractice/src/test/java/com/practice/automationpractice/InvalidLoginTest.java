package com.practice.automationpractice;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test(dataProvider = "invalidLogin", testName = "Invalid login, with credentials: ")
    public void inValidLoginTest(String caseName, String login, String password, String message) {
        homePage.goToLoginPage();
        loginPage.loginWithCredentials(login, password);
        loginPage.checkAlertBoxForMessage(message);
        homePage.checkIfUserIsNotLoggedIn();
    }


    @DataProvider(name = "invalidLogin")
    private Object[][] dataProvider() {
        Faker faker = new Faker();
        return new Object[][]
                {
                        {"Empty login and password",
                                "",
                                "",
                                "An email address required."},
                        {"Invalid email address",
                                faker.lorem().characters(10),
                                "",
                                "Invalid email address"},
                        {"Random email, empty password",
                                faker.lorem().characters(5) + faker.internet().emailAddress(),
                                "",
                                "Password is required."},
                        {"Empty email, random password",
                                "",
                                faker.lorem().characters(5),
                                "An email address required."},
                        {"Random email, random password",
                                faker.lorem().characters(5) + faker.internet().emailAddress(),
                                faker.lorem().characters(5),
                                "Authentication failed."
                        }
                };
    }
}
