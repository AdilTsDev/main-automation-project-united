package com.united.module.bookerTab;


import com.united.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.united.base.Hooks.driver;

public class HotelTabSection {

    // hotel tabs
    @FindBy(css = "li[id='bookHotelTab']")
    private WebElement hotelPanel;

    //inputs container
    @FindBy(css = "div[id='bookHotelTab-panel']")
    private WebElement hotelPanelContainer;

    @FindBy(css = "input[id='bookHotelInput']")
    private WebElement goingToInout;

    @FindBy(css = "input[id='bookHotelCheckinDate']")
    private WebElement checkInInput;

    @FindBy(css = "input[id='bookHotelCheckoutDate']")
    private WebElement checkOutInput;

    @FindBy(css = "button[id='roomsDropdown']")
    private WebElement roomNumberInput;

    @FindBy(css = "ul[aria-labelledby='roomsDropdown_label-0']")
    private WebElement roomNumberContainer;

    // travelers
    @FindBy(css = "input[id='bookHotelModel.passengers']")
    private WebElement travelerNumberInput;

    @FindBy(css = "button[id='Adults plusBtn']")
    private WebElement adultAddButton;

    @FindBy(css = "button[id='Children plusBtn']")
    private WebElement kidsAddButton;

    //hotel search button
    @FindBy(css = "button[aria-label='Find hotels button.']")
    private WebElement hotelSearchButton;

    public HotelTabSection(){ PageFactory.initElements(driver, this); }

    //getters
    public WebElement getHotelPanel() { return hotelPanel; }

    public WebElement getHotelPanelContainer() { return hotelPanelContainer; }

    public WebElement getGoingToInout() { return goingToInout; }

    public WebElement getCheckInInput() { return checkInInput; }

    public WebElement getCheckOutInput() { return checkOutInput; }

    public WebElement getRoomNumberInput() { return roomNumberInput; }

    public WebElement getRoomNumberContainer() { return roomNumberContainer; }

    // travelers
    public WebElement getTravelerNumberInput() { return travelerNumberInput; }

    public WebElement getAdultAddButton() { return adultAddButton; }

    public WebElement getKidsAddButton() { return kidsAddButton; }

    // search button
    public WebElement getHotelSearchButton() { return hotelSearchButton; }

    //functions
    public void verifyThatAllTheInputsArePresent() {
        List<WebElement> inputs = getHotelPanelContainer().findElements(By.tagName("input"));
        for(WebElement input : inputs){
            Common.highLightElement(input);
            Assert.assertTrue(input.isEnabled());
        }
    }

    // adding travelers to both
    public void addingCountsToBoth() {
        while(getKidsAddButton().isEnabled()){
            Common.highLightElement(getAdultAddButton());
            getAdultAddButton().click();
            Common.highLightElement(getKidsAddButton());
            getKidsAddButton().click();
        }
    }

    public void clickTheMaxOptionFromTheLIst(String max) {
        List<WebElement> lists = getRoomNumberContainer().findElements(By.tagName("li"));
        for(WebElement l : lists){
            if(l.getText().contains(max)){
                Common.highLightElement(l);
                Common.waitHalfSecond(1);
                l.click();
            }
        }
    }
}
