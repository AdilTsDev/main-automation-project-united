package com.united.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.united.base.Hooks.driver;

public class Common {
    // exp  waits
    public static void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilAllVisible(List<WebElement> element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public static void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //high light element
    public static void highLightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow;" +
                " border: 1px solid red;');", element);
    }

    // scroll page
    public static void scrollBy(int range){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + range + ")");
    }

    //wait seconds
    public static void waitSecond(int second) {
        try {
            Thread.sleep(1000L * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitHalfSecond(int second) {
        try {
            Thread.sleep(500L * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // switch to new tab
    public static void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    // get current url
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
