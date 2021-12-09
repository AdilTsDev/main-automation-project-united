package com.united.pages.resultPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.united.base.Hooks.driver;

public class PackageResultPage {

    @FindBy(xpath = "//*[@id='listingContent']/div/div/div/div[3]/div")
    private WebElement packageResultContainer;

    //constructor
    public PackageResultPage(){ PageFactory.initElements(driver, this); }

    //getter
    public WebElement getPackageResultContainer() { return packageResultContainer; }
}
