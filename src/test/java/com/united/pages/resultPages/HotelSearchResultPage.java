package com.united.pages.resultPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class HotelSearchResultPage {
    // hotel listing container
    @FindBy(css = "#listings > ol")
    private WebElement hotelListing;

    public HotelSearchResultPage(){ PageFactory.initElements(driver, this); }

    //gitter
    public WebElement getHotelListing() { return hotelListing; }
}
