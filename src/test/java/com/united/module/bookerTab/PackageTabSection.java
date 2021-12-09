package com.united.module.bookerTab;

import com.united.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.united.base.Hooks.driver;

public class PackageTabSection {

    @FindBy(css = "li[id='bookPackageTab']")
    private WebElement packagePanel;

    @FindBy(css = "div[id='bookPackageTab-panel']")
    private WebElement packageFormPanel;

    // form inputs
    @FindBy(css = "li[type='radio']")
    private List<WebElement> packageCheckboxes;

    @FindBy(css = "input[id='vacationOriginInput']")
    private WebElement fromInput;

    @FindBy(css = "input[id='vacationDestinationInput']")
    private WebElement toInput;

    @FindBy(css = "input[id='DepartDate']")
    private WebElement deParDateInput;

    @FindBy(css = "input[id='ReturnDate']")
    private WebElement returnDateInput;

    @FindBy(css = "button[id='selectedRooms']")
    private WebElement roomSelectInput;

    @FindBy(css = "ul[aria-labelledby='roomDescriptor']")
    private WebElement roomSelectDropDown;

    @FindBy(css = "#selectedRooms > div")
    private WebElement selectedRoomInfo;


    //search button
    @FindBy(xpath = "//*[@id='bookVacationForm']/div[3]/button")
    private WebElement findCarSearchButton;

    // cruise link
    @FindBy(css = "a[id='bookCruiseTab']")
    private WebElement cruiseLink;


    //constructor
    public PackageTabSection(){ PageFactory.initElements(driver, this); }

    //getters
    public WebElement getPackagePanel() { return packagePanel; }

    public WebElement getPackageFormPanel() { return packageFormPanel; }

    // form getters

    public List<WebElement> getPackageCheckboxes() { return packageCheckboxes; }

    public WebElement getFromInput() { return fromInput; }

    public WebElement getToInput() { return toInput;}

    public WebElement getDeParDateInput() { return deParDateInput; }

    public WebElement getReturnDateInput() { return returnDateInput;}

    public WebElement getRoomSelectInput() { return roomSelectInput; }

    public WebElement getRoomSelectDropDown() { return roomSelectDropDown; }

    public WebElement getSelectedRoomInfo() { return selectedRoomInfo; }

    //search button
    public WebElement getFindCarSearchButton() { return findCarSearchButton; }

    //cruise link
    public WebElement getCruiseLink() { return cruiseLink; }

    // set from and to at Package search
    public void setLocationsFor(String from, String to) {
        getFromInput().click();
        getFromInput().sendKeys(from);
        Common.waitHalfSecond(1);
        getToInput().click();
        getToInput().sendKeys(to);
        Common.waitHalfSecond(1);
        getPackageFormPanel().click();
    }

    // dates set at package search
    public void setDatesFor(String departDay, String returnDay) {
        getDeParDateInput().click();
        getDeParDateInput().sendKeys(departDay);
        Common.waitHalfSecond(1);
        getReturnDateInput().click();
        getReturnDateInput().sendKeys(returnDay);
        Common.waitHalfSecond(1);
        getPackageFormPanel().click();
    }

    // select the last option from room drop down
    public void clickTheLastOption() {
        List<WebElement> lists = getRoomSelectDropDown().findElements(By.tagName("li"));
        WebElement LastElement = lists.get(lists.size() - 1);
        Common.highLightElement(LastElement);
        LastElement.click();

    }
}
