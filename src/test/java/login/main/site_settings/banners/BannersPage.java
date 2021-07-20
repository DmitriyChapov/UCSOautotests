package login.main.site_settings.banners;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import static variables.Numbers.*;
import static variables.Strings.*;
import static variables.FilesForAdd.*;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;

public class BannersPage extends Login {

    String colorBanner;
    String bannerUrlwithID;

    public void sectionSiteSettings() {
        driver.findElement(xpathSiteSettings).click();
        String siteSettingsUrlNow = driver.getCurrentUrl();
        Assert.assertEquals("Некорректный Url страницы \"Настройки сайта\"",
                siteSettingsUrl, siteSettingsUrlNow);
        System.out.println("Go to section: Site Settings");
    }

    public void subsectionBanners() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanners));
        driver.findElement(xpathBanners).click();
        String bannersUrlNow = driver.getCurrentUrl();
        String bannersPageNameNow = driver.findElement(headingSettingsPage).getText();
        Assert.assertEquals("Некорректный Url страницы \"Баннеры\"",
                bannersUrl, bannersUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Баннеры\"",
                bannersPageName, bannersPageNameNow);
        System.out.println("Go to subsection: Banners");
    }

    public void openBannerCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String bannerCardUrlNow = driver.getCurrentUrl();
        String bannerCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы \"Карточка баннера\"",
                bannerCardUrl, bannerCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Карточка баннера\"",
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
        colorBanner = allColor.get(nmbColor).getText();
        allColor.get(nmbColor).click();
        driver.findElement(selectorFieldImage).sendKeys(imageBanner);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationBannerSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении баннера",
                notificationBannerSave, textNotificationBannerSave);
        bannerUrlwithID = driver.getCurrentUrl();
        System.out.println("Banner Card successfully created");
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
                System.out.println("Open Banner Card for check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String bannerCardUrlCheck = driver.getCurrentUrl();
        String bannerNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        String bannerFirstLineNameForCheck = driver.findElement(selectorFieldBannerFirstLine).getAttribute("value");
        String bannerSecondLineNameForCheck = driver.findElement(selectorFieldBannerSecondLine).getAttribute("value");
        String bannerColorForCheck = driver.findElement(By.xpath("//mat-select-trigger")).getText();
        Assert.assertEquals("Не совпадают Url созданного баннера и открытой карточки баннера",
                bannerUrlwithID, bannerCardUrlCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Название'",
                bannerName, bannerNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Текст на первой строке'",
                firstLineName, bannerFirstLineNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Текст на второй строке'",
                secondLineName, bannerSecondLineNameForCheck);
        Assert.assertEquals("Некорректный цвет баннера",
                colorBanner, bannerColorForCheck);
        System.out.println("Banner Card has been successfully verified");
    }

    public void deleteBanner() {
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

}
