package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAlertsSettingsPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularAlertsSettingsTest extends HawkularSeleniumWebDriver {
    
    @BeforeSuite
    public void prepareUser() throws MalformedURLException {
        WebDriver driver = createDriver("safari", "6", "OSX 10.8", "homePage");
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        registration.registerUserIfDoesNotExist();

    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularAlertsSettingsTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularAlertsSettingsTest");
        
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        addUrlPage.typeURL(HawkularManagementConsolePageConstants.testURL);
        addUrlPage.submitURL();
        addUrlPage.verifyUrlExists();
        addUrlPage.navigateToURL();
        
        HawkularAlertsSettingsPage alertsSettings = new HawkularAlertsSettingsPage(driver);
        alertsSettings.navigateToAllAlerts();
        alertsSettings.verifyAllAlertsLinkPresent();
        alertsSettings.navigateToAlertsSettings();
        alertsSettings.verifyAlertSettingsOpened();
        
        driver.quit();
        
    }
}
