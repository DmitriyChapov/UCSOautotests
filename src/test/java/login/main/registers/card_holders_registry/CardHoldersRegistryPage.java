package login.main.registers.card_holders_registry;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import static variables.admin.Selector.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Strings.*;

public class CardHoldersRegistryPage extends Login {

    public void sectionCardHoldersRegisters() {
        WebElement sectionRegisters = driver.findElement(xpathRegisters);
        WebElement subsectionCardHolders = driver.findElement(xpathCardHolders);
        actionChange.moveToElement(sectionRegisters);
        actionChange.moveToElement(subsectionCardHolders).click();
        actionChange.perform();
        waitingSpinner();
        String cardHoldersRegistryUrlNow = driver.getCurrentUrl();
        String cardHoldersRegistryPageNameNow = driver.findElement(headingCardHoldersPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Реестр держателей КЖСО'",
                cardHoldersRegistryUrl, cardHoldersRegistryUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Реестр держателей КЖСО'",
                cardHoldersRegistryPageName, cardHoldersRegistryPageNameNow);
        System.out.println("Go to section: Card Holders Register");
    }
}
