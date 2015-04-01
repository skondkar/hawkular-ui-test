package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.testng.Assert;

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

    public boolean verifyRegCompleted() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(HawkularManagementConsolePageConstants.consoleImageAltLocator));
        return driver.findElement(
                HawkularManagementConsolePageConstants.consoleImageAltLocator)
                .isDisplayed();
    }

    public boolean verifyMismatchPasswords() {

        // return
        // driver.getPageSource().contains(HawkularRegistrationPageConstants.mistmatchPasswordErrorMsg);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(HawkularRegistrationPageConstants.mismatchPasswordError));
        return driver.findElement(
                HawkularRegistrationPageConstants.mismatchPasswordError)
                .isDisplayed();
    }

    public boolean verifyNoPasswords() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noPasswordError)
                .isDisplayed();
    }

    public boolean verifyNoEmail() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noEmailError).isDisplayed();
    }

    public boolean verifyNoFirstName() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noFirstNameError)
                .isDisplayed();
    }

    public boolean verifyNoLastName() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noLastNameError)
                .isDisplayed();
    }

    public boolean verifyInvalidEmail() {

        return driver.findElement(
                HawkularRegistrationPageConstants.invalidEmailError)
                .isDisplayed();
    }

    public boolean verifyNoUsername() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noUsernameError)
                .isDisplayed();
    }

    public boolean verifyIncorrectPasswordFormat() {

        return driver.findElement(
                HawkularRegistrationPageConstants.noEmailError).isDisplayed();
    }

    public boolean verifyMismatchPassword() {

        return driver.findElement(
                HawkularRegistrationPageConstants.mismatchPasswordError)
                .isDisplayed();
    }

    public boolean verifyPasswordMinLength() {

        return driver.findElement(
                HawkularRegistrationPageConstants.passwordMinLengthError)
                .isDisplayed();
    }

    public boolean verifyPasswordUpperCase() {

        return driver.findElement(
                HawkularRegistrationPageConstants.passwordUpperCaseError)
                .isDisplayed();
    }

    public boolean verifyPasswordSpecialChar() {

        return driver.findElement(
                HawkularRegistrationPageConstants.passwordSpecialCharError)
                .isDisplayed();
    }

    public boolean verifyPasswordNumericChar() {

        return driver.findElement(
                HawkularRegistrationPageConstants.passwordNumericCharError)
                .isDisplayed();
    }
}
