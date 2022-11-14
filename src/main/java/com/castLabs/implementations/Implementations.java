package com.castLabs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implementations {
    static WebDriver driver;
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pushpanjali.dokania\\chrome driver extensions\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static void scrollThePage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) Implementations.getDriver();
        js.executeScript("window.scrollBy(+" + x + "," + y + ")");
    }
}
