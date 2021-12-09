package com.united.module.headerAndFooter;

import com.united.utils.Common;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.united.base.Hooks.driver;

public class SecondHeader {

    // all  the second teabs
    @FindBy(css = "div[role='tablist'] span")
    private List<WebElement> secondHeaderTabs;

    // book tab
    @FindBy(css = "#headerNav0-panel > div > div > ul > li")
    private List<WebElement> linksPanelsInBook;
    //11

    //MY TRIPS tab
    @FindBy(css = "#headerNav1-panel > div > div > ul > li")
    private List<WebElement>linkInMyTrips;
    //12

    // travel info
    @FindBy(css = "#headerNav2-panel > div > div > ul > li")
    private List<WebElement>linksInTravelInfo;
    //15

    //program
    @FindBy(css = "#headerNav3-panel > div > div > ul > li")
    private List<WebElement> linksInPrograms;
    //14

    @FindBy(css = "#headerNav4-panel > div > div > ul > li")
    private List<WebElement> linksINDeals;
    //12

    @FindBy(css = "#headerNav5-panel > div > div > ul > li")
    private List<WebElement> linksInHelp;
    //22




    public SecondHeader(){
        PageFactory.initElements(driver, this);
    }

    //getters
    public List<WebElement> getSecondHeaderTabs() {
        return secondHeaderTabs;
    }

    public List<WebElement> getLinksPanelsInBook() {
        return linksPanelsInBook;
    }

    public List<WebElement> getLinkInMyTrips() {
        return linkInMyTrips;
    }

    public List<WebElement> getLinksInTravelInfo() {
        return linksInTravelInfo;
    }

    public List<WebElement> getLinksInPrograms() {
        return linksInPrograms;
    }

    public List<WebElement> getLinksINDeals() {
        return linksINDeals;
    }

    public List<WebElement> getLinksInHelp() {
        return linksInHelp;
    }

    //fictions
    public void allTabsShouldDisplayCorrectPanels(){
        Common.waitUntilAllVisible(getSecondHeaderTabs());
        for(WebElement tab : getSecondHeaderTabs()){
            Common.waitSecond(2);
            tab.click();
            Common.waitSecond(2);
            if(tab.getText().equals("BOOK")){
                Assert.assertEquals(getLinksPanelsInBook().size(), 11);
            }
            if(tab.getText().equals("MY TRIPS")){
                Assert.assertEquals(getLinkInMyTrips().size(), 12);
            }
            if(tab.getText().equals("TRAVEl INFO")){
                Assert.assertEquals(getLinksInTravelInfo().size(), 15);
            }
            if(tab.getText().equals("MILEAGEPLUS® PROGRAM")){
                Assert.assertEquals(getLinksInPrograms().size(), 14);
            }
            if(tab.getText().equals("DEALS")){
                Assert.assertEquals(getLinksINDeals().size(), 12);
            }
            if(tab.getText().equals("HELP")){
                Assert.assertEquals(getLinksInHelp().size(), 22);
            }
        }


    }
}
