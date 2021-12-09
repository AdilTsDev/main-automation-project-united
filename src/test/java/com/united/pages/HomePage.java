package com.united.pages;

import com.united.utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.united.base.Hooks.driver;

public class HomePage {

    //main tabs
    @FindBy(css = "ul.app-components-BookTravel-bookTravel__travelNav--3RNBj")
    private List<WebElement> mainTabs;
    //tabs
    @FindBy(id = "travelTab")
    private WebElement bookerTab;
    @FindBy(id = "statusTab")
    private WebElement statusTab;
    @FindBy(id = "checkInTab")
    private WebElement checkInTab;
    @FindBy(id = "tripsTab")
    private WebElement myTripTab;



    //Constructor
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //getters
    //main tabs
    public List<WebElement> getMainTabs() {
        return mainTabs;
    }
    //tabs
    public WebElement getBookerTab() {
        return bookerTab;
    }

    public WebElement getStatusTab() {
        return statusTab;
    }

    public WebElement getCheckInTab() { return checkInTab;}

    public WebElement getMyTripTab() { return myTripTab; }



    // functions
    public boolean siteIsLoaded(){
        return (driver.getTitle().equals("United Airlines - Airline Tickets, Travel Deals and Flights"));
    }

    //verify main tabs are all displayed
    public boolean mainTabsAreDisp(){
        for (WebElement el : getMainTabs()){
            Common.highLightElement(el);
            return el.isDisplayed();
        }
        return false;
    }


}



