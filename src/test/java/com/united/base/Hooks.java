package com.united.base;

import com.united.utils.BrowserManager;
import com.united.utils.Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static String URL = "https://www.united.com/en/us";

    @Before
    public void setUp(){
        driver = BrowserManager.setDriver("chrome");
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @After
    public void ending(){
        Common.waitSecond(1);
        driver.quit();
    }
}
