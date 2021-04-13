package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login_validation.feature",
        glue = {"definitions"}
)
public class LoginValidation extends CommonValidation {

}