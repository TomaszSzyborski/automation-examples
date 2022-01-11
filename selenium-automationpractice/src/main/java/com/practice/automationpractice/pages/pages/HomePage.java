package com.practice.automationpractice.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "#search_query_top")
    private WebElement searchField;

    @FindBy(css = "#searchbox button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage(){
        topBarModule.goToSignInPage();
    }

    @Override
    public void isAt() {
    }

    public void searchFor(String clothing) {
        searchField.sendKeys(clothing);
        searchButton.click();
    }
}
