package com.ahmed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(id = "email_create")
    private WebElement email_signup;

    @FindBy(id = "SubmitCreate")
    private WebElement create_account;

    public PersonalInfoPage signup(String email) {
        enterText(email_signup, email);
        clickElement(create_account);
        return new PersonalInfoPage();
    }
}
