Feature: Login validation

  Scenario: Verify that clicking on the hyperlink text "registration page" will redirect to the Register page
    Given I navigate to the HOME_PAGE
    When I select the LOGIN tab on the top navigation
    Then I should be on the LOGIN_PAGE

    When I click on the hyperlink text "registration page"
    Then I should be on the REGISTER_PAGE