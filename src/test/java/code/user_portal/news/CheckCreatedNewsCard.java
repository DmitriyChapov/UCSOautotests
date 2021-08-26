package code.user_portal.news;

import code.main.administration.content.news.NewsPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.common.Strings.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;
import static variables.admin.Strings.*;


public class CheckCreatedNewsCard extends NewsPage {

    //Переход с главной страницы в раздел "Новости"
    public void sectionNews() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathUserNewsSection)));
        driver.findElement(xpathUserNewsSection).click();
    }

    //Получаем все новости, доступные пользователю
    public void getUserNews() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathAllUserNews));
        userNews = driver.findElements(xpathAllUserNews);
    }

    //Открываем конкретную созданную новость
    public void checkNewsInSection() {

        for (int i = 0; i < userNews.size(); i++) {
            String temp = userNews.get(i).getAttribute("href");
            String userCardId = temp.substring(temp.length() - 5);

            if (userCardId.equals(newsCardId)) {

                //Проверка Заголовка в общем разделе
                String newsSectionHeadingNow = userNews.get(i).findElement(xpathNewsSectionHeading).getText();
                Assert.assertEquals("Не совпадает заголовок новости в общем разделе 'Новости'", newsHeading, newsSectionHeadingNow);

                //Проверка Даты в общем разделе
                String newsSectionDateNow = userNews.get(i).findElement(xpathNewsSectionDates).getText();
                Assert.assertEquals("Не совпадает дата новости в общем разделе 'Новости'", dateNow, newsSectionDateNow);

                System.out.println("News ID: " + userCardId + " in Section 'News' has been successfully Verified");
                userNews.get(i).click();
                break;
            }
        }
    }

    public void checkOpenedNews(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathOpenedNewsHeading));
        //Проверка ID открытой новости
        String newsID = driver.getCurrentUrl();
        String openedNewsID = newsID.substring(newsID.length() - 5);
        Assert.assertEquals("Не совпадает ID у открытой новости", newsCardId, openedNewsID);

        //Проверка заголовка в открытой новости
        String openedNewsHeading = driver.findElement(xpathOpenedNewsHeading).getText();
        Assert.assertEquals("Не совпадает заголовок новости", newsHeading, openedNewsHeading);

        //Проверка даты в открытой новости
        String openedNewsDates = driver.findElement(xpathOpenedNewsDates).getText();
        Assert.assertEquals("Не совпадает дата новости", dateNow, openedNewsDates);

        //Проверка рубрики в открытой новости
        String openedNewsCategory = driver.findElement(xpathOpenedNewsCategory).getText();
        Assert.assertEquals("Не совпадает рубрика новости", newsCategory.toUpperCase(), openedNewsCategory);

        //Проверка анонса в открытой новости
        String openedNewsTeaser = driver.findElement(xpathOpenedNewsTeaser).getText();
        Assert.assertEquals("Не совпадает анонс новости", newsTeaser, openedNewsTeaser);

        //Проверка текста в открытой новости
        String openedNewsText = driver.findElement(xpathOpenedNewsText).getText();
        Assert.assertEquals("Не совпадает текст новости", fullNewsText, openedNewsText);
        System.out.println("Opened News ID: " + openedNewsID + " has been successfully Verified");
    }
}