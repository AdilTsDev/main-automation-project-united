@Regression
Feature: car panel features
  testing the functions at car panel under booker tab
  Background:
    When home page is loaded
    And click the car panel


    Scenario: Cars form should have correct fields
      Then verify that car form fields are displayed

    Scenario: Drop off location should disappear if return car to same location checkbox is checked
      And click same location checkbox
      And verify that drop off input is enabled
      And click same location checkbox
      Then verify that drop off input is disappear

    Scenario: Age field should disappear if primary driver is 25 or older checkbox is checked
      And click age checkbox
      And verify that age input is enabled
      And click age checkbox
      Then verify that age input is disappear

    Scenario: Finding a car after filling up the form should navigate to a separate tab
      And set the pick up location for "New York"
      And set the rental date for "Feb 15" and return at "Feb 20"
      And click the find car button to search
      Then verify that separate tab is open

    Scenario: Finding a car with book with miles checked should return result with miles only
      And set the pick up location for "New York"
      And set the rental date for "Feb 15" and return at "Feb 20"
      And click the book with miles checkbox
      And click the find car button to search
      Then verify that result is only with miles

    Scenario: Searching for a rental car with an age under 21 should display error message
      And set the pick up location for "New York"
      And set the rental date for "Feb 15" and return at "Feb 20"
      And click age checkbox
      And set age to "20"
      And click the find car button to search
      Then verify that under age error message is displayed

    Scenario: Searching for a rental car with an age 21 should not return any search result
      And set the pick up location for "New York"
      And set the rental date for "Feb 15" and return at "Feb 20"
      And click age checkbox
      And set age to "21"
      And click the find car button to search
      Then verify that no result message is displayed

    Scenario: Searching for a rental car with an age above 21 should return search result
      And set the pick up location for "New York"
      And set the rental date for "Feb 15" and return at "Feb 20"
      And click age checkbox
      And set age to "22"
      And click the find car button to search
      Then verify that results are displayed