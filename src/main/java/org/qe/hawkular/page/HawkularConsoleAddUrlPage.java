package org.qe.hawkular.page;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularConsoleAddUrlPage {

    public final WebDriver driver;

    By consoleImageAltLocator = HawkularManagementConsolePageConstants.consoleImageAltLocator;
    By urlLocator = HawkularManagementConsolePageConstants.urlLocator;
    By addButtonLocator = HawkularManagementConsolePageConstants.addButtonLocator;
    By urlsMenuLocator = HawkularManagementConsolePageConstants.urlsMenuLocator;
    By appServersMenuLocator = HawkularManagementConsolePageConstants.appServersMenuLocator;
    By appServersListLocator = HawkularManagementConsolePageConstants.appServersListLocator;
    By urlHeadingLocator = HawkularManagementConsolePageConstants.urlHeadingLocator;
    By addUrlMsg = HawkularManagementConsolePageConstants.addUrlMsg;
    By deleteButtonLocator = HawkularManagementConsolePageConstants.deleteButtonLocator;
    By confirmDelete = HawkularManagementConsolePageConstants.confirmDelete;

    public HawkularConsoleAddUrlPage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean verifyConsoleImagePresent() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(consoleImageAltLocator);
    }

    public HawkularConsoleAddUrlPage typeURL(String URL) {
        driver.findElement(urlLocator).sendKeys(URL);

        return this;
    }

    public HawkularConsoleAddUrlPage deleteURL() {
        try {
            driver.findElement(deleteButtonLocator).click();
            HawkularUtils util = new HawkularUtils(driver);
            util.waitForElementPresent(confirmDelete);
            driver.findElement(confirmDelete).click();
        } catch (Exception e) {
        }

        return new HawkularConsoleAddUrlPage(driver);
    }

    public HawkularConsoleAddUrlPage submitURL() {
        driver.findElement(addButtonLocator).submit();
        return new HawkularConsoleAddUrlPage(driver);
    }

    public boolean verifyAddUrlMsg() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(addUrlMsg);
    }

    public void verifyUrlExists() {
        HawkularUtils util = new HawkularUtils(driver);
        Assert.assertTrue(util.waitForElementPresent(urlHeadingLocator));
    }

    public void verifyUrlDoesnotExist() {
        boolean bool = true;
        try {
            driver.wait(5000);
            bool = driver.findElement(urlHeadingLocator).isDisplayed();
        } catch (Exception e) {
            bool = false;
        }
        Assert.assertFalse(bool);
    }

    public boolean urlsMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlsMenuLocator);
    }

    public boolean appServersMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServersMenuLocator);
    }

    public void navigateToAppServersMenu() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(appServersMenuLocator);
    }

    public void navigateToURLsMenu() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(urlsMenuLocator);
    }
    
    public void navigateToURL() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(urlHeadingLocator);
    }

    public boolean verifyAppServersMenuNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServersListLocator);
    }

    public boolean verifyURLsMenuNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlLocator);
    }

}
