package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriver extends DriverManager {

    @Override
    protected WebDriver createDriver() {
        System.out.println("`Initializing` firefox Driver"); // Change to Loggers
        WebDriverManager.getInstance(FIREFOX).setup();

        return new org.openqa.selenium.firefox.FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        // A few valid Options for firefox, showcase purpose.
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

}