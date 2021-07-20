package login.main.reference_books.location_transport_app;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class LocationTransportAppPage extends Login {
    boolean locationTransportAppAvailable;

    public void sectionReferenceBooks() {
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы \"Справочники\"",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Справочники\"",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionLocationTransportApp() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationTransportApps));
        driver.findElement(xpathLocationTransportApps).click();
        String locationTransportAppUrlNow = driver.getCurrentUrl();
        String locationTransportAppPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы \"Справочник локаций транспортного приложения\"",
                locationTransportAppUrl, locationTransportAppUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Справочник локаций транспортного приложения\"",
                locationTransportAppPageName, locationTransportAppPageNameNow);
        System.out.println("Go to subsection: Locations Transport App");
    }

    public void openLocationTransportAppCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  locationTransportAppCardUrlNow = driver.getCurrentUrl();
        String  locationTransportAppCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы \"Карточка локаций транспортного приложения\"",
                locationTransportAppCardUrl, locationTransportAppCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Карточка локаций транспортного приложения\"",
                locationTransportAppCardPageName,locationTransportAppCardPageNameNow);
        System.out.println("Open Locations Transport App Card");
    }

    public void createLocationTransportApp() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
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
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
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
                System.out.println("Open Locations Transport App Card for check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String locationTransportAppNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String codeOTKForCheck = driver.findElement(selectorFieldCodeOTK).getAttribute("value");
        boolean locationTransportAppAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Локация'",
                locationTransportAppName, locationTransportAppNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Код ОТК'",
                codeOTK, codeOTKForCheck);
        Assert.assertEquals("Изменился параметр доступности",
                locationTransportAppAvailable, locationTransportAppAvailableForCheck);
        System.out.println("Locations Transport App Card has been successfully verified");
    }

    public void deleteLocationTransportApp() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationTransportApps));
        driver.findElement(xpathLocationTransportApps).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
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
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> locationTransportAppListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Локация транспортного приложения не удалена",
                0, locationTransportAppListCheck.size());
        System.out.println("Locations Transport App successfully Deleted");
        }
}
