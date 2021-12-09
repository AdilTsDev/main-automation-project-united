package com.united.module.myTripTab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class MyTripSection {

    @FindBy(css = "input[id='myTripsConfirmationNumber']")
    private WebElement confirmInput;
    @FindBy(css = "input[id='myTripsLastName']")
    private WebElement lastNameInput;

    @FindBy(css = "#myTripsConfirmationNumber_aria")
    private WebElement confirmInputErrorMessage;

    @FindBy(css = "#myTripsLastName_aria")
    private WebElement lastNameInputErrorMessage;


    @FindBy(css = "button[id='myTripsSubmitBtn']")
    private WebElement myTripSearchButton;

    @FindBy(css = "a[href='/en/US/fly/travel/credit.html']")
    private WebElement findTravelCreditLink;

    @FindBy(css = "a[href='/en/US/manageres/mytrips?signIn=true']")
    private WebElement myTripSignInLink;


    public MyTripSection(){ PageFactory.initElements(driver, this); }

    //getters
    public WebElement getFindTravelCreditLink() { return findTravelCreditLink; }

    public WebElement getConfirmInput() { return confirmInput; }

    public WebElement getLastNameInput() { return lastNameInput; }

    public WebElement getConfirmInputErrorMessage() { return confirmInputErrorMessage; }

    public WebElement getLastNameInputErrorMessage() { return lastNameInputErrorMessage; }

    public WebElement getMyTripSearchButton() { return myTripSearchButton; }

    public WebElement getMyTripSignInLink() { return myTripSignInLink; }
}
