package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class HawkularAppServerTest extends HawkularSeleniumLocalWebDriver {

    @BeforeSuite
    public void prepareUser() throws MalformedURLException {
        WebDriver driver = createLocalDriver();
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username2, HawkularRegistrationPageConstants.password2, HawkularRegistrationPageConstants.confirmPassword2, HawkularRegistrationPageConstants.firstName2, HawkularRegistrationPageConstants.lastName2, HawkularRegistrationPageConstants.email2);

    }

    @Test
    public void hawkularAppServerInventoryTest() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        HawkularAppServerPage appServerPage = new HawkularAppServerPage(driver);
        addUrlPage.navigateToAppServersMenu();
        addUrlPage.verifyAppServersMenuNavigation();
        appServerPage.verifyLocalAppServerExists();
        appServerPage.navigateTOLocalAppServer();
        appServerPage.verifyAppServerJVMTabNavigation();
        driver.quit();
        
    }
    
    @Test
    public void hawkularAppServerDeploymentsTest() throws Exception {
        WebDriver driver = createLocalDriver();

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());
        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        HawkularUtils util = new HawkularUtils(driver);
        util.assertTitle(HawkularLoginPageConstants.loginTitle);
        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
                HawkularRegistrationPageConstants.password2);

        HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
                driver);
        addUrlPage.verifyConsoleImagePresent();
        HawkularAppServerPage appServerPage = new HawkularAppServerPage(driver);
        addUrlPage.navigateToAppServersMenu();
        addUrlPage.verifyAppServersMenuNavigation();
        appServerPage.verifyLocalAppServerExists();
        appServerPage.navigateTOLocalAppServer();
        appServerPage.verifyAppServerJVMTabNavigation();
        appServerPage.navigateTODeploymentsTab();
        appServerPage.verifyAppServerDeploymentsTabNavigation();
        appServerPage.verifyAppServerWarExists();
        driver.quit();
        
    }

}

