package com.vytrack.tests.components.DateTime;

import com.vytrack.pages.AllCalendarEventsPage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DateTimeTest extends TestBase {

    LoginPage loginPage =new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    AllCalendarEventsPage allCreateCalendarEventPage = new AllCalendarEventsPage();
    CreateCalendarEventPage createCalendarEventPage  = new CreateCalendarEventPage();


    public void untilClickCreateCalendar() throws InterruptedException {

        //configuration properties
        String url = ConfigurationReader.get("url");
        String username = ConfigurationReader.get("validUsername");
        String password = ConfigurationReader.get("validPassword");
        Driver.get().get(url);

        loginPage.login(username,password);
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        BrowserUtils.waitForClickablility(allCreateCalendarEventPage.createCalendarEventButton, 5);
        BrowserUtils.clickWithJS(allCreateCalendarEventPage.createCalendarEventButton);

        BrowserUtils.waitForClickablility(createCalendarEventPage.saveAndCloseButton,5);
        driver.navigate().refresh();
    }



    @Test(description = "Date Time, End date auto adjust")
    public void test1() throws InterruptedException {

        untilClickCreateCalendar();

        String startDate = createCalendarEventPage.startDateBox.getAttribute("value");
        String endDate = createCalendarEventPage.endDateBox.getAttribute("value");

        //start date
        BrowserUtils.waitForClickablility(createCalendarEventPage.startDateBox, 5);
        createCalendarEventPage.startDateBox.clear();
        BrowserUtils.waitFor(2);
        createCalendarEventPage.startDateBox.sendKeys("Jul 29, 2020" + Keys.ENTER);
        BrowserUtils.waitForClickablility(createCalendarEventPage.startDateBox, 5);
        String startDate2 = createCalendarEventPage.startDateBox.getAttribute("value");
        //end date
        BrowserUtils.waitForClickablility(createCalendarEventPage.endDateBox, 5);
        String endDate2 = createCalendarEventPage.endDateBox.getAttribute("value");
        BrowserUtils.waitForVisibility(createCalendarEventPage.endDateBox, 5);

        //comparing
        try {
            Assert.assertEquals(endDate2, startDate2, "Dont match");

        } catch (Exception e) {
            e.printStackTrace();
        }
        //putting date back as it was
        //start date
        BrowserUtils.waitForClickablility(createCalendarEventPage.startDateBox, 5);
        createCalendarEventPage.startDateBox.clear();
        BrowserUtils.waitFor(2);
        createCalendarEventPage.startDateBox.sendKeys(startDate + Keys.ENTER);
        String startDate3 = createCalendarEventPage.startDateBox.getAttribute("value");
        //end date
        BrowserUtils.waitForClickablility(createCalendarEventPage.endDateBox, 5);
        String endDate3 = createCalendarEventPage.endDateBox.getAttribute("value");
        BrowserUtils.waitForVisibility(createCalendarEventPage.endDateBox, 5);
        //comparing dates
        try {
            Assert.assertEquals(endDate3, startDate3, "Dont match");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test(description = "Date Time, End time auto adjust")
    public void test2() throws InterruptedException {

        untilClickCreateCalendar();
        //StartTime
        BrowserUtils.waitForClickablility(createCalendarEventPage.startTimeBox, 5);
        BrowserUtils.clickWithJS(createCalendarEventPage.startTimeBox);
        //pick 1 am
        createCalendarEventPage.setStartTimeBoxPicker("am","1:00 AM");
        //EndTime
        BrowserUtils.waitForClickablility(createCalendarEventPage.endTimeBox, 5);
        BrowserUtils.doubleClick(createCalendarEventPage.endTimeBox);
        BrowserUtils.waitForVisibility(createCalendarEventPage.endTimeBox, 5);
        //comparing end time
        try {
            Assert.assertEquals(createCalendarEventPage.endTimeBox.getAttribute("value"), "2:00 AM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test(description = "Date Time, End date/time auto adjust")
    public void test3() throws InterruptedException {

        untilClickCreateCalendar();

        //StartTime
        BrowserUtils.waitForClickablility(createCalendarEventPage.startTimeBox, 5);
        BrowserUtils.clickWithJS(createCalendarEventPage.startTimeBox);
        //pick 11:00 PM
        createCalendarEventPage.setStartTimeBoxPicker("pm","11:30 PM");

        //EndTime
        BrowserUtils.waitForClickablility(createCalendarEventPage.endTimeBox, 5);
        BrowserUtils.doubleClick(createCalendarEventPage.endTimeBox);
        BrowserUtils.waitForVisibility(createCalendarEventPage.endTimeBox, 5);
        String expectedEndTime = "12:30 AM";
        String actualEndTime = createCalendarEventPage.endTimeBox.getAttribute("value");

        //End Date
        BrowserUtils.waitForClickablility(createCalendarEventPage.endDateBox, 5);
        String endDate = createCalendarEventPage.endDateBox.getAttribute("value");
        String expectedEndDate = BrowserUtils.dateTime(driver,"date",1);
        BrowserUtils.waitForClickablility(createCalendarEventPage.endDateBox, 5);
        try {
            Assert.assertEquals(endDate, expectedEndDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(actualEndTime, expectedEndTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}







