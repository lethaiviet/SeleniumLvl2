package definitions;

import io.cucumber.java8.En;
import org.junit.Assert;
import pages.BasePage;

public class CommonDefinition implements En {
    BasePage basePage = new BasePage();

    public CommonDefinition() {
        Given("I navigate to the {word}", (String pageName) -> {
            basePage.navigateTo(pageName);
        });

        When("I select the {word} tab on the top navigation", (String tabName) -> {
            basePage.selectNavBarItem(tabName);
        });

        Then("I should be on the {word}", (String pageName) -> {
            boolean isCorrect = basePage.isMatchURL(pageName);
            String errorMsg = String.format("User can open the %s successfully", pageName);
            Assert.assertTrue(errorMsg, isCorrect);
        });
    }
}
