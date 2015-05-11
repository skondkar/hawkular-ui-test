package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularManagementConsolePageConstants {

    public static final By consoleImageAltLocator = By.xpath("//*[contains(attribute::alt, 'RED HAT JBOSS HAWKULAR Management Console')]");

   public static final By urlLocator = By.name("resourceUrl");
   public static final By addButtonLocator = By.cssSelector("button.btn.btn-primary");
}
