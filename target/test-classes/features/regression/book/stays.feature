@Regression
Feature: hotel stays features
  testing the functions at hotel panel under the book tab

  Background:
    When home page is loaded
    And click the hotel panel

    Scenario: Panel should have following fields: Going to, check-in, check-out Add a car and Add a flight checkbox
      Then verify that all the fields are displayed

    Scenario: One room and one travelers should be selected by default
      Then verify that room numbers and travelers are as default

    Scenario: User can select maximum 16 travelers
      And click the travelers input button
      And adding to both adult and children until not clickable
      Then verify that maximum travelers allowed is "16"

    Scenario: User should be able to add maximum 8 rooms
      And click the room number input
      And click the "8" option from the list
      Then verify that maximum room number allowed is "8"

    Scenario: User should be at least one room
      And click the room number input
      And click the "1" option from the list
      Then verify that maximum room number allowed is "1"

    Scenario: travelers field should disappear when number of rooms is more than one
      And click the room number input
      And click the "2" option from the list
      Then verify that travelers field is disappear

    Scenario: User should see result with the form fields filled properly
      And set the going to location for "New York"
      And set the dates to "Feb 12" and "Feb 22"
      And click the room number input
      And click the "2" option from the list
      And click the hotel search button
      Then verify that available hotel result are displayed




