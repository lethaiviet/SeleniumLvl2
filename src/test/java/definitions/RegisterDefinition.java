package definitions;

import commons.enums.PageURL;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.HomePage;
import pages.RegisterPage;
import utils.DriverUtils;

public class RegisterDefinition implements En {
    RegisterPage registerPage = new RegisterPage();

    public RegisterDefinition() {

    }
}
