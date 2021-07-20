package login.main.reference_books.user_type;

import login.Login;

import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class UserTypePage extends Login {

    public void sectionReferenceBooks() throws InterruptedException {
        loginAdmin();
        driver.findElement(xpathReferenceBooks).click();
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionUserType() throws InterruptedException {
        sectionReferenceBooks();      // Переход в раздел "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathUserTypes).click();
        System.out.println("Go to subsection: User Type");
    }

    public void openUserTypeCard() throws InterruptedException {
        subSectionUserType();       // Переход в подраздел "Типы пользователей", раздела "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open User Type Card");
    }

    public void createUserType() throws InterruptedException {
        openUserTypeCard();          // Открываем карточку Тип пользователя
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(userTypeName);
        driver.findElement(selectorFieldCodeOTK).sendKeys(codeOTK);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create User Type");
    }

    public void deleteUserType() throws InterruptedException {
        createUserType();            // Создаем Тип пользователя
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(userTypeName);
        Thread.sleep(2000);
        String nameUserTypeSearch = driver.findElementByXPath("//app-transport-card-users/div/div[2]/table/tbody/tr[1]/td[2]").getText();
        if (nameUserTypeSearch.equals(userTypeName)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete User Type");
        }
    }
}
