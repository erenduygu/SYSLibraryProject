package com.SYSLibrary.stepdefinitions;

import com.SYSLibrary.pages.*;
import com.SYSLibrary.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.*;

public class AddBookStepDefs {

    AddBookPage addBookPage = new AddBookPage();


    @Given("the user navigate to {string} tab")
    public void the_user_navigate_to_tab(String string) {
        addBookPage.navigateToTab("Books");

    }

    @Given("the user click on Add Book button")
    public void the_user_click_on_Add_Book_button() {
        addBookPage.addBookButton.click();
    }

    @Given("the user add new book using following information")
    public void the_user_add_new_book_using_following_information(Map<String, String> enteredInfo) {
        addBookPage.bookNameBox.sendKeys(enteredInfo.get("Book Name"));
        addBookPage.ISBNBox.sendKeys(enteredInfo.get("ISBN"));
        addBookPage.yearBox.sendKeys(enteredInfo.get("Year"));
        addBookPage.authorBox.sendKeys(enteredInfo.get("Author"));
        Select bookCategoryDropdown = new Select(addBookPage.bookCategoryBox);
        bookCategoryDropdown.selectByVisibleText(enteredInfo.get("Book Category"));
        addBookPage.descriptionBox.sendKeys(enteredInfo.get("Description"));
        addBookPage.saveChangesButton.click();
        BrowserUtils.waitForPageToLoad(20);

    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedText) {
        String actualText = Driver.get().findElement(By.className("toast-message")).getText();
        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);
        BrowserUtils.waitForPageToLoad(20);

        Assert.assertEquals("Verify the messages are the same", expectedText, actualText);

    }

    @Then("{string} message should be displayed under Book Name, Year or Author")
    public void message_should_be_displayed_under_Book_Name_Year_or_Author(String expectedText) {
        String actualText1 = addBookPage.nameErrorMessage.getText();
        String actualText2 = addBookPage.yearErrorMessage.getText();
        String actualText3 = addBookPage.authorErrorMessage.getText();

        Assert.assertTrue(expectedText.equals(actualText1) || expectedText.equals(actualText2) || expectedText.equals(actualText3));
    }


    @When("the user enters {string}{string}{string}{string}{string}{string} information")
    public void the_user_enters_information(String bookName, String ISBN, String year, String author, String bookCategory, String description) throws InterruptedException {
        addBookPage.bookNameBox.clear();
        addBookPage.bookNameBox.sendKeys(bookName);
        addBookPage.ISBNBox.clear();
        addBookPage.ISBNBox.sendKeys(ISBN);
        addBookPage.yearBox.clear();
        addBookPage.yearBox.sendKeys(year);
        addBookPage.authorBox.clear();
        addBookPage.authorBox.sendKeys(author);
        addBookPage.descriptionBox.clear();
        addBookPage.descriptionBox.sendKeys(description);
        Thread.sleep(3000);
        addBookPage.saveChangesButton.click();

    }

    @Then("{string} message should not be displayed")
    public void message_should_not_be_displayed() {
        Assert.assertFalse(Driver.get().findElement(By.className("toast-message")).isDisplayed());
    }

    @Given("Add book should have following parameters")
    public void add_book_should_have_following_parameters(List<String> expectedAddBookParameters) {

//        ArrayList<String> parameterNames = new ArrayList<>(Arrays.asList("Book Name", "ISBN", "Year", "Author", "Book Category", "Description"));
//
//        List<String> actualAddBookParameters = new ArrayList<>();
//        for (String parameterName : parameterNames) {
//            actualAddBookParameters.add(Driver.get().findElement(By.xpath("//div/label[.='"+parameterName+"']")).getText());
//        }
//        System.out.println(expectedAddBookParameters);
//        System.out.println(actualAddBookParameters);


        List<WebElement> fields = Driver.get().findElements(By.xpath("//*[@class='form-body']//label"));
        List<String> actualList = BrowserUtils.getElementsText(fields);
        System.out.println(expectedAddBookParameters);
        System.out.println(actualList);

        Assert.assertEquals("verify book categories are the same", expectedAddBookParameters, actualList);
    }

    @Given("Following categories should be present")
    public void following_categories_should_be_present(List<String> expectedBookCategories) {
            Select bookCategories = new Select(addBookPage.bookCategoryBox);
            List<WebElement> categories = bookCategories.getOptions();
//
//        List<String> actualBookCategories = new ArrayList<>();
//        for (WebElement category : categories) {
//            actualBookCategories.add(category.getText());
//        }

        List<String> actualBookCategories= BrowserUtils.getElementsText(categories);

        System.out.println(expectedBookCategories);
        System.out.println(actualBookCategories);

        Assert.assertEquals("Verify book category list", expectedBookCategories, actualBookCategories);
    }

}
