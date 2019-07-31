package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        //TODO have to add this all the time
        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,20);
    }

    //TODO collin method from Driver to close driver
    @AfterMethod
    public void closingBrowser() throws InterruptedException {
       // Thread.sleep(5000);
       // Driver.closeDriver();
    }
}
