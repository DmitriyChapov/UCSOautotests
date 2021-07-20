package login.main.reference_books.content_location;

import login.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static variables.Numbers.*;
import static variables.Strings.*;
import static variables.Strings.pathLocation;
import static variables.Urls.*;
import static variables.Xpath.*;
import static variables.Selector.*;

public class ContentLocationPage extends Login {
    int nmbLocationsBefore;
    int nmbLocationsAfter;

    public void sectionReferenceBooks(){
        driver.findElement(xpathReferenceBooks).click();
        String referenceBooksUrlNow = driver.getCurrentUrl();
        String referenceBooksPageNameNow = driver.findElement(headingReferenceBooks).getText();
        Assert.assertEquals("Некорректный Url страницы \"Справочники\"",
                referenceBooksUrl,referenceBooksUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Справочники\"",
                referenceBooksPageName,referenceBooksPageNameNow);
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionContentLocations() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathContentLocations));
        driver.findElement(xpathContentLocations).click();
        String contentLocationsUrlNow = driver.getCurrentUrl();
        String contentLocationsPageNameNow = driver.findElement(headingLocations).getText();
        Assert.assertEquals("Некорректный Url страницы \"Справочник банков\"",
                locationsUrl, contentLocationsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице \"Справочник банков\"",
                locationsPageName,contentLocationsPageNameNow);
        System.out.println("Go to subsection: Content Locations");
    }

    public void createContentLocations() {
        List<WebElement> locationsBefore = driver.findElements(xpathLocationPathForCheck);
        nmbLocationsBefore = locationsBefore.size();
        List<WebElement> locationName = driver.findElements(selectorIconAddLocation);
        locationName.get(locationName.size() - 1).click();
        int i = 1;
        driver.findElement(selectorFieldContentLocationName).sendKeys(pathLocation(i));
        driver.findElement(xpathIconSaveLocation).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationLocationSave = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификаций при сохранении Локации",
                notificationLocationSave(i),textNotificationLocationSave);
        System.out.println("Location № " + i + " successfully Created");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        for (; i <= nmbLocations ; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathLocationPathAdd(i)));
            driver.findElement(xpathLocationPathAdd(i)).click();
            wait.until(ExpectedConditions.elementToBeClickable(selectorFieldContentLocationName));
            driver.findElement(selectorFieldContentLocationName).sendKeys(pathLocation(i+1));
            driver.findElement(xpathIconSaveLocation).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
            textNotificationLocationSave = driver.findElement(xpathNotifier).getText();
            Assert.assertEquals("Не совпадают тексты нотификаций при сохранении Локации",
                    notificationLocationSave(i+1),textNotificationLocationSave);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
            System.out.println("Location № " + (i+1) + " successfully Created");
        }
        List<WebElement> locationsAfter = driver.findElements(xpathLocationPathForCheck);
        nmbLocationsAfter = locationsAfter.size();
        int nmbCreatedLocations = nmbLocationsAfter - nmbLocationsBefore;
        Assert.assertEquals("Не все Локации контента созданы",
                (nmbLocations +1), nmbCreatedLocations);
        System.out.println("All Locations successfully Created");
    }

    public void checkContentLocations() {
        String nameLocation;
        List<WebElement> listLocations = driver.findElements(xpathLocationPathForCheck);
        for (int i = 0; i < listLocations.size(); i++) {
            List<WebElement> listLocationsNew = driver.findElements(xpathLocationWithLevel(i+1));
                if (listLocationsNew.size() == 0){
                    break;
                }
            for (int j = 0; j < listLocationsNew.size(); j++) {
                    nameLocation = listLocationsNew.get(j).findElement(By.xpath(".//div")).getText();
                    if (nameLocation.equals(pathLocation(i+1))) {
                        Assert.assertEquals("Не совпадает наименования" + (i+1) + " локации",
                                pathLocation(i+1), nameLocation);
                        System.out.println("Location № " + (i+1) + " successfully Checked");
                    }
                }
        }
        System.out.println("All Locations successfully Checked");
    }

    public void deleteContentLocations() {
        for (int i = (nmbLocations + 1) ; i >= 1; i--){
            wait.until(ExpectedConditions.elementToBeClickable(xpathLocationPathDelete(i)));
            driver.findElement(xpathLocationPathDelete(i)).click();
            driver.findElement(xpathButtonDelete).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
            String textNotificationLocationDelete = driver.findElement(xpathNotifier).getText();
            Assert.assertEquals("Не совпадают тексты нотификаций при удалении Локации",
                    notificationLocationDelete(i),textNotificationLocationDelete);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
            System.out.println("Location № " + i + " successfully Deleted");
        }
        List<WebElement> locationsAfterDelete = driver.findElements(xpathLocationPathForCheck);
        int nmbLocationsAfterDelete = locationsAfterDelete.size();
        Assert.assertEquals("Не все Локации контента удалены",
                nmbLocationsBefore,nmbLocationsAfterDelete);
        System.out.println("All Locations successfully Deleted");
    }

}
