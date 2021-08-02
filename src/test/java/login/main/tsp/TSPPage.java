package login.main.tsp;

import login.Login;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.admin.Numbers.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;

public class TSPPage extends Login {
    boolean CheckBox;

    public void sectionTSP() {
        loginAdmin();
        driver.findElement(xpathTSP).click();
        System.out.println("Go to section: TSP");
    }

    public void openTSPCard(String tsp) {
        sectionTSP(); // Переход в раздел "Торгово-сервисные предприятия"
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(tsp);
        wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
        driver.findElement(xpathIconEdit).click();
        System.out.println("Open TSP Card");
    }

    //@Test
    public void openTabPromotions() {
        driver.findElement(xpathTabPromotions).click();
        System.out.println("Go to tab Promotions");
    }

    public void openPromotionCard() {
        openTabPromotions(); // Переход во вкладку "Акции", в карточке "Торгово-сервисного предприятия"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Promotion Card");
    }

    public void tabPropertiesPromotionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
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

    public void tabContentPromotionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        for (int i = 0; i < nmbAddressForPromotionAdmin; i++) {
            String deliveryAddress = "Адрес предоставления № " + (i + 1);
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            driver.findElement(selectorAddAddressOffer).click();
        }
        driver.findElement(selectorFieldContentTitle).sendKeys(promotionName);
        driver.findElement(selectorFieldOfferDateFrom).sendKeys(dateNow);
        driver.findElement(selectorFieldOfferDateTo).sendKeys(dateNow);
        driver.findElement(selectorFieldContentTeaser).sendKeys(descriptionAndConditionPromotion.repeat(nmbRptForPromotionAdmin));
        addImagePromotionCard(); // Прикрепляем изображение
    }

    public void addImagePromotionCard() {
        driver.findElement(xpathButtonSpanDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imagePromotionAdmin);
        driver.findElement(xpathButtonSaveImage).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonSaveImage));
    }

    public void createPromotion() {
        openPromotionCard();             // Открываем Карточку акции
        tabPropertiesPromotionCard();    // Заполняем вкладку "Свойства"
        tabContentPromotionCard();       // Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Promotion");
    }

    public void publicPromotion() {
        createPromotion(); // Создаем Акцию
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Public Promotion");
    }

    public void comparePromotion() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        boolean PromotionPortalCheckBoxForCheck = driver.findElement(xpathPortal).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Портал'", CheckBox, PromotionPortalCheckBoxForCheck);
        System.out.println("Promotion has been successfully Verified");

    }

    public void openTabDiscount() throws InterruptedException {
        //openTSPCard(tspNameAdmin);            // Открываем Карточку торгово-сервисного предприятия
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
        for (int i = 0; i < nmbAddressForDiscountAdmin; i++) {
            String deliveryAddress = "Адрес предоставления № " + (i + 1);
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            driver.findElement(selectorAddAddressOffer).click();
        }
        driver.findElement(selectorFieldContentTitle).sendKeys(discountName);
        driver.findElement(selectorFieldOfferDateFrom).sendKeys(dateNow);
        driver.findElement(selectorFieldOfferDateTo).sendKeys(dateNow);
        driver.findElement(selectorFieldContentTeaser).sendKeys(descriptionAndConditionDiscount.repeat(nmbRptForDiscountAdmin));
        driver.findElement(selectorFieldDiscount).sendKeys(discount);
        Thread.sleep(1000);
        addImageDiscountCard();            // Прикрепляем изображение
    }

    public void addImageDiscountCard() throws InterruptedException {
        driver.findElement(xpathButtonSpanDownloadImage).click();
        Thread.sleep(1000);
        driver.findElement(selectorFieldImage).sendKeys(imageDiscountAdmin);
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