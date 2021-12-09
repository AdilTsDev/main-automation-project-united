package com.united.pages.searchPages;


import com.united.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.united.base.Hooks.URL;
import static com.united.base.Hooks.driver;

public class AdvancedSearchPage {

    // main container
    @FindBy(css = "div[class='atm-l-section atm-l-sidebar__main']")
    private WebElement mainContainer;

    // pet number select field
    @FindBy(css = "button[class='atm-c-accordion-panel__button atm-js-accordion-btn']")
    private List<WebElement> petInCabinButton;

    @FindBy(css = "select[name='bookFlightModel.advancedSearch.petCabin']")
    private WebElement petNumberSelect;


    // constructor
    public AdvancedSearchPage(){ PageFactory.initElements(driver, this); }

    //gitter
    public WebElement getMainContainer() { return mainContainer; }

    // pet number
    public List<WebElement> getPetInCabinButton() { return petInCabinButton; }

    public WebElement getPetNumberSelect() { return petNumberSelect; }

    //functions
    //check the pet number limit
    public void checkTheLastOptionsEqualsTo(String pet) {
        List<WebElement> options = getPetNumberSelect().findElements(By.tagName("option"));
        Common.highLightElement(options.get(options.size() - 1));
        Assert.assertEquals(options.get(options.size() - 1).getAttribute("value"), pet);
    }

    public void verifyTheAdvancedSearchPgae(){
        Common.waitUntilVisible(getMainContainer());
        String currentUrl = driver.getCurrentUrl();
        List<WebElement> labels = getMainContainer().findElements(By.tagName("label"));
        for(WebElement label : labels){
            if(label.isDisplayed()){
                Common.highLightElement(label);
                Assert.assertTrue(label.isDisplayed());
            }
        }
        Assert.assertNotEquals(URL, currentUrl);
    }


}
