package login.main.reference_books.banks;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.admin.Numbers.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.Urls.*;
import static variables.admin.FilesForAdd.*;

public class BanksPage extends Login{
    String bankUrlwithID;
    int quantityBranch;
    int quantityDesign;
    boolean bankAvailable;

    public void sectionReferenceBooks(){
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочники''",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочники'",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionBanks() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanks));
        driver.findElement(xpathBanks).click();
        String banksUrlNow = driver.getCurrentUrl();
        String banksPageNameNow = driver.findElement(headingBanks).getText();
        Assert.assertEquals("Некорректный Url страницы 'Справочник банков'",
                banksUrl, banksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Справочник банков'",
                banksPageName, banksPageNameNow);
        System.out.println("Go to subsection: Banks");
    }

    public void openBankCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
        driver.findElement(xpathButtonAdd).click();
        String bankCardUrlNow = driver.getCurrentUrl();
        String bankCardPageNameNow = driver.findElement(headingCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка банка'",
                bankCardUrl, bankCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка банка'",
                bankCardPageName,bankCardPageNameNow);
        System.out.println("Open Bank Card");
    }

    public void createBank() {
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldBankName));
        driver.findElement(selectorFieldBankName).sendKeys(bankName);
        driver.findElement(selectorFieldBankBic).sendKeys(String.valueOf(bankBIC));
        driver.findElement(selectorFieldBankAddress).sendKeys(bankAddress);
        driver.findElement(xpathBankSite).sendKeys(banksSiteName);
        bankAvailable = driver.findElement(selectorBankAvailable).isSelected();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationBankSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Банка",
                bankSaveNotification, textNotificationBankSave);
        bankUrlwithID = driver.getCurrentUrl();
        System.out.println("Bank Card successfully Created");
    }

    public void createBranch() {
        for (int i = 0; i < nmbBranch; i++ ) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
            driver.findElement(xpathButtonAdd).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldBranchName));
            driver.findElement(selectorFieldBranchName).sendKeys(nameBranch(i));
            driver.findElement(selectorFieldBranchNumber).sendKeys(String.valueOf((i+1)));
            driver.findElement(selectorFieldBranchWorkingHours).sendKeys(branchHoursWork);
            driver.findElement(selectorFieldBranchAddress).sendKeys(branchAddress(i));
            driver.findElement(selectorBranchCoordinates).sendKeys(branchCoordinates());
            driver.findElement(selectorAvailable).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
            driver.findElement(xpathButtonSaveInWindow).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(selectorFieldBranchName));
        }
        List<WebElement> listBranch = driver.findElements(xpathNmbBranch);
        quantityBranch = listBranch.size();
        Assert.assertEquals("Не все Отделения банка созданы",
                nmbBranch, quantityBranch);
        System.out.println("Bank Branches successfully Created");
    }

    public void tabDesignCreate() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBankTabDesign));
        driver.findElement(xpathBankTabDesign).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        for (int i=0; i < nmbDesign; i++ ) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
            driver.findElement(xpathButtonAdd).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldName));
            driver.findElement(selectorFieldName).sendKeys(nameDesign(i));
            driver.findElement(selectorFieldDesignCode).sendKeys(String.valueOf(codeDesign()));
            driver.findElement(selectorDesignAvailable).click();
            driver.findElement(selectorFieldImage).sendKeys(imageDesignName(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
            driver.findElement(xpathButtonSaveInWindow).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("confirm")));
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
            driver.findElement(xpathButtonAccept).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonAccept));
        }
        List<WebElement> listDesign = driver.findElements(xpathNmbDesign);
        quantityDesign = listDesign.size();
        Assert.assertEquals("Не все Дизайны карт банка созданы",
                nmbDesign, quantityDesign);
        System.out.println("Bank Designs successfully Created");
    }

    public void checkBankCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanks));
        driver.findElement(xpathBanks).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(bankName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathBankNameForSearch, "title", bankName));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            wait.until(ExpectedConditions.attributeToBe(xpathBankNameForSearch, "title", bankName));
        }
        List<WebElement> bankList = driver.findElements(xpathListInTable);
        for (int i = 0; i < bankList.size(); i++) {
            String bankNameSearch = bankList.get(i).findElement(xpathBankNameForSearch).getText();
            if (bankNameSearch.equals(bankName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                bankList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Bank Card for Check");
                break;
        }
    }
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldBankName));
        String bankCardUrlForCheck = driver.getCurrentUrl();
        String bankNameForCheck = driver.findElement(selectorFieldBankName).getAttribute("value");
        String bankBICForCheck = driver.findElement(selectorFieldBankBic).getAttribute("value");
        String bankAddressForCheck = driver.findElement(selectorFieldBankAddress).getAttribute("value");
        String banksSiteNameForCheck = driver.findElement(xpathBankSite).getAttribute("value");
        boolean bankAvailableForCheck = driver.findElement(selectorBankAvailable).isSelected();
        List<WebElement> listBranchForCheck = driver.findElements(xpathNmbBranch);
        int quantityBranchForCheck = listBranchForCheck.size();
        Assert.assertEquals("Не совпадают Url созданного Банка и открытой карточки Банка",
                bankUrlwithID, bankCardUrlForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Наименование банка'",
                bankName, bankNameForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'БИК'",
                 String.valueOf(bankBIC), bankBICForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Юридический адрес'",
                bankAddress, bankAddressForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Сайт'",
                banksSiteName, banksSiteNameForCheck );
        Assert.assertEquals("Изменился параметр доступности Банка",
                bankAvailable, bankAvailableForCheck);
        Assert.assertEquals("Некорректное кол-во 'Отделений банка'",
                quantityBranch, quantityBranchForCheck );
        wait.until(ExpectedConditions.elementToBeClickable(xpathBankTabDesign));
        driver.findElement(xpathBankTabDesign).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        List<WebElement> listDesignForCheck = driver.findElements(xpathNmbDesign);
        int quantityDesignForCheck = listDesignForCheck.size();
        Assert.assertEquals("Некорректное кол-во 'Дизайнов карт банка'",
                quantityDesign, quantityDesignForCheck );
        System.out.println("Bank Card has been successfully Verified");
    }

    public void deleteBank() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathBanks));
        driver.findElement(xpathBanks).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(bankName);
        waitingSpinner();
        try {
            wait.until(ExpectedConditions.attributeToBe(xpathBankNameForSearch, "title", bankName));
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            wait.until(ExpectedConditions.attributeToBe(xpathBankNameForSearch, "title", bankName));
        }
        List<WebElement> bankList = driver.findElements(xpathListInTable);
        for (int i = 0; i < bankList.size(); i++) {
            String bankNameSearch = bankList.get(i).findElement(xpathBankNameForSearch).getText();
            if (bankNameSearch.equals(bankName)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconDelete));
                bankList.get(i).findElement(xpathIconDelete).click();
                wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
                driver.findElement(xpathButtonDelete).click();
                break;
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathButtonDelete));
        waitingSpinner();
        List<WebElement> bankListCheck = driver.findElements(xpathListInTable);
        Assert.assertEquals("Банк не удален",
                0, bankListCheck.size());
        System.out.println("Bank successfully Deleted");
    }

    public void createAndDeleteBank() {
        loginAdmin();            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks(); // Переход в раздел "Справочники"
        subSectionBanks();       // Переход в подраздел "Банки", раздела "Справочники"
        openBankCard();          // Открываем карточку Банка
        createBank();            // Создаем Банк
        createBranch();          // Создаем отделения банка
        tabDesignCreate();       // Создаем дизайны банковских карт
        checkBankCard();         // Проверяем заполненность карточки Банка
       // deleteBank();            // Удаляем банк
    }

}
