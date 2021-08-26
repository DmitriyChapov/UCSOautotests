package code.main.administration.users.users_logs;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static variables.admin.Xpath.*;

public class UsersLogs extends Login {

    public void sectionUsers() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionUsers = driver.findElement(xpathUsers);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionUsers).click();
        actionchange.perform();
        String UsersUrl = driver.getCurrentUrl();
        Assert.assertEquals(UsersUrl, "https://ucso-test.opencode.su/user-administration");
        System.out.println("Go to section: Users");
    }

    public void subsectionUsersLog() throws InterruptedException {
        sectionUsers();
        Thread.sleep(3000);
        driver.findElementByXPath("//a[contains(text(), 'Журнал действий')]").click();
        String securitySettingsUrl = driver.getCurrentUrl();
        String securitySettingsPageName = driver.findElementByClassName("logs__title").getText();
        Assert.assertEquals(securitySettingsUrl, "https://ucso-test.opencode.su/user-administration/user-logs");
        Assert.assertEquals("Журнал действий не работает", securitySettingsPageName,
                "Журнал действий");
        System.out.println("Go to subsection: Users Log");
    }
}
