package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularConsoleAddUrlPage {

    public final WebDriver driver;

    By consoleImageAltLocator = HawkularManagementConsolePageConstants.consoleImageAltLocator;

    public HawkularConsoleAddUrlPage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean verifyConsoleImagePresent() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(consoleImageAltLocator);
    }
}
