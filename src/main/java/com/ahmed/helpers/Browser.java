package com.ahmed.helpers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
    private static WebDriver driver = null;
    private final static  long WAIT_TIMEOUT = Long.parseLong(PropertyReader.getProperty("default-wait"));
    private final static String BROWSER = PropertyReader.getProperty("BROWSER");
    private final static Map<String, Supplier<WebDriver>> map = new HashMap<>();

    static {
        map.put(BrowserType.CHROME, ()-> {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions());
        });
        map.put(BrowserType.FIREFOX,()-> {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(firefoxOptions());
        });
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            driver = map.get(BROWSER).get();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT));
            driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void stopDriver() {
        driver.quit();
        driver = null;
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension",false);
        options.setHeadless(true);
        options.addArguments("window-size=2000,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return options;
    }

    private static FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);       
        return options;
    }
}
