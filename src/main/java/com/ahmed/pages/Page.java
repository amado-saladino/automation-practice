package com.ahmed.pages;

import com.ahmed.helpers.Browser;
import com.ahmed.helpers.PropertyReader;
import com.ahmed.helpers.WaitUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page {
    private JavascriptExecutor jsRunner;
    protected static WebDriver driver = Browser.createDriver();
    private static int TIME_OUT = PropertyReader.getIntegerProperty("default-wait", 20);

    public Page() {
        PageFactory.initElements(driver, this);
        jsRunner = (JavascriptExecutor) driver;
    }

    protected void clickElement(WebElement element) {
        WaitUtils.waitVisibilityOf(element, TIME_OUT);
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        WaitUtils.waitVisibilityOf(element, TIME_OUT);
        element.clear();
        element.sendKeys(text);
    }

    void runScript(String script, Object... args) {
        jsRunner.executeScript(script, args);
    }

    void scrollPage() {
        runScript("scrollTo(0,document.body.scrollHeight)");
    }

    void scrollToElement(WebElement element)  {
        runScript("arguments[0].scrollIntoView()", element);
    }

    void selectDropdownItemByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }
}
