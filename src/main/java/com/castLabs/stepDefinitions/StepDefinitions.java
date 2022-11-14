package com.castLabs.stepDefinitions;

import com.castLabs.commonFunctions.CommonFunctions;
import com.castLabs.implementations.Implementations;
import com.castLabs.pageObject.PageObject;
import com.castLabs.selectors.Selectors;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class StepDefinitions {
    @Given("navigate the page")
    public void navigateThePage() {
        CommonFunctions.navigateToPage();
    }

    @When("Play HLS - HLS Clear by clicking on the stream")
    public void ClickOnHLSClear() throws InterruptedException {
        PageObject.clickOnHLS();
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("The browser opens with the details of the video")
    public void openVideo() throws Exception {
        PageObject.waitIfBuffering();
        PageObject.pauseVideo();
    }

    @Then("Seek to {int} of the video duration")
    public void dragTheVideo(int percent) throws Exception {
        PageObject.dragProgressBar(percent);
    }

    @Then("Validate the Player state change in the console logs")
    public void consoleLogsValidation() throws Exception {
        PageObject.waitIfBuffering();
        PageObject.clickOnLogs();
        String logs2 = PageObject.consolelogs();
        PageObject.validateStateChange(logs2);
    }

    @Then("Click the options button three dots and click Videos")
    public void clickOnOptions() throws Exception {
        PageObject.clickOnOptions();
    }

    @Then("Select any video value 1280x720 and Validate the selection")
    public void selectTheQuality() throws Exception {
        PageObject.select1280X720();
        PageObject.focusOnPlayer();
        PageObject.waitIfBuffering();
        PageObject.hoverOnPlayer();
        Thread.sleep(2000);
    }

    @After
    public static void closeDriver() {
        Implementations.getDriver().quit();
    }
}

