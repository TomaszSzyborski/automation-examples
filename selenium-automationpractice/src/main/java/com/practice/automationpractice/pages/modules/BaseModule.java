package com.practice.automationpractice.pages.modules;

import com.practice.automationpractice.pages.BaseAbstraction;
import org.openqa.selenium.WebDriver;

public abstract class BaseModule extends BaseAbstraction {
    public BaseModule(WebDriver driver) {
        super(driver);
    }
}
