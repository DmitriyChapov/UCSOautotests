package code.main.administration.content.news;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.admin.Numbers.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Collections.*;
import static variables.common.Strings.*;

import java.time.format.DateTimeFormatter;

public class NewsPage extends Login {

    public void sectionContentNews() {
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathContent);
        actionChange.moveToElement(sectionAdmin);
        actionChange.moveToElement(subsectionContent).click();
        actionChange.perform();
        String newsUrlNow = driver.getCurrentUrl();
        String newsPageNameNow = driver.findElement(headingContentsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Новости'",
                newsUrl, newsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Новости'", newsPageName, newsPageNameNow);
        System.out.println("Go to section: News");
    }

    public void openNewsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String newsCardUrlNow = driver.getCurrentUrl();
        String newsCardPageNameNow = driver.findElement(headingContentCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка новости'",
                newsCardUrl, newsCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка новости'",
                newsCardPageName, newsCardPageNameNow);
        System.out.println("Open News Card");
    }

    public void tabPropertiesNewsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        driver.findElement(xpathPortal).click();
        contentPortalAvailable = driver.findElement(xpathPortal).isSelected();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathMobile));
        driver.findElement(xpathMobile).click();
        contentMobileAvailable = driver.findElement(xpathMobile).isSelected();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForContent));
        driver.findElement(xpathLocationForContent).click();
        contentLocationAvailable = driver.findElement(xpathLocationForContent).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTags));
        driver.findElement(selectorSelectTags).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathTagForContents));
        driver.findElement(xpathTagForContents).click();
        newsCategory = driver.findElement(xpathTagForContents).getText();
        driver.findElementByClassName("cdk-overlay-container").click();
    }

    public void tabContentNewsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldContentTitle));
        contentCreationDate = driver.findElement(selectorContentCreationDate).getText();
        driver.findElement(selectorFieldContentTitle).sendKeys(newsHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(newsTeaser);
        driver.findElement(selectorFieldContentText).sendKeys(newsText.repeat(20));
        addImageNewsCard();            // Прикрепляем изображения
    }

    public void addImageNewsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDownloadImage));
        driver.findElement(xpathButtonDownloadImage).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathRadioButtonPrevImage));
        driver.findElement(xpathRadioButtonPrevImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageNewsPrev);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
        driver.findElement(xpathButtonSaveImage).click();
        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDownloadImage));
            driver.findElement(xpathButtonDownloadImage).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
            driver.findElement(selectorFieldImage).sendKeys(imageNewsGallery(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
            driver.findElement(xpathButtonSaveImage).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonSaveImage));
        }
        countImage = driver.findElements(xpathContentImage).size();
    }

    public void createNews() {
        tabPropertiesNewsCard();                 // Заполняем вкладку "Свойства"
        tabContentNewsCard();                    // Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationNewsCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Новости",
                newsCardSaveNotification, textNotificationNewsCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        String stateNewsNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Новости после создания",
                stateCreate.toUpperCase(), stateNewsNow);
        System.out.println("News successfully Created");
    }

    public void getNewsID(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathContentCardId)));
        String newsCardTemp = driver.findElement(xpathContentCardId).getText();
        newsCardId = newsCardTemp.substring(newsCardTemp.length() - 5);
    }

    public void publicNews() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationNewsCardPublicNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при публикации Новости",
                newsCardPublicNotification, textNotificationNewsCardPublicNow);
        String stateNewsNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Новости после публикации",
                statePublic.toUpperCase(), stateNewsNow);
        System.out.println("News ID: " + newsCardId + " successfully Published");
    }

    public void checkNewsBlock(String Status) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-500);");
        wait.until(ExpectedConditions.elementToBeClickable(xpathNews));
        driver.findElement(xpathNews).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(newsHeading);
        waitingSpinner();
        newsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < newsList.size(); i++) {
            String newsNameSearch = newsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (newsNameSearch.equals(newsHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingNewsBlock(i,Status);
                System.out.println("News ID: " + newsCardId + " in Section 'News - Administration' has been successfully Verified");
                newsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open News Card for Check");
                break;
            }
        }
    }

    public void checkingNewsBlock(int i, String Status) {
        String stateText2 = "0", date = "0", state = "0";
        switch (Status){
            case "Create": {
                state = stateCreate;
                date = contentCreationDate;
                stateText2 = "создания";
                break;
            }
            case "Delete": {
                stateText2 = "удаления";
                date = contentDeleteDate;
                state = stateDelete;
                break;
            }
            case "Public": {
                stateText2 = "создания";
                date = contentCreationDate;
                state = statePublic;
                break;
            }
            case "UnPublic": {
                stateText2 = "снятия с публикации";
                date = contentUnPublicDate;
                state = stateUnPublic;
                break;
            }
        }
        String newsIDBlock = newsList.get(i).findElement(xpathContentIDInBlocks).getText();
        Assert.assertEquals("Некорректный ID Новости в общем списке Новостей",
                newsCardId, newsIDBlock.substring(newsIDBlock.length()-5));
        String newsStateBlock = newsList.get(i).findElement(xpathContentStateInBlocks).getText();
        newsStateBlock = newsStateBlock.substring(0,newsStateBlock.indexOf('\n'));
        Assert.assertEquals("Некорректный статус Новости в общем списке Новостей",
                state.toUpperCase(), newsStateBlock);
        String newsCreationDateBlock = newsList.get(i).findElement(xpathContentCreationDateInBlocks).getText();
        Assert.assertEquals("Некорректная дата " + stateText2 + " Новости в общем списке Новостей",
                date, newsCreationDateBlock);
        String newsHeadingBlock = newsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
        Assert.assertEquals("Некорректный заголовок Новости в общем списке Новостей",
                newsHeading, newsHeadingBlock);
        String newsTeaserBlock = newsList.get(i).findElement(xpathContentTeaserInBlocks).getText();
        Assert.assertEquals("Некорректный анонс Новости в общем списке Новостей",
                newsTeaser, newsTeaserBlock);
        String newsTagsBlock = newsList.get(i).findElement(xpathContentTagsInBlocks).getText();
        Assert.assertEquals("Некорректный тег Новости в общем списке Новостей",
                "Автотест", newsTagsBlock);
    }

    public void checkNewsCard(String state){
        wait.until(ExpectedConditions.presenceOfElementLocated(headingContentCard));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        String newsIdForCheck = driver.findElement(xpathContentCardId).getText();
        String newsStateForCheck = driver.findElement(xpathContentCardState).getText();
        boolean newsPortalAvailableForCheck = driver.findElement(xpathPortal).isSelected();
        boolean newsMobileAvailableForCheck = driver.findElement(xpathMobile).isSelected();
        String newsPortalDateStartForCheck = datepicker.get(4).getAttribute("value");
        String newsPortalTimeStartForCheck = timepicker.get(4).getAttribute("value");
        String newsPortalDateFinishForCheck = datepicker.get(5).getAttribute("value");
        String newsPortalTimeFinishForCheck = timepicker.get(5).getAttribute("value");
        String newsMobileDateStartForCheck = datepicker.get(0).getAttribute("value");
        String newsMobileTimeStartForCheck = timepicker.get(0).getAttribute("value");
        String newsMobileDateFinishForCheck = datepicker.get(1).getAttribute("value");
        String newsMobileTimeFinishForCheck = timepicker.get(1).getAttribute("value");
        String newsRubricsForCheck = driver.findElement(xpathRubrics).getText();
        boolean newsLocationForCheck = driver.findElement(xpathLocationForContent).isSelected();
        Assert.assertEquals("Некорректный ID Новости внутри карточки",
                newsCardId, newsIdForCheck.substring(newsIdForCheck.length()-5));
        Assert.assertEquals("Некорректный статус Новости внутри карточки",
                state.toUpperCase(), newsStateForCheck);
        Assert.assertEquals("Изменился параметр доступности размещения Новости на Портале",
                contentPortalAvailable, newsPortalAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Новости на Портале'",
                dateNow, newsPortalDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Новости на Портале'",
                timeNow, newsPortalTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Новости на Портале'",
                dateNow, newsPortalDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Новости на Портале'",
                "23:59", newsPortalTimeFinishForCheck );
        Assert.assertEquals("Изменился параметр доступности размещения Новости в Мобильном Приложении",
                contentMobileAvailable, newsMobileAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Новости в Мобильном Приложении'",
                dateNow, newsMobileDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Новости в Мобильном Приложении'",
                timeNow, newsMobileTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Новости в Мобильном Приложении'",
                dateNow, newsMobileDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Новости в Мобильном Приложении'",
                "23:59", newsMobileTimeFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Тег рубрики Новости'",
                "Автотест", newsRubricsForCheck );
        Assert.assertEquals("Изменился параметр доступности локации Новости",
                contentLocationAvailable, newsLocationForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        String newsTypeForCheck = driver.findElement(xpathContentType).getText();
        String newsHeadingForCheck = driver.findElement(selectorFieldContentTitle).getAttribute("value");
        String newsTeaserForCheck = driver.findElement(selectorFieldContentTeaser).getAttribute("value");
        String newsTextForCheck = driver.findElement(xpathContentText).getText();
        int countImageForCheck = driver.findElements(xpathContentImage).size();
        Assert.assertEquals("Некорректный тип контента внутри карточки Новости",
                "Новость", newsTypeForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Заголовок' в карточке Новости",
                newsHeading, newsHeadingForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Анонс' в карточке Новости",
                newsTeaser, newsTeaserForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Текст' в карточке Новости",
                fullNewsText, newsTextForCheck );
        Assert.assertEquals("Некорректное кол-во 'Изображений' в карточке Новости",
                countImage, countImageForCheck );
        System.out.println("News ID: " + newsCardId + " Card has been successfully Verified");
    }

    public void deleteNews(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
        driver.findElement(xpathButtonDelete).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentDeleteDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(toDay) + " " + DateTimeFormatter.ofPattern("HH:mm").format(toTime);
    }

    public void unPublicNews(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonUnPublic));
        driver.findElement(xpathButtonUnPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentUnPublicDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(toDay) + " " + DateTimeFormatter.ofPattern("HH:mm").format(toTime);
    }

    public void checkModifiedNewsBlock(String Status){
        String stateText1 = "0";
        switch (Status){
            case "Delete":
                stateText1 = "Удаленная";
                break;
            case "UnPublic":
                stateText1 = "Снятая с публикации";
                break;
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(newsHeading);
        waitingSpinner();
        newsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < newsList.size(); i++) {
            String newsNameSearch = newsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (newsNameSearch.equals(newsHeading)) {
                Assert.assertNotEquals(stateText1 +" Новость отображается в разделе 'Информационный блок'",
                        newsHeading, newsNameSearch);
            }
        }
        driver.findElement(xpathTabArchive).click();
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(newsHeading);
        waitingSpinner();
        newsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < newsList.size(); i++) {
            String newsNameSearch = newsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (newsNameSearch.equals(newsHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingNewsBlock(i,Status);
                System.out.println("News ID: " + newsCardId + " in Section 'News - Administration - Archive' has been successfully Verified");
                newsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open News Card for Check in Archive");
                break;
            }
            else{
                Assert.assertEquals(stateText1 + " Новость  не отображается в разделе 'Архив'",
                        newsHeading, newsNameSearch);
            }
        }
    }

    public void createAndDeleteNews(){
        loginAdmin();                             // Авторизация под пользователем с правами "Администратор"
        sectionContentNews();                     // Переход в раздел "Новости"
        openNewsCard();                           // Открываем Карточку новости
        createNews();                             // Создаем Новость
        getNewsID();                              // Получаем ID Новости
        checkNewsBlock("Create");           // Проверяем корректность блока Новости - Информационный блок
        checkNewsCard(stateCreate);               // Проверяем заполненность карточки Новости
        deleteNews();                             // Удаляем Новость
        checkModifiedNewsBlock("Delete");   // Проверяем корректность блока Новости - Архив
        checkNewsCard(stateDelete);               // Проверяем заполненность карточки Новости - Архив
    }

    public void publicAndUnPublicNews(){
        loginAdmin();                                       // Авторизация под пользователем с правами "Администратор"
        sectionContentNews();                               // Переход в раздел "Новости"
        openNewsCard();                                     // Открываем карточку новости
        createNews();                                       // Создаем Новость
        getNewsID();                                        // Получаем ID Новости
        publicNews();                                       // Публикуем Новость
        checkNewsBlock("Public");                     // Проверяем корректность блока Новости - Информационный блок
        checkNewsCard(statePublic);                         // Проверяем заполненность карточки Новости  - Информационный блок
        unPublicNews();                                     // Снимаем Новость с публикации
        checkModifiedNewsBlock("UnPublic");           // Проверяем корректность блока Новости - Архив
        checkNewsCard(stateUnPublic);                       // Проверяем заполненность карточки Новости - Архив
    }

}
