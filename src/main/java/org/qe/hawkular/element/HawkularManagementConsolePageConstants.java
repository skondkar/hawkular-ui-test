package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularManagementConsolePageConstants {

    public static final By consoleImageAltLocator = By.xpath("//*[contains(attribute::alt, 'RED HAT JBOSS HAWKULAR Management Console')]");

   public static final By urlLocator = By.name("resourceUrl");
   public static final By addButtonLocator = By.cssSelector("button.btn.btn-primary");
   public static final By homePageImgLocator = By.id("hawkularLogo");
   public static final By urlsMenuLocator = By.linkText("URLs");
   public static final By appServersMenuLocator = By.linkText("Application Servers");
   public static final By appServersListLocator = By.linkText("Tomy Machine");

}
