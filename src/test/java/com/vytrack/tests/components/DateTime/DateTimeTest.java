package com.vytrack.tests.components.DateTime;

import com.vytrack.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DateTimeTest extends TestBase {



    @Test(description = "Date Time, End date auto adjust")
            public void test1() throws InterruptedException {

        //configuration properties
        String url = ConfigurationReader.get("url");
        String username = ConfigurationReader.get("validUsername");
        String password = ConfigurationReader.get("validPassword");
        Driver.get().get(url);
        VyTrackUnits.login(driver,username,password);
        VyTrackUnits.selectMenuOption(driver,"Activities","Calendar Events");
        WebElement createCalendarEvent = driver.findElement(By.cssSelector("[title='Create Calendar event']"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Create Calendar event']")));
        Thread.sleep(10000);
        createCalendarEvent.click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@*='submit']")));
        Thread.sleep(10000);
        WebElement startDate = driver.findElement(By.cssSelector("[placeholder='Choose a date']"));
        startDate.clear();
        Thread.sleep(1000);
        startDate.sendKeys("Jul 29, 2020"+ Keys.ENTER);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(startDate);
        String startDat1 = startDate.getText();
        WebElement endDate = driver.findElement(By.cssSelector("input[class$='hasDatepicker']"));
        BrowserUtils.hover(endDate);
        Thread.sleep(2000);
        String endDate1=endDate.getText();
        try {
            Assert.assertEquals(startDat1, endDate1, "Dont match");

        }catch(Exception e){
            e.printStackTrace();
        }
        BrowserUtils.clickWithJS(endDate);
        Thread.sleep(2000);
        endDate1 = endDate.getText();
        startDat1=startDate.getText();
        driver.findElement(By.xpath("//button[@data-event='click' and contains(text(),'Today')]")).click();

        try{
            Assert.assertEquals(endDate1,startDat1,"Dont match");
        }catch (Exception e){
            e.printStackTrace();
        }













}
}
