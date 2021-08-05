package login.main.tsp;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.String.valueOf;
import static variables.admin.Numbers.*;
import static variables.admin.Urls.TSP;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.common.Urls.*;
import static variables.common.Urls.urlInsatgram;
import static variables.admin.Collections.*;

public class TSPPage extends Login {
    boolean CheckBox;

    public void sectionTSP() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP));
        driver.findElement(xpathTSP).click();
        driver.findElement(xpathButtonAdd).click();

    }

    public void sectionCreationTSP() {
        driver.findElement(xpathTSPAvailableSlide).click();
        driver.findElement(xpathNameField).sendKeys(adminTSPName);
        driver.findElement(xpathDescriptionField).sendKeys(adminTSPDescription);
        driver.findElement(xpathAddressField).sendKeys(adminTSPAddress);
        driver.findElement(xpathEmailField).sendKeys(email);
        driver.findElement(xpathOgrnField).sendKeys(valueOf(adminOGRN));
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,500)", "");
        driver.findElement(xpathMCCField).click();
        driver.findElement(xpathMCCChooseField).click();
        driver.findElement(xpathButtonSpanDownloadImage).click();
        driver.findElement(xpathChooseFile).sendKeys(imageLogoTSPAdmin);
        driver.findElement(xpathButtonOk).click();
        pageDown.executeScript("scroll(0,2000)", "");
        driver.findElement(xpathSiteField).sendKeys(tspSitePublic);
        driver.findElement(xpathEmail2Field).sendKeys(adminTSPEmailPublic);
        driver.findElement(xpathPhone).sendKeys(adminTSPPhonePublic);
        driver.findElement(xpathVK).sendKeys(urlVK);
        driver.findElement(xpathOK).sendKeys(urlOK);
        driver.findElement(xpathFaceBook).sendKeys(urlFacebook);
        driver.findElement(xpathInst).sendKeys(urlInsatgram);
        driver.findElement(xpathDop).sendKeys(adminTSPOptionalText);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
    }

    public void compareTSP() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
        driver.get(TSP);
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(adminTSPName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        }
        List<WebElement> TSPList = driver.findElements(xpathListInTable);
        for (int i = 0; i < TSPList.size(); i++) {
            String TSPNameSearch = TSPList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (TSPNameSearch.equals(adminTSPName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                TSPList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open TSP Card for Check");
                break;
            }
        }
        boolean TSPAvailableForCheck = driver.findElement(xpathTSPAvailableSlide).isSelected();
        if (TSPAvailableForCheck) {
            Assert.assertEquals("Изменился параметр доступности карточки TSP",
                    xpathTSPAvailableSlide, TSPAvailableForCheck);
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathNameField));
        String TSPNameForCheck = driver.findElement(xpathNameField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'", adminTSPName, TSPNameForCheck);
        String TSPDescriptionForCheck = driver.findElement(xpathDescriptionField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Описание'", adminTSPDescription, TSPDescriptionForCheck);
        String TSPAddressForCheck = driver.findElement(xpathAddressField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Адрес'", adminTSPAddress, TSPAddressForCheck);
        String TSPEmail1ForCheck = driver.findElement(xpathEmailField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'E-mail'", email, TSPEmail1ForCheck);
        String TSPOGRNForCheck = driver.findElement(xpathOgrnField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'ОГРН/ОГРНИП'", valueOf(adminOGRN), TSPOGRNForCheck);
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,500)", "");
        String TSPMCCForCheck = driver.findElement(xpathMCCChosenField).getText();
        Assert.assertEquals("Некорректно заполнено поле 'MCC'", "1223   Классификатор 1", TSPMCCForCheck);
        pageDown.executeScript("scroll(0,1500)", "");
        String TSPSiteForCheck = driver.findElement(xpathSiteField).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Сайт'", tspSitePublic, TSPSiteForCheck);
        String TSPEmail2ForCheck = driver.findElement(xpathEmail2Field).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Email'", adminTSPEmailPublic, TSPEmail2ForCheck);
        String TSPPhoneForCheck = driver.findElement(xpathPhone).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Телефон'", "+7(927)000-0000", TSPPhoneForCheck);
        String TSPVKForCheck = driver.findElement(xpathVK).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Вконтакте'", urlVK, TSPVKForCheck);
        String TSPOKForCheck = driver.findElement(xpathOK).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Одноклассники'", urlOK, TSPOKForCheck);
        String TSPFaceBookForCheck = driver.findElement(xpathFaceBook).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Facebook'", urlFacebook, TSPFaceBookForCheck);
        String TSPInstForCheck = driver.findElement(xpathInst).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Instagram'", urlInsatgram, TSPInstForCheck);
        String TSPDopForCheck = driver.findElement(xpathDop).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Дополнительно'", adminTSPOptionalText, TSPDopForCheck);
        System.out.println("TSP has been successfully Verified");
        JavascriptExecutor pageUp = (JavascriptExecutor) driver;
        pageUp.executeScript("window.scroll(0,-3000)", "");

    }

    public void deleteTSP() {
        driver.get(TSP);
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(adminTSPName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", adminTSPName));
        }
        List<WebElement> TSPList = driver.findElements(xpathListInTable);
        for (int i = 0; i < TSPList.size(); i++) {
            String TSPNameSearch = TSPList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (TSPNameSearch.equals(adminTSPName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                TSPList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> TSPListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("ТСП не удалена", 0, TSPListCheck.size());
        System.out.println("TSP successfully Deleted");
    }

    public void GoToTSP() {
        loginAdmin();
        driver.findElement(xpathTSP).click();
        System.out.println("Go to section: TSP");
    }

    public void openTSPCard(String tsp) {
        GoToTSP(); // Переход в раздел "Торгово-сервисные предприятия"
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
        chosenAddressForPromotion = driver.findElements(xpathChosenAddress);

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
        getPromotionID();
        System.out.println("Public Promotion");
    }

    public void getPromotionID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathPromotionID)));
        //String temp = driver.findElement(By.cssSelector("span[class = 'ng-star-inserted']")).getText();
        promotionID = driver.findElement(xpathPromotionID).getText().substring(driver.findElement(xpathPromotionID).getText().length() - 4);
        System.out.println("ID of created promotion: " + promotionID);
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
        Assert.assertEquals("Некорректно заполнены поля 'Адреса предоставления'", nmbAddressForPromotionAdmin, chosenAddressForPromotion.size());
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
        chosenAddressForDiscount = driver.findElements(xpathChosenAddress);
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

    public void getDiscountID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathDiscountID)));
        int colon = driver.findElement(xpathDiscountID).getText().lastIndexOf(":");
        discountID = driver.findElement(xpathDiscountID).getText().substring(colon + 2, driver.findElement(xpathDiscountID).getText().length());
        System.out.println("ID of created discount: " + discountID);
    }

    public void publicDiscount() {
        createDiscount();                 // Создаем Скидку
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        getDiscountID();
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
        Assert.assertEquals("Некорректно заполнены поля 'Адреса предоставления'", nmbAddressForDiscountAdmin, chosenAddressForDiscount.size());
        System.out.println("Discount has been successfully Verified");
    }

    public void CreateTSPPromotionAndDiscount() {
        loginAdmin(); // Авторизация под пользователем с правами "Администратор"
        sectionTSP(); // Переход в раздел "Торгово-сервисные предприятия"
        sectionCreationTSP(); // Создание и заполнение ТСП
        compareTSP(); // Проверка правильности заполнения ТСП
        publicPromotion(); // Создание акции
        comparePromotion(); // Проверка правильности заполнения Акции
        publicDiscount(); // Создание скидки
        compareDiscount(); // Проверка правильности заполнения скидки
        deleteTSP(); // Удаление ТСП

    }
}