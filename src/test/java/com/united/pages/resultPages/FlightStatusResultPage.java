package com.united.pages.resultPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.united.base.Hooks.driver;

public class FlightStatusResultPage {

    @FindBy(css = " div.app-components-flifo-ResultsTable-resultsTable__resultsTable--35H6x")
    private WebElement StatusResultsContainer;

    //constructor
    public FlightStatusResultPage(){
        PageFactory.initElements(driver, this);
    }

    //getters
    public WebElement getStatusResultsContainer() { return StatusResultsContainer; }


}
