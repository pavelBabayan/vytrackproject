package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllCarsPage {
    public AllCarsPage(){
        PageFactory.initElements(Driver.get(),this);
    }



    //TODO choosing header grid: licence plate,tag,driver etc..
    public WebElement chooseHeaderGrid(String idx){
       String xpath = "//table[starts-with(@class,'grid table')]/thead/tr/th["+idx+"]";
       return Driver.get().findElement(By.xpath(xpath));
    }


    //TODO choose the number of column: under license plate, tag,driver,etc
    public List<WebElement> column(String idx){
        List<WebElement> el = Driver.get().findElements(By.xpath("//table[starts-with(@class,'grid table')]/tbody/tr/td["+idx+"]"));
        return el;
    }


    //TODO ascending order of values under header
    public void ascendingOrder(List<WebElement> element){
        ArrayList<String > nonSorted = new ArrayList<>();
        ArrayList<String > ascendOrder = new ArrayList<>();
        List<WebElement> allElements = element;
        for(WebElement el :allElements){
           // nonSorted.add(Integer.parseInt(el.getText()));
            nonSorted.add(el.getText());
        }
        for (String i : nonSorted){
                ascendOrder.add(i);
        }
        Collections.sort(ascendOrder);
        System.out.println(ascendOrder);
        System.out.println(nonSorted);
        Assert.assertEquals(nonSorted, ascendOrder, "Not in ascend order");
    }



    //TODO descending order of values under header
    public void descendingOrder(List<WebElement> element){
        ArrayList<String > nonSorted = new ArrayList<>();
        ArrayList<String > descendOrder = new ArrayList<>();
        List<WebElement> allElements = element;
        for(WebElement el :allElements) {
            //nonSorted.add(Integer.parseInt(el.getText()));
            nonSorted.add(el.getText());
        }
        for (String i : nonSorted){
            descendOrder.add(i);
        }
        Collections.sort(descendOrder);
        Collections.sort(descendOrder,Collections.reverseOrder());
        System.out.println(nonSorted);
        System.out.println(descendOrder);
        Assert.assertEquals(nonSorted,descendOrder,"Not is descent order");
    }


}
