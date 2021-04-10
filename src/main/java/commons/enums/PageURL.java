package commons.enums;

import commons.Constants;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PageURL {
    HOME_PAGE("HomePage.cshtml"),
    REGISTER_PAGE("Register.cshtml"),
    LOGIN_PAGE("Login.cshtml"),
    BOOK_TICKET_PAGE("BookTicketPage.cshtml"),
    MANAGE_TICKET_PAGE("ManageTicket.cshtml");

    private final String pageName;
    private final String URL;

    PageURL(String pageName) {
        this.pageName = pageName;
        URL = Constants.RAILWAY_URL + '/' + pageName;
    }

}
