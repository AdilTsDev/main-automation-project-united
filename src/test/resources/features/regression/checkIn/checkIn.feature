@Regression
Feature: checkIn feature
  testing the functions under the check in panel

  Background:
    When home page is loaded
    And click check in tab

  Scenario: Empty flight check-in form should show error messages when searched without filling up
    And click the check in search button
    Then verify confirm number error message "Please enter a valid confirmation or eTicket number." is displayed
    Then verify last name error message "Please enter a valid last name." is displayed

  Scenario: There should be a check-in details link and navigates to correct page
    And click the check in detail link
    Then verify that check in processing detail page is opened and loaded

  Scenario: There should be a check-in with MilesPlus link and navigates to correct page
    And click the check in with mileage plus link
    Then verify that check in options page is opened and loaded