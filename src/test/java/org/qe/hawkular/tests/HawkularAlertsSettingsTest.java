package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularAlertsSettingsTest extends HawkularSeleniumWebDriver {
    @BeforeSuite
    public void prepateUser() throws MalformedURLException {
        WebDriver driver = createDriver("firefox", "24.0", "Linux", "homePage");
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        registration.registerUserIfDoesNotExist();

    }

}
