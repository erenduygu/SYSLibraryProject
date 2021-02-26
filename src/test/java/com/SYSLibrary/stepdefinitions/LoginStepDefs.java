package com.SYSLibrary.stepdefinitions;

import com.SYSLibrary.pages.*;
import com.SYSLibrary.utilities.*;
import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

public class LoginStepDefs {

    @When("the user logged in as a {string}")
    public void the_user_logged_in_as_a(String usertype) throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));

        String username=null;
        String password=null;

        switch (usertype) {

            case "student":
                username= ConfigurationReader.get("student_username");
                password= ConfigurationReader.get("student_password");
                break;
            case "librarian":
                username= ConfigurationReader.get("librarian_username");
                password= ConfigurationReader.get("librarian_password");
                break;

        }
        new LoginPage().login(username, password);
        Thread.sleep(3000);

    }


    @Then("the page title should be {string}")
    public void the_page_title_should_be(String title) throws InterruptedException {

        String pageTitle= Driver.get().getTitle();
        System.out.println("pageTitle = " + pageTitle);

       Assert.assertEquals("Verify page title is "+title+"",title,pageTitle);
    }

}
