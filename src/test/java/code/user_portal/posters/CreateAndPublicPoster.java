package code.user_portal.posters;

import code.main.administration.content.afisha.PostersPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.admin.Strings.*;
import static variables.admin.Urls.*;
import static variables.common.Strings.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;


public class CreateAndPublicPoster extends PostersPage {

    public void sectionPosters() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathUserPostersSection)));
        driver.findElement(xpathUserPostersSection).click();
    }

    public void getUserPosters() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllUserPosters));
        userPosters = driver.findElements(xpathAllUserPosters);
    }

    public void checkPosterInSection() {
        for (int i = 0; i < userPosters.size(); i++) {
            String temp = userPosters.get(i).getAttribute("href");
            String userPosterId = temp.substring(52, 57);

            if (userPosterId.equals(posterCardId)) {

                //Проверка заголовка созданной афиши в основном разделе 'Афииши'
                String posterSectionHeadingNow = userPosters.get(i).findElement(xpathPosterSectionHeading).getText();
                if (posterHeading.length() >= 97) {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading.substring(0, 97), posterSectionHeadingNow.substring(0, 97));
                }
                else {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading, posterSectionHeadingNow);
                }

                //Проверка анонса созданной афиши в основном разделе 'Афииши'
                String posterSectionTeaserNow = userPosters.get(i).findElement(xpathPosterSectionTeaser).getText();
                Assert.assertEquals("Не совпадает анонс афиши в общем разделе 'Афиши'", posterTeaser, posterSectionTeaserNow);

                //Проверка даты созданной афиши в основном разделе 'Афииши'
                String posterSectionDateNow = userPosters.get(i).findElement(xpathPosterSectionDates).getText();
                Assert.assertEquals("Не совпадает дата афиши в общем разделе 'Афиши'", posterEventDate, posterSectionDateNow);

                //Проверка возраста созданной афиши в основном разделе 'Афииши'
                String posterSectionAgeNow = userPosters.get(i).findElement(xpathPosterSectionAge).getText();
                Assert.assertEquals("Не совпадает возраст афиши в общем разделе 'Афиши'", agePlus, posterSectionAgeNow);

                //Проверка цены созданной афиши в основном разделе 'Афииши'
                String posterSectionCostNow = userPosters.get(i).findElement(xpathPosterSectionCost).getText();
                Assert.assertEquals("Не совпадает цена у афиши в общем разделе 'Афиши'", posterEventCost, posterSectionCostNow);

                //Проверка локации созданной афиши в основном разделе 'Афииши'
                String posterSectionLocationNow = userPosters.get(i).findElement(xpathPosterSectionLocation).getText();
                Assert.assertEquals("Не совпадает локация афиши в общем разделе 'Афиши'", posterEventLocation, posterSectionLocationNow);

                System.out.println("Poster ID: " + userPosterId + " in Section 'Posters' has been successfully Verified");
                userPosters.get(i).click();
                break;
            }
        }
    }

    //Проверки для открытой афиши

    public void checkOpenedPoster() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedPosterHeader));
        //Проверка ID открытой афиши
        String posterID = driver.getCurrentUrl();
        String openedPosterID = posterID.substring(52, 57);
        Assert.assertEquals("Не совпадает ID у открытой афиши", posterCardId, openedPosterID);

        //Проверка заголовка в открытой афише
        String openedPosterHeading = driver.findElement(xpathOpenedPosterHeading).getText();
        Assert.assertEquals("Не совпадает заголовок у открытой афиши", posterHeading, openedPosterHeading);

        //Проверка даты в открытой афише
        String openedPosterDate = driver.findElement(xpathOpenedPosterDate).getText();
        Assert.assertEquals("Не совпадает дата у открытой афиши", posterEventDate, openedPosterDate);

        //Проверка цены в открытой афише
        String openedPosterCost = driver.findElement(xpathOpenedPosterCost).getText();
        Assert.assertEquals("Не совпадает цена у открытой афиши", posterEventCost, openedPosterCost);

        //Проверка возраста в открытой афише
        String openedPosterAge = driver.findElement(xpathOpenedPosterAge).getText();
        Assert.assertEquals("Не совпадает цена у открытой афиши", agePlus, openedPosterAge);

        //Проверка локации в открытой афише
        String openedPosterLocation = driver.findElement(xpathOpenedPosterLocation).getText();
        Assert.assertEquals("Не совпадает локация у открытой афиши", posterEventLocation, openedPosterLocation);

        //Проверка ссылки в открытой афише
        String openedPosterUrl = driver.findElement(xpathOpenedPosterUrl).getAttribute("href");
        Assert.assertEquals("Не совпадает ссылка у открытой афиши", posterEventSchedule, openedPosterUrl);

        //Проверка рубрики в открытой афише
        String openedPosterCategory = driver.findElement(xpathOpenedPosterCategory).getText();
        Assert.assertEquals("Не совпадает рубрика у открытой афиши", posterCategory.toUpperCase(), openedPosterCategory);

        //Проверка анонса в открытой афише
        String openedPosterTeaser = driver.findElement(xpathOpenedPosterTeaser).getText();
        Assert.assertEquals("Не совпадает анонс у открытой афиши", posterTeaser, openedPosterTeaser);

        //Проверка текста в открытой афише
        String openedPosterText = driver.findElement(xpathOpenedPosterText).getText();
        Assert.assertEquals("Не совпадает текст у открытой афиши", fullPosterText, openedPosterText);
        System.out.println("Opened Poster ID: " + openedPosterID + " has been successfully Verified");
    }
}
