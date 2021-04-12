package definitions;

import commons.Constants;
import data.TicketInfo;
import io.cucumber.java8.En;
import org.testng.Assert;
import pages.MyTicketPage;
import utils.CacheHelper;

import java.util.List;

public class MyTicketDefinition implements En {
    MyTicketPage myTicketPage = new MyTicketPage();

    public MyTicketDefinition() {
        When("I remove all tickets if there are greater than {int} tickets", (Integer count) -> {
            if (myTicketPage.getAmountOfTicketOnNote() > 5)
                myTicketPage.removeAllTickets();
        });

        When("The ticket information on {word} and {word} page should be consistent", (String pageKey1, String pageKey2) -> {
            List<TicketInfo> ticketInfoBookTicketList =
                    CacheHelper.getValue(Constants.CACHE_ALL_TICKET_INFO_ON_BOOK_TICKET, List.class);
            List<TicketInfo> ticketInfoMyTicketList =
                    CacheHelper.getValue(Constants.CACHE_ALL_TICKET_INFO_ON_MY_TICKET, List.class);

            TicketInfo ticketInfoBookTicket = ticketInfoBookTicketList.get(0);
            int lastIndex = ticketInfoMyTicketList.size() - 1;
            TicketInfo ticketInfoMyTicket = ticketInfoMyTicketList.get(lastIndex);
            String message = String.format("The ticket information on %s and %s page should be consistent", pageKey1, pageKey2);
            Assert.assertEquals(ticketInfoBookTicket, ticketInfoMyTicket, message);
        });

        When("I scrape the total tickets in note on {word} {word} booking new tickets", (String pageKey, String type) -> {
            String key = type.equals("before") ?
                    Constants.CACHE_TOTAL_TICKET_IN_NOTE_BEFORE_BOOKING_ON_MY_TICKET :
                    Constants.CACHE_TOTAL_TICKET_IN_NOTE_AFTER_BOOKING_ON_MY_TICKET;
            CacheHelper.setValue(key, myTicketPage.getAmountOfTicketOnNote());
        });

        When("The total tickets match the note on {word}", (String pageKey) -> {
            int numTicketBefore = CacheHelper.getValue(
                    Constants.CACHE_TOTAL_TICKET_IN_NOTE_BEFORE_BOOKING_ON_MY_TICKET,
                    Integer.class);
            int numTicketAfter = CacheHelper.getValue(
                    Constants.CACHE_TOTAL_TICKET_IN_NOTE_AFTER_BOOKING_ON_MY_TICKET,
                    Integer.class);
            List<TicketInfo> ticketInfoLst = CacheHelper.getValue(
                    Constants.CACHE_ALL_TICKET_INFO_ON_BOOK_TICKET,
                    List.class);

            int numTicketBooking = ticketInfoLst.get(0).getAmount();
            String message = "The total tickets should match the note on " + pageKey;
            Assert.assertEquals(numTicketBefore + numTicketBooking, numTicketAfter, message);
        });

    }
}
