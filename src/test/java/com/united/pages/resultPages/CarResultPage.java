package com.united.pages.resultPages;

import com.united.utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
import static com.united.base.Hooks.driver;


public class CarResultPage {

    @FindBy(css = "#ct-search-results > div.ct-availability-container.ct-padding-bottom")
    private WebElement carResultContainer;

    @FindBy(css = "div[ng-if='::$ctrl.message']")
    private List<WebElement> milesTagOfEach;

    @FindBy(css = "#ct-availability-list-no-result > div > div.ct-panel-content.ct-padding > div:nth-child(1) > p")
    private WebElement errorMessage;

    //constructor
    public CarResultPage(){ PageFactory.initElements(driver, this); }

    //getters
    public WebElement getCarResultContainer() { return carResultContainer; }

    public List<WebElement> getMilesTagOfEach() { return milesTagOfEach; }

    public WebElement getErrorMessage() { return errorMessage; }

    //functions
    //miles tag displayed at every result
    public void verifyAllTheMilesTagIsDisplayed() {
        for(WebElement each : getMilesTagOfEach()){
            Common.highLightElement(each);
            Common.waitHalfSecond(1);
            Assert.assertTrue(each.isDisplayed());
        }
    }
    // under 21 error message
    public void verifyThatUnder21ErrorMessage() {
        Common.waitUntilVisible(getErrorMessage());
        String errorMessage = "Some car rental suppliers do not rent to young drivers." +
                " If you are travelling with an older person," +
                " it may help to make them your main driver.";
        Assert.assertEquals(getErrorMessage().getText(), errorMessage);
    }
    // 21 no result message
    public void verifyThatNoResultMessage() {
        Common.waitUntilVisible(getErrorMessage());
        String errorMessage = "We couldn't find any results matching your criteria," +
                " but changing your search may help.";
        Assert.assertEquals(getErrorMessage().getText(), errorMessage);
    }
}
