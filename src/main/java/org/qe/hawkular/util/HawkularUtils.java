package org.qe.hawkular.util;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;

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

    public boolean waitForElementPresent(By element) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

  

}
