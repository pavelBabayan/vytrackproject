package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class MenuOptionsTest {

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
    public void closeBrowser(){
       // driver.quit();
    }


    @Test(priority = 2)
    public void driver() throws InterruptedException {
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("user16");
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123"+Keys.ENTER);
        Thread.sleep(2000);

        //TODO mouse move
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector("#main-menu>ul>li>a>span"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicles")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName = "Cars";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName,actualPageName);


        Thread.sleep(2000);


        builder.moveToElement(driver.findElement(By.linkText("Customers"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Accounts")).click();
        Thread.sleep(2000);
        //TODO compare URL
        String expectedTitle2 = "Accounts - Customers";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName2 = "Accounts";
        String actualPageName2 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName2,actualPageName2);

        Thread.sleep(2000);

        builder.moveToElement(driver.findElement(By.linkText("Customers"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Contacts")).click();
        Thread.sleep(2000);
        //TODO compare URL
        String expectedTitle3 = "Contacts - Customers";
        String actualTitle3 = driver.getTitle();
        Assert.assertEquals(expectedTitle3,actualTitle3);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName3 = "Contacts";
        String actualPageName3 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName3,actualPageName3);

        Thread.sleep(4000);

     driver.findElement(By.linkText("Activities")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(3000);
        //TODO compare URL
        String expectedTitle4 = "Calendar Events - Activities";
        String actualTitle4 = driver.getTitle();
        Assert.assertEquals(expectedTitle4,actualTitle4);
        Thread.sleep(3000);
        //TODO verify title
        String expectedPageName4 = "Calendar Events";
        String actualPageName4 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName4,actualPageName4);

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void storeManager() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id='prependedInput'][class='span2']")).sendKeys("storemanager61");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).submit();
        Thread.sleep(2000);

        //==============================================================================================================
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[1]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Dashboard")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle = "Dashboard - Dashboards";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName = "Dashboard";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName,actualPageName);

        Thread.sleep(2000);
//======================================================================================================================
        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[2]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicles")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle2 = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName2 = "All Cars";
        String actualPageName2 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName2,actualPageName2);

        Thread.sleep(2000);
        //==============================================================================================================

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Accounts")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle3 = "All - Accounts - Customers";
        String actualTitle3 = driver.getTitle();
        Assert.assertEquals(expectedTitle3,actualTitle3);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName3 = "All Accounts";
        String actualPageName3 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName3,actualPageName3);

        Thread.sleep(2000);
        //==============================================================================================================

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Contacts")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle4 = "All - Contacts - Customers";
        String actualTitle4 = driver.getTitle();
        Assert.assertEquals(expectedTitle4,actualTitle4);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName4 = "All Contacts";
        String actualPageName4 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName4,actualPageName4);

        Thread.sleep(2000);
        //==============================================================================================================

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[4]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Opportunities")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle5 = "Open Opportunities - Opportunities - Sales";
        String actualTitle5 = driver.getTitle();
        Assert.assertEquals(expectedTitle5,actualTitle5);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName5 = "Open Opportunities";
        String actualPageName5 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName5,actualPageName5);

        Thread.sleep(2000);
        //==============================================================================================================

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[5]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Calls")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle6 = "All - Calls - Activities";
        String actualTitle6 = driver.getTitle();
        Assert.assertEquals(expectedTitle6,actualTitle6);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName6 = "All Calls";
        String actualPageName6 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName6,actualPageName6);

        Thread.sleep(2000);
        //==============================================================================================================

        builder.moveToElement(driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[5]"))).build().perform();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Calendar Events")).click();

        Thread.sleep(2000);

        //TODO compare URL
        String expectedTitle7 = "All - Calendar Events - Activities";
        String actualTitle7 = driver.getTitle();
        Assert.assertEquals(expectedTitle7,actualTitle7);
        Thread.sleep(2000);
        //TODO verify title
        String expectedPageName7 = "All Calendar Events";
        String actualPageName7 = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName7,actualPageName7);

        Thread.sleep(2000);
        //=============================================================================================================
    }
}

