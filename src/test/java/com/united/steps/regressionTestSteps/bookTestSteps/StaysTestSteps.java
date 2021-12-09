package com.united.steps.regressionTestSteps.bookTestSteps;

import com.united.module.bookerTab.HotelTabSection;
import com.united.pages.resultPages.HotelSearchResultPage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class StaysTestSteps {

    @And("click the hotel panel")
    public void clickTheHotelPanel() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitSecond(1);
        Common.highLightElement(hotelTabSection.getHotelPanel());
        hotelTabSection.getHotelPanel().click();
    }

    //  hotel inputs fields are shown
    @Then("verify that all the fields are displayed")
    public void verifyThatAllTheFieldsAreDisplayed() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitSecond(1);
        hotelTabSection.verifyThatAllTheInputsArePresent();
    }

    // room, travelers numbers default
    @Then("verify that room numbers and travelers are as default")
    public void verifyThatRoomNumbersAndTravelersAreAsDefault() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Assert.assertEquals(hotelTabSection.getRoomNumberInput().getAttribute("value"), "1");
        Assert.assertEquals(hotelTabSection.getTravelerNumberInput().getAttribute("value"), "1 adult");
    }

    // maximum traveler numbers
    @And("click the travelers input button")
    public void clickTheTravelersInputButton() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.highLightElement(hotelTabSection.getTravelerNumberInput());
        hotelTabSection.getTravelerNumberInput().click();
    }

    @And("adding to both adult and children until not clickable")
    public void addingToBothAdultAndChildrenUntilNotClickable() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitSecond(1);
        hotelTabSection.addingCountsToBoth();
    }

    @Then("verify that maximum travelers allowed is {string}")
    public void verifyThatMaximumTravelersAllowedIs(String max) {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitSecond(1);
        Assert.assertTrue(hotelTabSection.getTravelerNumberInput().getAttribute("value").contains(max));
    }

    // maximum room numbers test
    @And("click the room number input")
    public void clickTheRoomNumberInput() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitSecond(1);
        Common.highLightElement(hotelTabSection.getRoomNumberInput());
        hotelTabSection.getRoomNumberInput().click();
    }

    @And("click the {string} option from the list")
    public void clickTheMaxOptionFromTheList(String max) {
        HotelTabSection hotelTabSection = new HotelTabSection();
        hotelTabSection.clickTheMaxOptionFromTheLIst(max);
    }

    @Then("verify that maximum room number allowed is {string}")
    public void verifyThatMaximumRoomNumberAllowedIs(String max) {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Assert.assertEquals(hotelTabSection.getRoomNumberInput().getAttribute("value"), max);
    }


    // travelers input disappear when room is more than 1
    @Then("verify that travelers field is disappear")
    public void verifyThatTravelersFieldIsDisappear() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitHalfSecond(1);
        Assert.assertFalse(hotelTabSection.getTravelerNumberInput().isDisplayed());
    }

    // fill out the form and see the result
    @And("set the going to location for {string}")
    public void setTheGoingToLocationFor(String where) {
        HotelTabSection hotelTabSection = new HotelTabSection();
        hotelTabSection.getGoingToInout().click();
        hotelTabSection.getGoingToInout().sendKeys(where);
        Common.waitHalfSecond(1);
    }

    @And("set the dates to {string} and {string}")
    public void setTheDatesToAnd(String going, String returning) {
        HotelTabSection hotelTabSection = new HotelTabSection();
        hotelTabSection.getCheckInInput().click();
        hotelTabSection.getCheckInInput().sendKeys(going);
        Common.waitHalfSecond(1);
        hotelTabSection.getCheckOutInput().click();
        hotelTabSection.getCheckOutInput().sendKeys(returning);
    }

    @And("click the hotel search button")
    public void clickTheHotelSearchButton() {
        HotelTabSection hotelTabSection = new HotelTabSection();
        Common.waitHalfSecond(1);
        hotelTabSection.getHotelSearchButton().click();
    }

    @Then("verify that available hotel result are displayed")
    public void verifyThatAvailableHotelResultAreDisplayed() {
        HotelSearchResultPage hotelSearchResultPage = new HotelSearchResultPage();
        Common.switchToNewWindow();
        Common.scrollBy(200);
        Common.waitUntilVisible(hotelSearchResultPage.getHotelListing());
        Assert.assertTrue(hotelSearchResultPage.getHotelListing().isDisplayed());
    }
}
