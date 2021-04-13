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
        features = "src/test/resources/features/book_ticket_validation.feature",
        glue = {"definitions"}
)
public class BookTicketValidation extends CommonValidation {

}