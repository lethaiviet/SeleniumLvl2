package com.railway.drivers;

import com.railway.utils.LogUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriver extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        LogUtils.info("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();
        return new org.openqa.selenium.chrome.ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");
        return options;
    }
}