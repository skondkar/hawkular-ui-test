package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularRegistrationPageConstants {

    public static final By usernameLocator = By.id("username");
    public static final By firstNameLocator = By.id("firstName");
    public static final By lastNameLocator = By.id("lastName");
    public static final By emailLocator = By.id("email");
    public static final By passwordLocator = By.id("password");
    public static final By confirmPasswordLocator = By.id("password-confirm");
    public static final By registerButtonLocator = By
            .xpath("//inout[@value='Register']");
    public static final String registrationTitle = "Register with hawkular";
    public static final String username ="ahovsepy";
    public static final String password ="H@wkular123";
    public static final String confirmPassword ="H@wkular123";
    public static final String firstName ="Armine";
    public static final String lastName ="Hovsepyan";
    public static final String email ="ahovsepy@redhat.com";

}
