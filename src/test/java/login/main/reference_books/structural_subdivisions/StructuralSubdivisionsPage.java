package login.main.reference_books.structural_subdivisions;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class StructuralSubdivisionsPage extends Login {
    boolean structuralSubdivisionAvailable;

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

    public void subSectionStructuralSubdivisions() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathStructuralSubdivisions));
        driver.findElement(xpathStructuralSubdivisions).click();
        String structuralSubdivisionsUrlNow = driver.getCurrentUrl();
        String structuralSubdivisionsPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Структурных подразделений'",
                structuralSubdivisionsUrl, structuralSubdivisionsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Структурных подразделений'",
                structuralSubdivisionsPageName, structuralSubdivisionsPageNameNow);
        System.out.println("Go to subsection: Structural Subdivisions");
    }

    public void openStructuralSubdivisionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  structuralSubdivisionCardUrlNow = driver.getCurrentUrl();
        String  structuralSubdivisionCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Структурного подразделения'",
                structuralSubdivisionCardUrl, structuralSubdivisionCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Структурного подразделения'",
                structuralSubdivisionCardPageName,structuralSubdivisionCardPageNameNow);
        System.out.println("Open Structural Subdivision Card");
    }

    public void createStructuralSubdivision() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(structuralSubdivisionName);
        structuralSubdivisionAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationStructuralSubdivisionCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Структурного подразделения",
                structuralSubdivisionCardSaveNotification, textNotificationStructuralSubdivisionCardSave);
        System.out.println("Structural Subdivision successfully Created");
    }

    public void checkStructuralSubdivisionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(structuralSubdivisionName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", structuralSubdivisionName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", structuralSubdivisionName));
        }
        List<WebElement> structuralSubdivisionList = driver.findElements(xpathListInTable);
        for (int i = 0; i < structuralSubdivisionList.size(); i++) {
            String structuralSubdivisionNameSearch = structuralSubdivisionList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (structuralSubdivisionNameSearch.equals(structuralSubdivisionName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                structuralSubdivisionList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Structural Subdivision Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String structuralSubdivisionNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        boolean structuralSubdivisionAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Структурное подразделение'",
                structuralSubdivisionName, structuralSubdivisionNameForCheck);
        Assert.assertEquals("Изменился параметр доступности Структурного подразделения",
                structuralSubdivisionAvailable, structuralSubdivisionAvailableForCheck);
        System.out.println("Structural Subdivision has been successfully Verified");
    }

    public void deleteStructuralSubdivision() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathStructuralSubdivisions));
        driver.findElement(xpathStructuralSubdivisions).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(structuralSubdivisionName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", structuralSubdivisionName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", structuralSubdivisionName));
        }
        List<WebElement> structuralSubdivisionList = driver.findElements(xpathListInTable);
        for (int i = 0; i < structuralSubdivisionList.size(); i++) {
            String structuralSubdivisionNameSearch = structuralSubdivisionList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (structuralSubdivisionNameSearch.equals(structuralSubdivisionName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                structuralSubdivisionList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> structuralSubdivisionListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Струтурное подразделение не удалено",
                0, structuralSubdivisionListCheck.size());
        System.out.println("Structural Subdivision successfully Deleted");
    }
    public void createAndDeleteStructuralSubdivision(){
        loginAdmin();                            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                 // Переход в раздел "Справочники"
        subSectionStructuralSubdivisions();      // Переход в подраздел "Структурные подразделения", раздела "Справочники"
        openStructuralSubdivisionCard();         // Открываем карточку Структурное подразделение
        createStructuralSubdivision();           // Создаем Структурное подразделение
        checkStructuralSubdivisionCard();        // Проверяем заполненность карточки Структурного подразделения
        deleteStructuralSubdivision();           // Удаляем Структурное подразделение
    }
}
