@forgotpassword
Feature: Forgot password

  Scenario: Verify that user can open the Register page
    Given I navigate to the HOME_PAGE
    When I click on the Register tab
    Then I should be on the REGISTER_PAGE