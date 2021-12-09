package com.united.steps.regressionTestSteps.myTripTestSteps;

import com.united.module.myTripTab.MyTripSection;
import com.united.pages.HomePage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;


public class MyTripSteps {
    @And("click the my trip tab")
    public void clickTheMyTripTab() {
        HomePage homePage = new HomePage();
        Common.highLightElement(homePage.getMyTripTab());
        homePage.getMyTripTab().click();

    }
    // find travel credit link should work
    @Then("verify that find travel credits link is enabled")
    public void verifyThatFindTravelCreditsLinkIsEnabled() {
        MyTripSection myTripSection = new MyTripSection();
        Common.waitSecond(1);
        Common.highLightElement(myTripSection.getFindTravelCreditLink());
        Assert.assertTrue(myTripSection.getFindTravelCreditLink().isEnabled());
    }

    @And("click the my trip search button")
    public void clickTheMyTripSearchButton() {
        MyTripSection myTripSection = new MyTripSection();
        Common.waitSecond(1);
        myTripSection.getMyTripSearchButton().click();

    }

    @Then("verify that confirmation input error {string} is displayed")
    public void verifyThatConfirmationInputErrorIsDisplayed(String confirmErrorMessage) {
        MyTripSection myTripSection = new MyTripSection();
        Common.waitUntilVisible(myTripSection.getConfirmInputErrorMessage());
        Common.highLightElement(myTripSection.getConfirmInputErrorMessage());
        Assert.assertEquals(myTripSection.getConfirmInputErrorMessage().getText(), confirmErrorMessage);
    }

    @Then("verify that last name input error {string} is displayed")
    public void verifyThatLastNameInputErrorIsDisplayed(String lastNameErrorMessage) {
        MyTripSection myTripSection = new MyTripSection();
        Common.highLightElement(myTripSection.getLastNameInputErrorMessage());
        Assert.assertEquals(myTripSection.getLastNameInputErrorMessage().getText(), lastNameErrorMessage);
    }

    // my trip sign in link test
    @Then("verify that my trip sign in link is enabled")
    public void verifyThatMyTripSignInLinkIsEnabled() {
        MyTripSection myTripSection = new MyTripSection();
        Common.waitSecond(1);
        Common.highLightElement(myTripSection.getMyTripSignInLink());
        Assert.assertTrue(myTripSection.getMyTripSignInLink().isEnabled());
    }
}
