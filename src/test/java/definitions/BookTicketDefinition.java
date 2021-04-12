package definitions;

import commons.Constants;
import data.TicketInfo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;
import pages.BookTicketPage;
import utils.CacheHelper;
import utils.UserInfoUtils;

import java.util.List;
import java.util.Map;

public class BookTicketDefinition implements En {
    BookTicketPage bookTicketPage = new BookTicketPage();

    public BookTicketDefinition() {
        When("I select option from the dropdowns", (DataTable itemsData) -> {
            List<Map<String, String>> dataLst = itemsData.asMaps(String.class, String.class);
            dataLst.stream().forEach(x -> bookTicketPage.selectOptionFromDropdown(x.get("Name"), x.get("Option")));
        });

        When("I scrape all information of selected dropdown on {}", (String pageKey) -> {
            Map<String, String> data = bookTicketPage.getAllOptionsOfSelectedDropdown();
            CacheHelper.setValue(Constants.CACHE_ALL_OPTIONS_OF_SELECTED_DROPDOWN, new TicketInfo(data));
        });

        Then("The PID on BOOK_TICKET matches with the PID of {word}", (String userKey) -> {
            String pipActual = bookTicketPage.getTextPid();
            String pipExpected = UserInfoUtils.getUserInfo(userKey).getPid();
            String message = String.format("The PID on BOOK_TICKET matches with the PID of %s", userKey);
            Assert.assertEquals(pipActual, pipExpected, message);
        });

        Then("The ticket information matches with the booking data", () -> {
            TicketInfo bookingData =
                    CacheHelper.getValue(Constants.CACHE_ALL_OPTIONS_OF_SELECTED_DROPDOWN, TicketInfo.class);

            List<TicketInfo> ticketInfoLst =
                    CacheHelper.getValue(Constants.CACHE_ALL_TICKET_INFO_ON_BOOK_TICKET, List.class);

            TicketInfo ticketInfo = ticketInfoLst.get(0);
            String message = "The ticket information should match with the booking data";
            Assert.assertEquals(bookingData, ticketInfo, message);
        });
    }
}
