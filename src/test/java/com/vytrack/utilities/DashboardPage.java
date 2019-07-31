package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class DashboardPage {


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



    //TODO return false when element is not found
    public static boolean isElementDisplayed(WebDriver driver, By by) {
        try {
            System.out.println(driver.findElement(by).getText());
            return driver.findElement(by).isDisplayed();


        } catch (NoSuchElementException e) {
            return false;
        }
    }
}





