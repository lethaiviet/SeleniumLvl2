Feature: Register validation

  Scenario: Verify that user cannot create new account using Email that has been registered
    Given I navigate to the HOME_PAGE
    When I select the REGISTER tab on the top navigation
    Then I should be on the REGISTER_PAGE

    When I input valid data for the register form
      | Email          | Password  | PID          |
      | test1@test.com | 123456789 | 123456789PID |
    And I click on the REGISTER button
    Then I should cannot register new account with an error message
      | Message                               |
      | This email address is already in use. |

