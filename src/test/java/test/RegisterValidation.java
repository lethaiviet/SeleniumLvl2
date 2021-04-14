package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/register_validation.feature",
        glue = {"definitions"}
)
public class RegisterValidation extends CommonValidation {

}