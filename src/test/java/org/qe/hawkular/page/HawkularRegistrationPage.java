package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;

public class HawkularRegistrationPage {

    private final WebDriver driver;

    public HawkularRegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    By usernameLocator = HawkularRegistrationPageConstants.usernameLocator;
    By firstNameLocator = HawkularRegistrationPageConstants.firstNameLocator;
    By lastNameLocator = HawkularRegistrationPageConstants.lastNameLocator;
    By emailLocator = HawkularRegistrationPageConstants.emailLocator;
    By passwordLocator = HawkularRegistrationPageConstants.passwordLocator;
    By confirmPasswordLocator = HawkularRegistrationPageConstants.confirmPasswordLocator;
    By registerButtonLocator = HawkularRegistrationPageConstants.registerButtonLocator;

    public HawkularRegistrationPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);

        return this;
    }

    public HawkularRegistrationPage typefirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);

        return this;
    }

    public HawkularRegistrationPage typelastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);

        return this;
    }

    public HawkularRegistrationPage typeEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);

        return this;
    }

    public HawkularRegistrationPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);

        return this;
    }

    public HawkularRegistrationPage typeConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);

        return this;
    }

    public HawkularRegistrationPage submitRegistrationForm() {
        driver.findElement(registerButtonLocator).click();
        ;

        return this;
    }

    public HawkularRegistrationPage register(String username, String password,
            String confirmPassword, String email, String firstName,
            String lastName) {
        typeUsername(username);
        typePassword(password);
        typeConfirmPassword(confirmPassword);
        typefirstName(firstName);
        typelastName(lastName);
        typeEmail(email);
        return submitRegistrationForm();
    }
}
