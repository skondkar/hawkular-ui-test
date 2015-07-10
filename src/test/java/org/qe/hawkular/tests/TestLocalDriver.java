package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.testng.annotations.Test;

@Test
public class TestLocalDriver  extends HawkularSeleniumLocalWebDriver {
    
    @Test
    public void testTest() throws Exception {
        
        WebDriver driver = createLocalDriver();
        
        HawkularRegistrationPage registration = new HawkularRegistrationPage(
                driver);
        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);


    }


}
