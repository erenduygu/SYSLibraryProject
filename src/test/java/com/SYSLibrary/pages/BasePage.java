package com.SYSLibrary.pages;

import com.SYSLibrary.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToTab(String tabName){

        Driver.get().findElement(By.xpath("//*[.='"+tabName+"']")).click();
    }
}
