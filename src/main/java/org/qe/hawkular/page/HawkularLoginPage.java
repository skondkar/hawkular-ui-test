package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularLoginPage {
    private final WebDriver driver;

    public HawkularLoginPage(WebDriver driver) {

        this.driver = driver;
//        if (HawkularLoginPageConstants.loginTitle.contains(driver.getTitle())) {
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    By usernameLocator = HawkularLoginPageConstants.usernameLocator;
    By passwordLocator = HawkularLoginPageConstants.passwordLocator;
    By loginButtonLocator = HawkularLoginPageConstants.loginButtonLocator;
    By registrationLink = HawkularLoginPageConstants.registrationLink;

    
    public HawkularLoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);

        return this;
    }

    public void navigateToRegistration(){
        HawkularUtils utils = new HawkularUtils(driver);
         utils.navigateTo(registrationLink);
    }

    public HawkularLoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);

        return this;
    }

    public HawkularLoginPage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HawkularLoginPage(driver);
    }

    public HawkularLoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();

        return new HawkularLoginPage(driver);
    }

    public HawkularLoginPage loginAs(String username, String password) {

        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}