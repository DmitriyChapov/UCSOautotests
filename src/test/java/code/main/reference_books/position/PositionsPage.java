package code.main.reference_books.position;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class PositionsPage extends Login {
    boolean positionAvailable;

    public void sectionReferenceBooks() {
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники'",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionPositions() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPositions));
        driver.findElement(xpathPositions).click();
        String positionsUrlNow = driver.getCurrentUrl();
        String positionsPageNameNow = driver.findElement(headingPositionsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Должностей'",
                positionsUrl, positionsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Должностей'",
                positionsPageName, positionsPageNameNow);
        System.out.println("Go to subsection: Positions");
    }

    public void openPositionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String positionCardUrlNow = driver.getCurrentUrl();
        String positionCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Должности'",
                positionCardUrl, positionCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Должности'",
                positionCardPageName,positionCardPageNameNow);
        System.out.println("Open Position Card");
    }

    public void createPosition() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(positionName);
        positionAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationPositionCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Должности",
                positionCardSaveNotification, textNotificationPositionCardSave);
        System.out.println("Position successfully Created");
    }

    public void checkPositionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(positionName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", positionName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", positionName));
        }
        List<WebElement> positionList = driver.findElements(xpathListInTable);
        for (int i = 0; i < positionList.size(); i++) {
            String positionNameSearch = positionList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (positionNameSearch.equals(positionName)) {
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
                positionName, positionNameForCheck);
        Assert.assertEquals("Изменился параметр доступности Должности",
                positionAvailable, positionAvailableForCheck);
        System.out.println("Position has been successfully Verified");
    }

    public void deletePosition() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPositions));
        driver.findElement(xpathPositions).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(positionName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", positionName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", positionName));
        }
        List<WebElement> positionList = driver.findElements(xpathListInTable);
        for (int i = 0; i < positionList.size(); i++) {
            String positionNameSearch = positionList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (positionNameSearch.equals(positionName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                positionList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> positionListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Должность не удалена",
                0, positionListCheck.size());
        System.out.println("Position successfully Deleted");
        }

    public void createAndDeletePosition(){
        loginAdmin();               // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();    // Переход в раздел "Справочники"
        subSectionPositions();      // Переход в подраздел "Должности", раздела "Справочники"
        openPositionCard();         // Открываем карточку Должности
        createPosition();           // Создаем Должность
        checkPositionCard();        // Проверяем заполненность карточки Должности
        deletePosition();           // Удаляем Должность
    }
}
