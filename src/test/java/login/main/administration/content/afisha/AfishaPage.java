package login.main.administration.content.afisha;

import login.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static variables.Numbers.*;
import static variables.Strings.*;
import static variables.FilesForAdd.*;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import java.util.List;

public class AfishaPage extends Login {

    public void sectionContentAfisha() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionKontent = driver.findElement(xpathContent);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionKontent).click();
        actionchange.perform();
        Thread.sleep(3000);
        driver.findElement(xpathPoster).click();
        System.out.println("Go to section: Afishi");
    }

    public void openAfishaCard() throws InterruptedException {
        sectionContentAfisha();                     // Переход в подраздел "Афиши", раздела "Контент"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Afisha Card");
    }

    public void tabPropertiesAfishaCard() throws InterruptedException {
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

    public void tabContentAfishaCard() throws InterruptedException {
        driver.findElement(xpathTabContent).click();
        Thread.sleep(2000);
        driver.findElement(selectorFieldContentTitle).sendKeys(posterHeading);
        driver.findElement(selectorFieldContentTeaser).sendKeys(posterAnnouncement);
        driver.findElement(selectorFieldContentText).sendKeys(posterText.repeat(20));
        Thread.sleep(2000);
        driver.findElement(selectorFieldAge).sendKeys(String.valueOf(age));
        driver.findElement(selectorFieldEventDate).sendKeys(posterDate);
        driver.findElement(selectorFieldEventLocation).sendKeys(posterLocation);
        Thread.sleep(2000);
        driver.findElement(xpathLocationForEvent).click();
        driver.findElement(selectorFieldEventCost).sendKeys(posterCost);
        driver.findElement(selectorFieldEventShedule).sendKeys(scheduleAfisha);
        Thread.sleep(1000);
        addImageAfishaCard();             // Прикрепляем изображения
    }

    public void addImageAfishaCard() throws InterruptedException {
        driver.findElement(xpathButtonDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(xpathRadioButtonPrevImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageAfishaPrev);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(xpathRadioButtonMainImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageAfishaMain);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageAfishaGallery_1);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageAfishaGallery_2);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
        Thread.sleep(3000);
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageAfishaGallery_3);
        Thread.sleep(3000);
        driver.findElement(xpathButtonSaveImage).click();
    }

    public void createAfisha() throws InterruptedException {
        openAfishaCard();                   // Открываем Карточку афиши
        Thread.sleep(2000);
        tabPropertiesAfishaCard();            // Заполняем вкладку "Свойства"
        Thread.sleep(2000);
        tabContentAfishaCard();               // Заполняем вкладку "Содержимое"
        Thread.sleep(3000);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Afisha");
    }

    public void publicAfisha() throws InterruptedException {
        createAfisha();                 // Создаем Афишу
        Thread.sleep(2000);
        driver.findElement(xpathButtonPublic).click();
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindom).click();
        System.out.println("Public Afisha");
    }
}
