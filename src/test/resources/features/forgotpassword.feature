@forgotpassword
Feature: Forgot password

  Scenario: A valid email id is allowed
    Given Navigate to Page ForgotPassword
    When A User enters a valid email id
    And A User clicks on Retrieve password button
    Then Application shows that the email has been sent.

  Scenario: An invalid email is not allowed
    Given Navigate to Page ForgotPassword
    When A User enters a invalid email id
    And A User clicks on Retrieve password button
    Then Application does not show that email has been sent.
    # TODO - the below step is not be implemented because feature is still not available
    # And Application shows an error message "Invalid Email"