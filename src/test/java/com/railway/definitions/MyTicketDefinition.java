package com.railway.definitions;

import com.railway.commons.Constants;
import com.railway.data.TicketInfo;
import io.cucumber.java8.En;
import org.testng.Assert;
import com.railway.pages.MyTicketPage;
import com.railway.utils.CacheHelper;

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
            boolean isConsistent = ticketInfoMyTicketList.contains(ticketInfoBookTicket);

            String message = String.format("The ticket information on BOOK_TICKET_PAGE and MY_TICKET_PAGE should be consistent \n" +
                            "More detail:\n\t+ Ticket Info in BOOK_TICKET_PAGE: %s\n\t+ Ticket Info in MY_TICKET_PAGE: %s",
                    ticketInfoBookTicketList.toString(), ticketInfoMyTicketList.toString());
            Assert.assertTrue(isConsistent, message);
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
            Assert.assertEquals(numTicketAfter,numTicketBefore + numTicketBooking, message);
        });

    }
}
