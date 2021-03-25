package TestDemo;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;
import static org.openqa.selenium.remote.BrowserType.CHROME;

public class TestEx01 implements En {
    private final WebDriver driver = DriverFactory.valueOf(CHROME.toUpperCase()).getDriverManager().getDriver();

    public TestEx01() {
        Given("Navigate to Page ForgotPassword", () -> {
            driver.navigate().to("https://the-internet.herokuapp.com/forgot_password");
        });

        When("A User enters a valid email id", () -> {
            driver.findElement(By.name("email")).sendKeys("valid@example.com");
        });

        When("A User clicks on Retrieve password button", () -> {
            driver.findElement(By.id("form_submit")).click();
        });

        When("A User enters a invalid email id", () -> {
            driver.findElement(By.name("email")).sendKeys("invalid@");
        });

        Then("Application shows that the email has been sent", () -> {
            String actualMessage = driver.findElement(By.id("content")).getText();
            assertThat(actualMessage.trim()).isEqualTo("Your e-mail's been sent!");
        });

        Then("Application does not show that email has been sent", () -> {
            String actualMessage = driver.findElement(By.id("content")).getText();
            assertThat(actualMessage.trim()).isNotEqualTo("Your e-mail's been sent!");
        });
    }
}
