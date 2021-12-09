package com.united.pages.resultPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.united.base.Hooks.driver;

public class FlightResultPage {

    // main search results container
    @FindBy(id = "flightResults-content")
    private List<WebElement> mainResultsSection;

    @FindBy(xpath = "//*[@id=\"flightResults-content\"]/div[1]/div/div/div/div[1]/div[2]")
    private WebElement searchResultInfo;

    // constructor
    public FlightResultPage(){
        PageFactory.initElements(driver, this);
    }

    //getters
    public WebElement getSearchResultInfo() {
        return searchResultInfo;
    }

    public List<WebElement> getMainResultsSection() {
        return mainResultsSection;
    }
}
