package code.main.guidelines_and_regulations;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Collections.*;

public class GuidelinesAndRegulations extends Login {

    public void sectionGuidelinesAndRegulations() {
        WebElement sectionGuidelinesAndRegulations = driver.findElement(xpathDocument);
        WebElement subsectionGuidelinesAndRegulations = driver.findElement(xpathGuidelinesAndRegulations);
        actionChange.moveToElement(sectionGuidelinesAndRegulations);
        actionChange.moveToElement(subsectionGuidelinesAndRegulations).click();
        actionChange.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingPage));
        guidelinesAndRegulationsUrlNow = driver.getCurrentUrl();
        guidelinesAndRegulationsPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Руководства и регламенты'",
                guidelinesAndRegulationsUrl, guidelinesAndRegulationsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Руководства и регламенты'",
                guidelinesAndRegulationsPageName,guidelinesAndRegulationsPageNameNow );
        System.out.println("Go to section: Guidelines And Regulations");
    }

    public void openDocumentCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingPage));
        driver.findElement(xpathButtonAdd).click();
        guidelinesAndRegulationsCardUrlNow = driver.getCurrentUrl();
        guidelinesAndRegulationsCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка документа'",
                guidelinesAndRegulationsCardUrl, guidelinesAndRegulationsCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка документа'",
                guidelinesAndRegulationsCardPageName,guidelinesAndRegulationsCardPageNameNow);
        System.out.println("Open Document Card");
    }

    public void createDocument() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(documentName);
        driver.findElement(selectorDocumentPortal).click();
        documentPortalAvailable = driver.findElement(selectorDocumentPortal).isSelected();
        driver.findElement(selectorDocumentMobile).click();
        documentMobileAvailable = driver.findElement(selectorDocumentMobile).isSelected();
        driver.findElement(selectorFieldImage).sendKeys(fileDocument);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        guidelinesAndRegulationsCardSaveNotificationNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Документа",
                guidelinesAndRegulationsCardSaveNotification, guidelinesAndRegulationsCardSaveNotificationNow);
        System.out.println("Document successfully Created");
    }

    public void checkDocumentCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(documentName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathDocumentNameForSearch,
                    "title", documentName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathDocumentNameForSearch,
                    "title", documentName));
        }
        documentList = driver.findElements(xpathListInTable);
        for (int i = 0; i < documentList.size(); i++) {
            String documentNameSearch = documentList.get(i).findElement(xpathDocumentNameForSearch).getText();
            if (documentNameSearch.equals(documentName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                documentList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Document Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldName));
        guidelinesAndRegulationsCardNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        documentPortalAvailableForCheck = driver.findElement(selectorDocumentPortal).isSelected();
        documentMobileAvailableForCheck = driver.findElement(selectorDocumentMobile).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'",
                documentName, guidelinesAndRegulationsCardNameForCheck);
        Assert.assertEquals("Изменился параметр доступности чек-бокса 'Портал'",
                documentPortalAvailable, documentPortalAvailableForCheck);
        Assert.assertEquals("Изменился параметр доступности чек-бокса 'Мобильное приложение'",
                documentMobileAvailable, documentMobileAvailableForCheck);
        System.out.println("Document Card has been successfully Verified");
    }

    public void deleteDocument() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathSectionGuidelinesAndRegulations));
        driver.findElement(xpathSectionGuidelinesAndRegulations).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(documentName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathDocumentNameForSearch,
                    "title", documentName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathDocumentNameForSearch,
                    "title", documentName));
        }
        documentList = driver.findElements(xpathListInTable);
        for (int i = 0; i < documentList.size(); i++) {
            String documentNameSearch = documentList.get(i).findElement(xpathDocumentNameForSearch).getText();
            if (documentNameSearch.equals(documentName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                documentList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        documentListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Документ не удален",
                0, documentListCheck.size());
        System.out.println("Document successfully Deleted");
        }

    public void createAndDeleteDocument(){
        loginAdmin();                                 // Авторизация под пользователем с правами "Администратор"
        sectionGuidelinesAndRegulations();            // Переход в раздел "Руководства и регламенты"
        openDocumentCard();                           // Открываем карточку Документа
        createDocument();                             // Создаем Документ
        checkDocumentCard();                          // Проверяем заполненность карточки Документа
        deleteDocument();                             // Удаляем Документ
    }
}
