package login.main.administration.TSP;

import login.Login;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.FilesForAdd.*;
import static variables.admin.Xpath.*;


public class CreateTSP  extends Login {
String name = "Тестовое название";
String Ogrn = "1117746358608";


    public void sectionTSP() {
        loginAdmin();
        wait.until(ExpectedConditions.elementToBeClickable(xpathTSP));
        driver.findElement(xpathTSP).click();
        driver.findElement(xpathButtonAdd).click();

    }

    public void sectionCreationTSP() throws InterruptedException {
        sectionTSP();
        driver.findElement(xpathButtonAvailable).click();
        driver.findElement(xpathNameField).sendKeys(name);
        driver.findElement(xpathDescriptionField).sendKeys("Тестовое описание");
        driver.findElement(xpathAddressField).sendKeys("г.Тест ул.Тестовая. д.1");
        driver.findElement(xpathEmailField).sendKeys("test@gmail.com");
        driver.findElement(xpathOgrnField).sendKeys(Ogrn);
        driver.findElement(xpathMCCField).click();
        driver.findElement(xpathMCCChooseField).click();
        JavascriptExecutor pageDown = (JavascriptExecutor)driver;
        pageDown.executeScript("scroll(0,1000)","");
        driver.findElement(xpathButtonDownloadImage).click();
        driver.findElement(xpathChooseFile).sendKeys(imageLogoTSPAdmin);
        driver.findElement(xpathButtonOk).click();
        driver.findElement(xpathSiteField).sendKeys("https://test.com");
        driver.findElement(xpathEmail2Field).sendKeys("test@gmail.com");
        driver.findElement(xpathPhone).sendKeys("9275553535");
        driver.findElement(xpathVK).sendKeys("https://vk.com/test");
        driver.findElement(xpathOK).sendKeys("https://ok.ru/test");
        driver.findElement(xpathFaceBook).sendKeys("https://facebook.com/test");
        driver.findElement(xpathInst).sendKeys("https://www.instagram.com/test");
        driver.findElement(xpathDop).sendKeys("Тестовая дополнительная информация");
        driver.findElement(xpathButtonSave).click();
        Thread.sleep(3000);
    }

    public void searchTSP() throws InterruptedException{
        sectionCreationTSP();
        driver.findElement(xpathTSP).click();
        driver.findElement(xpathTSPSearch).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(xpathTSPEdit).click();
        Thread.sleep(3000);
        JavascriptExecutor pageDown = (JavascriptExecutor)driver;
        pageDown.executeScript("scroll(0,1000)","");
        Thread.sleep(3000);

    }

}