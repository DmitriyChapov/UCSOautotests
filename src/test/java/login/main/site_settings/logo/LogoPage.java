package login.main.site_settings.logo;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;
import static variables.FilesForAdd.*;

public class LogoPage extends Login {

    public void sectionSiteSettings() {
        driver.findElement(xpathSiteSettings).click();
        String siteSettingsUrlNow = driver.getCurrentUrl();
        Assert.assertEquals("Некорректный Url страницы \"Настройки сайта\"",
                siteSettingsUrl, siteSettingsUrlNow);
        System.out.println("Go to section: Site Settings");
    }

    public void subsectionLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathLogo));
        driver.findElement(xpathLogo).click();
        String logoUrlNow = driver.getCurrentUrl();
        String logoPageNameNow = driver.findElement(headingSettingsPage).getText();
        Assert.assertEquals("Некорректный Url страницы \"Управление логотипом\"",
                logoUrl, logoUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Управление логотипом\"",
                logoPageName,logoPageNameNow);
        System.out.println("Go to subsection: Logo");
    }

    public void openLogoWindow() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String logoWindowNameNow = driver.findElement(headingLogoWindow).getText();
        Assert.assertEquals("Не совпадают заголовки в окне 'Вариант логотипа'",
                logoWindowName, logoWindowNameNow);
        System.out.println("Open Logo window");
    }

    public void createLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        driver.findElement(selectorFieldName).sendKeys(logoName);
        driver.findElement(selectorFieldImage).sendKeys(imageLogo);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonSave));
        System.out.println("Logo successfully Created");
    }

    public void checkLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(logoName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.textToBe(xpathLogoNameForSearch,logoName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.textToBe(xpathLogoNameForSearch,logoName));
        }
        List<WebElement> logoList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < logoList.size(); i++) {
            String logoNameSearch = logoList.get(i).findElement(xpathLogoNameForSearch).getText();
            if (logoNameSearch.equals(logoName)) {
                logoList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Logo Window for check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldName));
        String logoNameForCheck = driver.findElement(selectorFieldName).getAttribute("value");
        Assert.assertEquals("Некорректно заполнено поле 'Название'",
                logoName, logoNameForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(selectorCloseWindow));
        driver.findElement(selectorCloseWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(selectorCloseWindow));
        System.out.println("Logo has been successfully verified");
    }

    public void deleteLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(logoName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.textToBe(xpathLogoNameForSearch, logoName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.textToBe(xpathLogoNameForSearch, logoName));
        }
        List<WebElement> logoList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < logoList.size(); i++) {
            String logoNameSearch = logoList.get(i).findElement(xpathLogoNameForSearch).getText();
            if (logoNameSearch.equals(logoName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                logoList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> logoListCheck = driver.findElements(xpathListBlocks);
        Assert.assertEquals("Логотип не удален",
                0, logoListCheck.size());
        System.out.println("Logo successfully Deleted");
    }

}
