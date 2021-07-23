package login.main.reference_books.event_places;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.Strings.*;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;

public class EventPlacesPage extends Login {
    boolean eventPlaceAvailable;
    boolean eventPlaceSameAddressAvailable;

    public void sectionReferenceBooks()  {
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники'",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionEventPlaces() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathEventPlaces));
        driver.findElement(xpathEventPlaces).click();
        String eventPlacesUrlNow = driver.getCurrentUrl();
        String eventPlacesPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Учреждений для проведения мероприятий'",
                eventPlacesUrl, eventPlacesUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Учреждений для проведения мероприятий'",
                eventPlacesPageName, eventPlacesPageNameNow);
        System.out.println("Go to subsection: Event Places");
    }

    public void openEventPlaceCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String eventPlaceCardUrlNow = driver.getCurrentUrl();
        String eventPlaceCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Учреждения для проведения мероприятий'",
                eventPlaceCardUrl, eventPlaceCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Учреждения для проведения мероприятий'",
                eventPlaceCardPageName,eventPlaceCardPageNameNow);
        System.out.println("Open Event Place Card");
    }

    public void createEventPlace() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(eventPlaceName);
        driver.findElement(selectorFieldEventPlacesActAddress).sendKeys(eventPlaceAddress);
        driver.findElement(selectorEventPlacesSameAddress).click();
        eventPlaceSameAddressAvailable = driver.findElement(selectorEventPlacesSameAddress).isSelected();
        eventPlaceAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationEventPlaceCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Учреждения для проведения мероприятий",
                eventPlaceCardSaveNotification, textNotificationEventPlaceCardSave);
        System.out.println("Event Place successfully Created");
    }

    public void checkEventPlaceCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathEventPlaces));
        driver.findElement(xpathEventPlaces).click();
        driver.findElement(selectorFieldSearch).sendKeys(eventPlaceName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", eventPlaceName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", eventPlaceName));
        }
        List<WebElement> eventPlaceList = driver.findElements(xpathListInTable);
        for (int i = 0; i < eventPlaceList.size(); i++) {
            String eventPlaceNameSearch = eventPlaceList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (eventPlaceNameSearch.equals(eventPlaceName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                eventPlaceList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Event Place Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String eventPlaceNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        boolean eventPlaceAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        boolean eventPlaceSameAddressAvailableForCheck = driver.findElement(selectorEventPlacesSameAddress).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Наименование учреждения'",
                eventPlaceName, eventPlaceNameForCheck);
        Assert.assertEquals("Изменился параметр доступности Учреждения для проведения мероприятий",
                eventPlaceAvailable, eventPlaceAvailableForCheck);
        Assert.assertEquals("Изменился параметр доступности чек-бокса 'Юридический адресс соответствует фактическому'",
                eventPlaceSameAddressAvailable, eventPlaceSameAddressAvailableForCheck);
        System.out.println("Event Place Card has been successfully Verified");
    }

    public void deleteEventPlace() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathEventPlaces));
        driver.findElement(xpathEventPlaces).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(eventPlaceName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", eventPlaceName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", eventPlaceName));
        }
        List<WebElement> eventPlaceList = driver.findElements(xpathListInTable);
        for (int i = 0; i < eventPlaceList.size(); i++) {
            String eventPlaceNameSearch = eventPlaceList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (eventPlaceNameSearch.equals(eventPlaceName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                eventPlaceList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> eventPlaceListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Учреждение для проведения мероприятий не удалено",
                0, eventPlaceListCheck.size());
        System.out.println("Event Place successfully Deleted");
        }

    public void createAndDeleteEventPlace(){
        loginAdmin();                  // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();       // Переход в раздел "Справочники"
        subSectionEventPlaces();       // Переход в подраздел "Учреждения для проведения мероприятий", раздела "Справочники"
        openEventPlaceCard();          // Открываем карточку Учреждения для проведения мероприятий
        createEventPlace();            // Создаем Учреждение для проведения мероприятий
        checkEventPlaceCard();         // Проверяем заполненность карточки Учреждения для проведения мероприятий
        deleteEventPlace();            // Удаляем Учреждение для проведения мероприятий
    }
}
