package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularRegistrationTest extends HawkularSeleniumWebDriver {

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationBasicTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationBasicTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.confirmPassword,
                HawkularRegistrationPageConstants.email,
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        driver.quit();
    }

}
