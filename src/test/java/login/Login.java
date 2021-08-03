package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static variables.admin.Strings.*;
import static variables.portal.Strings.*;
import static variables.admin.Urls.*;
import static variables.portal.Urls.*;
import static variables.common.Selector.*;
import static variables.admin.Xpath.*;
import static variables.portal.Xpath.*;

public class Login {

    public static ChromeDriver driver;
    public static WebDriverWait wait;
    public static Actions actionChange;
    public LocalDate toDay = LocalDate.now();
    public LocalTime toTime = LocalTime.now();
    public String dateNow = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(toDay);
    public String timeNow = DateTimeFormatter.ofPattern("HH:mm").format(toTime);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        actionChange = new Actions(driver);
        System.out.println("Start Browser");
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        System.out.println("Browser closed");
        driver.quit();
    }

   public void loginAdmin() {
        driver.get(siteAdmin);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonIn));
        driver.findElement(selectorLogin).sendKeys(loginInUser);
        driver.findElement(selectorPassword).sendKeys(passwordInUser);
        driver.findElement(xpathButtonIn).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathReferenceBooks));
        String title = driver.getTitle();
        String mainUrl = driver.getCurrentUrl();
        Assert.assertEquals("Не совпадают Url", mainUrl,"https://ucso-test.opencode.su/main");
        Assert.assertEquals("Не совпадают title", title,"Карта жителя СО");
    }

    public void loginPortal() {
        driver.get(sitePortal);
        wait.until(ExpectedConditions.elementToBeClickable(xpathCookieYes));
        driver.findElement(xpathCookieYes).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathESIAuthorize));
        driver.findElement(xpathESIAuthorize).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathCheckBoxDate));
        driver.findElement(xpathCheckBoxDate).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathConfirmDateButton));
        driver.findElement(xpathConfirmDateButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorLogin));
        driver.findElement(selectorLogin).sendKeys(loginOutUser);
        driver.findElement(selectorPassword).sendKeys(passwordOutUser);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonIn));
        driver.findElement(xpathButtonIn).click();
    }


    public boolean spinner(){
        try{
            driver.findElement(xpathSpinner);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public void waitingSpinner(){
        if (spinner()) {
            System.out.println("Спиннер появился");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSpinner));
        }
    }
}
