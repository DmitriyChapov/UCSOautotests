package login.main.reference_books.description_transport_card;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class DescriptionTransportCardPage extends Login {
    boolean descriptionsTransportCardAvailable;

    public void sectionReferenceBooks(){
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники'",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionDescriptionsTransportCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathDescriptionsTransportCards));
        driver.findElement(xpathDescriptionsTransportCards).click();
        String descriptionsTransportCardUrlNow = driver.getCurrentUrl();
        String descriptionsTransportCardPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник Описаний карты'",
                descriptionsTransportCardUrl, descriptionsTransportCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник Описаний карты'",
                descriptionsTransportCardPageName, descriptionsTransportCardPageNameNow);
        System.out.println("Go to subsection: Descriptions Transport Card");
    }

    public void openDescriptionsTransportCardCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String descriptionsTransportCardCardUrlNow = driver.getCurrentUrl();
        String descriptionsTransportCardCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка описаний карты'",
                descriptionsTransportCardCardUrl, descriptionsTransportCardCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка описаний карты'",
                descriptionsTransportCardCardPageName,descriptionsTransportCardCardPageNameNow);
        System.out.println("Open Descriptions Transport Card Card");
    }

    public void createDescriptionsTransportCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(descriptionsTransportCardName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        descriptionsTransportCardAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationDescriptionsTransportCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Описания карты",
                descriptionsTransportCardSaveNotification, textNotificationDescriptionsTransportCardSave);
        System.out.println("Descriptions Transport Card Card successfully Created");
    }

    public void checkDescriptionsTransportCardCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathDescriptionsTransportCards));
        driver.findElement(xpathDescriptionsTransportCards).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(descriptionsTransportCardName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", descriptionsTransportCardName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", descriptionsTransportCardName));
        }
        List<WebElement> descriptionsTransportCardList = driver.findElements(xpathListInTable);
        for (int i = 0; i < descriptionsTransportCardList.size(); i++) {
            String descriptionsTransportCardNameSearch = descriptionsTransportCardList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (descriptionsTransportCardNameSearch.equals(descriptionsTransportCardName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                descriptionsTransportCardList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Descriptions Transport Card Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String descriptionsTransportCardNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String codeOTKForCheck = driver.findElement(selectorFieldCodeOTK).getAttribute("value");
        boolean descriptionsTransportCardAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Описание карты'",
                descriptionsTransportCardName, descriptionsTransportCardNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Код ОТК'",
                codeOTK, codeOTKForCheck);
        Assert.assertEquals("Изменился параметр доступности Описания карты",
                descriptionsTransportCardAvailable, descriptionsTransportCardAvailableForCheck);
        System.out.println("Descriptions Transport Card Card has been successfully Verified");
    }

    public void deleteDescriptionsTransportCard()   {
        wait.until(ExpectedConditions.elementToBeClickable(xpathDescriptionsTransportCards));
        driver.findElement(xpathDescriptionsTransportCards).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(descriptionsTransportCardName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", descriptionsTransportCardName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", descriptionsTransportCardName));
        }
        List<WebElement> descriptionsTransportCardList = driver.findElements(xpathListInTable);
        for (int i = 0; i < descriptionsTransportCardList.size(); i++) {
            String descriptionsTransportCardNameSearch = descriptionsTransportCardList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (descriptionsTransportCardNameSearch.equals(descriptionsTransportCardName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                descriptionsTransportCardList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> descriptionsTransportCardListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Описание транспортной карты не удалено",
                0, descriptionsTransportCardListCheck.size());
        System.out.println("Descriptions Transport Card successfully Deleted");
    }
}
