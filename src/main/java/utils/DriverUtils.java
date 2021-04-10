package utils;

import drivers.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverUtils {
    private static Logger logger = Logger.getLogger(DriverUtils.class);

    public static WebDriver getDriver() {
        return DriverFactory.valueOf(CHROME.toUpperCase()).getDriverManager().getDriver();
    }

    public static String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    public static void navigate(String url) {
        getDriver().get(url);
    }

    public static WebDriver getWebDriver() {
        return getDriver();
    }

    public static Actions actions() {
        return new Actions(getWebDriver());
    }

    public static void waitForAjaxJQueryProcess() {
        logger.debug("Wait for ajax complete");
        long timeOutInSeconds = 10;
        WebDriverWait wait = new WebDriverWait(getWebDriver(), timeOutInSeconds);

        try {
            wait.until(driver -> {
                Boolean ajaxIsComplete = (Boolean) ((Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return Ext.Ajax.isLoading() == false;", new Object[0]));
                return ajaxIsComplete;
            });
        } catch (Exception var1) {
            logger.error("An error occurred when waitForAjaxJQueryProcess" + var1.getMessage());
        }
    }

    public static void delay(double timeInSecond) {
        try {
            Thread.sleep((long)(timeInSecond * 1000.0D));
        } catch (Exception var2) {
            logger.error("An error occurred when delay: " + var2.getMessage());
        }

    }
}
