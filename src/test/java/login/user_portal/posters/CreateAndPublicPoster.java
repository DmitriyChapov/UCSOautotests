package login.user_portal.posters;

import login.main.administration.content.afisha.PostersPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Numbers.age;
import static variables.admin.Strings.*;
import static variables.admin.Urls.scheduleAfisha;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;


public class CreateAndPublicPoster extends PostersPage {

    public void userToPosterCard() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathPosterSection)));
        driver.findElement(xpathPosterSection).click();
    }

    public void getUserPosters() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllUserPosters));
        userPosters = driver.findElements(xpathAllUserPosters);
        posterCardDates = driver.findElements(xpathMainSPosterDates);
        posterCardAges = driver.findElements(xpathMainSPosterAge);
        posterCardCosts = driver.findElements(xpathMainSPosterCost);
        posterCardHeadings = driver.findElements(xpathMainSPosterHeading);
        posterCardLocations = driver.findElements(xpathMainSPosterLocation);
        posterCardTeasers = driver.findElements(xpathMainSPosterTeaser);
    }

    public void openCreatedPosterCard() {
        for (int i = 0; i < userPosters.size(); i++) {
            String temp = userPosters.get(i).getAttribute("href");
            String userPosterId = temp.substring(52, 57);

            if (userPosterId.equals(posterCardId)) {

                //Проверка даты созданной афиши в основном разделе 'Афииши'
                String posterCardMainSDateNow = posterCardDates.get(i).getText();
                Assert.assertEquals("Не совпадает дата афиши в общем разделе 'Афиши'", posterDate, posterCardMainSDateNow);

                //Проверка возраста созданной афиши в основном разделе 'Афииши'
                String tempAge = posterCardAges.get(i).getText();
                int plus = tempAge.indexOf("+");
                String posterCardMainSAgeNow = tempAge.substring(0, plus);
                Assert.assertEquals("Не совпадает возраст афиши в общем разделе 'Афиши'", String.valueOf(age), posterCardMainSAgeNow);

                //Проверка цены созданной афиши в основном разделе 'Афииши'
                String posterCardMainSCostNow = posterCardCosts.get(i).getText();
                Assert.assertEquals("Не совпадает цена у афиши в общем разделе 'Афиши'", posterCost, posterCardMainSCostNow);


                //Проверка заголовка созданной афиши в основном разделе 'Афииши'
                String posterCardMainSHeadingNow = posterCardHeadings.get(i).getText();
                if (posterHeading.length() > 97) {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading.substring(0, 97), posterCardMainSHeadingNow.substring(0, 97));
                }
                else {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading, posterCardMainSHeadingNow);
                }

                //Проверка анонса созданной афиши в основном разделе 'Афииши'
                String posterCardMainSTeaserNow = posterCardTeasers.get(i).getText();
                Assert.assertEquals("Не совпадает анонс афиши в общем разделе 'Афиши'", posterAnnouncement, posterCardMainSTeaserNow);

                //Проверка локации созданной афиши в основном разделе 'Афииши'
                String posterCardMainSLocationNow = posterCardLocations.get(i).getText();
                Assert.assertEquals("Не совпадает локация афиши в общем разделе 'Афиши'", posterLocation, posterCardMainSLocationNow);

                userPosters.get(i).click();
                break;
            }
        }

        openedPosterAsserts();
    }

    //Проверки для открытой афиши
    public void openedPosterAsserts() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathOpenedPosterHeader));

        //Проверка заголовка в открытой афише
        String openedPosterHeading = driver.findElement(xpathOpenedPosterHeading).getText();
        Assert.assertEquals("Не совпадает заголовок у открытой афиши", posterHeading, openedPosterHeading);

        //Проверка даты в открытой афише
        String openedPosterDate = driver.findElement(xpathOpenedPosterDate).getText();
        Assert.assertEquals("Не совпадает дата у открытой афиши", posterDate, openedPosterDate);

        //Проверка цены в открытой афише
        String openedPosterCost = driver.findElement(xpathOpenedPosterCost).getText();
        Assert.assertEquals("Не совпадает цена у открытой афиши", posterCost, openedPosterCost);

        //Проверка возраста в открытой афише
        String tAge = driver.findElement(xpathOpenedPosterAge).getText();
        int pl = tAge.indexOf("+");
        String openedPosterAge = tAge.substring(0, pl);
        Assert.assertEquals("Не совпадает цена у открытой афиши", String.valueOf(age), openedPosterAge);

        //Проверка локации в открытой афише
        String openedPosterLocation = driver.findElement(xpathOpenedPosterLocation).getText();
        Assert.assertEquals("Не совпадает локация у открытой афиши", posterLocation, openedPosterLocation);

        //Проверка ссылки в открытой афише
        String openedPosterUrl = driver.findElement(xpathOpenedPosterUrl).getAttribute("href");
        Assert.assertEquals("Не совпадает ссылка у открытой афиши", scheduleAfisha, openedPosterUrl);

        //Проверка рубрики в открытой афише
        String openedPosterCategory = driver.findElement(xpathOpenedPosterCategory).getText();
        Assert.assertEquals("Не совпадает рубрика у открытой афиши", posterCategory.toUpperCase(), openedPosterCategory);

        //Проверка анонса в открытой афише
        String openedPosterTeaser = driver.findElement(xpathOpenedPosterTeaser).getText();
        Assert.assertEquals("Не совпадает анонс у открытой афиши", posterAnnouncement, openedPosterTeaser);

        //Проверка текста в открытой афише
        /*String openedPosterText = driver.findElement(xpathOpenedPosterText).getText();
        Assert.assertEquals("Не совпадает рубрика у открытой афиши", posterText, openedPosterText);*/
    }
}
