package com.SYSLibrary.stepdefinitions;

import com.SYSLibrary.utilities.*;
import io.cucumber.java.*;
import org.openqa.selenium.*;

import java.util.concurrent.*;

public class Hooks {
    @Before
    public void setUp() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");

        }
        Driver.closeDriver();
    }
}
