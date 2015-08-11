package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularManagementConsolePageConstants {

   public static final By consoleImageAltLocator = By.xpath("//*[contains(attribute::alt, 'RED HAT JBOSS HAWKULAR Management Console')]");
   public static final String testURL = "www.redhat.com";
   public static final By urlLocator = By.name("resourceUrl");
   public static final By addButtonLocator = By.cssSelector("button.btn.btn-primary");
   public static final By homePageImgLocator = By.id("hawkularLogo");
   public static final By urlsMenuLocator = By.linkText("URLs");
   public static final By appServersMenuLocator = By.linkText("Application Servers");
   public static final By appServersListLocator = By.xpath("//*[text()='Application Servers']");
   public static final By urlHeadingLocator = By.linkText("http://"+testURL);
   public static final By addUrlMsg = By.xpath("//*[text()='Your data is being collected. Please be patient (should be about another minute).']");
   public static final By deleteButtonLocator =  By.xpath("//*[text() = 'http://"+testURL+"']/../..//button");
   public static final By confirmDelete =  By.xpath("//button[text()='Delete']");
   public static final By errorAlert =  By.xpath("//*[@class='toast-message']");
   public static final By urlIPLocator = By.xpath("//*[contains(text(),'IP:')]");
   public static final By urlTraits =  By.xpath("//*[text() = 'http://"+testURL+"']/../..//span");
}
