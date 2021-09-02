package code.main.administration.content.afisha;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static variables.admin.Collections.*;
import static variables.admin.Numbers.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.common.Strings.*;

public class PostersPage extends Login {

    public void sectionContentPosters() {
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathContent);
        actionChange.moveToElement(sectionAdmin);
        actionChange.moveToElement(subsectionContent).click();
        actionChange.perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathPoster));
        driver.findElement(xpathPoster).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentsPage));
        String postersUrlNow = driver.getCurrentUrl();
        String postersPageNameNow = driver.findElement(headingContentsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Афиши'", postersUrl, postersUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Афиши'", postersPageName, postersPageNameNow);
        System.out.println("Go to section: Posters");
    }

    public void openPosterCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentsPage));
        driver.findElement(xpathButtonAdd).click();
        String posterCardUrlNow = driver.getCurrentUrl();
        String posterCardPageNameNow = driver.findElement(headingContentCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка новости'", posterCardUrl, posterCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка новости'", posterCardPageName, posterCardPageNameNow);
        System.out.println("Open Poster Card");
    }

    public void tabPropertiesPosterCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentCard));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        dateAndTime();
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
        posterCategory = driver.findElement(xpathTagForContents).getText();
        driver.findElementByClassName("cdk-overlay-container").click();
    }

    public void tabContentPosterCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldContentTitle));
        contentCreationDate = driver.findElement(selectorContentCreationDate).getText();
        driver.findElement(selectorFieldContentTitle).sendKeys(posterHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(posterTeaser);
        driver.findElement(selectorFieldContentText).sendKeys(posterText.repeat(20));
        driver.findElement(selectorFieldAge).sendKeys(String.valueOf(age));
        driver.findElement(selectorFieldEventDate).sendKeys(posterEventDate);
        driver.findElement(selectorFieldEventLocation).sendKeys(posterEventLocation);
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForEvent));
        driver.findElement(xpathLocationForEvent).click();
        driver.findElement(selectorFieldEventCost).sendKeys(posterEventCost);
        driver.findElement(selectorFieldEventSchedule).sendKeys(posterEventSchedule);
        addImagePosterCard();             // Прикрепляем изображения
    }

    public void addImagePosterCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDownloadImage));
        driver.findElement(xpathButtonDownloadImage).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathRadioButtonPrevImage));
        driver.findElement(xpathRadioButtonPrevImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imagePosterPrev);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
        driver.findElement(xpathButtonSaveImage).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDownloadImage));
        driver.findElement(xpathButtonDownloadImage).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathRadioButtonMainImage));
        driver.findElement(xpathRadioButtonMainImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imagePosterMain);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
        driver.findElement(xpathButtonSaveImage).click();
        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDownloadImage));
            driver.findElement(xpathButtonDownloadImage).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
            driver.findElement(selectorFieldImage).sendKeys(imagePosterGallery(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
            driver.findElement(xpathButtonSaveImage).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonSaveImage));
        }
        countImage = driver.findElements(xpathContentImage).size();
    }

    public void createPoster() {
        tabPropertiesPosterCard();            // Заполняем вкладку "Свойства"
        tabContentPosterCard();               // Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationPosterCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Афиши",
                posterCardSaveNotification, textNotificationPosterCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        String statePosterNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Афиши после создания",
                stateCreate.toUpperCase(), statePosterNow);
        System.out.println("Poster successfully Created");
    }

    public void getPosterID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathPosterHeadingID)));
        String temp = driver.findElement(xpathPosterHeadingID).getText();
        posterCardId = temp.substring(temp.length() - 5);
    }

    public void publicPoster() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationPosterCardPublicNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при публикации Афиши",
                posterCardPublicNotification, textNotificationPosterCardPublicNow);
        String statePosterNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Афиши после публикации",
                statePublic.toUpperCase(), statePosterNow);
        System.out.println("Poster ID: " + posterCardId + " successfully Published");
    }

    public void checkPosterBlock(String Status) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-500);");
        wait.until(ExpectedConditions.elementToBeClickable(xpathPoster));
        driver.findElement(xpathPoster).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentsPage));
        driver.findElement(selectorFieldSearch).sendKeys(posterHeading);
        waitingSpinner();
        posterList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < posterList.size(); i++) {
            String posterNameSearch = posterList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (posterNameSearch.equals(posterHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingPosterBlock(i,Status);
                System.out.println("Poster ID: " + posterCardId + " in Section 'Posters - Administration' has been successfully Verified");
                posterList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Poster Card for Check");
                break;
            }
        }
    }

    public void checkingPosterBlock(int i, String Status) {
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
        String posterIDBlock = posterList.get(i).findElement(xpathContentIDInBlocks).getText();
        Assert.assertEquals("Некорректный ID Афиши в общем списке Афиш",
                posterCardId, posterIDBlock.substring(posterIDBlock.length()-5));
        String posterStateBlock = posterList.get(i).findElement(xpathContentStateInBlocks).getText();
        posterStateBlock = posterStateBlock.substring(0,posterStateBlock.indexOf('\n'));
        Assert.assertEquals("Некорректный статус Афиши в общем списке Афиш",
                state.toUpperCase(), posterStateBlock);
        String posterCreationDateBlock = posterList.get(i).findElement(xpathContentCreationDateInBlocks).getText();
        Assert.assertEquals("Некорректная дата " + stateText2 + " Афиши в общем списке Афиш",
                date, posterCreationDateBlock);
        String posterHeadingBlock = posterList.get(i).findElement(xpathContentHeadingInBlocks).getText();
        Assert.assertEquals("Некорректный заголовок Афиши в общем списке Афиш",
                posterHeading, posterHeadingBlock);
        String posterTeaserBlock = posterList.get(i).findElement(xpathContentTeaserInBlocks).getText();
        Assert.assertEquals("Некорректный анонс Афиши в общем списке Афиш",
                posterTeaser, posterTeaserBlock);
        String posterTagsBlock = posterList.get(i).findElement(xpathContentTagsInBlocks).getText();
        Assert.assertEquals("Некорректный тег Афиши в общем списке Афиш",
                "Автотест", posterTagsBlock);
    }

    public void checkPosterCard(String state){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentCard));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        String posterIdForCheck = driver.findElement(xpathContentCardId).getText();
        String posterStateForCheck = driver.findElement(xpathContentCardState).getText();
        boolean posterPortalAvailableForCheck = driver.findElement(xpathPortal).isSelected();
        boolean posterMobileAvailableForCheck = driver.findElement(xpathMobile).isSelected();
        String posterPortalDateStartForCheck = datepicker.get(4).getAttribute("value");
        String posterPortalTimeStartForCheck = timepicker.get(4).getAttribute("value");
        String posterPortalDateFinishForCheck = datepicker.get(5).getAttribute("value");
        String posterPortalTimeFinishForCheck = timepicker.get(5).getAttribute("value");
        String posterMobileDateStartForCheck = datepicker.get(0).getAttribute("value");
        String posterMobileTimeStartForCheck = timepicker.get(0).getAttribute("value");
        String posterMobileDateFinishForCheck = datepicker.get(1).getAttribute("value");
        String posterMobileTimeFinishForCheck = timepicker.get(1).getAttribute("value");
        String posterRubricsForCheck = driver.findElement(xpathRubrics).getText();
        boolean posterLocationForCheck = driver.findElement(xpathLocationForContent).isSelected();
        Assert.assertEquals("Некорректный ID Афиши внутри карточки",
                posterCardId, posterIdForCheck.substring(posterIdForCheck.length()-5));
        Assert.assertEquals("Некорректный статус Афиши внутри карточки",
                state.toUpperCase(), posterStateForCheck);
        Assert.assertEquals("Изменился параметр доступности размещения Афиши на Портале",
                contentPortalAvailable, posterPortalAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Афиши на Портале'",
                dateNow, posterPortalDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Афиши на Портале'",
                timeNow, posterPortalTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Афиши на Портале'",
                dateNow, posterPortalDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Афиши на Портале'",
                "23:59", posterPortalTimeFinishForCheck );
        Assert.assertEquals("Изменился параметр доступности размещения Афиши в Мобильном Приложении",
                contentMobileAvailable, posterMobileAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Афиши в Мобильном Приложении'",
                dateNow, posterMobileDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Афиши в Мобильном Приложении'",
                timeNow, posterMobileTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Афиши в Мобильном Приложении'",
                dateNow, posterMobileDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Афиши в Мобильном Приложении'",
                "23:59", posterMobileTimeFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Тег рубрики Афиши'",
                "Автотест", posterRubricsForCheck );
        Assert.assertEquals("Изменился параметр доступности локации Афиши",
                contentLocationAvailable, posterLocationForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        String posterTypeForCheck = driver.findElement(xpathContentType).getText();
        String posterHeadingForCheck = driver.findElement(selectorFieldContentTitle).getAttribute("value");
        String posterTeaserForCheck = driver.findElement(selectorFieldContentTeaser).getAttribute("value");
        String posterAgeForCheck = driver.findElement(selectorFieldAge).getAttribute("value");
        String posterTextForCheck = driver.findElement(xpathContentText).getText();
        String posterEventDateForCheck = driver.findElement(selectorFieldEventDate).getAttribute("value");
        String posterEventLocationForCheck = driver.findElement(selectorFieldEventLocation).getAttribute("value");
        String posterEventCostForCheck = driver.findElement(selectorFieldEventCost).getAttribute("value");
        String posterEventScheduleForCheck = driver.findElement(selectorFieldEventSchedule).getAttribute("value");
        int countImageForCheck = driver.findElements(xpathContentImage).size();
        Assert.assertEquals("Некорректный тип контента внутри карточки Афиши",
                "Афиша", posterTypeForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Заголовок' в карточке Афиши",
                posterHeading, posterHeadingForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Анонс' в карточке Афиши",
                posterTeaser, posterTeaserForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Возраст' в карточке Афиши",
                String.valueOf(age), posterAgeForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Текст' в карточке Афиши",
                fullPosterText, posterTextForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата проведения' в карточке Афиши",
                posterEventDate, posterEventDateForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Место проведения' в карточке Афиши",
                posterEventLocation, posterEventLocationForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Стоимость' в карточке Афиши",
                posterEventCost, posterEventCostForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Расписание и билет' в карточке Афиши",
                posterEventSchedule, posterEventScheduleForCheck );
        Assert.assertEquals("Некорректное кол-во 'Изображений' в карточке Афиши",
                countImage, countImageForCheck );
        System.out.println("Poster ID: " + posterCardId + " Card has been successfully Verified");
    }

    public void deletePoster(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
        driver.findElement(xpathButtonDelete).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentDeleteDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;
    }

    public void unPublicPoster(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonUnPublic));
        driver.findElement(xpathButtonUnPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentUnPublicDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;
    }

    public void checkModifiedPosterBlock(String Status){
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
        driver.findElement(selectorFieldSearch).sendKeys(posterHeading);
        waitingSpinner();
        posterList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < posterList.size(); i++) {
            String posterNameSearch = posterList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (posterNameSearch.equals(posterHeading)) {
                Assert.assertNotEquals(stateText1 +" Афиша отображается в разделе 'Информационный блок'",
                        posterHeading, posterNameSearch);
            }
        }
        driver.findElement(xpathTabArchive).click();
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(posterHeading);
        waitingSpinner();
        posterList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < posterList.size(); i++) {
            String posterNameSearch = posterList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (posterNameSearch.equals(posterHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingPosterBlock(i,Status);
                System.out.println("Poster ID: " + posterCardId + " in Section 'Posters - Administration - Archive' has been successfully Verified");
                posterList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Poster Card for Check in Archive");
                break;
            }
            else{
                Assert.assertEquals(stateText1 + " Афиша  не отображается в разделе 'Архив'",
                        posterHeading, posterNameSearch);
            }
        }
    }

    public void createAndDeletePoster(){
        loginAdmin();                               // Авторизация под пользователем с правами "Администратор"
        sectionContentPosters();                    // Переход в раздел "Афиши"
        openPosterCard();                           // Открываем карточку Афиши
        createPoster();                             // Создаем Афишу
        getPosterID();                              // Получаем ID Афиши
        checkPosterBlock("Create");           // Проверяем корректность блока Афиши - Информационный блок
        checkPosterCard(stateCreate);               // Проверяем заполненность карточки Афиши
        deletePoster();                             // Удаляем Афишу
        checkModifiedPosterBlock("Delete");   // Проверяем корректность блока Афиши - Архив
        checkPosterCard(stateDelete);               // Проверяем заполненность карточки Афиши - Архив
    }

    public void publicAndUnPublicPoster(){
        loginAdmin();                                         // Авторизация под пользователем с правами "Администратор"
        sectionContentPosters();                              // Переход в раздел "Афиши"
        openPosterCard();                                     // Открываем карточку Афиши
        createPoster();                                       // Создаем Афишу
        getPosterID();                                        // Получаем ID Афиши
        publicPoster();                                       // Публикуем Афишу
        checkPosterBlock("Public");                     // Проверяем корректность блока Афиши - Информационный блок
        checkPosterCard(statePublic);                         // Проверяем заполненность карточки Афиши  - Информационный блок
        unPublicPoster();                                     // Снимаем Афишу с публикации
        checkModifiedPosterBlock("UnPublic");           // Проверяем корректность блока Афиши - Архив
        checkPosterCard(stateUnPublic);                       // Проверяем заполненность карточки Афиши - Архив
    }
}
