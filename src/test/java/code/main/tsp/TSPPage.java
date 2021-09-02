package code.main.tsp;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.lang.String.valueOf;
import static variables.admin.Numbers.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.common.Urls.*;
import static variables.admin.Collections.*;

public class TSPPage extends Login {
    boolean CheckBox;
    boolean TSPAvailable;

    public void sectionTSP(){
        driver.findElement(xpathTSP).click();
        String tspUrlNow = driver.getCurrentUrl();
        String tspPageNameNow = driver.findElement(headingTSPPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Торгово-сервисные предприятия''",
                tspUrl,tspUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Торгово-сервисные предприятия'",
                tspPageName,tspPageNameNow);
        System.out.println("Go to section: TSP");
    }

    public void openTSPCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String tspCardUrlNow = driver.getCurrentUrl();
        String tspCardPageNameNow = driver.findElement(headingTSPCardPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка торгово-сервисного предприятия'",
                tspCardUrl, tspCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка торгово-сервисного предприятия'",
                tspCardPageName,tspCardPageNameNow);
        System.out.println("Open TSP Card");
    }

    public void createTSP() {
        driver.findElement(xpathTSPAvailableSlide).click();
        TSPAvailable = driver.findElement(xpathTSPAvailableSlide).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathNameField));
        driver.findElement(xpathNameField).sendKeys(adminTSPName);
        driver.findElement(xpathDescriptionField).sendKeys(adminTSPDescription);
        driver.findElement(xpathAddressField).sendKeys(adminTSPAddress);
        driver.findElement(xpathEmailField).sendKeys(email);
        driver.findElement(xpathOgrnField).sendKeys(valueOf(adminOGRN));
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        pageDown.executeScript("scroll(0,500)", "");
        driver.findElement(xpathMCCField).click();
        driver.findElement(xpathMCC_CodeInDropDown).click();
        driver.findElement(xpathButtonSpanDownloadImage).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonOk));
        driver.findElement(selectorFieldImage).sendKeys(imageTSPLogoAdmin);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonOk));
        driver.findElement(xpathButtonOk).click();
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathSiteField));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationTSPSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении ТСП",
                tspSaveNotification, textNotificationTSPSave);
        System.out.println("TSP Card successfully Created");
    }

    public void getTSPID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathID)));
        int colon = driver.findElement(xpathID).getText().lastIndexOf(":");
        tspID = driver.findElement(xpathID).getText().substring(colon + 2, driver.findElement(xpathID).getText().length());
        System.out.println("ID of created TSP: " + tspID);
    }

    public void checkTSPCard() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-500);");
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP2));
        driver.findElement(xpathTSP2).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathNameField));
        JavascriptExecutor pageDown = (JavascriptExecutor) driver;
        boolean TSPAvailableForCheck = driver.findElement(xpathTSPAvailableSlide).isSelected();
        String TSPNameForCheck = driver.findElement(xpathNameField).getAttribute("value");
        String TSPDescriptionForCheck = driver.findElement(xpathDescriptionField).getAttribute("value");
        String TSPAddressForCheck = driver.findElement(xpathAddressField).getAttribute("value");
        String TSPEmail1ForCheck = driver.findElement(xpathEmailField).getAttribute("value");
        String TSPOGRNForCheck = driver.findElement(xpathOgrnField).getAttribute("value");
        String TSPMCCForCheck = driver.findElement(xpathMCC_CodeField).getText();
        Assert.assertEquals("Изменился параметр доступности карточки TSP",
                TSPAvailable, TSPAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'", adminTSPName, TSPNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Описание'", adminTSPDescription, TSPDescriptionForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Адрес'", adminTSPAddress, TSPAddressForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'E-mail'", email, TSPEmail1ForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'ОГРН/ОГРНИП'", valueOf(adminOGRN), TSPOGRNForCheck);
        pageDown.executeScript("scroll(0,500)", "");
        Assert.assertEquals("Некорректно заполнено поле 'MCC'", "1223   Классификатор 1", TSPMCCForCheck);
        pageDown.executeScript("scroll(0,1500)", "");
        String TSPSiteForCheck = driver.findElement(xpathSiteField).getAttribute("value");
        String TSPEmail2ForCheck = driver.findElement(xpathEmail2Field).getAttribute("value");
        String TSPPhoneForCheck = driver.findElement(xpathPhone).getAttribute("value");
        String TSPVKForCheck = driver.findElement(xpathVK).getAttribute("value");
        String TSPOKForCheck = driver.findElement(xpathOK).getAttribute("value");
        String TSPFaceBookForCheck = driver.findElement(xpathFaceBook).getAttribute("value");
        String TSPInstForCheck = driver.findElement(xpathInst).getAttribute("value");
        String TSPDopForCheck = driver.findElement(xpathDop).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Сайт'", tspSitePublic, TSPSiteForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Email'", adminTSPEmailPublic, TSPEmail2ForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Телефон'", "+7(927)000-0000", TSPPhoneForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Вконтакте'", urlVK, TSPVKForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Одноклассники'", urlOK, TSPOKForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Facebook'", urlFacebook, TSPFaceBookForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Instagram'", urlInsatgram, TSPInstForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дополнительно'", adminTSPOptionalText, TSPDopForCheck);
        pageDown.executeScript("scroll(0,-1500)", "");
        System.out.println("TSP has been successfully Verified");
    }

    public void deleteTSP() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-500);");
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP2));
        driver.findElement(xpathTSP2).click();
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

    public void openTSPCard(String tsp) {
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
        ((JavascriptExecutor) driver).executeScript("scroll(0,-1500)", "");
        driver.findElement(xpathTabPromotions).click();
        System.out.println("Go to tab Promotions");
    }

    public void openPromotionCard() {
        openTabPromotions();               // Переход во вкладку "Акции", в карточке "Торгово-сервисного предприятия"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Promotion Card");
    }

    public void tabPropertiesPromotionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        dateAndTime();
        driver.findElement(xpathPortal).click();
        contentPortalAvailable = driver.findElement(xpathPortal).isSelected();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        driver.findElement(xpathMobile).click();
        contentMobileAvailable = driver.findElement(xpathMobile).isSelected();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        driver.findElement(xpathLocationForContent).click();
        contentLocationAvailable = driver.findElement(xpathLocationForContent).isSelected();
    }

    public void tabContentPromotionCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabContent));
        driver.findElement(xpathTabContent).click();
        for (int i = 0; i < nmbAddressForPromotionAdmin; i++) {
            String deliveryAddress = "Адрес предоставления № " + (i + 1);
            wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAddressOffer));
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            wait.until(ExpectedConditions.elementToBeClickable(selectorAddAddressOffer));
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
        tabPropertiesPromotionCard();    // Заполняем вкладку "Свойства"
        tabContentPromotionCard();       // Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        contentCreationDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;;
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationPromotionCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Акции",
                promotionSaveNotification, textNotificationPromotionCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        contentCreationDateInCard = driver.findElement(selectorInterviewCreationDate).getText();
        Assert.assertEquals("Некорректная дата создания Акции после сохранения",
                contentCreationDate, contentCreationDateInCard);
        String statePromotionNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Акции после создания",
                stateCreate.toUpperCase(), statePromotionNow);
        System.out.println("Promotion successfully Created");
    }

    public void publicPromotion() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Public Promotion");
    }

    public void getPromotionID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathID)));
        int colon = driver.findElement(xpathID).getText().lastIndexOf(":");
        promotionID = driver.findElement(xpathID).getText().substring(colon + 2);
        System.out.println("ID of created promotion: " + promotionID);
    }

    public void checkPromotion() {
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
    }

    public void checkPromotionBlock(String Status){
        waitingSpinner();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentCard));
        wait.until(ExpectedConditions.elementToBeClickable(selectorTspNameAdmin));
        driver.findElement(selectorTspNameAdmin).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabPromotions));
        driver.findElement(xpathTabPromotions).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(promotionName);
        waitingSpinner();
        promotionsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < promotionsList.size(); i++) {
            String promotionNameSearch = promotionsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (promotionNameSearch.equals(promotionName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingPromotionBlock(i,Status);
                System.out.println("Promotion ID: " + promotionID + " in Section 'Promotion - Administration' has been successfully Verified");
                promotionsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Promotion Card for Check");
                break;
            }
        }
    }

    public void checkingPromotionBlock(int i, String Status) {
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
        String promotionIDBlock = promotionsList.get(i).findElement(xpathContentIDInBlocks).getText();
        Assert.assertEquals("Некорректный ID Акции в общем списке Акций",
                promotionID, promotionIDBlock.substring(promotionIDBlock.length()-4));
        String promotionStateBlock = promotionsList.get(i).findElement(xpathContentStateInBlocks).getText();
        promotionStateBlock = promotionStateBlock.substring(0,promotionStateBlock.indexOf('\n'));
        Assert.assertEquals("Некорректный статус Акции в общем списке Акций",
                state.toUpperCase(), promotionStateBlock);
        String promotionCreationDateBlock = promotionsList.get(i).findElement(xpathContentCreationDateInBlocks).getText();
        Assert.assertEquals("Некорректная дата " + stateText2 + " Акции в общем списке Акций",
                date, promotionCreationDateBlock);
        String promotionNameBlock = promotionsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
        Assert.assertEquals("Некорректный заголовок Акции в общем списке Акций",
                promotionName, promotionNameBlock);
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
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        dateAndTime();
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
            wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAddressOffer));
            driver.findElement(selectorFieldAddressOffer).sendKeys(deliveryAddress);
            wait.until(ExpectedConditions.elementToBeClickable(selectorAddAddressOffer));
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
        tabPropertiesDiscountCard();    //Заполняем вкладку "Свойства"
        tabContentDiscountCard();       //Заполняем вкладку "Содержимое"
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationDiscountCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Скидки",
                discountSaveNotification, textNotificationDiscountCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        System.out.println("Discount successfully Created");
    }

    public void getDiscountID() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathID)));
        int colon = driver.findElement(xpathID).getText().lastIndexOf(":");
        discountID = driver.findElement(xpathID).getText().substring(colon + 2);
        System.out.println("ID of created discount: " + discountID);
    }

    public void publicDiscount() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Public Discount");
    }

    public void checkDiscount() {
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

    public void createAndCheckTSP(){
        loginAdmin();                        // Авторизация под пользователем с правами "Администратор"
        sectionTSP();                        // Переход в раздел "Торгово-сервисные предприятия"
        openTSPCard();                       // Открываем карточку Торгово-сервисного предприятия
        createTSP();                         // Создаем ТСП
        getTSPID();                          // Получаем ID ТСП
        checkTSPCard();                      // Проверяем заполненность карточки ТСП
    }

    public void createAndDeleteTSP(){
        loginAdmin();                        // Авторизация под пользователем с правами "Администратор"
        sectionTSP();                        // Переход в раздел "Торгово-сервисные предприятия"
        openTSPCard();                       // Открываем карточку Торгово-сервисного предприятия
        createTSP();                         // Создаем ТСП
        getTSPID();                          // Получаем ID ТСП
        checkTSPCard();                      // Проверяем заполненность карточки ТСП
        deleteTSP();                         // Удаляем ТСП
    }

    public void createAndDeletePromotion(){
        loginAdmin();                        // Авторизация под пользователем с правами "Администратор"
        sectionTSP();                        // Переход в раздел "Торгово-сервисные предприятия"
        openTSPCard(tspNameAdmin);                       // Открываем карточку Торгово-сервисного предприятия
        //createTSP();                         // Создаем ТСП
        openTabPromotions();                 // открываем вкладку Акции
        openPromotionCard();                 // Открываем карточку Акции
        createPromotion();                   // Создаем Акцию
        getPromotionID();                    // Получаем ID Акции
        publicPromotion();
        checkPromotionBlock("Public");

    }

    public void createAndCheckPromotion(){
        sectionTSP();                        // Переход в раздел "Торгово-сервисные предприятия"
        openTSPCard(adminTSPName);           // Открываем карточку Торгово-сервисного предприятия
        openPromotionCard();                 // Открываем карточку Акции
        createPromotion();                   // Создаем Акцию
        getPromotionID();                    // Получаем ID Акции
        publicPromotion();                   // Публикуем Акцию
        checkPromotion();                    // Проверяем заполненность карточки Акции
    }

    public void createAndCheckDiscount(){
        sectionTSP();                        // Переход в раздел "Торгово-сервисные предприятия"
        openTSPCard(adminTSPName);           // Открываем карточку Торгово-сервисного предприятия
        openDiscountCard();                  // Открываем карточку Акции
        createDiscount();                    // Создаем Акцию
        getDiscountID();                     // Получаем ID Акции
        publicDiscount();                    // Публикуем Акцию
        checkDiscount();                     // Проверяем заполненность карточки Акции
    }
}