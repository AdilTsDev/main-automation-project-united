@Regression
Feature: Flight features
  testing the functions at flight panel under the flight tab

  Background: at home page
    When home page is loaded

  Scenario: Choosing round trip option should have departing and return date fields
    And the roundTrip is selected
    Then verify that departing and return date fields are enabled

  Scenario: Choosing one way flight option should only have one
    And click one-way trip
    Then verify that only departing date is enabled

  Scenario: User should be able to increment traveler count up to 9
    And click the travelers button
    Then verify that value of travelers can be  "9"

  @demo
  Scenario: User can select one traveler from every single passenger type
    And click the travelers button
    And select "1" for every single passenger type
    Then verify that value of travelers is matched

  Scenario: Destination fields should switch when click on switch icon in the middle
    And set up the locations from "" and to "Chicago";
    Then click the switch button and verify the locations are switch

  Scenario: Leaving from and going to fields should have correct placeholders
    Then verify that locations fields have correct placeholders

  Scenario: User should be able to remove leaving from location value
    And set up the locations from "" and to "Chicago";
    Then click the remove button to verify for "From"

  Scenario: User should be able to remove going from location value
    And set up the locations from "" and to "Chicago";
    Then click the remove button to verify for "To"

  Scenario: User can select different flight classes
    Then click through the flight class to verify

  Scenario: Minimum one traveler should be selected
    And click the travelers button
    And click the clear all button
    Then verify that travelers input is still one

  @demo
  Scenario: User can only travel with one pet
    And click the advanced search button
    And click the select number of pet
    Then verify user can only travel with "1" pet

  Scenario: Advance search should open a separate page with more advanced search fields
    And click the advanced search button
    Then verify that advanced search page is opened with more search field

  Scenario: Checking flexible dates option should change the Dates field to month dropdown only
    And click the flex dates check box
    Then verify that date field is moth drop down