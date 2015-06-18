package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkualrLoginTest extends HawkularSeleniumWebDriver {

    @BeforeSuite
    public void prepareUser() throws MalformedURLException {
        WebDriver driver = createDriver("safari", "6", "OSX 10.8", "homePage");
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        registration.registerUserIfDoesNotExist();

    }

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularLoginTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularLoginTest");

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.password);

        util = new HawkularUtils(driver);
        Assert.assertTrue(util
                .waitForElementPresent(HawkularManagementConsolePageConstants.consoleImageAltLocator));
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularLoginEmptyFieldsTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularLoginEmptyFieldsTest");

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs("",
                "");

        loginPage.verifyInvalidUsernameOrPassword();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularLoginInvalidPasswordTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularLoginEmptyFieldsTest");

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);

        loginPage = new HawkularLoginPage(driver);
        loginPage.loginAs(HawkularRegistrationPageConstants.username,
                HawkularRegistrationPageConstants.wrongPassword);

        loginPage.verifyInvalidUsernameOrPassword();
        driver.quit();
    }

}