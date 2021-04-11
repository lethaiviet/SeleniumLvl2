Feature: Register validation

  Scenario: Verify that user can open the Register page
    Given I navigate to the HOME_PAGE
    When I select the REGISTER tab on the top navigation
    Then I should be on the REGISTER_PAGE

#  Scenario: Verify that user cannot create new account using Email that has been registered
#    Given I navigate to the HOME_PAGE
#    When I select the REGISTER tab on the top navigation
#    Then I should be on the REGISTER_PAGE