package org.qe.hawkular.driver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HawkularSeleniumLocalWebDriver {
    
    
    public WebDriver createLocalDriver() throws MalformedURLException {
        WebDriver localDriver = new FirefoxDriver();
        localDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    return localDriver;
    }

}
