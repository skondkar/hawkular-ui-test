package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
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
public class HawkularMultiTenancyTest extends HawkularSeleniumWebDriver {

	@BeforeSuite
	public void prepareUser() throws MalformedURLException {
		WebDriver driver = createDriver("firefox", "24.0", "Linux", "homePage");
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);

	}

	@BeforeSuite
	public void preparejonqeUser() throws MalformedURLException {
		WebDriver driver = createDriver("firefox", "24.0", "Linux", "homePage");
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username1, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName1, HawkularRegistrationPageConstants.lastName1, HawkularRegistrationPageConstants.email1);

	}


	@Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
	public void hawkularBasicMultiTenancyTest(String browser, String version, String os)
			throws Exception {
		WebDriver driver = createDriver(browser, version, os,
				"hawkularBasicMultiTenancyTest");

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
		addUrlPage.navigateToURLsMenu();
		loginPage.logout();
		loginPage.loginAs(HawkularRegistrationPageConstants.username1,
				HawkularRegistrationPageConstants.password);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.verifyUrlDoesnotExist();
		addUrlPage.typeURL(HawkularManagementConsolePageConstants.testURL);
		addUrlPage.submitURL();
		addUrlPage.verifyUrlExists();
		addUrlPage.deleteURL();
		addUrlPage.verifyUrlDoesnotExist();
		loginPage.logout();
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.deleteURL();
		addUrlPage.verifyUrlDoesnotExist();
		loginPage.logout();
		driver.quit();

	}

}

