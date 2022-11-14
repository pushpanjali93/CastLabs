package com.castLabs.commonFunctions;

import com.castLabs.implementations.Implementations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFunctions {
    public static void navigateToPage() {
        try {
            Implementations.getDriver().get("http://demo.castlabs.com/");
            Implementations.getDriver().manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void searchLists(By search,String searchItem) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> searchLists = Implementations.getDriver().findElements(search);
        System.out.println(searchLists.size());
        for (int i = 0; i < searchLists.size(); i++) {
            System.out.println(searchLists.get(i).getText());
            if (searchLists.get(i).getText().equalsIgnoreCase(searchItem)) {
                searchLists.get(i).click();
                break;
            }
            Implementations.scrollThePage(0,200);
        }
        Thread.sleep(5000);
    }
}
