package login.main.reference_books.tags;

import login.Login;

import static variables.Xpath.*;
import static variables.Selector.*;
import static variables.Strings.*;

public class TagsPage extends Login {

    public void sectionReferenceBooks() throws InterruptedException {
        loginAdmin();
        driver.findElement(xpathReferenceBooks).click();
        System.out.println("Go to section: Reference Books");
    }

    public void subSectionTags() throws InterruptedException {
        sectionReferenceBooks();               // Переход в раздел "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathTags).click();
        System.out.println("Go to subsection: Tags");
    }

    public void openTagCard() throws InterruptedException {
        subSectionTags();                     // Переход в подраздел "Теги рубрик", раздела "Справочники"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Tag Card");
    }

    public void createTag() throws InterruptedException {
        openTagCard();                     // Открываем карточку Тега рубрики
        Thread.sleep(2000);
        driver.findElement(selectorFieldName).sendKeys(tagName);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Tag");
    }

    public void deleteTag() throws InterruptedException {
        createTag();                       // Создаем Тег рубрики
        Thread.sleep(2000);
        driver.findElement(selectorFieldSearch).sendKeys(tagName);
        Thread.sleep(2000);
        String nameTagSearch = driver.findElementByXPath("//app-rubrics/div/div[2]/table/tbody/tr/td[2]").getText();
        if (nameTagSearch.equals(tagName)) {
            driver.findElement(xpathIconDelete).click();
            Thread.sleep(1000);
            driver.findElement(xpathButtonDelete).click();
            System.out.println("Delete Tag");
        }
    }
}
