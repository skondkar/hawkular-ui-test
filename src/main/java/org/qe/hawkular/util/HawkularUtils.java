package org.qe.hawkular.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HawkularUtils {

    WebDriver driver;

    public HawkularUtils(WebDriver driver) {

        this.driver = driver;

    }

    public boolean assertTitle(String title) {

        return driver.getTitle().equals(title);
    }

    public void navigateTo(By navigationLink) {
        driver.findElement(navigationLink).click();
    }
}
