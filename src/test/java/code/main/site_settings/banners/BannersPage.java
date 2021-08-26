package code.main.site_settings.banners;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.admin.Numbers.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;

public class BannersPage extends Login {

    String colorBanner;
    String bannerUrlwithID;

    public void sectionSiteSettings() {
        driver.findElement(xpathSiteSettings).click();
        String siteSettingsUrlNow = driver.getCurrentUrl();
        Assert.assertEquals("Некорректный Url страницы 'Настройки сайта'",
                siteSettingsUrl, siteSettingsUrlNow);
        System.out.println("Go to section: Site Settings");
    }

    public void subsectionBanners() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanners));
        driver.findElement(xpathBanners).click();
        String bannersUrlNow = driver.getCurrentUrl();
        String bannersPageNameNow = driver.findElement(headingSettingsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Баннеры'",
                bannersUrl, bannersUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Баннеры'",
                bannersPageName, bannersPageNameNow);
        System.out.println("Go to subsection: Banners");
    }

    public void openBannerCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String bannerCardUrlNow = driver.getCurrentUrl();
        String bannerCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка Баннера'",
                bannerCardUrl, bannerCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка Баннера'",
                bannerCardPageName, bannerCardPageNameNow);
        System.out.println("Open Banner Card");
    }

    public void createBanner() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(bannerName);
        driver.findElement(selectorFieldBannerFirstLine).sendKeys(firstLineName);
        driver.findElement(selectorFieldBannerSecondLine).sendKeys(secondLineName);
        driver.findElement(selectorSelectBannerColor).click();
        List<WebElement> allColor = driver.findElements(selectorFieldBannerColors);
        allColor.get(nmbColor).click();
        colorBanner = allColor.get(nmbColor).getText();
        driver.findElement(selectorFieldImage).sendKeys(imageBanner);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationBannerSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Баннера",
                notificationBannerSave, textNotificationBannerSave);
        bannerUrlwithID = driver.getCurrentUrl();
        System.out.println("Banner Card successfully Created");
    }
    public void checkBannerCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanners));
        ((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
        driver.findElement(xpathBanners).click();
        driver.findElement(selectorFieldSearch).sendKeys(bannerName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathBannerNameForSearch, "title", bannerName));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            wait.until(ExpectedConditions.attributeToBe(xpathBannerNameForSearch, "title", bannerName));
        }
        List<WebElement> bannerList = driver.findElements(xpathListInTable);
        for (int i = 0; i < bannerList.size(); i++) {
            String bannerNameSearch = bannerList.get(i).findElement(xpathBannerNameForSearch).getText();
            if (bannerNameSearch.equals(bannerName)) {
                bannerList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Banner Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String bannerCardUrlCheck = driver.getCurrentUrl();
        String bannerNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String bannerFirstLineNameForCheck = driver.findElement(selectorFieldBannerFirstLine).getAttribute("value");
        String bannerSecondLineNameForCheck = driver.findElement(selectorFieldBannerSecondLine).getAttribute("value");
        String bannerColorForCheck = driver.findElement(By.xpath("//mat-select-trigger")).getText();
        Assert.assertEquals("Не совпадают Url созданного Баннера и открытой карточки Баннера",
                bannerUrlwithID, bannerCardUrlCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Название'",
                bannerName, bannerNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Текст на первой строке'",
                firstLineName, bannerFirstLineNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Текст на второй строке'",
                secondLineName, bannerSecondLineNameForCheck);
        Assert.assertEquals("Некорректный цвет Баннера",
                colorBanner, bannerColorForCheck);
        System.out.println("Banner Card has been successfully Verified");
    }

    public void deleteBanner() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanners));
        ((JavascriptExecutor) driver).executeScript("scroll(0,-250);");
        driver.findElement(xpathBanners).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(bannerName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathBannerNameForSearch, "title", bannerName));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            wait.until(ExpectedConditions.attributeToBe(xpathBannerNameForSearch, "title", bannerName));
        }
        List<WebElement> bannerList = driver.findElements(xpathListInTable);
        for (int i = 0; i < bannerList.size(); i++) {
            String bannerNameSearch = bannerList.get(i).findElement(xpathBannerNameForSearch).getText();
            if (bannerNameSearch.equals(bannerName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                bannerList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> bannerListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Баннер не удален",
                0, bannerListCheck.size());
        System.out.println("Banner successfully Deleted");
        }

    public void createAndDeleteBanner(){
        loginAdmin();            // Авторизация под пользователем с правами "Администратор"
        sectionSiteSettings();   // Переход в раздел "Настройки сайта"
        subsectionBanners();     // Переход в подраздел "Баннеры", раздела "Настройки сайта"
        openBannerCard();        // Открываем карточку Баннера
        createBanner();          // Создаем Баннер
        checkBannerCard();       // Проверяем заполненность карточки Баннера
        deleteBanner();          // Удаляем Баннер
    }
}
