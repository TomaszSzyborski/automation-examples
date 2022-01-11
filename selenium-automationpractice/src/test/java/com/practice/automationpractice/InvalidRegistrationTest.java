package com.practice.automationpractice;

import com.practice.automationpractice.pages.pages.accountCreation.AccountCreationPage;
import com.practice.automationpractice.utils.Client;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidRegistrationTest extends BaseTest {

    private AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void registrationSetup() {
        accountCreationPage = new AccountCreationPage(driver);
    }


    @Test(dataProvider = "invalidRegistration")
    public void invalidRegistration(String testName, Client client, String expectedErrorMessage) {
        Faker faker = new Faker();
        homePage.goToLoginPage();
        loginPage.createAnAccountWithEmail(faker.internet().emailAddress());

        accountCreationPage.fillPersonalInformation(client);
        accountCreationPage.fillAddressInformation(client);
        accountCreationPage.submitRegistrationForm();

        accountCreationPage.checkIfUserIsNotLoggedIn();
        accountCreationPage.checkforErrorText(expectedErrorMessage);
    }

    @DataProvider(name = "invalidRegistration")
    private Object[][] dataProvider() {
        Faker faker = new Faker();
        return new Object[][]
                {
                        {"Invalid email",
                                new Client().setEmail(faker.lorem().characters(10)),
                                "email is invalid"
                        },
                        {"No password",
                                new Client().setPassword(""),
                                "passwd is required"
                        },
                        {"Too short password",
                                new Client().setPassword(faker.lorem().characters(4)),
                                "passwd is invalid"
                        },
                        {"Too long postal code",
                                new Client().setZipcode(faker.number().digits(6)),
                                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"
                        },
                        {"Too short postal code",
                                new Client().setZipcode(faker.number().digits(4)),
                                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"
                        },
                        {"Non-numeric postal code",
                                new Client().setZipcode(faker.lorem().characters(5)),
                                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"
                        },
                        {"No phone number",
                                new Client().setMobile("").setPhone(""),
                            "You must register at least one phone number"
                        },
                        {"No main address",
                                new Client().setAddress1(""),
                                "address1 is required"
                        },
                        {"No city",
                                new Client().setCity(""),
                                "city is required"
                        }

                };
    }

}
