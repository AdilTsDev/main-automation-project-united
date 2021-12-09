@Regression
Feature: Flight Tabs functions
  testing the functions under the flight tab
  Background:
    When home page is loaded
    And click flight status tab


  Scenario: User searches flight status between from and to destinations
    And set the from location from "" and to "New York"
    And click the status search button
    Then verify that status search results are displayed

  Scenario: Flight number field should not accept other than numbers
    And type "rand" in flight number filed
    And click the status search button
    Then verify that flight number error message "Please enter a valid flight number." is displayed

  Scenario: Invalid number error message should be displayed when a wrong flight number is entered
    And type "6666" in flight number filed
    And click the status search button
    Then verify that Invalid number message "The number you entered is not a valid flight number." id displayed