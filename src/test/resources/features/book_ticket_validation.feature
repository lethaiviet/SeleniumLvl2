Feature: Book ticket validation

  Scenario: Verify that the "Ticket booked successfully!" page displays correct information
    Given I navigate to the LOGIN_PAGE
    When I login with USER_01 account
    And I navigate to the BOOK_TICKET_PAGE
    Then I should be on the BOOK_TICKET_PAGE

    When I select option from the dropdowns
      | Name          | Option  |
      | DEPART_DATE   | random  |
      | DEPART_FROM   | random  |
      | ARRIVE_AT     | random  |
      | SEAT_TYPE     | random  |
      | TICKET_AMOUNT | default |
    And I scrape all information of selected dropdown on BOOK_TICKET
    And I click on the BOOK_TICKET button
    And I scrape all information of tickets in table on BOOK_TICKET
    Then The PID on BOOK_TICKET matches with the PID of USER_01
    And The ticket information matches with the booking data