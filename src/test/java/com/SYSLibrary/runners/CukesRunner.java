package com.SYSLibrary.runners;


import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/SYSLibrary/stepdefinitions",
        dryRun=false,
        tags="@SYS-291"
)

public class CukesRunner {
}
