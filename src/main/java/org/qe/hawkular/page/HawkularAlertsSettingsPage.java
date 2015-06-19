package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertsSettingsConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAlertsSettingsPage {
    public final WebDriver driver;

    By allAlertsLink = HawkularAlertsSettingsConstants.allAlertsLink;
    By alertsSettingsLink = HawkularAlertsSettingsConstants.alertsSettingsLink;
    By emailField = HawkularAlertsSettingsConstants.emailField;
    By responseTimeField = HawkularAlertsSettingsConstants.responseTimeField;

    public HawkularAlertsSettingsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToAllAlerts() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(allAlertsLink);
    }

    public void navigateToAlertsSettings() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(alertsSettingsLink);
    }

    public void verifyAllAlertsLinkPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(allAlertsLink);
        Assert.assertTrue(driver.findElement(allAlertsLink).isDisplayed());
    }

    public void verifyAlertSettingsOpened() {
        verifyAlertsSettingsEmailFieldPresent();
        verifyAlertsSettingsResponseTimeFieldPresent();
    }

    public void verifyAlertsSettingsEmailFieldPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(emailField);
        Assert.assertTrue(driver.findElement(emailField).isDisplayed());

    }
    
    public void verifyAlertsSettingsResponseTimeFieldPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(responseTimeField);

    }
    
    public void verifyAlertsSettingsResponseEnabled() {

    }
}
