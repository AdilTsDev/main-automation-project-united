package com.united.module.bookerTab;

import com.united.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

import static com.united.base.Hooks.driver;

public class CarTabSection {

    @FindBy(css = "li[id='bookCarTab']")
    private WebElement carPanel;
    // form elements
    @FindBy(css = "#bookCarForm")
    private WebElement carFormContainer;

    @FindBy(css = "input[id='bookCarPickupInput']")
    private WebElement carPickUpLocationInput;

    @FindBy(css = "input[id='bookCarDropoffInput']")
    private WebElement dropOffLocationInput;

    @FindBy(css = "input[id='driversAge']")
    private WebElement ageInput;

    @FindBy(css = "input[id='bookCarPickupDate']")
    private WebElement pickUpDateInput;

    @FindBy(css = "input[id='bookCarDropoffDate']")
    private WebElement dropOffDateInput;

    //return same location
    @FindBy(css = "label[for='showDropOffLocation']")
    private WebElement returnToSameCheckBox;

    @FindBy(css = "label[for='hideAgeBox']")
    private WebElement ageCheckBox;

    @FindBy(css = "label[for='awardCarTravel']")
    private WebElement bookWithMiles;

    //search button
    @FindBy(css = "button[aria-label='Find cars button.']")
    private WebElement carSearchButton;

    //constructor
    public CarTabSection(){ PageFactory.initElements(driver, this); }

    //gitter
    public WebElement getCarPanel() { return carPanel; }

    public WebElement getCarFormContainer() { return carFormContainer; }

    public WebElement getCarPickUpLocationInput() { return carPickUpLocationInput; }

    public WebElement getDropOffLocationInput() { return dropOffLocationInput; }

    public WebElement getAgeInput() { return ageInput; }

    public WebElement getPickUpDateInput() { return pickUpDateInput; }

    public WebElement getDropOffDateInput() { return dropOffDateInput; }

    //same location checkbox
    public WebElement getReturnToSameCheckBox() { return returnToSameCheckBox; }

    //age checkbox
    public WebElement getAgeCheckBox() { return ageCheckBox; }

    public WebElement getBookWithMiles() { return bookWithMiles; }

    public WebElement getCarSearchButton() { return carSearchButton; }

    //function
    public void checkThroughTheFields(){
        List<WebElement> inputs = getCarFormContainer().findElements(By.tagName("input"));
        for(WebElement input : inputs){
            Common.highLightElement(input);
            Common.waitHalfSecond(1);
            Assert.assertTrue(input.isEnabled());
        }

    }
}
