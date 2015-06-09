package org.qe.hawkular.page;

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
        driver.findElement(deleteButtonLocator).click();
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

    public boolean verifyUrlExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlHeadingLocator);
    }
    
    public boolean verifyUrlDoesnotExist() {
        return !driver.findElement(urlHeadingLocator).isDisplayed();
    }
    
    public boolean urlsMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlsMenuLocator);
    }

    public boolean appServersMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServersMenuLocator);
    }


    public void navigateToAppServersMenu(){
        HawkularUtils utils = new HawkularUtils(driver);
         utils.navigateTo(appServersMenuLocator);
    }

    public void navigateToURLsMenu(){
        HawkularUtils utils = new HawkularUtils(driver);
         utils.navigateTo(urlsMenuLocator);
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
