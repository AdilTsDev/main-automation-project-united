package com.united.pages.checkInPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class CheckInOptionsPage {

    @FindBy(css = "div.relativePosition > div > main > div > div.atm-c-tabs__header > ul")
    private WebElement CheckInOptions;

    public CheckInOptionsPage(){ PageFactory.initElements(driver, this); }

    //getters

    public WebElement getCheckInOptions() { return CheckInOptions; }
}
