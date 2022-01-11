package com.practice.automationpractice.pages.pages;

import com.practice.automationpractice.pages.BaseAbstraction;
import com.practice.automationpractice.pages.modules.BottomBarModule;
import com.practice.automationpractice.pages.modules.TopBarModule;
import com.practice.automationpractice.utils.Client;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BasePage extends BaseAbstraction {

    protected static final String baseURL = "http://automationpractice.com/";

    protected TopBarModule topBarModule;
    protected BottomBarModule bottomBarModule;

    public BasePage(WebDriver driver) {
        super(driver);
        topBarModule = new TopBarModule(driver);
        bottomBarModule = new BottomBarModule(driver);
    }

    public void openHomePage(){
        driver.get(baseURL);
    }

    public void checkIfUserIsLoggedIn(Client client){
        assertThat(topBarModule.getMyAccountButtonText())
                .as("My account has user name")
                .isEqualTo(client.getFirstName() + " " + client.getLastName());
    }

    public void checkIfUserIsNotLoggedIn(){
        topBarModule.checkMyAccountButtonAvailability();
    }

    public void logOut(){
        topBarModule.logOut();
    }

    public abstract void isAt();
}
