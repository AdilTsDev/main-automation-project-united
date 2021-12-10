@smoke
Feature: smoke test
  Testing the crucial function of the website

  Background:
    When home page is loaded

  Scenario: website loading
    Then verify that all the tabs are loaded

  Scenario: Available flight for round trip should be displayed when searched
    And click round-trip
    And set up the locations from "Orange County" and to "Chicago";
    And click search button
    Then verify that available results are displayed

  Scenario: checks out one way fight for the date
    And click one-way trip
    And set up the locations from "" and to "Chicago";
    And check flight for date "Saturday, January 15, 2022"
    And click search button
    Then verify that available results for "Jan 15, 2022" are displayed

  Scenario: checks out 3 round trip tickets for the date
    And click round-trip
    And set up the locations from "" and to "Chicago";
    And select "2" adults and "1" infants for travelers
    And set flight date for "Tuesday, February 15, 2022", and return at "Friday, February 25, 2022"
    And click search button
    Then verify that available results for "Feb 15, 2022" are displayed
