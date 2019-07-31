package com.vytrack.tests.components.Vehicles;

import com.vytrack.pages.AllCarsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultOrder extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AllCarsPage allCarsPage = new AllCarsPage();

    public void untilAllCarsTitle(){

        String url = ConfigurationReader.get("url");
       String username = ConfigurationReader.get("validUsername");
       String password = ConfigurationReader.get("validPassword");

       driver.get(url);
       loginPage.login(username,password);
       wait.until(ExpectedConditions.titleIs("Dashboard"));
       dashboardPage.selectMenuOption("Fleet","Vehicles");
    }

    @Test(description = "Verify default order")
    public void test1(){

        untilAllCarsTitle();
        wait.until(ExpectedConditions.titleIs("All - Car - Entities - System - Car - Entities - System"));

        //verify that license plate values in ascending order
        allCarsPage.chooseHeaderGrid("2").click();
        BrowserUtils.waitFor(1);
        allCarsPage.ascendingOrder(allCarsPage.column("2"));
       // WebElement wait = allCarsPage.chooseHeaderGrid("2");
       BrowserUtils.waitForVisibility(allCarsPage.chooseHeaderGrid("2"),5);

       //verify that license plate values in descending order
        allCarsPage.chooseHeaderGrid("2").click();
        BrowserUtils.waitFor(2);
        allCarsPage.descendingOrder(allCarsPage.column("2"));





    }


}
