package com.united.steps.regressionTestSteps.statusTestSteps;

import com.united.module.flightStatusTab.FlightStatusSection;
import com.united.pages.HomePage;
import com.united.pages.resultPages.FlightStatusResultPage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FlightStatusSteps {

    @And("click flight status tab")
    public void clickFlightStatusTab() {
        HomePage homePage = new HomePage();
        Common.highLightElement(homePage.getStatusTab());
        homePage.getStatusTab().click();
        Common.waitHalfSecond(1);
    }

    // light status checking
    @And("set the from location from {string} and to {string}")
    public void setTheFromLocationFromAndTo(String from, String to) {
        FlightStatusSection flightStatusSection = new FlightStatusSection();
        flightStatusSection.setLocationsAs(from, to);
    }

    @And("click the status search button")
    public void clickTheStatusSearchButton() {
        FlightStatusSection flightStatusSection = new FlightStatusSection();
        Common.waitHalfSecond(1);
        flightStatusSection.getStatusSearchButton().click();
    }

    @Then("verify that status search results are displayed")
    public void verifyThatStatusSearchResultsAreDisplayed() {
        FlightStatusResultPage flightStatusResultPage = new FlightStatusResultPage();
        Common.switchToNewWindow();
        Common.waitUntilVisible(flightStatusResultPage.getStatusResultsContainer());
        Assert.assertTrue(flightStatusResultPage.getStatusResultsContainer().isDisplayed());

    }

    // flight number is only accept number
    // give input
    @And("type {string} in flight number filed")
    public void typeInFlightNumberFiled(String text) {
        FlightStatusSection flightStatusSection = new FlightStatusSection();
        flightStatusSection.typeTextToTheNumberInput(text);

    }

    // verify the error message
    @Then("verify that flight number error message {string} is displayed")
    public void verifyThatFlightNumberErrorMessageIsDisplayed(String errorMessage) {
        FlightStatusSection flightStatusSection = new FlightStatusSection();
        if(flightStatusSection.getNumberErrorMessage().isDisplayed()){
            Common.highLightElement(flightStatusSection.getNumberErrorMessage());
            Assert.assertEquals(flightStatusSection.getNumberErrorMessage().getText(), errorMessage);
        }
    }
    @Then("verify that Invalid number message {string} id displayed")
    public void verifyThatInvalidNumberMessageIdDisplayed(String inValidNumber) {
        FlightStatusSection flightStatusSection = new FlightStatusSection();
        Common.waitUntilVisible(flightStatusSection.getInValidNumberMessage());
        Common.highLightElement(flightStatusSection.getInValidNumberMessage());
        Assert.assertEquals(flightStatusSection.getInValidNumberMessage().getText(), inValidNumber);
    }
}
