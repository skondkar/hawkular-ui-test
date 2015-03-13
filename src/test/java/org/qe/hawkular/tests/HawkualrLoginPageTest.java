package org.qe.hawkular.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.util.BrowsersAndOs;
import org.qe.hawkular.util.HawkularLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkualrLoginPageTest extends HawkularSeleniumWebDriver {
	
	@DataProvider(name = "browsersAndOs", parallel = false)
	public static Object[][] dataProviderTest() throws Exception {

		List<String> browsersList = BrowsersAndOs.readBrowsersAndOsFromFile();

		Object[][] dataProv;
		dataProv = new Object[browsersList.size()][3];

		int i = 0;
		for (; i++ < browsersList.size();) {
			dataProv[i-1] = browsersList.get(i-1).split(":");
		}
		return dataProv;
	}

	@Test(dataProvider = "browsersAndOs")
	public void hawkularLoginTest(String browser, String version, String os)
			throws Exception {
		WebDriver driver = createDriver(browser, version, os, "hawkularGuiTest" );
		
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularLoginPageConstants.login, HawkularLoginPageConstants.password);
//		driver.close();
		driver.quit();
	}
	
	
}