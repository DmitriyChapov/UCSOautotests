package login.main.tsp;

import login.Login;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
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
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tsp));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", tsp));
        }
        List<WebElement> TSPList = driver.findElements(xpathListInTable);
        for (int i = 0; i < TSPList.size(); i++) {
            String TSPNameSearch = TSPList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (TSPNameSearch.equals(tsp)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                TSPList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open TSP Card");
                break;
            }
        }
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
        boolean PromotionMobileCheckBoxForCheck = driver.findElement(xpathMobile).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Мобильное приложение'", CheckBox, PromotionMobileCheckBoxForCheck);
        String PromotionDateForCheck = driver.findElement(dateFields).getAttribute("value");
        Assert.assertEquals("Некорректно заполнены поля дат", dateNow, PromotionDateForCheck);
        String PromotionTimeForCheck = driver.findElement(timeFields).getAttribute("value");
        Assert.assertEquals("Некорректно заполнены поля времени", timeNow, PromotionTimeForCheck);
        boolean LocalListCheckBoxForCheck = driver.findElement(xpathLocationForContent).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Самарская область'", CheckBox, LocalListCheckBoxForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        String PromotionNameForCheck = driver.findElement(selectorFieldContentTitle).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'", promotionName, PromotionNameForCheck);
        String PromotionDateFromForCheck = driver.findElement(selectorFieldOfferDateFrom).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено первое поле 'Период действия'", dateNow, PromotionDateFromForCheck);
        String PromotionDateToForCheck = driver.findElement(selectorFieldOfferDateTo).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено второе поле 'Период действия'", dateNow, PromotionDateToForCheck);
        String PromotionDescriptionForCheck = driver.findElement(selectorFieldContentTeaser).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено второе поле 'Описание'", descriptionAndConditionPromotion.repeat(nmbRptForPromotionAdmin), PromotionDescriptionForCheck);

        /*for (int i = 0; i < nmbAddressForPromotionAdmin; i++) {
            String deliveryAddress = "Адрес предоставления № " + (i + 1);
            String PromotionAddressForCheck = driver.findElement(xpathChosenAddress).getText();
            //Assert.assertEquals("Некорректно заполнены поля 'Адреса предоставления'", deliveryAddress, PromotionAddressForCheck);
            System.out.println(PromotionAddressForCheck);

        }*/ //ДОДЕЛАТЬ!(НЕ ДОЙДЁТ НИКАК)

        System.out.println("Promotion has been successfully Verified");
        driver.navigate().back();
        driver.navigate().back();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
    }

    public void openTabDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabDiscount));
        driver.findElement(xpathTabDiscount).click();
        System.out.println("Go to tab Discount");
    }

    public void openDiscountCard() {
        openTabDiscount(); // Переход во вкладку "Скидки", в карточке "Торгово-сервисного предприятия"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Discount Card");
    }

    public void tabPropertiesDiscountCard() {
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

    public void tabContentDiscountCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
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
        addImageDiscountCard();            // Прикрепляем изображение
    }

    public void addImageDiscountCard() {
        driver.findElement(xpathButtonSpanDownloadImage).click();
        driver.findElement(selectorFieldImage).sendKeys(imageDiscountAdmin);
        driver.findElement(xpathButtonSaveImage).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonSaveImage));

    }

    public void createDiscount() {
        openDiscountCard();             // Открываем Карточку скидки
        tabPropertiesDiscountCard();    //Заполняем вкладку "Свойства"
        tabContentDiscountCard();       //Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Discount");
    }

    public void publicDiscount() {
        createDiscount();                 // Создаем Скидку
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Public Discount");
    }

    public void compareDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        boolean DiscountPortalCheckBoxForCheck = driver.findElement(xpathPortal).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Портал'", CheckBox, DiscountPortalCheckBoxForCheck);
        boolean DiscountMobileCheckBoxForCheck = driver.findElement(xpathMobile).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Мобильное приложение'", CheckBox, DiscountMobileCheckBoxForCheck);
        String DiscountDateForCheck = driver.findElement(dateFields).getAttribute("value");
        Assert.assertEquals("Некорректно заполнены поля дат", dateNow, DiscountDateForCheck);
        String DiscountTimeForCheck = driver.findElement(timeFields).getAttribute("value");
        Assert.assertEquals("Некорректно заполнены поля времени", timeNow, DiscountTimeForCheck);
        boolean LocalListCheckBoxForCheck = driver.findElement(xpathLocationForContent).isSelected();
        Assert.assertEquals("Некорректно заполнен чек-бокс 'Самарская область'", CheckBox, LocalListCheckBoxForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        String DiscountNameForCheck = driver.findElement(selectorFieldContentTitle).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'", discountName, DiscountNameForCheck);
        String DiscountDateFromForCheck = driver.findElement(selectorFieldOfferDateFrom).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено первое поле 'Период действия'", dateNow, DiscountDateFromForCheck);
        String DiscountDateToForCheck = driver.findElement(selectorFieldOfferDateTo).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено второе поле 'Период действия'", dateNow, DiscountDateToForCheck);
        String DiscountDescriptionForCheck = driver.findElement(selectorFieldContentTeaser).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено второе поле 'Описание'", descriptionAndConditionDiscount.repeat(nmbRptForDiscountAdmin), DiscountDescriptionForCheck);
        String DiscountForCheck = driver.findElement(selectorFieldDiscount).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено второе поле 'Скидка'", discount, DiscountForCheck);

        /*for (int i = 0; i < nmbAddressForPromotionAdmin; i++) {
            String deliveryAddress = "Адрес предоставления № " + (i + 1);
            String PromotionAddressForCheck = driver.findElement(xpathChosenAddress).getText();
            //Assert.assertEquals("Некорректно заполнены поля 'Адреса предоставления'", deliveryAddress, PromotionAddressForCheck);
            System.out.println(PromotionAddressForCheck);

        }*/ //ДОДЕЛАТЬ!(НЕ ДОЙДЁТ НИКАК)
        System.out.println("Discount has been successfully Verified");
    }
}