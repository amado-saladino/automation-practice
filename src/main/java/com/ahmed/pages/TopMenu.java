package com.ahmed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends Page {
    @FindBy(partialLinkText = "Sign in")
    private WebElement login;

    public LoginPage click_login() {
        clickElement(login);
        return new LoginPage();
    }
}
