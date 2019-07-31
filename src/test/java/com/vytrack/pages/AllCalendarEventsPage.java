package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllCalendarEventsPage {
    public AllCalendarEventsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    @CacheLookup
    public WebElement createCalendarEventButton;
}
