package com.united.module.headerAndFooter;


import com.united.utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static com.united.base.Hooks.driver;

public class HeaderSection {
    @FindBy(css = "button[aria-label='Currently in English United States\t$ enter to change']")
    private WebElement languageLinks;

    @FindBy(xpath = "//*[@id=\"localization-language-selector\"]")
    private WebElement languageButton;

    @FindBy(xpath = "//*[@id=\"localization-content-wrapper\"]/div[2]/div[1]/div/div/ul/li")
    private List<WebElement> languageSelect;

    @FindBy(xpath = "//*[@id=\"localization-content-wrapper\"]/div[3]/button")
    private WebElement changeButton;

    //advisory
    @FindBy(css = "#app > div > div > div > div.page > div:nth-child(3) > div a")
    private List<WebElement> linksInAdvisory;


    public HeaderSection(){
        PageFactory.initElements(driver, this);
    }

    //getters

    public WebElement getLanguageLinks() {
        return languageLinks;
    }

    public List<WebElement> getLanguageSelect() {
        return languageSelect;
    }

    public WebElement getChangeButton() {
        return changeButton;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public List<WebElement> getLinksInAdvisory() {
        return linksInAdvisory;
    }

    public void switchTo(String language){
        for(WebElement il : getLanguageSelect()){
            if(il.getText().equals(language)){
                Common.highLightElement(il);
                il.click();
            }
        }
        Common.waitSecond(1);
        getChangeButton().click();

    }


}
