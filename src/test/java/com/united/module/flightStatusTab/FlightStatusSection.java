package com.united.module.flightStatusTab;

import com.united.utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class FlightStatusSection {

    @FindBy(css = "#flightStatusModel")
    private WebElement statusInputForm;

    @FindBy(css = "#flightStatusOriginInput")
    private WebElement statusFromInput;

    @FindBy(css = "#flightStatusDestinationInput")
    private WebElement statusToInput;

    //flight number
    @FindBy(css = "input[id='flightStatusModel.flightNumber']")
    private WebElement flightNumberInput;
    @FindBy(css = "#flightStatusModel\\.flightNumber_aria")
    private WebElement numberErrorMessage;
    @FindBy(css = "p[class='app-components-FlightNotFoundMessage-flightNotFoundMessage__message--KSn-O']")
    private WebElement inValidNumberMessage;



    //search button
    @FindBy(css = "#flightStatusModel > div > button")
    private WebElement statusSearchButton;

    public FlightStatusSection(){
        PageFactory.initElements(driver, this);
    }

    //getters
    public WebElement getStatusInputForm() { return statusInputForm; }

    public WebElement getStatusFromInput() { return statusFromInput;}

    public WebElement getStatusToInput() { return statusToInput; }

    public WebElement getFlightNumberInput() { return flightNumberInput; }

    public WebElement getNumberErrorMessage() { return numberErrorMessage; }

    public WebElement getInValidNumberMessage() { return inValidNumberMessage; }

    public WebElement getStatusSearchButton() { return statusSearchButton; }

    //functions
    //set locations at flight status
    public void setLocationsAs(String from, String to) {
        Common.waitSecond(1);
        getStatusFromInput().click();
        Common.waitHalfSecond(1);
        getStatusFromInput().sendKeys(from);
        Common.waitHalfSecond(1);
        getStatusToInput().click();
        getStatusToInput().sendKeys(to);
        getStatusInputForm().click();

    }

    // give input at number input
    public void typeTextToTheNumberInput(String text) {
        Common.waitUntilVisible(getFlightNumberInput());
        getFlightNumberInput().click();
        getFlightNumberInput().sendKeys(text);
        Common.waitHalfSecond(1);
    }
}
