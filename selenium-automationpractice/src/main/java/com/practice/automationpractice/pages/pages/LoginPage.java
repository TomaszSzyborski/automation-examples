package com.practice.automationpractice.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {


    @FindBy(css = "#email_create")
    private WebElement createAccountEmailInputfield;

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(css = "#email")
    private WebElement loginEmailInputField;

    @FindBy(css = "#passwd")
    private WebElement passwordInputField;

    @FindBy(css = "#SubmitLogin")
    private WebElement submitLoginButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertDangerBox;
    private WebElement element;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void createAnAccountWithEmail(String email){
        createAccountEmailInputfield.sendKeys(email);
        createAccountButton.click();
    }

    @Override
    public void isAt() {
        Map<String, WebElement> pageElements = Map.of(
                "Create Account - email field", createAccountEmailInputfield,
                "Create Account - submit button", createAccountButton,
                "Login - email field", loginEmailInputField,
                "Login - password field", passwordInputField,
                "Login - submit button", submitLoginButton
        );

        pageElements.forEach( (description, element) ->
                assertThat(element.isDisplayed())
                        .as(description)
                .isTrue()
        );
    }

    public void loginWithCredentials(String login, String password) {
        loginEmailInputField.sendKeys(login);
        passwordInputField.sendKeys(password);
        submitLoginButton.click();
    }

    public void checkAlertBoxForMessage(String message) {
        assertThat(alertDangerBox.isDisplayed()).isTrue();
        assertThat(alertDangerBox.getText()).contains(message);
    }
}
