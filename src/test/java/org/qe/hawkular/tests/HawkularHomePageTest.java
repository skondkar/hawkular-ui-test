package org.qe.hawkular.tests;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularHomePageTest extends HawkularSeleniumWebDriver {
    private final String testURL = "www.redhat.com";
    @BeforeSuite
    public void homePage() throws MalformedURLException {
        WebDriver driver = createDriver("firefox", "24.0", "Linux",
                "homePage");

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        try {
            // try registering hawkularqe, in case it's no yet registered
            loginPage.navigateToRegistration();

            HawkularRegistrationPage regPage = new HawkularRegistrationPage(
                    driver);
            regPage.register(HawkularRegistrationPageConstants.username,
                    HawkularRegistrationPageConstants.password,
                    HawkularRegistrationPageConstants.password,
                    HawkularRegistrationPageConstants.email,
                    HawkularRegistrationPageConstants.firstName,
                    HawkularRegistrationPageConstants.lastName);
            regPage.verifyRegCompleted();

        } catch (Exception ex) {

        } finally {
            driver.quit();
        }
    }

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularAddURLTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularAddURLTest");

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
                .waitForElementPresent(HawkularManagementConsolePageConstants.homePageImgLocator));

        System.out.print(">>>>>> This is a Add URL test");
            driver.get(HawkularSeleniumWebDriver.hawkularUrl);
     
            HawkularConsoleAddUrlPage AddUrlPage = new HawkularConsoleAddUrlPage(driver);
           
            AddUrlPage.typeURL(testURL);
            AddUrlPage.submitURL();
        driver.quit();
    }

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularMenuNavigationTest(String browser, String version, String os)
            throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "MenuNavigationTest");

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
                .waitForElementPresent(HawkularManagementConsolePageConstants.homePageImgLocator));
       
        System.out.print(">>>>>> This is Menu Vavigation Test");
            driver.get(HawkularSeleniumWebDriver.hawkularUrl);

            HawkularConsoleAddUrlPage AddUrlPage = new HawkularConsoleAddUrlPage(driver);
            AddUrlPage.urlsMenuExists();
            AddUrlPage.appServersMenuExists();
            AddUrlPage.navigateAppServersMenu();
            Assert.assertTrue(util
                .waitForElementPresent(HawkularManagementConsolePageConstants.appServersListLocator));
            AddUrlPage.navigateURLsMenu();
            Assert.assertTrue(util
                .waitForElementPresent(HawkularManagementConsolePageConstants.urlLocator));
        driver.quit();

    }
}
	
