package com.united.pages.checkInPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class CheckInProcessDetailPage {

    @FindBy(css = "#main-content > h1")
    private WebElement headerTextOfThePage;

    public CheckInProcessDetailPage(){ PageFactory.initElements(driver, this);}

    public WebElement getHeaderTextOfThePage() { return headerTextOfThePage; }
}
