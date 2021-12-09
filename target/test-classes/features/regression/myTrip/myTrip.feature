@Regression
Feature: myTrip feature
  testing the functions under the my trip panel

  Background:
    When home page is loaded
    And click the my trip tab

    Scenario: There should be a link to find United Travel Credits page
      Then verify that find travel credits link is enabled

    Scenario: Empty My Trips form should show error messages when searched without filling up
      And click the my trip search button
      Then verify that confirmation input error "Please enter a valid confirmation number." is displayed
      Then verify that last name input error "Please enter a valid last name." is displayed

    Scenario: There should be a link to find my trips sign in page
      Then verify that my trip sign in link is enabled