package definitions;

import io.cucumber.java8.En;
import pages.BookTicketPage;

public class BookTicketDefinition implements En {
    BookTicketPage bookTicketPage = new BookTicketPage();

    public BookTicketDefinition() {
//        When("I click on the hyperlink text {string}", (String itemName) -> {
//            loginPage.clickHyperLinkText(itemName);
//        });
    }
}
