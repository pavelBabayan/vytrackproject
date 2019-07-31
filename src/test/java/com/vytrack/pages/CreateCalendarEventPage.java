package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateCalendarEventPage {

    public CreateCalendarEventPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Save and Close')]")
    @CacheLookup
    public WebElement saveAndCloseButton;


    @FindBy(css = "[placeholder='Choose a date']")
    @CacheLookup
    public WebElement startDateBox;

    @FindBy(css = "[class$='end hasDatepicker']")
    @CacheLookup
    public WebElement endDateBox;

    @FindBy(css = "[placeholder='time']")
    @CacheLookup
    public WebElement startTimeBox;

    @FindBy(css = ".control-group.end.control-group-datetime div:nth-of-type(2) input:nth-of-type(2)")
    @CacheLookup
    public WebElement endTimeBox;


    @FindBy(css = "[data-name='recurrence-repeat']")
    @CacheLookup
    public WebElement repeatButton;

    @FindBy(css = ".recurrence-repeats__select")
    @CacheLookup
    public WebElement repeatOptions;

    @FindBy(xpath = "//div[@data-name='control-sections']//div[1]//input[1]")
    @CacheLookup
    public WebElement daysRadioButton;

    @FindBy(xpath = "//div[@data-name='control-sections']//div[1]//input[3]")
    @CacheLookup
    public WebElement repeatDaysBox;


    @FindBy(css = "[data-name='recurrence-summary']>div>span")
    @CacheLookup
    public WebElement summary;










    //TODO Select option for Repeat Box
    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }


    //TODO method for picking a time from start time box
    public void setStartTimeBoxPicker(String amOrPm,String startTime){
        WebElement startTimePicker = Driver.get().findElement(By.xpath("//li[@class='ui-timepicker-"+amOrPm+"' and contains(text(),'"+startTime+"')]"));
        startTimePicker.click();
    }

    //TODO method for picking a time from end time box
    public void setEndTimeBoxPicker(String amOrPm,String endTime){
        WebElement endTimePicker = Driver.get().findElement
                (By.xpath("//div[@class='ui-timepicker-wrapper ui-timepicker-positioned-top'][2]/ul//li[@class='ui-timepicker-"+amOrPm+"' and contains(text(),'"+endTime+"')]"));
        endTimePicker.click();
    }
}
