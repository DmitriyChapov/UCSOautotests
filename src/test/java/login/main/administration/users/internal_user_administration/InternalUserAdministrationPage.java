package login.main.administration.users.internal_user_administration;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static variables.admin.Xpath.*;

public class InternalUserAdministrationPage extends Login {

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

    public void subsectionInternalUserAdministration() throws InterruptedException {
        sectionUsers();
        Thread.sleep(3000);
        driver.findElementByXPath("//a[contains(text(), 'Администрирование внутренних пользователей')]").click();
        String internalUserAdministrationUrl = driver.getCurrentUrl();
        String internalUserAdministrationPageName = driver.findElementByClassName("users__title").getText();
        Assert.assertEquals(internalUserAdministrationUrl, "https://ucso-test.opencode.su/user-administration/user-register");
        Assert.assertEquals("Администрирование внутренних пользователей не работает", internalUserAdministrationPageName,
                "Администрирование внутренних пользователей");
        System.out.println("Go to subsection: Internal User Administration");
    }
}
