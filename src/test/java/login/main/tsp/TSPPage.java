package login.main.tsp;

import login.Login;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import static variables.Numbers.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;
import static variables.FilesForAdd.*;

public class TSPPage extends Login {

    public void sectionTSP() throws InterruptedException {
        loginAdmin();
        driver.findElement(xpathTSP).click();
        System.out.println("Go to section: TSP");
    }

    public void openTSPCard(String tsp) throws InterruptedException {
        sectionTSP();                       // Переход в раздел "Торгово-сервисные предприятия"
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(tsp);
        Thread.sleep(2000);
        driver.findElement(xpathIconEdit).click();
        System.out.println("Open TSP Card");
    }
@Test
    public void openTabPromotions() throws InterruptedException {
        openTSPCard(tspNameAdmin);            // Открываем Карточку торгово-сервисного предприятия
        driver.findElement(xpathTabPromotions).click();
        System.out.println("Go to tab Promotions");
    }

    public void openPromotionCard() throws InterruptedException {
        openTabPromotions();                       // Переход во вкладку "Акции", в карточке "Торгово-сервисного предприятия"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Promotion Card");
    }

    public void tabPropertiesPromotionCard() {
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
    }

    public void tabContentPromotionCard() throws InterruptedException {
        driver.findElement(xpathTabContent).click();
        Thread.sleep(2000);
        for (int i = 0; i < nmbAddressForPromotion; i ++) {
            String deliveryAddress = "Адрес предоставления № " + (i+1);
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            driver.findElement(selectorAddAddressOffer).click();
        }
        driver.findElement(selectorFieldContentTitle).sendKeys(promotionName);
        driver.findElement(selectorFieldOfferDateFrom).sendKeys(dateNow);
        driver.findElement(selectorFieldOfferDateTo).sendKeys(dateNow);
        driver.findElement(selectorFieldContentTeaser).sendKeys(descriptionAndConditionPromotion.repeat(nmbRptForPromotion));
        Thread.sleep(1000);
        addImagePromotionCard();            // Прикрепляем изображение
    }

    public void addImagePromotionCard() throws InterruptedException {
        driver.findElement(xpathButtonDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(selectorFieldImage).sendKeys(imagePromotion);
        driver.findElement(xpathButtonSaveImage).click();
    }

    public void createPromotion() throws InterruptedException {
        openPromotionCard();             // Открываем Карточку акции
        Thread.sleep(2000);
        tabPropertiesPromotionCard();    //Заполняем вкладку "Свойства"
        Thread.sleep(2000);
        tabContentPromotionCard();       //Заполняем вкладку "Содержимое"
        Thread.sleep(2000);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Promotion");
    }

    public void publicPromotion() throws InterruptedException {
        createPromotion();                 // Создаем Акцию
        Thread.sleep(2000);
        driver.findElement(xpathButtonPublic).click();
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        Thread.sleep(2000);
        System.out.println("Public Promotion");
    }

    public void openTabDiscount() throws InterruptedException {
        openTSPCard(tspNameAdmin);            // Открываем Карточку торгово-сервисного предприятия
        driver.findElement(xpathTabDiscount).click();
        System.out.println("Go to tab Discount");
    }

    public void tabPropertiesDiscountCard() {
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
    }

    public void tabContentDiscountCard() throws InterruptedException {
        driver.findElement(xpathTabContent).click();
        Thread.sleep(2000);
        for (int i = 0; i < nmbAddressForDiscount; i ++) {
            String deliveryAddress = "Адрес предоставления № " + (i+1);
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            driver.findElement(selectorAddAddressOffer).click();
        }
        driver.findElement(selectorFieldContentTitle).sendKeys(discountName);
        driver.findElement(selectorFieldOfferDateFrom).sendKeys(dateNow);
        driver.findElement(selectorFieldOfferDateTo).sendKeys(dateNow);
        driver.findElement(selectorFieldContentTeaser).sendKeys(descriptionAndConditionDiscount.repeat(nmbRptForDiscount));
        driver.findElement(selectorFieldDiscount).sendKeys(discount);
        Thread.sleep(1000);
        addImageDiscountCard();            // Прикрепляем изображение
    }

    public void addImageDiscountCard() throws InterruptedException {
        driver.findElement(xpathButtonDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(selectorFieldImage).sendKeys(imageDiscount);
        driver.findElement(xpathButtonSaveImage).click();
    }

    public void openDiscountCard() throws InterruptedException {
        openTabDiscount();                       // Переход во вкладку "Скидки", в карточке "Торгово-сервисного предприятия"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Discount Card");
    }

    public void createDiscount() throws InterruptedException {
        openDiscountCard();             // Открываем Карточку скидки
        Thread.sleep(2000);
        tabPropertiesDiscountCard();    //Заполняем вкладку "Свойства"
        Thread.sleep(2000);
        tabContentDiscountCard();       //Заполняем вкладку "Содержимое"
        Thread.sleep(2000);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Discount");
    }

    public void publicDiscount() throws InterruptedException {
        createDiscount();                 // Создаем Скидку
        Thread.sleep(2000);
        driver.findElement(xpathButtonPublic).click();
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        Thread.sleep(2000);
        System.out.println("Public Discount");
    }
}