package com.vytrack.tests.components.activities;

import com.vytrack.utilities.VyTrackUnits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateButtons {

    WebDriver driver;

    @BeforeMethod(description = "Browser setup")
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.get("http://qa3.vytrack.com/user/login");
        Thread.sleep(2000);
    }


    @AfterMethod(description = "Closing browser")
    public void closeBrowser() {
        // driver.quit();
    }


    @Test
    public void storeManager() throws InterruptedException {

        //TODO log in using as Store Manager a method
        VyTrackUnits.login(driver,"storemanager51","UserUser123");
        Thread.sleep(1000);



        //TODO Select Activities > Calls option using a method
        VyTrackUnits.selectMenuOption(driver,"Activities","Calls");
        //TODO Verify "Log Calls is displayed(Calling method)
        String css = "a[title='Log call']";
        Assert.assertTrue(VyTrackUnits.isElementDisplayed(driver,By.cssSelector(css)));


        Thread.sleep(2000);

        //TODO select Activities > Calendar Events
        VyTrackUnits.selectMenuOption(driver,"Activities","Calendar Events");
        //TODO Verify "Log Calls is displayed(Calling method)
       css = "a[title='Create Calendar event']";
        Assert.assertTrue(VyTrackUnits.isElementDisplayed(driver,By.cssSelector(css)));
    }



    @Test
    public void salesManagerTest() throws InterruptedException {


        //TODO log in using as Sales Manager a method
        VyTrackUnits.login(driver,"salesmanager123","UserUser123");
        Thread.sleep(1000);


        //TODO Select Activities > Calls option using a method
        VyTrackUnits.selectMenuOption(driver,"Activities","Calls");
        //TODO Verify "Log Calls is displayed(Calling method)
        String css = "a[title='Log call']";
        Assert.assertTrue(VyTrackUnits.isElementDisplayed(driver,By.cssSelector(css)));


        Thread.sleep(2000);

        //TODO select Activities > Calendar Events
        VyTrackUnits.selectMenuOption(driver,"Activities","Calendar Events");
        //TODO Verify "Log Calls is displayed(Calling method)
        css = "a[title='Create Calendar event']";
        Assert.assertTrue(VyTrackUnits.isElementDisplayed(driver,By.cssSelector(css)));


    }




}
