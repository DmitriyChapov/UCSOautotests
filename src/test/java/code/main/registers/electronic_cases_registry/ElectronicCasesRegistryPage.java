package code.main.registers.electronic_cases_registry;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import static variables.admin.Selector.*;
import static variables.admin.Xpath.*;
import static variables.admin.Strings.*;
import static variables.admin.Urls.*;

public class ElectronicCasesRegistryPage extends Login {

        public void sectionRegistersElectronicCases() {
        WebElement sectionRegisters = driver.findElement(xpathRegisters);
        WebElement subsectionElectronicCases = driver.findElement(xpathElectronicCases);
        actionChange.moveToElement(sectionRegisters);
        actionChange.moveToElement(subsectionElectronicCases).click();
        actionChange.perform();
        waitingSpinner();
        String electronicCasesRegistersUrlNow = driver.getCurrentUrl();
        String electronicCasesRegisterPageNameNow = driver.findElement(headingElectronicCasesPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Реестр электронных дел'",
                electronicCasesRegistersUrlNow, electronicCasesRegistersUrl);
        Assert.assertEquals("Не совпадают заголовки на странице 'Реестр электронных дел'",
                electronicCasesRegisterPageNameNow, electronicCasesRegisterPageName);
        System.out.println("Go to section: Electronic Cases Registers");
    }
}
