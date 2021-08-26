package code.main.reference_books.user_type;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class UserTypePage extends Login {
    boolean userTypeAvailable;

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

    public void subSectionUsersType() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathUserTypes));
        driver.findElement(xpathUserTypes).click();
        String usersTypeUrlNow = driver.getCurrentUrl();
        String usersTypePageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Типов пользователей'",
                usersTypeUrl, usersTypeUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Типов пользователей'",
                usersTypePageName, usersTypePageNameNow);
        System.out.println("Go to subsection: Users Type");
    }

    public void openUserTypeCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  userTypeCardUrlNow = driver.getCurrentUrl();
        String  userTypeCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка типа пользователя'",
                userTypeCardUrl, userTypeCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка типа пользователя'",
                userTypeCardPageName,userTypeCardPageNameNow);
        System.out.println("Open User Type Card");
    }

    public void createUserType() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(userTypeName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        userTypeAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationUserTypeCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Типа пользователя",
                userTypeCardSaveNotification, textNotificationUserTypeCardSave);
        System.out.println("User Type successfully Created");
    }

    public void checkUserTypeCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(userTypeName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", userTypeName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", userTypeName));
        }
        List<WebElement> userTypeList = driver.findElements(xpathListInTable);
        for (int i = 0; i < userTypeList.size(); i++) {
            String userTypeNameSearch = userTypeList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (userTypeNameSearch.equals(userTypeName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                userTypeList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open User Type Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String userTypeNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String codeOTKForCheck = driver.findElement(selectorFieldCodeOTK).getAttribute("value");
        boolean userTypeAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Тип пользователя'",
                userTypeName, userTypeNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Код ОТК'",
                codeOTK, codeOTKForCheck);
        Assert.assertEquals("Изменился параметр доступности Типа пользователя",
                userTypeAvailable, userTypeAvailableForCheck);
        System.out.println("User Type has been successfully Verified");
    }

    public void deleteUserType() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathUserTypes));
        driver.findElement(xpathUserTypes).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(userTypeName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", userTypeName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", userTypeName));
        }
        List<WebElement> userTypeList = driver.findElements(xpathListInTable);
        for (int i = 0; i < userTypeList.size(); i++) {
            String userTypeNameSearch = userTypeList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (userTypeNameSearch.equals(userTypeName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                userTypeList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> userTypeListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Тип пользователя не удален",
                0, userTypeListCheck.size());
        System.out.println("User Type successfully Deleted");
    }
    public void createAndDeleteUserType(){
        loginAdmin();                // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();     // Переход в раздел "Справочники"
        subSectionUsersType();       // Переход в подраздел "Типы пользователей", раздела "Справочники"
        openUserTypeCard();          // Открываем карточку Типа пользователя
        createUserType();            // Создаем Тип пользователя
        checkUserTypeCard();         // Проверяем заполненность карточки Типа пользователя
        deleteUserType();            // Удаляем Тип пользователя
    }
}
