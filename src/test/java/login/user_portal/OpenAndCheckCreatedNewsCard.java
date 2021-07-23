package login.user_portal;

import login.main.administration.content.news.NewsPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.Xpath.*;
import static variables.Collections.*;
import static variables.Strings.*;


public class OpenAndCheckCreatedNewsCard extends NewsPage {

    //Переход с главной страницы в раздел "Новости"
    public void userMainPageToNews() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathUserNewsSection)));
        driver.findElement(xpathUserNewsSection).click();
    }

    //Получаем все новости, доступные пользователю
    public void getUserNews() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathAllUserNews));
        userNews = driver.findElements(xpathAllUserNews);
        newsCardMainSectionHeadings = driver.findElements(xpathNewsCardMainSectionHeading);
        newsCardMainSectionDates = driver.findElements(xpathNewsCardMainSectionDates);
    }

    //Открываем конкретную созданную новость
    public void openCreatedNewsCard() {

        for (int i = 0; i < userNews.size(); i++) {
            String temp = userNews.get(i).getAttribute("href");
            String userCardId = temp.substring(temp.length() - 5);


            if (userCardId.equals(newsCardId)) {

                //Проверка Заголовка в общем разделе
                String newsCardMainSectionHeadingNow = newsCardMainSectionHeadings.get(i).getText();
                Assert.assertEquals("Не совпадает заголовок новости в общем разделе 'Новости'", newsHeading, newsCardMainSectionHeadingNow);

                //Проверка Даты в общем разделе
                String newsCardMainSectionDateNow = newsCardMainSectionDates.get(i).getText();
                Assert.assertEquals("Не совпадает дата новости в общем разделе 'Новости'", dateNow, newsCardMainSectionDateNow);

                userNews.get(i).click();
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathOpenedNewsCardAttributes));
                break;
            }
        }

        //Проверка заголовка в открытой новости
        String openedNewsCardHeading = driver.findElement(xpathOpenedNewsCardHeading).getText();
        Assert.assertEquals("Не совпадает заголовок новости", newsHeading, openedNewsCardHeading);

        //Получение Даты, Анонса и Текста новости
        newsCardAttributes = driver.findElements(xpathOpenedNewsCardAttributes);

        //Проверка даты в открытой новости
        String openedNewsCardDate = newsCardAttributes.get(0).getText();
        Assert.assertEquals("Не совпадает дата новости", dateNow, openedNewsCardDate);

        //Проверка рубрики в открытой новости
        String openedNewsCardCategory = driver.findElement(xpathOpenedNewsCardCategory).getText();
        Assert.assertEquals("Не совпадает рубрика новости", newsCardCategory.toUpperCase(), openedNewsCardCategory);

        //Проверка анонса в открытой новости
        String openedNewsCardAnnouncement = newsCardAttributes.get(1).getText();
        Assert.assertEquals("Не совпадает анонс новости", newsAnnouncement, openedNewsCardAnnouncement);

        /*//Проверка текста в открытой новости
        String openedNewsCardText = newsCardAttributes.get(2).getText();
        Assert.assertEquals("Не совпадает текст новости", newsText.repeat(20), openedNewsCardText);*/
    }
}