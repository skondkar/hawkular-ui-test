package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularLoginPageConstants {
	
    public static final By usernameLocator = By.id("username");
    public static final By passwordLocator = By.id("password");
    public static final By loginButtonLocator = By.id("kc-login");
    public static final By cancelButtonLocator = By.id("kc-cancel");
    public static final String loginTitle = "Log in to hawkular";
    public static final String login = "hawkularqe";
    public static final String password = "H@wkular123";
    public static final By registrationLink = By.linkText("Register");
    public static final By logoutDropdown = By.xpath("/html/body/nav/div[2]/div[2]/ul/li/a");
    public static final By logoutLink = By.id("logout");
    
    public static final By invalidUsernamePasswordError = By.xpath("//*[text()='Invalid username or password.']");
}
