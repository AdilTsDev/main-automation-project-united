package com.united.module.checkInTab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.united.base.Hooks.driver;

public class CheckInSection {
    @FindBy(css = "input[id='flightCheckInConfNumber']")
    private WebElement confirmationInput;
    @FindBy(css = "input[id='flightCheckInLastName']")
    private WebElement lastNameInput;
    @FindBy(css = "button[id='formSubmitBtn']")
    private WebElement checkInSearchButton;
    @FindBy(css = "div.app-components-FlightCheckinForm-flightCheckinForm__checkinWithMPlinkContainer--1l8YL > button")
    private WebElement checkInWithMileagePlus;
    @FindBy(css = "a[href='https://www.united.com/ual/en/US/fly/travel/airport/process.html']")
    private WebElement checkInDetailLInk;


    // inputs error messages
    @FindBy(css = "div[id='flightCheckInConfNumber_aria']")
    private WebElement confirmInputErrorMessage;
    @FindBy(css = "div[id='flightCheckInLastName_aria']")
    private WebElement lastNameInputErrorMessage;

    public CheckInSection(){ PageFactory.initElements(driver, this); }

    //getters
    public WebElement getConfirmationInput() { return confirmationInput; }

    public WebElement getLastNameInput() { return lastNameInput; }

    public WebElement getCheckInSearchButton() { return checkInSearchButton; }

    public WebElement getCheckInWithMileagePlus() { return checkInWithMileagePlus; }

    public WebElement getCheckInDetailLInk() { return checkInDetailLInk; }

    // inputs error messages
    public WebElement getConfirmInputErrorMessage() { return confirmInputErrorMessage; }

    public WebElement getLastNameInputErrorMessage() { return lastNameInputErrorMessage; }
}
