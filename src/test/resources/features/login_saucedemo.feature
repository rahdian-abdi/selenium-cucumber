@login
Feature: Validate the login functionality
  Scenario: Login with valid credentials
    When User input username "standard_user" and password "secret_sauce"
    And Click on the login button
    Then User will be directed to inventory page

  Scenario: Login with invalid credentials
    When User input username "locked_out_user" and password "secret_sauce"
    And Click on the login button
    Then User will get warning message
