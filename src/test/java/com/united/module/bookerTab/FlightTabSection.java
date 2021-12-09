package com.united.module.bookerTab;

import com.united.utils.Common;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.united.base.Hooks.driver;

public class FlightTabSection {

    //Flight tabs
    @FindBy(id = "travelTab-panel")
    private WebElement bookersPanels;

    @FindBy(id = "bookFlightTab")
    private WebElement flightButton;

    @FindBy(id = "oneway")
    private WebElement oneWayCheckBox;

    @FindBy(id = "roundtrip")
    private WebElement roundTripCheckBox;

    @FindBy(css = "label[id='flexDatesLabel']")
    private WebElement flexDateCheckBox;

    @FindBy(id = "cabinType")
    private WebElement cabinTypeButton;

    @FindBy(css = "ul[aria-labelledby='cabinDescriptor']")
    private  WebElement cabinTypeList;

    // Locations
    @FindBy(css = "input[aria-owns='bookFlightOriginInput-menu']")
    private WebElement leavingInput;

    @FindBy(css = "input[aria-owns='bookFlightDestinationInput-menu']")
    private WebElement goingInput;

    @FindBy(css = "button[aria-label='reverse origin and destination']")
    private WebElement locationSwitchButton;

    // date picker

    @FindBy(css = "div[class='SingleDatePicker SingleDatePicker_1'] ")
    private WebElement dateInputParent;

    @FindBy(id = "DepartDate")
    private WebElement departDate;

    @FindBy(id = "ReturnDate")
    private WebElement returnDate;

    @FindBy(css = "[aria-label='Move backward to switch to the previous month.']")
    private WebElement prevButtonDatePicker;

    // flex dates moth drop down
    @FindBy(css = "button[id='flexMonth']")
    private WebElement flexMonthInput;

    @FindBy(css = "button[id='flexDay']")
    private WebElement flexDayInput;

    // travelers
    @FindBy(css = "#passengerSelector")
    private WebElement travelersInput;

    @FindBy(xpath = "//*[@id=\"passengerMenuId\"]/div[1]/div[1]/div[1]/div/input")
    private WebElement adultsNumberInput;

    @FindBy(xpath = "//*[@id=\"passengerMenuId\"]/div[1]/div[1]/div[3]/div/input")
    private WebElement infantNumberInput;

    @FindBy(css = "div.app-components-PassengerSelector-passengers__passengerMenu__controls--1-kWM > button:nth-child(2)")
    private WebElement travelersClosButton;

    @FindBy(css = "button[aria-label='Clear all fields']")
    private WebElement clearAllInTravelers;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    private WebElement adultTravelerAdd;

    @FindBy(css = "#passengerMenuId > div:nth-child(3) > button")
    private WebElement TravelWithPet;

    @FindBy(css = " div.app-components-PassengerSelector-passengers__passengerMenu__items--lgmNz")
    private WebElement passengersMenu;
    // #passengerMenuId

    //Search button
    @FindBy(css = "button[aria-label='Find flights']")
    private WebElement searchButton;

    // advanced search button
    @FindBy(css = "button[title='Advanced search']")
    private WebElement advancedSearchButton;

    public FlightTabSection(){
        PageFactory.initElements(driver, this);
    }

    //getters

    //flight getters
    public WebElement getBookersPanels() {
        return bookersPanels;
    }

    public WebElement getFlightButton() {
        return flightButton;
    }

    public WebElement getOneWayCheckBox() {
        return oneWayCheckBox;
    }

    public WebElement getRoundTripCheckBox() {
        return roundTripCheckBox;
    }

    public WebElement getFlexDateCheckBox() { return flexDateCheckBox; }

    public WebElement getCabinTypeButton() {
        return cabinTypeButton;
    }

    public WebElement getCabinTypeList() { return cabinTypeList; }

    // locations gettter
    public WebElement getLeavingInput() { return leavingInput; }

    public WebElement getGoingInput() {
        return goingInput;
    }

    public WebElement getLocationSwitchButton() { return locationSwitchButton; }

    //date pickers getter
    public WebElement getDateInputParent() {
        return dateInputParent;
    }

    public WebElement getDepartDate() {
        return departDate;
    }

    public WebElement getReturnDate() {
        return returnDate;
    }

    public WebElement getPrevButtonDatePicker() { return prevButtonDatePicker; }

    //flex dates inputs
    public WebElement getFlexMonthInput() { return flexMonthInput; }

    public WebElement getFlexDayInput() { return flexDayInput; }

    // travelers getter
    public WebElement getTravelersInput() {
        return travelersInput;
    }

    public WebElement getAdultsNumberInput() {
        return adultsNumberInput;
    }

    public WebElement getInfantNumberInput() {
        return infantNumberInput;
    }

    public WebElement getTravelersClosButton() {
        return travelersClosButton;
    }

    public WebElement getClearAllInTravelers() { return clearAllInTravelers; }

    public WebElement getAdultTravelerAdd() {
        return adultTravelerAdd;
    }

    public WebElement getTravelWithPet() { return TravelWithPet; }

    public WebElement getPassengersMenu() { return passengersMenu; }

    public WebElement getAdvancedSearchButton() { return advancedSearchButton; }

    public WebElement getSearchButton() {
        return searchButton;
    }

    //functions

    // clicks
    public void clickFlightsButton(){
        Common.highLightElement(getFlightButton());
        getFlightButton().click();
        Common.waitUntilVisible(getCabinTypeButton());
    }

    public void clickSearchButton(){
        Common.waitUntilVisible(getSearchButton());
        Common.highLightElement(getSearchButton());
        getSearchButton().click();
    }

    public void clickOneWayRadio(){
        Common.highLightElement(getOneWayCheckBox());
        getOneWayCheckBox().click();
    }

    //Set Depart and Destination
    public void setUpTheLocations(String from, String to){
        Common.highLightElement(getLeavingInput());
        getLeavingInput().sendKeys(from);
        Common.waitSecond(1);
        Common.highLightElement(getGoingInput());
        getGoingInput().sendKeys(to);

    }

    // date select
    public void datePickerSelect(String date){
        getPrevButtonDatePicker().click();
        Common.waitSecond(1);
        List<WebElement> elements = driver.findElements(By.cssSelector("td[aria-disabled='false']"));
        for(WebElement element : elements){
            try {
                if(element.getAttribute("aria-label").contains(date)){
                    Common.highLightElement(element);
                    Common.waitSecond(1);
                    element.click();
                }
            }catch (StaleElementReferenceException | NullPointerException | NoSuchWindowException ignored){}

        }
    }

    // set travelers
    public void setTravelers(String adult, String infant){
        getTravelersInput().click();
        Common.waitUntilVisible(getAdultsNumberInput());
        Common.highLightElement(getAdultsNumberInput());
        getAdultsNumberInput().sendKeys(adult);
        Common.waitHalfSecond(1);
        Common.highLightElement(getInfantNumberInput());
        getInfantNumberInput().sendKeys(infant);
        Common.waitSecond(1);
        Common.highLightElement(getTravelersClosButton());
        getTravelersClosButton().click();
    }

    //round trip date select
    public void roundTripSelect(String date, String returnDay){
        getDepartDate().click();
        Common.waitSecond(1);
        List<WebElement> elements = driver.findElements(By.cssSelector("td[aria-disabled='false']"));
        for(WebElement target : elements){
            try {
                String attribute = target.getAttribute("aria-label");
                if(attribute.contains(date)){
                    Common.highLightElement(target);
                    target.click();
                    Common.waitSecond(1);
                }
                if(attribute.contains(returnDay)){
                    Common.highLightElement(target);
                    target.click();
                    Common.waitSecond(1);
                }
            }catch (StaleElementReferenceException | NullPointerException | NoSuchWindowException ignored){
            }
        }
    }

    // remove the input of locations
    public void removeAndVerifyTheValueOf(String where){
        if(getGoingInput().getAttribute("placeholder").contains(where)){
            getGoingInput().click();
            Common.highLightElement(getGoingInput());
            getGoingInput().clear();
            Assert.assertEquals(getGoingInput().getAttribute("value"), "");
        }
        else if (getLeavingInput().getAttribute("placeholder").contains(where)){
            getLeavingInput().click();
            Common.highLightElement(getLeavingInput());
            getLeavingInput().clear();
            Assert.assertEquals(getLeavingInput().getAttribute("value"), "");
        }
    }

    // click through and verify the flight class
    public void goThroughTheFlightClass(){
        Common.waitSecond(1);
        Common.highLightElement(getCabinTypeButton());
        getCabinTypeButton().click();
        Common.waitUntilVisible(getCabinTypeList());
        String ogValue = "2";
        List<WebElement> list = getCabinTypeList().findElements(By.tagName("li"));
        for(WebElement l : list){
            try {
                Common.waitHalfSecond(1);
                Common.highLightElement(l);
                l.click();
                getCabinTypeButton().click();
                String newValue = getCabinTypeButton().getAttribute("value");
                Assert.assertNotEquals(ogValue, newValue);
                ogValue = newValue;
            }
            catch (ElementNotInteractableException ignored){}

        }
    }









}


