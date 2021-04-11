package commons.enums;

import commons.Constants;
import lombok.Getter;

@Getter
public enum PageURL {
    HOME_PAGE("Page/HomePage.cshtml"),
    REGISTER_PAGE("Account/Register.cshtml"),
    LOGIN_PAGE("Account/Login.cshtml"),
    BOOK_TICKET_PAGE("Page/BookTicketPage.cshtml");
//    MANAGE_TICKET_PAGE("ManageTicket.cshtml");

    private final String route;
    private String URL;

    PageURL(String route) {
        this.route = route;
        URL = Constants.RAILWAY_URL + '/' + route;
    }
}
