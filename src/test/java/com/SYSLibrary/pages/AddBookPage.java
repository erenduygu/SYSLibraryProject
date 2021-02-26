package com.SYSLibrary.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class AddBookPage extends BasePage {

    @FindBy(css = "a[class*='add_book_btn']")
    public WebElement addBookButton;

    @FindBy(xpath = "//*[@placeholder='Book Name']")
    public WebElement bookNameBox;

    @FindBy(xpath = "//*[@placeholder='ISBN']")
    public WebElement ISBNBox;

    @FindBy(xpath = "//*[@placeholder='Year']")
    public WebElement yearBox;


    @FindBy(xpath = "//*[@placeholder='Author']")
    public WebElement authorBox;


    @FindBy(id = "book_group_id")
    public WebElement bookCategoryBox;

    @FindBy(id = "description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement saveChangesButton;

    @FindBy(id = "author-error")
    public WebElement authorErrorMessage;

    @FindBy(id = "name-error")
    public WebElement nameErrorMessage;

    @FindBy(id = "year-error")
    public WebElement yearErrorMessage;

}
