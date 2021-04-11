package pages;

import commons.enums.PageURL;
import utils.DriverUtils;

public class BookTicketPage extends BasePage {
    public static final PageURL page = PageURL.BOOK_TICKET_PAGE;

    @Override
    public void load() {
        navigateTo(page);
    }

    @Override
    public void isLoaded() throws Error {
        DriverUtils.waitForAjaxJQueryProcess();
        if (!isMatchURL(page)) {
            throw new Error("BOOK_TICKET_PAGE was not successfully loaded");
        }
    }
}
