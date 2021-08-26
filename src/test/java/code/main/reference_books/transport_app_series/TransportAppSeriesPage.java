package code.main.reference_books.transport_app_series;

import code.Login;
import code.main.reference_books.description_transport_card.DescriptionTransportCardPage;
import code.main.reference_books.location_transport_app.LocationTransportAppPage;
import code.main.reference_books.user_type.UserTypePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class TransportAppSeriesPage extends Login {
    boolean transportAppSeriesAvailable;

    DescriptionTransportCardPage DescriptionTransportCard = new DescriptionTransportCardPage();
    UserTypePage UserType = new UserTypePage();
    LocationTransportAppPage LocationTransportApp = new LocationTransportAppPage();

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

    public void createDescriptionsTransportCard() {
        DescriptionTransportCard.subSectionDescriptionsTransportCard();      // Переход в подраздел "Описания транспортной карты", раздела "Справочники"
        DescriptionTransportCard.openDescriptionsTransportCardCard();        // Открываем карточку Описания транспортной карты
        DescriptionTransportCard.createDescriptionsTransportCard();          // Создаем Описание транспортной карты
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        DescriptionTransportCard.checkDescriptionsTransportCardCard();       // Проверяем заполненность карточки Описание транспортной карты
    }

    public void createUserType()   {
        UserType.subSectionUsersType();                                      // Переход в подраздел "Типы пользователей", раздела "Справочники"
        UserType.openUserTypeCard();                                         // Открываем карточку Типа пользователя
        UserType.createUserType();                                           // Создаем Тип пользователя
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        UserType.checkUserTypeCard();                                        // Проверяем заполненность карточки Типа пользователя
    }

    public void createLocationTransportApp() {
        LocationTransportApp.subSectionLocationTransportApp();               // Переход в подраздел "Локации транспортного приложения", раздела "Справочники"
        LocationTransportApp.openLocationTransportAppCard();                 // Открываем карточку Локация транспортного приложения
        LocationTransportApp.createLocationTransportApp();                   // Создаем Локацию транспортного приложения
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        LocationTransportApp.checkLocationTransportAppCard();                // Проверяем заполненность карточки Локации транспортного приложения
    }

    public void subSectionTransportAppSeries() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTransportAppSeries));
        driver.findElement(xpathTransportAppSeries).click();
        String transportAppSeriesUrlNow = driver.getCurrentUrl();
        String transportAppSeriesPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Серии транспортного приложения'",
                transportAppSeriesUrl, transportAppSeriesUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Серии транспортного приложения'",
                transportAppSeriesPageName, transportAppSeriesPageNameNow);
        System.out.println("Go to subsection: Transport App Series");
    }

    public void openTransportAppSeriesCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  transportAppSeriesCardUrlNow = driver.getCurrentUrl();
        String  transportAppSeriesCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Серии транспортного приложения'",
                transportAppSeriesCardUrl, transportAppSeriesCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Серии транспортного приложения'",
                transportAppSeriesCardPageName,transportAppSeriesCardPageNameNow);
        System.out.println("Open Transport App Series Card");
    }

    public void createTransportAppSeries() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(transportAppSeries);
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectCardDescription));
        driver.findElement(selectorSelectCardDescription).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownDescriptionsTransportCard));
        driver.findElement(xpathDropDownDescriptionsTransportCard).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectSocialCode));
        driver.findElement(selectorSelectSocialCode).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownSocialCodes));
        driver.findElement(xpathDropDownSocialCodes).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectUserType));
        driver.findElement(selectorSelectUserType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownUsersType));
        driver.findElement(xpathDropDownUsersType).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectLocationTransportApp));
        driver.findElement(selectorSelectLocationTransportApp).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownLocationsTransportApp));
        driver.findElement(xpathDropDownLocationsTransportApp).click();
        transportAppSeriesAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationTransportAppSeriesCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Серии транспортного приложения",
                transportAppSeriesCardSaveNotification, textNotificationTransportAppSeriesCardSave);
        System.out.println("Transport App Series successfully Created");
    }

    public void checkTransportAppSeriesCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(transportAppSeries);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", transportAppSeries));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", transportAppSeries));
        }
        List<WebElement> transportAppSeriesList = driver.findElements(xpathListInTable);
        for (int i = 0; i < transportAppSeriesList.size(); i++) {
            String transportAppSeriesListNameSearch = transportAppSeriesList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (transportAppSeriesListNameSearch.equals(transportAppSeries)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                transportAppSeriesList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Transport App Series Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String transportAppSeriesNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String cardDescriptionNameForCheck = driver.findElement(selectorSelectCardDescription).findElement(xpathCheckDropDown).getText();
        String socialCodeNameForCheck = driver.findElement(selectorSelectSocialCode).findElement(xpathCheckDropDown).getText();
        String typeUserNameForCheck = driver.findElement(selectorSelectUserType).findElement(xpathCheckDropDown).getText();
        String locationTransportAppNameForCheck = driver.findElement(selectorSelectLocationTransportApp).findElement(xpathCheckDropDown).getText();
        boolean transportAppSeriesAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        System.out.println(transportAppSeriesAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Серия'",
                transportAppSeries, transportAppSeriesNameForCheck);
        Assert.assertEquals("Некорректное Описание транспортной карты",
                descriptionsTransportCardName, cardDescriptionNameForCheck);
        Assert.assertEquals("Некорректная Группа социальных категорий",
                socialCode, socialCodeNameForCheck);
        Assert.assertEquals("Некорректный Тип пользователя",
                userTypeName, typeUserNameForCheck);
        Assert.assertEquals("Некорректная Локация транспортного приложения",
                locationTransportAppName, locationTransportAppNameForCheck);
        Assert.assertEquals("Изменился параметр доступности Серии транспортного приложения",
                transportAppSeriesAvailable, transportAppSeriesAvailableForCheck);
        System.out.println("Transport App Series Card has been successfully Verified");
    }

    public void deleteTransportAppSeries() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTransportAppSeries));
        driver.findElement(xpathTransportAppSeries).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(transportAppSeries);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", transportAppSeries));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", transportAppSeries));
        }
        List<WebElement> transportAppSeriesList = driver.findElements(xpathListInTable);
        for (int i = 0; i < transportAppSeriesList.size(); i++) {
            String transportAppSeriesListNameSearch = transportAppSeriesList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (transportAppSeriesListNameSearch.equals(transportAppSeries)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                transportAppSeriesList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> transportAppSeriesCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Серия транспортного приложения не удалена",
                0, transportAppSeriesCheck.size());
        System.out.println("Transport App Series successfully Deleted");
    }

    public void deleteRelatedDirectories() {
        DescriptionTransportCard.deleteDescriptionsTransportCard();         //Удаляем Описание транспортной карты
        UserType.deleteUserType();                                          //Удаляем Тип пользователя
        LocationTransportApp.deleteLocationTransportApp();                  //Удаляем Локацию транспортного приложения
    }

    public void createAndDeleteTransportAppSeries(){
        loginAdmin();                              // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                   // Переход в раздел "Справочники"
        createDescriptionsTransportCard();         // Создаем Описание транспортной карты
        createUserType();                          // Создаем Тип пользователя
        createLocationTransportApp();              // Создаем Локацию транспортного приложения
        subSectionTransportAppSeries();            // Переход в подраздел "Серии транспортного приложения", раздела "Справочники"
        openTransportAppSeriesCard();              //Открываем карточку Серии транспортного приложения
        createTransportAppSeries();                // Создаем Серию транспортного приложения
        checkTransportAppSeriesCard();             // Проверяем заполненность карточки Серии транспортного приложения
        deleteTransportAppSeries();                // Удаляем Серию транспортного приложения
        deleteRelatedDirectories();                // Удаляем остальные задействованные атрибуты
    }

}
