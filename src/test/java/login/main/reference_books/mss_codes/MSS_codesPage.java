package login.main.reference_books.mss_codes;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.common.Numbers.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;

public class MSS_codesPage extends Login {
    boolean mss_CodeAvailable;

    public void sectionReferenceBooks() {
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники'",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionMSSCodes() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathMSSCodes));
        driver.findElement(xpathMSSCodes).click();
        String mss_CodesUrlNow = driver.getCurrentUrl();
        String mss_CodesPageNameNow = driver.findElement(headingPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник МСС-кодов'",
                mss_CodesUrl, mss_CodesUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник МСС-кодов'",
                mss_CodesPageName, mss_CodesPageNameNow);
        System.out.println("Go to subsection: MSS-codes");
    }

    public void openMSSCodeCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String  mss_CodeCardUrlNow = driver.getCurrentUrl();
        String  mss_CodeCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка МСС-кода'",
                mss_CodeCardUrl, mss_CodeCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка МСС-кода'",
                mss_CodeCardPageName,mss_CodeCardPageNameNow);
        System.out.println("Open MSS-code Card");
    }

    public void createMSSCode() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldMSSCodeName));
        driver.findElement(selectorFieldMSSCodeName).sendKeys(mss_CodeName);
        driver.findElement(selectorFieldMSSCode).sendKeys(String.valueOf(nmbAutoTest));
        mss_CodeAvailable = driver.findElement(selectorAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationMSSCodeCardSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении МСС-кода",
                mss_CodeCardSaveNotification, textNotificationMSSCodeCardSave);
        System.out.println("MSS-code successfully Created");
    }

    public void checkMSSCodeCard() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(mss_CodeName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", mss_CodeName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", mss_CodeName));
        }
        List<WebElement> mss_CodeList = driver.findElements(xpathListInTable);
        for (int i = 0; i < mss_CodeList.size(); i++) {
            String mss_CodeNameSearch = mss_CodeList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (mss_CodeNameSearch.equals(mss_CodeName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                mss_CodeList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open MSS-code Card for Check");
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldMSSCodeName));
        String mss_CodeNameForCheck = driver.findElement(selectorFieldMSSCodeName).getAttribute("value");
        String mss_CodeForCheck = driver.findElement(selectorFieldMSSCode).getAttribute("value");
        boolean mss_CodeAvailableForCheck = driver.findElement(selectorAvailable).isSelected();
        Assert.assertEquals("Некорректно заполнено поле 'Наименование'",
                mss_CodeName, mss_CodeNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'МСС-код'",
                String.valueOf(nmbAutoTest), mss_CodeForCheck);
        Assert.assertEquals("Изменился параметр доступности МСС-кода",
                mss_CodeAvailable, mss_CodeAvailableForCheck);
        System.out.println("MSS-code has been successfully Verified");
    }

    public void deleteMSSCode() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathMSSCodes));
        driver.findElement(xpathMSSCodes).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(mss_CodeName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", mss_CodeName));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            wait.until(ExpectedConditions.attributeToBe(xpathReferenceBookNameForSearch,
                    "title", mss_CodeName));
        }
        List<WebElement> mss_CodeList = driver.findElements(xpathListInTable);
        for (int i = 0; i < mss_CodeList.size(); i++) {
            String mss_CodeNameSearch = mss_CodeList.get(i).findElement(xpathReferenceBookNameForSearch).getText();
            if (mss_CodeNameSearch.equals(mss_CodeName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                mss_CodeList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
                driver.findElement(xpathButtonAccept).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        waitingSpinner();
        List<WebElement> mss_CodeListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("МСС-код не удален",
                0, mss_CodeListCheck.size());
            System.out.println("MSS-code successfully Deleted");
        }
    public void createAndDeleteMSSCode(){
        loginAdmin();               // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();    // Переход в раздел "Справочники"
        subSectionMSSCodes();       // Переход в подраздел "МСС-коды", раздела "Справочники"
        openMSSCodeCard();          // Открываем карточку МСС-кода
        createMSSCode();            // Создаем МСС-код
        checkMSSCodeCard();         // Проверяем заполненность карточки МСС-кода
        deleteMSSCode();            // Удаляем МСС-код
    }
}
