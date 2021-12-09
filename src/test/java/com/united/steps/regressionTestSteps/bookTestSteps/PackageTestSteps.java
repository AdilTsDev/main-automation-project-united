package com.united.steps.regressionTestSteps.bookTestSteps;

import com.united.module.bookerTab.PackageTabSection;
import com.united.pages.resultPages.PackageResultPage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class PackageTestSteps {
    @And("click the package panel")
    public void clickThePackagePanel() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitSecond(1);
        Common.waitUntilClickable(packageTabSection.getPackagePanel());
        Common.highLightElement(packageTabSection.getPackagePanel());
        packageTabSection.getPackagePanel().click();
    }

    //  proper search should show result
    @And("set from location {string} and to location {string}")
    public void setFromLocationAndToLocation(String from, String to) {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.setLocationsFor(from, to);
    }

    @And("set the depar date for {string} and return date for {string}")
    public void setTheDeparDateForAndReturnDateFor(String departDay, String returnDay) {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.setDatesFor(departDay, returnDay);
    }

    @And("click the find trip search button")
    public void clickTheFindTripSearchButton() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.getFindCarSearchButton().click();
    }

    @Then("verify that result for package search is displayed")
    public void verifyThatResultForPackageSearchIsDisplayed() {
        PackageResultPage packageResultPage = new PackageResultPage();
        Common.switchToNewWindow();
        Common.waitUntilVisible(packageResultPage.getPackageResultContainer());
        Assert.assertTrue(packageResultPage.getPackageResultContainer().isDisplayed());

    }

    // maximum room number should be 4
    @And("click the room selector")
    public void clickTheRoomSelector() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.getRoomSelectInput().click();
    }

    @And("click the last option from the drop down")
    public void clickTheLastOptionFromTheDropDown() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.clickTheLastOption();
    }

    @Then("verify that room number value is {string}")
    public void verifyThatRoomNumberValueIs(String number) {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        Assert.assertEquals(packageTabSection.getRoomSelectInput().getAttribute("value"), number);
    }

    // verify it says rooms when more than one
    @Then("verify that selected room info says {string}")
    public void verifyThatSelectedRoomInfoSays(String rooms) {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        Assert.assertTrue(packageTabSection.getSelectedRoomInfo().getText().contains(rooms));
    }

    // test the room select disappear for flight and car
    @And("click the Flight and car checkbox")
    public void clickTheFlightAndCarCheckbox() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        packageTabSection.getPackageCheckboxes().get(2).click();

    }

    @And("verify that room select dropdown is disappear")
    public void verifyThatRoomSelectDropdownIsDisappear() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.waitHalfSecond(1);
        try {
            Assert.assertFalse(packageTabSection.getRoomSelectInput().isDisplayed());
        }catch (NoSuchElementException ignored){}
    }

    // cruise link test
    @And("click the cruise link")
    public void clickTheCruiseLink() {
        PackageTabSection packageTabSection = new PackageTabSection();
        Common.highLightElement(packageTabSection.getCruiseLink());
        packageTabSection.getCruiseLink().click();
    }

    @Then("verify that united cruises page is loaded")
    public void verifyThatUnitedCruisesPageIsLoaded() {
        String currentUrl = Common.getCurrentUrl();
        Common.switchToNewWindow();
        Assert.assertNotEquals(currentUrl, Common.getCurrentUrl());


    }
}
