package com.ahmed;

import java.util.concurrent.TimeUnit;

import com.ahmed.helpers.Screenshot;
import com.ahmed.pages.LoginPage;
import com.ahmed.pages.PersonalInfoPage;
import com.ahmed.pages.TopMenu;
import com.google.common.util.concurrent.Uninterruptibles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.ahmed.helpers.Faker;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTest extends TestCase {
    @Test
    void test_01() {
        Faker faker = new Faker();
        String email = faker.getEmail();

        TopMenu topMenu = new TopMenu();
        LoginPage loginPage = topMenu.click_login();
        PersonalInfoPage infoPage = loginPage.signup(email);

        infoPage.enterName("Mr.", "first name", "last name");
        infoPage.setCredentials(email, "somepassword");
        infoPage.fill_address_name("first name", "last name", "some address");
        infoPage.fill_address_location("some city", "Alaska", "United States", "12345");
        infoPage.fill_contact("123456789", "some reference");
        infoPage.submit();

        infoPage.wait_for_dashboard();
        Screenshot.takeScreenshot("dashboard");
    }
}