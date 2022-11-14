package com.castLabs.selectors;

import org.openqa.selenium.By;

public class Selectors {
    public static By chooseContainer = By.xpath("//div[@class='asset-title']");
    public static By playVideo = By.xpath("(//button[@class='pp-ui-button-22 pp-ui-button pp-ui-button-play'])[2]");
    public static By pauseVideo = By.xpath("//button[@class='pp-ui-button-22 pp-ui-button pp-ui-button-pause']");
    public static By options = By.xpath("//button[@class='pp-ui-button-22 pp-ui-button pp-ui-button-options']");
    public static By selectVideo = By.xpath("(//div[@class='pp-ui-clickable'])[3]");
    public static By chooseLogs = By.xpath("//div[@class='pp-toolbar pp-toolbar-transparent pp-sub-nav']/ul/li");
    public static By iframe = By.xpath("//div[@class='player']/div/div/div/div/div[1]/iframe[1]");
    public static By videoOptions = By.xpath("//div[@class='pp-ui-options-selection']/div[5]");
    public static By progressBar = By.xpath("//div[@class='pp-ui-bar-range-thumb pp-ui-bar-range-thumb-foreground']");
    public static By consoleLogsDetails = By.xpath("//div[@class='log-view group']");
    public static By playerContainer= By.xpath("//div[@class='player']");
    public static By videoTitle= By.xpath("(//div[@class='pp-ui-options-title'])[3]");
    public static By validateState= By.xpath("//table[@class='plot-table info-table']/tr[2]/td[2]");
    public static By bufferButton=By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[1]/div/div[4]/div[2]/div");
}
