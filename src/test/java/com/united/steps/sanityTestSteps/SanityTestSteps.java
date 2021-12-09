package com.united.steps.sanityTestSteps;

import com.united.module.headerAndFooter.FooterSection;
import com.united.module.headerAndFooter.HeaderSection;
import com.united.module.headerAndFooter.SecondHeader;
import com.united.module.bookerTab.FlightTabSection;
import com.united.pages.HomePage;
import com.united.utils.Common;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.testng.Assert;



public class SanityTestSteps {

    @And("click the book tab")
    public void clickTheBookTab() {
        HomePage homePage = new HomePage();
        Common.highLightElement(homePage.getBookerTab());
        homePage.getBookerTab().click();
    }

    @Then("verify that correct fields are displayed")
    public void verifyThatCorrectFieldsAreDisplayed() {
        FlightTabSection flightTabSection = new FlightTabSection();
        Common.waitUntilVisible(flightTabSection.getBookersPanels());
        Common.highLightElement(flightTabSection.getBookersPanels());
        Assert.assertTrue(flightTabSection.getBookersPanels().isDisplayed());
    }

    //language test
    @And("click the language and location button")
    public void clickTheLanguageAndLocationButton() {
        HeaderSection headerSection = new HeaderSection();
        Common.highLightElement(headerSection.getLanguageLinks());
        headerSection.getLanguageLinks().click();
        Common.waitUntilVisible(headerSection.getChangeButton());
    }

    @And("click the language selector and chose {string}")
    public void clickTheLanguageSelectorAndChose(String language) throws InterruptedException {
        HeaderSection headerSection = new HeaderSection();
        Common.highLightElement(headerSection.getLanguageButton());
        headerSection.getLanguageButton().click();
        headerSection.switchTo(language);
    }

    @Then("verify that the site language is changed;")
    public void verifyThatTheSiteLanguageIsChanged() {
        HeaderSection headerSection = new HeaderSection();
        String attribute = headerSection.getLanguageLinks().getAttribute("aria-label");
        Assert.assertFalse(attribute.contains("english"));
    }

    //SecondHeader test
    @And("click through the tabs and verify show correct ones")
    public void clickThroughTheTabsAndVerifyShowCorrectOnes(){
        SecondHeader secondHeader = new SecondHeader();
        secondHeader.allTabsShouldDisplayCorrectPanels();
    }

    //Advisory check
    @Then("verify that advisory section is display with links")
    public void verifyThatAdvisorySectionIsDisplayWithLinks() {
        HeaderSection headerSection = new HeaderSection();
        Common.waitUntilAllVisible(headerSection.getLinksInAdvisory());
        Common.highLightElement(headerSection.getLinksInAdvisory().get(1));
        Assert.assertEquals(headerSection.getLinksInAdvisory().get(1).getText(),
                "what to expect when you travel");
        Assert.assertFalse(headerSection.getLinksInAdvisory().isEmpty());
    }

    //footer links check
    @And("check through about united tab")
    public void checkThroughAboutUnitedTab() {
        FooterSection footerSection = new FooterSection();
        footerSection.goThroughAllTheLinks(footerSection.getAboutUnitedLink(),
                footerSection.getAboutUnitedContainer());
    }

    @And("check through products and services tab")
    public void checkThroughProductsAndServicesTab() {
        FooterSection footerSection = new FooterSection();
        footerSection.goThroughAllTheLinks(footerSection.getProductsServicesLink(),
                footerSection.getProductsServiesCOntainer());
    }

    @And("check through popular destinations tab")
    public void checkThroughPopularDestinationsTab() {
        FooterSection footerSection = new FooterSection();
        footerSection.goThroughAllTheLinks(footerSection.getPopularDestinationsLink(),
                footerSection.getPopularDesContainer());
    }

}
