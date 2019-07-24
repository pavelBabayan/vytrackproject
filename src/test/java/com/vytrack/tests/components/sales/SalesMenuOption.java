package com.vytrack.tests.components.sales;

import com.vytrack.utilities.VyTrackUnits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesMenuOption {

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

    @Test(priority = 1,description = "Store Manager")
    public void storeManagerTest() throws InterruptedException {

        //TODO using login method to login in utilities package
        VyTrackUnits.login(driver,"storemanager61","UserUser123");

        //TODO verify if "Sales" module is displayed
        String xpath = "//span[@class='title title-level-1' and contains(text(), 'Sales')]";

        //TODO assertTrue and call the method
        Assert.assertTrue(VyTrackUnits.isElementDisplayed(driver,By.xpath(xpath)));

    }




    @Test(priority = 2,description = "Driver")
    public void driverTest() throws InterruptedException {

        //TODO this case is different , because we are verifying  what DOES NOT exist on the page

        //TODO using login method to login in utilities package
        VyTrackUnits.login(driver,"user16","UserUser123");


        //TODO verify if "Sales" module is NOT displayed
        String xpath = "//span[@class='title title-level-1' and contains(text(), 'Sales')]";

        //TODO assertFalse nad call the method
        Assert.assertFalse(VyTrackUnits.isElementDisplayed(driver,By.xpath(xpath)));

    }



}

