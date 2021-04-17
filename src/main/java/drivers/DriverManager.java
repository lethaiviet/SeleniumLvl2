package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import utils.LogUtils;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (null != drivers.get()) {
            try {
                drivers.get().quit(); // First quit WebDriver session gracefully
                drivers.remove(); // Remove WebDriver reference from the ThreadLocal variable.
            } catch (Exception e) {
                LogUtils.error("Unable to gracefully quit WebDriver." + e);
            }
        }
    }

    public WebDriver getDriver() {
        if (null == drivers.get()) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        return drivers.get();
    }
}