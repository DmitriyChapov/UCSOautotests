package login.main.administration.content.news;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static variables.Strings.*;
import static variables.FilesForAdd.*;
import static variables.Xpath.*;
import static variables.Selector.*;

import java.util.List;

public class NewsPage extends Login {

    public void sectionContentNews() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionKontent = driver.findElement(xpathContent);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionKontent).click();
        actionchange.perform();
        String newsUrl = driver.getCurrentUrl();
        String newsPageName = driver.findElement(headingContentsPage).getText();
        Assert.assertEquals("Раздел \"Контент\" недоступен",
                newsUrl, "https://ucso-test.opencode.su/news-dashboard/publications?type=NEWS&searchString=");
        Assert.assertEquals("Подраздел \"Новости\" недоступен", "Новости", newsPageName);
        System.out.println("Go to section: News");
    }

    public void openNewsCard() throws InterruptedException {
        sectionContentNews();                       // Переход в подраздел "Новости", раздела "Контент"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        String newsCardUrl = driver.getCurrentUrl();
        String newsCardPageName = driver.findElement(headingContentCard).getText();
        Assert.assertEquals("Карточка новости недоступна",newsCardUrl, "https://ucso-test.opencode.su/news-dashboard/posts-editor?type=NEWS");
        Assert.assertEquals(newsCardPageName, "Карточка новости");
        System.out.println("Open News Card");
    }

    public void tabPropertiesNewsCard() throws InterruptedException {
        List<WebElement> datepicker = driver.findElements(dateFields);
        List<WebElement> timepicker = driver.findElements(timeFields);
        driver.findElement(xpathPortal).click();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        driver.findElement(xpathMobile).click();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        driver.findElement(xpathLocationForContent).click();
        driver.findElement(selectorSelectTags).click();
        Thread.sleep(1000);
        driver.findElement(xpathTagForContents).click();
        driver.findElementByClassName("cdk-overlay-container").click();
    }

    public void tabContentNewsCard() throws InterruptedException {
        driver.findElement(xpathTabContent).click();
        Thread.sleep(2000);
        driver.findElement(selectorFieldContentTitle).sendKeys(newsHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(newsAnnouncement);
        driver.findElement(selectorFieldContentText).sendKeys(newsText.repeat(20));
        Thread.sleep(1000);
        addImageNewsCard();            // Прикрепляем изображения
    }

    public void addImageNewsCard() throws InterruptedException {
        driver.findElement(xpathButtonDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(xpathRadioButtonPrevImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageNewsPrev);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageNewsGallery_1);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageNewsGallery_2);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageNewsGallery_3);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
    }

    public void createNews() throws InterruptedException {
        openNewsCard();                          // Открываем Карточку новости
        Thread.sleep(2000);
        tabPropertiesNewsCard();                 // Заполняем вкладку "Свойства"
        Thread.sleep(2000);
        tabContentNewsCard();                    // Заполняем вкладку "Содержимое"
        Thread.sleep(2000);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create News");
    }

    public void publicNews() throws InterruptedException {
        createNews();                         // Создаем Новость
        Thread.sleep(2000);
        driver.findElement(xpathButtonPublic).click();
        Thread.sleep(1000);
        driver.findElement(xpathButtonSaveInWindom).click();
        System.out.println("Public News");
    }
}
