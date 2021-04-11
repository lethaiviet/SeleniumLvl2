Feature: Book ticket validation

  Scenario: Verify that the "Ticket booked successfully!" page displays correct information
    Given I navigate to the LOGIN_PAGE
    When I login with USER_01 account
    And I navigate to the BOOK_TICKET_PAGE
    Then I should be on the BOOK_TICKET_PAGE