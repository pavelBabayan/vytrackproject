package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class VyTrackUnits {


    //TODO Verify if Equals
    public static void verifyEquals(String expected, String actual){
        if (expected.equals(actual)) {
            System.out.println("PASS");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }

    }

    //TODO LOGIN Method
    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys(username);
        driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys(password + Keys.ENTER);
    }

    //TODO return false when element is not found
    public static boolean isElementDisplayed(WebDriver driver, By by) {
        try {
            System.out.println(driver.findElement(by).getText());
            return driver.findElement(by).isDisplayed();


        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static void selectMenuOption(WebDriver driver, String tab, String module) throws InterruptedException {

        Actions build = new Actions(driver);


        // move to tab Module
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '"+tab+"')]";
        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tabXpath)));

        Thread.sleep(20000);
        build.moveToElement(driver.findElement(By.xpath(tabXpath))).build().perform();

        // click on module
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '"+module+"')]";
        Thread.sleep(3000);
        driver.findElement(By.xpath(moduleXpath)).click();

    }
}





