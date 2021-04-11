package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.List;
import java.util.Map;

public class RegisterDefinition implements En {
    RegisterPage registerPage = new RegisterPage();

    public RegisterDefinition() {
        When("I input valid data for the register form", (DataTable itemsData) -> {
            List<Map<String, String>> dataLst = itemsData.asMaps(String.class, String.class);
            registerPage.fillRegisterForm(dataLst.get(0));
        });

        When("I click on the {word} button", (String name) -> {
            registerPage.clickRegisterButton();
        });

        Then("I should cannot register new account with an error message", (DataTable itemsData) -> {
            List<Map<String, String>> dataLst = itemsData.asMaps(String.class, String.class);
            String errorMsgActual = registerPage.getErrorMsg();
            String errorMsgExpected = dataLst.get(0).get("Message");
            String message = "The error message should display correctly";
            Assert.assertEquals(errorMsgActual, errorMsgExpected, message);
        });
    }
}
