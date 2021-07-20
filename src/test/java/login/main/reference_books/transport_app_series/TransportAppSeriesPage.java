package login.main.reference_books.transport_app_series;

import login.Login;
import org.openqa.selenium.By;

import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class TransportAppSeriesPage extends Login {

    public void sectionReferenceBooks() throws InterruptedException {
        loginAdmin();
        driver.findElement(xpathReferenceBooks).click();
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionTransportAppSeries() throws InterruptedException {
        sectionReferenceBooks();               // Переход в раздел "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathTransportAppSeries).click();
        System.out.println("Go to subsection: Transport App Series");
    }


    public void createDescriptionsTransportCard() throws InterruptedException {
        driver.findElement(xpathDescriptionsTransportCards).click();
        System.out.println("Go to subsection: Descriptions Transport Card");
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Descriptions Transport Card Card");
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(descriptionsTransportCardName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Descriptions Transport Card");
    }

    public void createUserType() throws InterruptedException {
        driver.findElement(xpathUserTypes).click();
        System.out.println("Go to subsection: User Type");
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open User Type Card");
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(userTypeName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create User Type");
    }

    public void createLocationTransportApp() throws InterruptedException {
        driver.findElement(xpathLocationTransportApps).click();
        System.out.println("Go to subsection: Locations Transport App");
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Locations Transport App Card");
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(locationTransportAppName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Locations Transport App");
    }

    public void openTransportAppSeriesCard() throws InterruptedException {
        subSectionTransportAppSeries();       // Переход в подраздел "Серии транспортного приложения", раздела "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Transport App Series Card");
    }

    public void createTransportAppSeries() throws InterruptedException {
        sectionReferenceBooks();             // Переход в раздел "Справочники"
        Thread.sleep(2000);
        createDescriptionsTransportCard();   // Создаем Описание транспортной карты
        Thread.sleep(2000);
        createUserType();                    // Создаем Тип пользователя
        Thread.sleep(2000);
        createLocationTransportApp();        // Создаем Локацию транспортного приложения
        Thread.sleep(2000);
        driver.findElement(xpathTransportAppSeries).click();
        System.out.println("Go to subsection: Transport App Series");
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Transport App Series Card");
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(TransportAppSeries);
        driver.findElement(selectorSelectCardDescription).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'" + descriptionsTransportCardName + "' )]")).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectSocialCode).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + socialCode + "' )]")).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectUserType).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + userTypeName + "' )]")).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectLocationTransportApp).click();
        driver.findElement(By.xpath("//span[contains(text(),'" + locationTransportAppName + "' )]")).click();
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Transport App Series");
    }

    public void deleteTransportAppSeries() throws InterruptedException {
        createTransportAppSeries();         // Создаем Серию транспортного приложения
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(TransportAppSeries);
        Thread.sleep(2000);           // Удаляем Серию транспортного приложения
        String nameTransportAppSeriesSearch = driver.findElementByXPath("//app-application-series/div/div[2]/table/tbody/tr/td[2]").getText();
        if (nameTransportAppSeriesSearch.equals(TransportAppSeries)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Transport App Series");
        }
        Thread.sleep(2000);          // Удаляем Описание транспортной карты
        driver.findElement(xpathDescriptionsTransportCards).click();
        System.out.println("Go to subsection: Descriptions Transport Card");
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(descriptionsTransportCardName);
        Thread.sleep(2000);
        String nameDescriptionsTransportCardSearch = driver.findElementByXPath("//app-transport-card-descriptions/div/div[2]/table/tbody/tr[1]/td[2]").getText();
        if (nameDescriptionsTransportCardSearch.equals(nameDescriptionsTransportCardSearch)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Descriptions Transport Card");
        }
        Thread.sleep(2000);         // Удаляем Тип пользователя
        driver.findElement(xpathUserTypes).click();
        System.out.println("Go to subsection: User Type");
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(userTypeName);
        Thread.sleep(2000);
        String nameUserTypeSearch = driver.findElementByXPath("//app-transport-card-users/div/div[2]/table/tbody/tr[1]/td[2]").getText();
        if (nameUserTypeSearch.equals(userTypeName)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Locations Transport App");
        }
        Thread.sleep(2000);         // Удаляем Локацию транспортного приложения
        driver.findElement(xpathLocationTransportApps).click();
        System.out.println("Go to subsection: Locations Transport App");
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(locationTransportAppName);
        Thread.sleep(2000);
        String nameLocationTransportAppSearch = driver.findElementByXPath("//app-transport-locations/div/div[2]/table/tbody/tr/td[2]").getText();
        if (nameLocationTransportAppSearch.equals(locationTransportAppName)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Locations Transport App");
        }
    }

}
