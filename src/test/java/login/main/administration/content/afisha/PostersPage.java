package login.main.administration.content.afisha;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Numbers.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import java.util.List;

public class PostersPage extends Login {

    public void sectionContentPosters() {
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathContent);
        actionChange.moveToElement(sectionAdmin);
        actionChange.moveToElement(subsectionContent).click();
        actionChange.perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathPoster));
        driver.findElement(xpathPoster).click();
        String postersUrlNow = driver.getCurrentUrl();
        String postersPageNameNow = driver.findElement(headingContentsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Афиши'", postersUrl, postersUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Афиши'", postersPageName, postersPageNameNow);
        System.out.println("Go to section: Posters");
    }

    public void openPosterCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String posterCardUrlNow = driver.getCurrentUrl();
        String posterCardPageNameNow = driver.findElement(headingContentCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка новости'", posterCardUrl, posterCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка новости'", posterCardPageName, posterCardPageNameNow);
        System.out.println("Open Poster Card");
    }

    public void tabPropertiesPosterCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        List<WebElement> datepicker = driver.findElements(dateFields);
        List<WebElement> timepicker = driver.findElements(timeFields);
        driver.findElement(xpathPortal).click();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathMobile));
        driver.findElement(xpathMobile).click();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForContent));
        driver.findElement(xpathLocationForContent).click();
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
        driver.findElement(selectorFieldContentTitle).sendKeys(posterHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(posterAnnouncement);
        driver.findElement(selectorFieldContentText).sendKeys(posterText.repeat(20));
        driver.findElement(selectorFieldAge).sendKeys(String.valueOf(age));
        driver.findElement(selectorFieldEventDate).sendKeys(posterDate);
        driver.findElement(selectorFieldEventLocation).sendKeys(posterLocation);
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForEvent));
        driver.findElement(xpathLocationForEvent).click();
        driver.findElement(selectorFieldEventCost).sendKeys(posterCost);
        driver.findElement(selectorFieldEventShedule).sendKeys(scheduleAfisha);
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
    }

    public void getPosterID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathPosterHeadingID)));
        String temp = driver.findElement(xpathPosterHeadingID).getText();
        posterCardId = temp.substring(temp.length() - 5);
        System.out.println("ID созданной афиши: " + posterCardId);
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
        System.out.println("Poster successfully Created");
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
        System.out.println("Poster successfully Published");
    }

    public void createAndPublicPoster(){
        loginAdmin();                             // Авторизация под пользователем с правами "Администратор"
        sectionContentPosters();                  // Переход в раздел "Афиши"
        openPosterCard();                         // Открываем Карточку афиши
        createPoster();                           // Создаем Афишу
        getPosterID();                            // Получаем ID Афиши
        publicPoster();                           // Публикуем Афишу
    }
}
