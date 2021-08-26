package code.main.administration.users.security_settings;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static variables.admin.Xpath.*;

public class SecuritySettings extends Login {

    public void sectionUsers() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionUsers = driver.findElement(xpathUsers);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionUsers).click();
        actionchange.perform();
        String usersUrl = driver.getCurrentUrl();
        Assert.assertEquals(usersUrl, "https://ucso-test.opencode.su/user-administration");
        System.out.println("Go to section: Users");
    }


    public void subsectionSecuritySettings() throws InterruptedException {
        sectionUsers();
        Thread.sleep(3000);
        driver.findElementByXPath("//a[contains(text(), 'Безопасность внутренних пользователей')]").click();
        String securitySettingsUrl = driver.getCurrentUrl();
        String securitySettingsPageName = driver.findElementByClassName("security__title").getText();
        Assert.assertEquals(securitySettingsUrl, "https://ucso-test.opencode.su/user-administration/security-settings");
        Assert.assertEquals("Параметры безопасности для внутренних пользователей не работают", securitySettingsPageName,
                "Параметры безопасности для внутренних пользователей");
        System.out.println("Go to subsection: Security Settings");
    }
}
