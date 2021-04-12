package definitions;

import commons.Constants;
import io.cucumber.java8.En;
import org.junit.Assert;
import pages.BasePage;
import utils.CacheHelper;

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

        When("I click on the {word} button", (String name) -> {
            basePage.clickSubmitButton();
        });

        When("I scrape all information of tickets in table on {word}", (String pageName) -> {
            String key = pageName.equals("MY_TICKET_PAGE") ?
                    Constants.CACHE_ALL_TICKET_INFO_ON_MY_TICKET :
                    Constants.CACHE_ALL_TICKET_INFO_ON_BOOK_TICKET;
            CacheHelper.setValue(key, basePage.getTicketInfoInTableOnCurrentPage());
        });
    }
}
