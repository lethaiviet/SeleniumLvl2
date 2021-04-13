package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.DriverUtils;

public class CommonValidation extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUpBrowser(String browser) {
        DriverUtils.setDriverType(browser);
    }

    @AfterMethod
    public void closeBrowser() {
        DriverUtils.quitDriver();
    }
}