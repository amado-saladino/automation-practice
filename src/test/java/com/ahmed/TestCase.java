package com.ahmed;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import com.ahmed.helpers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCase {
    protected static WebDriver driver;

    @BeforeAll
    void setupTest() {
        driver = Browser.createDriver();
        driver.navigate().to(PropertyReader.getProperty("BASE_URL"));
    }

    @AfterAll
    void teardown() {
        Browser.stopDriver();
    }
}
