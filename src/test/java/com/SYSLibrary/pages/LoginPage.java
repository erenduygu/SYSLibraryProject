package com.SYSLibrary.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage extends BasePage {

    @FindBy(id="inputEmail")
    public WebElement username;

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submit;


    public void login(String userNameStr, String passwordStr) throws InterruptedException {

        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }

}
