package login.main.reference_books.structural_subdivisions;

import login.Login;

import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class StructuralSubdivisionsPage extends Login {

    public void sectionReferenceBooks() throws InterruptedException {
        loginAdmin();
        driver.findElement(xpathReferenceBooks).click();
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionStructuralSubdivisions() throws InterruptedException {
        sectionReferenceBooks();               // Переход в раздел "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathStructuralSubdivisions).click();
        System.out.println("Go to subsection: Structural Subdivisions");
    }

    public void openStructuralSubdivisionCard() throws InterruptedException {
        subSectionStructuralSubdivisions();     // Переход в подраздел "Структурные подразделения", раздела "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Structural Subdivision Card");
    }

    public void createStructuralSubdivision() throws InterruptedException {
        openStructuralSubdivisionCard();       // Открываем карточку Структурного подразделения
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(structuralSubdivisionName);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Structural Subdivision");
    }

    public void deleteStructuralSubdivision() throws InterruptedException {
        createStructuralSubdivision();        // Создаем Структурное подразделение
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(structuralSubdivisionName);
        Thread.sleep(2000);
        String nameStructuralSubdivisionSearch = driver.findElementByXPath("//app-structural-subdivisions/div/div[2]/table/tbody/tr/td[2]").getText();
        if (nameStructuralSubdivisionSearch.equals(structuralSubdivisionName)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Structural Subdivision");
        }
    }
}
