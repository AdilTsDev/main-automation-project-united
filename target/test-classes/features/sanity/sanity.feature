@sanity
Feature: sanity test
  testing
  Background: at home page
    When home page is loaded

  Scenario: bookers tab should display correct fields
    And click flight status tab
    And click the book tab
    Then verify that correct fields are displayed

  Scenario: user should be able to change language
    And click the language and location button
    And click the language selector and chose "Deutsch"
    Then verify that the site language is changed;

  Scenario: top header should show correct panels when clicked
    And click through the tabs and verify show correct ones

  Scenario: advisory section should display info with links
    Then verify that advisory section is display with links


  Scenario: footer inks should no be broken
    And check through about united tab
    And check through products and services tab
    And check through popular destinations tab
