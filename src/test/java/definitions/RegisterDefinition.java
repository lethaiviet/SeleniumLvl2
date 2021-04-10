package definitions;

import commons.enums.PageURL;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.HomePage;
import utils.DriverUtils;

public class RegisterDefinition implements En {
    HomePage homePage = new HomePage();

    public RegisterDefinition() {
        Given("I navigate to the {word}", (String pageName) -> {
            homePage.load();
        });

        When("I click on the {word} tab", (String tabName) -> {
            homePage.selectMenuTab(tabName);
        });

        Then("I should be on the {word}", (String pageName) -> {
            boolean isCorrect = DriverUtils.getCurrentURL().contains(PageURL.valueOf(pageName).getURL());
            String errorMsg = String.format("User can open the %s successfully", pageName);
            Assert.assertTrue(errorMsg, isCorrect);
        });
    }
}
