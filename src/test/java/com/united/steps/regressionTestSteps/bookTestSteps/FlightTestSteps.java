package com.united.steps.regressionTestSteps.bookTestSteps;

import com.united.module.bookerTab.FlightTabSection;
import com.united.pages.searchPages.AdvancedSearchPage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

// checking round trip date box
public class FlightTestSteps {
    @And("the roundTrip is selected")
    public void theRoundTripIsSelected() {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.getRoundTripCheckBox().click();
        Common.waitSecond(1);
        Assert.assertTrue(flightTabSection.getRoundTripCheckBox().isSelected());
    }

    @Then("verify that departing and return date fields are enabled")
    public void verifyThatDepartingAndReturnDateFieldsAreEnabled() {
        FlightTabSection flightTabSection = new FlightTabSection();
        if (flightTabSection.getDepartDate().isDisplayed() && flightTabSection.getReturnDate().isDisplayed()) {
            Common.highLightElement(flightTabSection.getDepartDate());
            Common.highLightElement(flightTabSection.getReturnDate());
        }
        Assert.assertTrue(flightTabSection.getDepartDate().isEnabled()
                && flightTabSection.getReturnDate().isEnabled());
    }

    // checking one way date box
    @Then("verify that only departing date is enabled")
    public void verifyThatOnlyDepartingDateIsEnabled() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        if (flightTabSection.getDepartDate().isEnabled()) {
            Common.waitSecond(1);
            Common.highLightElement(flightTabSection.getDepartDate());
        }
        List<WebElement> inputCount = flightTabSection.getDateInputParent().findElements(By.tagName("input"));
        Assert.assertEquals(inputCount.size(), 1);

    }

    //  check user can select 9 travelers
    @Then("verify that value of travelers can be  {string}")
    public void verifyThatValueOfTravelersCanBe(String limit) {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.waitUntilVisible(flightTabSection.getAdultTravelerAdd());
        while (flightTabSection.getAdultTravelerAdd().isEnabled()) {
            Common.waitHalfSecond(1);
            try {
                Common.highLightElement(flightTabSection.getAdultTravelerAdd());
                flightTabSection.getAdultTravelerAdd().click();
                if (flightTabSection.getAdultsNumberInput().getAttribute("value").equals("9")) {
                    break;
                }
            }catch (ElementNotInteractableException ignored){}
        }
        Common.waitSecond(1);
        flightTabSection.getTravelersClosButton().click();
        Common.waitSecond(1);
        Assert.assertTrue(flightTabSection.getTravelersInput().getText().contains(limit));
    }

    // user can select every single type of travelers
    @And("select {string} for every single passenger type")
    public void selectForEverySinglePassengerType(String number) {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitUntilVisible(flightTabSection.getAdultTravelerAdd());
        Common.waitSecond(1);
        List<WebElement> inputs = flightTabSection.getPassengersMenu().findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            try {
                Common.waitSecond(1);
                Common.highLightElement(input);
                input.sendKeys(number);
            }
            catch (ElementNotInteractableException ignored){}
        }
        flightTabSection.getTravelersClosButton().click();
        Common.waitHalfSecond(1);
    }

    @Then("verify that value of travelers is matched")
    public void verifyThatValueOfTravelersIsMatched() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Assert.assertTrue(flightTabSection.getTravelersInput().getText().contains("8 Travelers"));
    }



    // Destinations switch
    @Then("click the switch button and verify the locations are switch")
    public void clickTheSwitchButtonAndVerifyTheLocationsAreSwitch() {
        FlightTabSection flightTabSection = new FlightTabSection();
        String ogValue = flightTabSection.getLeavingInput().getAttribute("value");
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getLocationSwitchButton());
        flightTabSection.getLocationSwitchButton().click();
        Common.waitSecond(1);
        String newValue = flightTabSection.getLeavingInput().getAttribute("value");
        Assert.assertNotEquals(ogValue, newValue);
    }


    // locations placeholder
    @Then("verify that locations fields have correct placeholders")
    public void verifyThatLocationsFieldsHaveCorrectPlaceholders() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getLeavingInput());
        Assert.assertEquals(flightTabSection.getLeavingInput().getAttribute("placeholder"), "From*");
        Common.highLightElement(flightTabSection.getGoingInput());
        Assert.assertEquals(flightTabSection.getGoingInput().getAttribute("placeholder"), "To*");

    }

    //remove input value of locations
    @Then("click the remove button to verify for {string}")
    public void clickTheRemoveButtonToVerifyFor(String where) {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        flightTabSection.removeAndVerifyTheValueOf(where);
    }

    // flight classes
    @Then("click through the flight class to verify")
    public void clickThroughTheFlightClassToVerify() {
        FlightTabSection flightTabSection = new FlightTabSection();
        flightTabSection.goThroughTheFlightClass();
    }

    // minimum travelers check
    @And("click the travelers button")
    public void clickTheTravelersButton() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getTravelersInput());
        flightTabSection.getTravelersInput().click();
    }

    @And("click the clear all button")
    public void clickTheClearAllButton() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getClearAllInTravelers());
        flightTabSection.getClearAllInTravelers().click();
    }

    @Then("verify that travelers input is still one")
    public void verifyThatTravelersInputIsStillOne() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Assert.assertTrue(flightTabSection.getTravelersInput().getText().contains("1 Adult"));
    }

    //user can only travel with one pet
    @And("click the travel with pet")
    public void clickTheTravelWithPet() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitUntilVisible(flightTabSection.getTravelWithPet());
        Common.highLightElement(flightTabSection.getTravelWithPet());
        flightTabSection.getTravelWithPet().click();
        Common.waitSecond(3);
    }

    @And("click the select number of pet")
    public void clickTheSelectNumberOfPet() {
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
        Common.waitSecond(1);
        Common.scrollBy(1000);
        advancedSearchPage.getPetInCabinButton().get(2).click();
        Common.waitUntilVisible(advancedSearchPage.getPetNumberSelect());
        advancedSearchPage.getPetNumberSelect().click();
    }
    @Then("verify user can only travel with {string} pet")
    public void verifyUserCanOnlyTravelWithPet(String pet) {
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
        Common.waitHalfSecond(1);
        advancedSearchPage.checkTheLastOptionsEqualsTo(pet);

    }

    // advanced search page test
    @And("click the advanced search button")
    public void clickTheAdvancedSearchButton() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getAdvancedSearchButton());
        flightTabSection.getAdvancedSearchButton().click();
    }

    @Then("verify that advanced search page is opened with more search field")
    public void verifyThatAdvancedSearchPageIsOpenedWithMoreSearchField() {
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
        advancedSearchPage.verifyTheAdvancedSearchPgae();
    }

    // flex dates selection test
    @And("click the flex dates check box")
    public void clickTheFlexDatesCheckBox() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitSecond(1);
        Common.highLightElement(flightTabSection.getFlexDateCheckBox());
        flightTabSection.getFlexDateCheckBox().click();
    }

    @Then("verify that date field is moth drop down")
    public void verifyThatDateFieldIsMothDropDown() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitUntilVisible(flightTabSection.getFlexMonthInput());
        Common.highLightElement(flightTabSection.getFlexMonthInput());
        Common.highLightElement(flightTabSection.getFlexDayInput());
        Assert.assertTrue(flightTabSection.getFlexMonthInput().isEnabled() &&
                flightTabSection.getFlexDayInput().isEnabled());
    }


}