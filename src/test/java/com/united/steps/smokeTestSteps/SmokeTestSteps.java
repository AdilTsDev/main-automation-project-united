package com.united.steps.smokeTestSteps;

import com.united.module.bookerTab.FlightTabSection;
import com.united.pages.resultPages.FlightResultPage;
import com.united.pages.HomePage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SmokeTestSteps {

    //website loading
    @When("home page is loaded")
    public void homePageIsLoaded() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.siteIsLoaded());
    }

    @Then("verify that all the tabs are loaded")
    public void verifyThatAllTheTabsAreLoaded() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.mainTabsAreDisp());
    }

    @And("click the flights at main tabs")
    public void clickTheFlightsAtMainTabs() {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.clickFlightsButton();
    }

    // set locations
    @And("set up the locations from {string} and to {string};")
    public void setUpTheLocationsFromAndTo(String from, String to) {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.setUpTheLocations(from, to);

    }
    // search button click
    @And("click search button")
    public void clickSearchButton() {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.clickSearchButton();
    }

    // verify that result
    @Then("verify that available results are displayed")
    public void verifyThatAvailableResultsAreDisplayed() {
        FlightResultPage flightResultPage = new FlightResultPage();
        Common.waitUntilAllVisible(flightResultPage.getMainResultsSection());
        Assert.assertFalse(flightResultPage.getMainResultsSection().isEmpty());
    }

    // One way trip steps
    @And("click one-way trip")
    public void clickOneWayTrip() {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.clickOneWayRadio();
    }

    @And("check flight for date {string}")
    public void checkFlightForDate(String date){
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.highLightElement(flightTabSection.getDepartDate());
        flightTabSection.getDepartDate().click();
        flightTabSection.datePickerSelect(date);
    }

    @Then("verify that available results for {string} are displayed")
    public void verifyThatAvailableResultsForAreDisplayed(String expect) {
        FlightResultPage flightResultPage = new FlightResultPage();
        Common.waitUntilVisible(flightResultPage.getSearchResultInfo());
        Assert.assertTrue(flightResultPage.getSearchResultInfo().getText().contains(expect));
    }

    // round trip 3 tickets
    @And("click round-trip")
    public void clickRoundTrip() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.highLightElement(flightTabSection.getRoundTripCheckBox());
        flightTabSection.getRoundTripCheckBox().click();
    }

    @And("select {string} adults and {string} infants for travelers")
    public void selectAdultsAndInfantsForTravelers(String adult, String infant) {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.setTravelers(adult, infant);
    }

    @And("set flight date for {string}, and return at {string}")
    public void setFlightDateForAndReturnAt(String date, String returnDay) {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.roundTripSelect(date, returnDay);
    }

}
