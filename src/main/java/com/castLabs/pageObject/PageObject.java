package com.castLabs.pageObject;

import com.castLabs.commonFunctions.CommonFunctions;
import com.castLabs.implementations.Implementations;
import com.castLabs.selectors.Selectors;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;

public class PageObject {
    public static void clickOnHLS() throws InterruptedException {
        CommonFunctions.searchLists(Selectors.chooseContainer, "HLS clear");
    }

    public static void hoverOnPlayer() throws Exception {
        //Hover over Video PLayer
        Actions hoverAction = new Actions(Implementations.getDriver());
        WebElement playerElement = Implementations.getDriver().findElement(Selectors.playerContainer);
        hoverAction.moveToElement(playerElement).perform();
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public static void dragProgressBar(int percent) throws Exception {
        //drag the progress bar to the 70%
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        hoverOnPlayer();
        JavascriptExecutor js = (JavascriptExecutor) Implementations.getDriver();
        WebElement progressbar = Implementations.getDriver().findElement(Selectors.progressBar);
        js.executeScript("arguments[0].setAttribute('style', 'left: " + percent + "%;')", progressbar);
        progressbar.click();
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }


    public static void pauseVideo() throws Exception {
        //hover on the video and then pause the video
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        hoverOnPlayer();
        Implementations.getDriver().findElement(Selectors.pauseVideo).click();
    }

    public static void playVideo() throws Exception {
        //hover on the video and the play the video
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        hoverOnPlayer();
        Implementations.getDriver().findElement(Selectors.playVideo).click();
    }

    public static void clickOnOptions() throws Exception {
        //hover on the video and then click on the options button
        hoverOnPlayer();
        Implementations.getDriver().findElement(Selectors.options).click();
        Thread.sleep(1000);
        Implementations.getDriver().findElement(Selectors.selectVideo).click();
        Thread.sleep(1000);
    }

    public static void select1280X720() throws InterruptedException {
        //select the 1280x720 quality in the video
        WebElement m = Implementations.getDriver().findElement(Selectors.videoTitle);
        Actions actions = new Actions(Implementations.getDriver());
        actions.moveToElement(m).keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        Implementations.getDriver().findElement(Selectors.videoOptions).click();
        Thread.sleep(500);
    }
    public static void focusOnPlayer() throws Exception {
        //it will click on the video to close the option button
        Actions action = new Actions(Implementations.getDriver());
        WebElement playerContainer = Implementations.getDriver().findElement(Selectors.playerContainer);
        action.moveToElement(playerContainer, -playerContainer.getSize().getWidth() / 3, 0).click().perform();
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public static void waitIfBuffering() {
        //this will wait if the video is buffering
        Boolean isBuffering = false;
        try {
            hoverOnPlayer();
            Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            WebElement el = Implementations.getDriver().findElement(Selectors.bufferButton);
            isBuffering = true;
        } catch (Exception e) {
            isBuffering = false;
        }
        if (isBuffering) {
            WebDriverWait wait = new WebDriverWait(Implementations.getDriver(), Duration.ofSeconds(180));
            wait.until(ExpectedConditions.invisibilityOf(Implementations.getDriver().findElement(Selectors.bufferButton)));
        }
    }

    public static void validateStateChange(String logs) {
        //this will get the latest player state change details from the console logs and then print it.
        String[] validateConsoleLogs = {};
        String[] logsArray = logs.split("\n");
        for (int i = 0; i < logsArray.length; i++) {
            String log = logsArray[i];
            if (log.contains("Player state change")) {
                System.out.println(log);
                validateConsoleLogs = log.split(" ");
                break;
            }
        }
        //This will validate from the console logs and from the state which is mentioned near video
        String validateFromState = Implementations.getDriver().findElement(Selectors.validateState).getText();
        String validateFromConsoleLogs = validateConsoleLogs[7];
        Assert.assertEquals(validateFromState, validateFromConsoleLogs);
    }

    public static String consolelogs() throws InterruptedException {
        //this will get all the details from the console logs
        Implementations.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        String details = Implementations.getDriver().findElement(Selectors.consoleLogsDetails).getText();
        return details;
    }

    public static void clickOnLogs() throws InterruptedException {
        // this will click on the logs button
        CommonFunctions.searchLists(Selectors.chooseLogs, "Logs");
    }

}
