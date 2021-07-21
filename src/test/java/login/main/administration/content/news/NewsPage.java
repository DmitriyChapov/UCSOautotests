package login.main.administration.content.news;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.Strings.*;
import static variables.FilesForAdd.*;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import java.util.List;

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
        driver.findElementByClassName("cdk-overlay-container").click();
    }

    public void tabContentNewsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldContentTitle));
        driver.findElement(selectorFieldContentTitle).sendKeys(newsHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(newsAnnouncement);
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
            driver.findElement(selectorFieldImage).sendKeys(imageNewsGallery(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveImage));
            driver.findElement(xpathButtonSaveImage).click();
        }
    }

    public void createNews() {
        openNewsCard();                          // Открываем Карточку новости
        tabPropertiesNewsCard();                 // Заполняем вкладку "Свойства"
        tabContentNewsCard();                    // Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationNewsCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Новости",
                newsCardSaveNotification, textNotificationNewsCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        System.out.println("News successfully Created");
    }

    public void publicNews() {
        createNews();                         // Создаем Новость
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationNewsCardPublicNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при публикации Новости",
                newsCardPublicNotification, textNotificationNewsCardPublicNow);
        System.out.println("News successfully Published");
    }

    public void createAndPublicNews(){
        loginAdmin();
        sectionContentNews();
        publicNews();
    }

}
