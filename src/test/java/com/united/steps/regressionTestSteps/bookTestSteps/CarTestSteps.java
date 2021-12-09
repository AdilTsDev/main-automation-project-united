package com.united.steps.regressionTestSteps.bookTestSteps;

import com.united.module.bookerTab.CarTabSection;
import com.united.pages.resultPages.CarResultPage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class CarTestSteps {
    @And("click the car panel")
    public void clickTheCarPanel() {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitSecond(1);
        Common.highLightElement(carTabSection.getCarPanel());
        carTabSection.getCarPanel().click();
    }

    // all the input are displayed
    @Then("verify that car form fields are displayed")
    public void verifyThatCarFormFieldsAreDisplayed() {
        CarTabSection carTabSection = new CarTabSection();
        carTabSection.checkThroughTheFields();
    }

    // drop off location checkbox input
    @And("click same location checkbox")
    public void clickSameLocationCheckbox() {
        CarTabSection carTabSection = new CarTabSection();
        Common.highLightElement(carTabSection.getReturnToSameCheckBox());
        carTabSection.getReturnToSameCheckBox().click();
    }

    @And("verify that drop off input is enabled")
    public void verifyThatDropOffInputIsEnabled() {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitHalfSecond(1);
        Common.highLightElement(carTabSection.getDropOffLocationInput());
        Assert.assertTrue(carTabSection.getDropOffLocationInput().isEnabled());
    }

    @Then("verify that drop off input is disappear")
    public void verifyThatDropOffInputIsDisappear() {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitHalfSecond(1);
        try {
            Assert.assertFalse(carTabSection.getDropOffLocationInput().isDisplayed());
        }catch (NoSuchElementException ignored){}
    }

    //age checkbox input test
    @And("click age checkbox")
    public void clickAgeCheckbox() {
        CarTabSection carTabSection = new CarTabSection();
        Common.highLightElement(carTabSection.getAgeCheckBox());
        carTabSection.getAgeCheckBox().click();
    }

    @And("verify that age input is enabled")
    public void verifyThatAgeInputIsEnabled() {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitSecond(1);
        Common.highLightElement(carTabSection.getAgeInput());
        Assert.assertTrue(carTabSection.getAgeInput().isEnabled());
    }

    @Then("verify that age input is disappear")
    public void verifyThatAgeInputIsDisappear() {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitHalfSecond(1);
        try {
            Assert.assertFalse(carTabSection.getAgeInput().isDisplayed());
        }catch (NoSuchElementException ignored){}
    }

    // search for a car should open new window
    @And("set the pick up location for {string}")
    public void setThePickUpLocationFor(String where) {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitSecond(1);
        carTabSection.getCarPickUpLocationInput().click();
        carTabSection.getCarPickUpLocationInput().sendKeys(where);

    }

    @And("set the rental date for {string} and return at {string}")
    public void setTheRentalDateForAndReturnAt(String pickUp, String dropOff) {
        CarTabSection carTabSection = new CarTabSection();
        Common.waitSecond(1);
        carTabSection.getCarFormContainer().click();
        carTabSection.getPickUpDateInput().click();
        carTabSection.getPickUpDateInput().sendKeys(pickUp);
        Common.waitHalfSecond(2);
        carTabSection.getDropOffDateInput().click();
        carTabSection.getDropOffDateInput().sendKeys(dropOff);
        carTabSection.getCarFormContainer().click();
    }

    @And("click the find car button to search")
    public void clickTheFindCarButtonToSearch() {
        CarTabSection carTabSection = new CarTabSection();
        carTabSection.getCarSearchButton().click();
    }

    @Then("verify that separate tab is open")
    public void verifyThatSeparateTabIsOpen() {
        CarResultPage carResultPage = new CarResultPage();
        Common.switchToNewWindow();
        Common.waitUntilVisible(carResultPage.getCarResultContainer());
        Assert.assertTrue(carResultPage.getCarResultContainer().isDisplayed());

    }

    // book with mile test
    @And("click the book with miles checkbox")
    public void clickTheBookWithMilesCheckbox() {
        CarTabSection carTabSection = new CarTabSection();
        carTabSection.getBookWithMiles().click();
        Common.waitHalfSecond(1);
    }

    @Then("verify that result is only with miles")
    public void verifyThatResultIsOnlyWithMiles() {
        CarResultPage carResultPage = new CarResultPage();
        Common.switchToNewWindow();
        carResultPage.verifyAllTheMilesTagIsDisplayed();
    }

    // under 21 error message
    @And("set age to {string}")
    public void setAgeTo(String age) {
        CarTabSection carTabSection = new CarTabSection();
        carTabSection.getAgeInput().click();
        carTabSection.getAgeInput().sendKeys(age);
        Common.waitHalfSecond(1);
        carTabSection.getCarFormContainer().click();
    }

    @Then("verify that under age error message is displayed")
    public void verifyThatUnderAgeErrorMessageIsDisplayed() {
        CarResultPage carResultPage = new CarResultPage();
        Common.switchToNewWindow();
        carResultPage.verifyThatUnder21ErrorMessage();
    }

    // for 21
    @Then("verify that no result message is displayed")
    public void verifyThatNoResultMessageIsDisplayed() {
        CarResultPage carResultPage = new CarResultPage();
        Common.switchToNewWindow();
        carResultPage.verifyThatNoResultMessage();
    }

    // for above 21
    @Then("verify that results are displayed")
    public void verifyThatResultsAreDisplayed() {
        CarResultPage carResultPage = new CarResultPage();
        Common.switchToNewWindow();
        Common.waitUntilVisible(carResultPage.getCarResultContainer());
        Assert.assertTrue(carResultPage.getCarResultContainer().isDisplayed());

    }

}
