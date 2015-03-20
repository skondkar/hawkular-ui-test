package org.qe.hawkular.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.util.BrowsersAndOs;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkualrLoginTest extends HawkularSeleniumWebDriver {

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularLoginTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os, "hawkularGuiTest");

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularLoginPageConstants.login,
                HawkularLoginPageConstants.password);
        driver.quit();
    }

}