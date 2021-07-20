package login.main.reference_books.tags;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class TagsPage extends Login {
    boolean tagAvailable;

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

    public void subSectionTags() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTags));
        driver.findElement(xpathTags).click();
        String tagsUrlNow = driver.getCurrentUrl();
        String tagsPageNameNow = driver.findElement(headingTags).getText();
        Assert.assertEquals("Некорректный Url страницы \"Справочник Тегов рубрик\"",
                tagsUrl, tagsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Справочник Тегов рубрик\"",
                tagsPageName, tagsPageNameNow);
        System.out.println("Go to subsection: Tags");
    }

    public void openTagCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  tagCardUrlNow = driver.getCurrentUrl();
        String  tagCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы \"Карточка Тега рубрики\"",
                tagCardUrl, tagCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Карточка Тега рубрики\"",
                tagCardPageName,tagCardPageNameNow);
        System.out.println("Open Tag Card");
    }

    public void createTag() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(tagName);
        tagAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationTagCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Тега рубрики",
                tagCardSaveNotification, textNotificationTagCardSave);
        System.out.println("Tag successfully Created");
    }

    public void checkTagCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(tagName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tagName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tagName));
        }
        List<WebElement> tagList = driver.findElements(xpathListInTable);
        for (int i = 0; i < tagList.size(); i++) {
            String tagNameSearch = tagList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (tagNameSearch.equals(tagName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                tagList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Tag Card for check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String tagNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        boolean tagAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Наименование тега'",
                tagName, tagNameForCheck);
        Assert.assertEquals("Изменился параметр доступности Тега рубрики",
                tagAvailable, tagAvailableForCheck);
        System.out.println("Tag has been successfully verified");
    }

    public void deleteTag() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTags));
        driver.findElement(xpathTags).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(tagName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tagName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tagName));
        }
        List<WebElement> tagList = driver.findElements(xpathListInTable);
        for (int i = 0; i < tagList.size(); i++) {
            String tagNameSearch = tagList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (tagNameSearch.equals(tagName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                tagList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> tagListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Тег рубрики не удален",
                0, tagListCheck.size());
        System.out.println("Tag successfully Deleted");
    }
}
