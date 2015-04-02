package org.qe.hawkular.driver;

/**
 * @author Armine Hovsepyan
 */

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularSeleniumWebDriver implements
        SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

    public static String hawkularUrl = (System.getProperty("hawkularUrl") != null) ? System
            .getProperty("hawkularUrl") : "http://localhost:8080";

    public String authenticationKey = System.getProperty("authenticationKey");

    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
            "hawkularqe", authenticationKey);

    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private ThreadLocal<String> sessionId = new ThreadLocal<String>();

    public WebDriver createDriver(String browser, String version, String os,
            String testName) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        if (version != null) {
            capabilities.setCapability(CapabilityType.VERSION, version);
        }
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        capabilities.setCapability("name", testName);
        webDriver.set(new RemoteWebDriver(new URL("http://"
                + authentication.getUsername() + ":"
                + authentication.getAccessKey()
                + "@ondemand.saucelabs.com:80/wd/hub"), capabilities));
        sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId()
                .toString());
        return webDriver.get();
    }

    /**
     * @return the {@link WebDriver} for the current thread
     */
    public WebDriver getWebDriver() {
        System.out.println("WebDriver" + webDriver.get());
        return webDriver.get();
    }

    public String getSessionId() {
        return sessionId.get();
    }

    /**
     *
     * @return the {@link SauceOnDemandAuthentication} instance containing the
     *         Sauce username/access key
     */
    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }
}
