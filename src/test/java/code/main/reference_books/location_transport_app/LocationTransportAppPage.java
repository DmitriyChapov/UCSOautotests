package code.main.reference_books.location_transport_app;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class LocationTransportAppPage extends Login {
    boolean locationTransportAppAvailable;

    public void sectionReferenceBooks() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathReferenceBooks));
        driver.findElement(xpathReferenceBooks).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingReferenceBooks));
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники'",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionLocationTransportApp() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationTransportApps));
        driver.findElement(xpathLocationTransportApps).click();
        String locationTransportAppUrlNow = driver.getCurrentUrl();
        String locationTransportAppPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Локаций транспортного приложения'",
                locationTransportAppUrl, locationTransportAppUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Локаций транспортного приложения'",
                locationTransportAppPageName, locationTransportAppPageNameNow);
        System.out.println("Go to subsection: Locations Transport App");
    }

    public void openLocationTransportAppCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingPage));
        driver.findElement(xpathButtonAdd).click();
        String  locationTransportAppCardUrlNow = driver.getCurrentUrl();
        String  locationTransportAppCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Локаций транспортного приложения'",
                locationTransportAppCardUrl, locationTransportAppCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Локаций транспортного приложения'",
                locationTransportAppCardPageName,locationTransportAppCardPageNameNow);
        System.out.println("Open Location Transport App Card");
    }

    public void createLocationTransportApp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingCard));
        driver.findElement(selectorFieldName).sendKeys(locationTransportAppName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        locationTransportAppAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationLocationTransportAppCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Локации транспортного приложения",
                locationTransportAppCardSaveNotification, textNotificationLocationTransportAppCardSave);
        System.out.println("Locations Transport App successfully Created");
    }

    public void checkLocationTransportAppCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationTransportApps));
        driver.findElement(xpathLocationTransportApps).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingPage));
        driver.findElement(selectorFieldSearch).sendKeys(locationTransportAppName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", locationTransportAppName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", locationTransportAppName));
        }
        List<WebElement> locationTransportAppList = driver.findElements(xpathListInTable);
        for (int i = 0; i < locationTransportAppList.size(); i++) {
            String locationTransportAppNameSearch = locationTransportAppList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (locationTransportAppNameSearch.equals(locationTransportAppName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                locationTransportAppList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Locations Transport App Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingCard));
        String  locationTransportAppCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Локаций транспортного приложения'",
                locationTransportAppCardPageName,locationTransportAppCardPageNameNow);
        System.out.println("Open Location Transport App Card");
        String locationTransportAppNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String codeOTKForCheck = driver.findElement(selectorFieldCodeOTK).getAttribute("value");
        boolean locationTransportAppAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Локация'",
                locationTransportAppName, locationTransportAppNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Код ОТК'",
                codeOTK, codeOTKForCheck);
        Assert.assertEquals("Изменился параметр доступности Локации траснпортного приложения",
                locationTransportAppAvailable, locationTransportAppAvailableForCheck);
        System.out.println("Locations Transport App Card has been successfully Verified");
    }

    public void deleteLocationTransportApp() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationTransportApps));
        driver.findElement(xpathLocationTransportApps).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingPage));
        driver.findElement(selectorFieldSearch).sendKeys(locationTransportAppName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", locationTransportAppName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", locationTransportAppName));
        }
        List<WebElement> locationTransportAppList = driver.findElements(xpathListInTable);
        for (int i = 0; i < locationTransportAppList.size(); i++) {
            String locationTransportAppNameSearch = locationTransportAppList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (locationTransportAppNameSearch.equals(locationTransportAppName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                locationTransportAppList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> locationTransportAppListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Локация транспортного приложения не удалена",
                0, locationTransportAppListCheck.size());
        System.out.println("Locations Transport App successfully Deleted");
        }

    public void createAndDeleteLocationTransportApp(){
        loginAdmin();                            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                 // Переход в раздел "Справочники"
        subSectionLocationTransportApp();        // Переход в подраздел "Локации транспортного приложения", раздела "Справочники"
        openLocationTransportAppCard();          // Открываем карточку Локация транспортного приложения
        createLocationTransportApp();            // Создаем Локацию транспортного приложения
        checkLocationTransportAppCard();         // Проверяем заполненность карточки Локации транспортного приложения
        deleteLocationTransportApp();            // Удаляем Локацию транспортного приложения
    }
}
