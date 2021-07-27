package login.main.administration.TSP;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.valueOf;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Selector.*;
import static variables.admin.Xpath.*;
import static variables.admin.Strings.*;
import static variables.admin.Numbers.*;
import static variables.common.Urls.*;


public class CreateTSP extends Login {

    public void sectionTSP() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP));
        driver.findElement(xpathTSP).click();
        driver.findElement(xpathButtonAdd).click();

    }

    public void sectionCreationTSP() {
        driver.findElement(xpathTSPAvailableSlide).click();
        driver.findElement(xpathNameField).sendKeys(adminTSPName);
        driver.findElement(xpathDescriptionField).sendKeys(adminTSPDescription);
        driver.findElement(xpathAddressField).sendKeys(adminTSPAddress);
        driver.findElement(xpathEmailField).sendKeys(email);
        driver.findElement(xpathOgrnField).sendKeys(valueOf(adminOGRN));
        driver.findElement(xpathMCCField).click();
        driver.findElement(xpathMCCChooseField).click();
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,1000)", "");
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(xpathChooseFile).sendKeys(imageLogoTSPAdmin);
        driver.findElement(xpathButtonOk).click();
        driver.findElement(xpathSiteField).sendKeys(tspSitePublic);
        driver.findElement(xpathEmail2Field).sendKeys(adminTSPEmailPublic);
        driver.findElement(xpathPhone).sendKeys(adminTSPPhonePublic);
        driver.findElement(xpathVK).sendKeys(urlVK);
        driver.findElement(xpathOK).sendKeys(urlOK);
        driver.findElement(xpathFaceBook).sendKeys(urlFacebook);
        driver.findElement(xpathInst).sendKeys(urlInsatgram);
        driver.findElement(xpathDop).sendKeys(adminTSPOptionalText);
        driver.findElement(xpathButtonSave).click();
    }

    public void compareTSP(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP));
        driver.findElement(xpathTSP).click();
     /* wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(adminTSPName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        }
        List<WebElement> positionList = driver.findElements(xpathListInTable);
        for (int i = 0; i < positionList.size(); i++) {
            String positionNameSearch = positionList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (positionNameSearch.equals(adminTSPName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                positionList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Position Card for Check");
                break;
            }
        }
   wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
    String positionNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
    boolean positionAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
  Assert.assertEquals("Некорректно заполнено поле 'Должность'",
           adminTSPName, positionNameForCheck);
   Assert.assertEquals("Изменился параметр доступности Должности",
             positionAvailable, positionAvailableForCheck);
     System.out.println("Position has been successfully Verified");

      */
    }


    public void CreationTSP(){
        loginAdmin(); // Авторизация под пользователем с правами "Администратор"
        sectionTSP(); // Переход в раздел "Торгово-сервисные предприятия"
        sectionCreationTSP(); // Создание и заполнение ТСП
        compareTSP(); // Проверка правильности заполнения ТСП
        // deleteTSP();


    }

}