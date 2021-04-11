@forgotpassword
Feature: Forgot password

  Scenario: Verify that user can open the Register page
    Given I navigate to the HOME_PAGE
    When I select the Register tab on the top navigation
    Then I should be on the REGISTER_PAGE