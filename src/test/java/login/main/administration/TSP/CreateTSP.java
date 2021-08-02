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
import static variables.admin.Urls.*;


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
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,500)", "");
        driver.findElement(xpathMCCField).click();
        driver.findElement(xpathMCCChooseField).click();
        driver.findElement(xpathButtonSpanDownloadImage).click();
        driver.findElement(xpathChooseFile).sendKeys(imageLogoTSPAdmin);
        driver.findElement(xpathButtonOk).click();
        pageDown.executeScript("scroll(0,1500)", "");
        driver.findElement(xpathSiteField).sendKeys(tspSitePublic);
        driver.findElement(xpathEmail2Field).sendKeys(adminTSPEmailPublic);
        driver.findElement(xpathPhone).sendKeys(adminTSPPhonePublic);
        driver.findElement(xpathVK).sendKeys(urlVK);
        driver.findElement(xpathOK).sendKeys(urlOK);
        driver.findElement(xpathFaceBook).sendKeys(urlFacebook);
        driver.findElement(xpathInst).sendKeys(urlInsatgram);
        driver.findElement(xpathDop).sendKeys(adminTSPOptionalText);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
    }

    public void compareTSP() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
        driver.get(TSP);
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(adminTSPName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        }
        List<WebElement> TSPList = driver.findElements(xpathListInTable);
        for (int i = 0; i < TSPList.size(); i++) {
            String TSPNameSearch = TSPList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (TSPNameSearch.equals(adminTSPName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                TSPList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open TSP Card for Check");
                break;
            }
        }
        boolean TSPAvailableForCheck = driver.findElement(xpathTSPAvailableSlide).isSelected();
        if (TSPAvailableForCheck) {
            Assert.assertEquals("Изменился параметр доступности карточки TSP",
                    xpathTSPAvailableSlide, TSPAvailableForCheck);
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathNameField));
        String TSPNameForCheck = driver.findElement(xpathNameField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'", adminTSPName, TSPNameForCheck);
        String TSPDescriptionForCheck = driver.findElement(xpathDescriptionField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Описание'", adminTSPDescription, TSPDescriptionForCheck);
        String TSPAddressForCheck = driver.findElement(xpathAddressField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Адрес'", adminTSPAddress, TSPAddressForCheck);
        String TSPEmail1ForCheck = driver.findElement(xpathEmailField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'E-mail'", email, TSPEmail1ForCheck);
        String TSPOGRNForCheck = driver.findElement(xpathOgrnField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'ОГРН/ОГРНИП'", valueOf(adminOGRN), TSPOGRNForCheck);
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,500)", "");
        String TSPMCCForCheck = driver.findElement(xpathMCCChosenField).getText();
        Assert.assertEquals("Некорректно заполнено поле 'MCC'", "1223   Классификатор 1", TSPMCCForCheck);
        pageDown.executeScript("scroll(0,1500)", "");
        String TSPSiteForCheck = driver.findElement(xpathSiteField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Сайт'", tspSitePublic, TSPSiteForCheck);
        String TSPEmail2ForCheck = driver.findElement(xpathEmail2Field).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Email'", adminTSPEmailPublic, TSPEmail2ForCheck);
        String TSPPhoneForCheck = driver.findElement(xpathPhone).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Телефон'", "+7(927)000-0000", TSPPhoneForCheck);
        String TSPVKForCheck = driver.findElement(xpathVK).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Вконтакте'", urlVK, TSPVKForCheck);
        String TSPOKForCheck = driver.findElement(xpathOK).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Одноклассники'", urlOK, TSPOKForCheck);
        String TSPFaceBookForCheck = driver.findElement(xpathFaceBook).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Facebook'", urlFacebook, TSPFaceBookForCheck);
        String TSPInstForCheck = driver.findElement(xpathInst).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Instagram'", urlInsatgram, TSPInstForCheck);
        String TSPDopForCheck = driver.findElement(xpathDop).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Дополнительно'", adminTSPOptionalText, TSPDopForCheck);
        System.out.println("TSP has been successfully Verified");

    }

    public void deleteTSP() {
        driver.get(TSP);
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(adminTSPName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        }
        List<WebElement> TSPList = driver.findElements(xpathListInTable);
        for (int i = 0; i < TSPList.size(); i++) {
            String TSPNameSearch = TSPList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (TSPNameSearch.equals(adminTSPName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                TSPList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> TSPListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("ТСП не удалена",0, TSPListCheck.size());
        System.out.println("TSP successfully Deleted");
    }

    public void CreationTSP() {
        loginAdmin(); // Авторизация под пользователем с правами "Администратор"
        sectionTSP(); // Переход в раздел "Торгово-сервисные предприятия"
        sectionCreationTSP(); // Создание и заполнение ТСП
        compareTSP(); // Проверка правильности заполнения ТСП
        deleteTSP(); // Удаление ТСП


    }

}