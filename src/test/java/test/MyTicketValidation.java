package test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/my_ticket_validation.feature",
        glue = {"definitions"}
)
public class MyTicketValidation extends CommonValidation {

}