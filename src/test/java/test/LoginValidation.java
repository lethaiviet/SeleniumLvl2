package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import utils.DriverUtils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login_validation.feature",
        glue = {"definitions"}
)
public class LoginValidation extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverUtils.quitDriver();
    }
}