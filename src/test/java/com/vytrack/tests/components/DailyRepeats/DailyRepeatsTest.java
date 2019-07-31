package com.vytrack.tests.components.DailyRepeats;

import com.vytrack.pages.AllCalendarEventsPage;
import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DailyRepeatsTest extends TestBase {
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
       // BrowserUtils.waitForClickablility(createCalendarEventPage.saveAndCloseButton,5);
    }

    @Test
    public void test1() throws InterruptedException {
        untilClickCreateCalendar();
        BrowserUtils.waitFor(5);
        createCalendarEventPage.repeatButton.click();
        //check if Daily is selected by default
        String daily = createCalendarEventPage.repeatOptionsList().getFirstSelectedOption().getText();
        try{
            System.out.println(daily);
            Assert.assertEquals(daily,"Daily","Do not match");
        }catch (Exception e){
            e.printStackTrace();
        }

        //verify daysRadioButton is selected
        BrowserUtils.waitForVisibility(createCalendarEventPage.daysRadioButton,5);
        try{
            if(createCalendarEventPage.daysRadioButton.isSelected()){
                System.out.println("It is selected");
            }
            Assert.assertTrue(createCalendarEventPage.daysRadioButton.isSelected());
        }catch (Exception e){
            e.printStackTrace();
        }
        //verify days box value is 1

        BrowserUtils.waitForVisibility(createCalendarEventPage.repeatDaysBox,5);
        String valueOne = createCalendarEventPage.repeatDaysBox.getAttribute("value");
        try{
            Assert.assertEquals(valueOne,"1");
        }catch (Exception e){
            e.printStackTrace();
        }
        //verify summary
        BrowserUtils.waitForVisibility(createCalendarEventPage.summary,5);
        String summaryText = "Daily every 1 day";
        try{
            System.out.println(createCalendarEventPage.summary.getText());
            Assert.assertEquals(createCalendarEventPage.summary.getText(),summaryText);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

