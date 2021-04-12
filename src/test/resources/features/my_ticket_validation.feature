Feature: My ticket validation

  Scenario Outline: Verify that total tickets in the table must match with the message in the Note
    Given I navigate to the LOGIN_PAGE
    When I login with USER_01 account
    And I navigate to the MY_TICKET_PAGE
    And I remove all tickets if there are greater than 5 tickets
    And I scrape the total tickets in note on MY_TICKET_PAGE before booking new tickets
    And I navigate to the BOOK_TICKET_PAGE
    And I select option from the dropdowns
      | Name          | Option  |
      | DEPART_DATE   | random  |
      | ARRIVE_AT     | random  |
      | DEPART_FROM   | random  |
      | SEAT_TYPE     | random  |
      | TICKET_AMOUNT | default |
    And I click on the BOOK_TICKET_PAGE button
    And I scrape all information of tickets in table on BOOK_TICKET_PAGE
    And I navigate to the MY_TICKET_PAGE
    And I scrape the total tickets in note on MY_TICKET_PAGE after booking new tickets
    And I scrape all information of tickets in table on MY_TICKET_PAGE
    Then The total tickets match the note on MY_TICKET_PAGE
    And The ticket information on BOOK_TICKET and MY_TICKET_PAGE page should be consistent
    Examples:
      | count |
      | 1     |
#      | 2     |
#      | 3     |
