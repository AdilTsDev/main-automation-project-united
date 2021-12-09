package com.united.steps.regressionTestSteps.checkInTestSteps;

import com.united.module.checkInTab.CheckInSection;
import com.united.pages.checkInPages.CheckInOptionsPage;
import com.united.pages.checkInPages.CheckInProcessDetailPage;
import com.united.pages.HomePage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckInTestSteps {
    @And("click check in tab")
    public void clickCheckInTab() {
        HomePage homePage = new HomePage();
        Common.highLightElement(homePage.getCheckInTab());
        homePage.getCheckInTab().click();
    }

    //error message when sending the empty form
    @And("click the check in search button")
    public void clickTheCheckInSearchButton() {
        CheckInSection checkInSection = new CheckInSection();
        Common.waitHalfSecond(1);
        checkInSection.getCheckInSearchButton().click();
    }

    @Then("verify confirm number error message {string} is displayed")
    public void verifyConfirmNumberErrorMessageIsDisplayed(String confirmInputError) {
        CheckInSection checkInSection = new CheckInSection();
        Common.waitUntilVisible(checkInSection.getConfirmInputErrorMessage());
        Common.highLightElement(checkInSection.getConfirmInputErrorMessage());
        Assert.assertEquals(checkInSection.getConfirmInputErrorMessage().getText(), confirmInputError);
    }

    @Then("verify last name error message {string} is displayed")
    public void verifyLastNameErrorMessageIsDisplayed(String lastNameInputError) {
        CheckInSection checkInSection = new CheckInSection();
        Common.waitUntilVisible(checkInSection.getLastNameInputErrorMessage());
        Common.highLightElement(checkInSection.getLastNameInputErrorMessage());
        Assert.assertEquals(checkInSection.getLastNameInputErrorMessage().getText(), lastNameInputError);
    }

    //check in process detail page open test
    @And("click the check in detail link")
    public void clickTheCheckInDetailLink() {
        CheckInSection checkInSection = new CheckInSection();
        Common.highLightElement(checkInSection.getCheckInDetailLInk());
        checkInSection.getCheckInDetailLInk().click();
        Common.waitSecond(2);
    }

    @Then("verify that check in processing detail page is opened and loaded")
    public void verifyThatCheckInProcessingDetailPageIsOpenedAndLoaded() {
        CheckInProcessDetailPage checkInProcessDetailPage = new CheckInProcessDetailPage();
        Common.waitUntilVisible(checkInProcessDetailPage.getHeaderTextOfThePage());
        Common.highLightElement(checkInProcessDetailPage.getHeaderTextOfThePage());
        Assert.assertEquals(checkInProcessDetailPage.getHeaderTextOfThePage().getText(),
                "Check-in and airport processing times");
    }

    // mileage plus link test
    @And("click the check in with mileage plus link")
    public void clickTheCheckInWithMileagePlusLink() {
        CheckInSection checkInSection = new CheckInSection();
        Common.highLightElement(checkInSection.getCheckInWithMileagePlus());
        Common.waitSecond(1);
        checkInSection.getCheckInWithMileagePlus().click();
    }

    @Then("verify that check in options page is opened and loaded")
    public void verifyThatCheckInOptionsPageIsOpenedAndLoaded() {
        CheckInOptionsPage checkInOptionsPage = new CheckInOptionsPage();
        Common.waitUntilVisible(checkInOptionsPage.getCheckInOptions());
        Common.highLightElement(checkInOptionsPage.getCheckInOptions());
        Assert.assertTrue(checkInOptionsPage.getCheckInOptions().isEnabled());
    }
}
