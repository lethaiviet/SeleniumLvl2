package definitions;

import io.cucumber.java8.En;
import pages.LoginPage;

public class LoginDefinition implements En {
    LoginPage loginPage = new LoginPage();

    public LoginDefinition() {
        When("I click on the hyperlink text {string}", (String itemName) -> {
            loginPage.clickHyperLinkText(itemName);
        });
    }
}
