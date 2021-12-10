
Feature: packages panel features
  testing the functions at packages panel under booker tab

Background:
  When home page is loaded
  And click the package panel

  Scenario: User should see vacation search result with all fields filled properly
    And click the package panel
    And set from location "San Jose" and to location "New York"
    And set the depar date for "Feb 15" and return date for "Feb 20"
    And click the find trip search button
    Then verify that result for package search is displayed

  Scenario: Vacation form should have only up to 4 rooms
    And click the room selector
    And click the last option from the drop down
    Then verify that room number value is "4"

  Scenario: Rooms container should say “rooms” if room count is more than one
    And click the room selector
    And  click the last option from the drop down
    Then verify that selected room info says "rooms"

  Scenario: Rooms option dropdown should disappear when Flight and car option is selected
    And click the Flight and car checkbox
    And verify that room select dropdown is disappear

  Scenario: Clicking cruise link should navigate to United Cruises page
    And click the cruise link
    Then verify that united cruises page is loaded

