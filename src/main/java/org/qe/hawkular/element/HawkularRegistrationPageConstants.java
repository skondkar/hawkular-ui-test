package org.qe.hawkular.element;

import java.util.Date;

import org.openqa.selenium.By;

public class HawkularRegistrationPageConstants {

    public static final By usernameLocator = By.id("username");
    public static final By firstNameLocator = By.id("firstName");
    public static final By lastNameLocator = By.id("lastName");
    public static final By emailLocator = By.id("email");
    public static final By passwordLocator = By.id("password");
    public static final By confirmPasswordLocator = By.id("password-confirm");
    public static final By registerButtonLocator = By
            .xpath("//input[@value='Register']");
    public static final By backToLoginLink = By.xpath("//a[contains(text(),'Back to Login')]");
    public static final String registrationTitle = "Register with hawkular";
    public static final By noFirstNameError = By.xpath("//*[text()='Please specify first name.']");
    public static final By noLastNameError = By.xpath("//*[text()='Please specify last name.']");
    public static final By noEmailError = By.xpath("//*[text()='Please specify email.']");
    public static final By invalidEmailError = By.xpath("//*[text()='Invalid email address.']");
    public static final By noUsernameError = By.xpath("//*[text()='Please specify username.']");
    public static final By noPasswordError = By.xpath("//*[text()='Please specify password.']");
    public static final By mismatchPasswordError = By.xpath("//*[contains(text(),'Password confirmation doesn')]");
    public static final String mistmatchPasswordErrorMsg = "Password confirmation doesn't match";
    public static final By passwordMinLengthError = By.xpath("//*[text()='Invalid password: minimum length 8.']");
    public static final By passwordUpperCaseError = By.xpath("//*[text()='Invalid password: must contain at least 1 upper case characters']");
    public static final By passwordSpecialCharError = By.xpath("//*[text()='Invalid password: must contain at least 1 special characters']");
    public static final By passwordNumericCharError = By.xpath("//*[text()='Invalid password: must contain at least 1 numerical digits']");
    
    
    
    public static final String username = "hawkularqe";
    public static final String password = "H@wkular123";
    public static final String confirmPassword = "H@wkular123";
    public static final String wrongPassword = "abgdez";
    public static final String firstName = "Hawkular";
    public static final String lastName = "QE";
    public static final String email = "hawkularqe@gmail.com";

    public static final String username1 = "jonqe";
    public static final String firstName1 = "jon";
    public static final String lastName1 = "QE";
    public static final String email1 = "jonqe@gmail.com";

    public static String generateUsername() {
        String generatedUsername = username + (new Date().getTime());

        return generatedUsername;
    }

    public static String generateEmail() {
        String generatedEmail = "hawkularqe" + (new Date().getTime())
                + "@redhat.com";

        return generatedEmail;
    }
}
