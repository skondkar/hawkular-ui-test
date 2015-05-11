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

    public HawkularConsoleAddUrlPage submitURL() {
        driver.findElement(addButtonLocator).submit();
        return new HawkularConsoleAddUrlPage(driver);
    }    

}
