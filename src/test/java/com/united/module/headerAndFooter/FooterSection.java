package com.united.module.headerAndFooter;

import com.united.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static com.united.base.Hooks.driver;

public class FooterSection {
    @FindBy(css = "li[id='footerPanel0']")
    private WebElement aboutUnitedLink;

    @FindBy(css = "section[id='footerPanel0-panel']")
    private WebElement aboutUnitedContainer;

    @FindBy(css = "li[id='footerPanel1']")
    private WebElement productsServicesLink;

    @FindBy(css = "section[id='footerPanel1-panel']")
    private WebElement productsServiesCOntainer;

    @FindBy(css = "li[id='footerPanel2']")
    private WebElement popularDestinationsLink;

    @FindBy(css = "section[id='footerPanel2-panel']")
    private WebElement popularDesContainer;

    //constructor
    public FooterSection(){
        PageFactory.initElements(driver, this);
    }

    //getters
    public WebElement getAboutUnitedLink() {
        return aboutUnitedLink;
    }

    public WebElement getAboutUnitedContainer() {
        return aboutUnitedContainer;
    }

    public WebElement getProductsServicesLink() {
        return productsServicesLink;
    }

    public WebElement getProductsServiesCOntainer() {
        return productsServiesCOntainer;
    }

    public WebElement getPopularDestinationsLink() {
        return popularDestinationsLink;
    }

    public WebElement getPopularDesContainer() {
        return popularDesContainer;
    }

    // go through links
    public void goThroughAllTheLinks(WebElement linkTab, WebElement linkContainer){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Common.waitSecond(2);
        linkTab.click();
        Common.scrollBy(350);
        List<WebElement> links = linkContainer.findElements(By.tagName("a"));
        for(WebElement link : links){
            Common.waitHalfSecond(1);
            Common.highLightElement(link);
            Assert.assertTrue(link.isEnabled());
            Assert.assertFalse(link.getAttribute("href").isEmpty());
        }

    }

}
