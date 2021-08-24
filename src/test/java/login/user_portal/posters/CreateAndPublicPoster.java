package login.user_portal.posters;

import login.main.administration.content.afisha.PostersPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static variables.admin.Strings.*;
import static variables.admin.Urls.*;
import static variables.portal.Strings.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;


public class CreateAndPublicPoster extends PostersPage {

    public void sectionPosters() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(xpathPosterSection)));
        driver.findElement(xpathPosterSection).click();
    }

    public void getUserPosters() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllUserPosters));
        userPosters = driver.findElements(xpathAllUserPosters);
    }

    public void openCreatedPosterCard() {
        for (int i = 0; i < userPosters.size(); i++) {
            String temp = userPosters.get(i).getAttribute("href");
            String userPosterId = temp.substring(52, 57);

            if (userPosterId.equals(posterCardId)) {

                //Проверка заголовка созданной афиши в основном разделе 'Афииши'
                String posterMainHeadingNow = userPosters.get(i).findElement(xpathPosterMainHeading).getText();
                if (posterHeading.length() >= 97) {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading.substring(0, 97), posterMainHeadingNow.substring(0, 97));
                }
                else {
                    Assert.assertEquals("Не совпадает заголовок афиши в общем разделе 'Афиши'", posterHeading, posterMainHeadingNow);
                }

                //Проверка анонса созданной афиши в основном разделе 'Афииши'
                String posterMainTeaserNow = userPosters.get(i).findElement(xpathPosterMainTeaser).getText();
                Assert.assertEquals("Не совпадает анонс афиши в общем разделе 'Афиши'", posterTeaser, posterMainTeaserNow);

                //Проверка даты созданной афиши в основном разделе 'Афииши'
                String posterMainDateNow = userPosters.get(i).findElement(xpathPosterMainDates).getText();
                Assert.assertEquals("Не совпадает дата афиши в общем разделе 'Афиши'", posterDate, posterMainDateNow);

                //Проверка возраста созданной афиши в основном разделе 'Афииши'
                String posterMainAgeNow = userPosters.get(i).findElement(xpathPosterMainAge).getText();
                Assert.assertEquals("Не совпадает возраст афиши в общем разделе 'Афиши'", agePlus, posterMainAgeNow);

                //Проверка цены созданной афиши в основном разделе 'Афииши'
                String posterMainCostNow = userPosters.get(i).findElement(xpathPosterMainCost).getText();
                Assert.assertEquals("Не совпадает цена у афиши в общем разделе 'Афиши'", posterCost, posterMainCostNow);

                //Проверка локации созданной афиши в основном разделе 'Афииши'
                String posterMainLocationNow = userPosters.get(i).findElement(xpathPosterMainLocation).getText();
                Assert.assertEquals("Не совпадает локация афиши в общем разделе 'Афиши'", posterLocation, posterMainLocationNow);

                System.out.println("Poster ID: " + userPosterId + " in Main has been successfully Verified");
                userPosters.get(i).click();
                break;
            }
        }
        openedPosterAsserts();
    }

    //Проверки для открытой афиши
    public void openedPosterAsserts() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathOpenedPosterHeader));

        //Проверка ID открытой афиши
        String posterID = driver.getCurrentUrl();
        String openedPosterID = posterID.substring(52, 57);
        Assert.assertEquals("Не совпадает ID у открытой афиши", posterCardId, openedPosterID);

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
        String openedPosterAge = driver.findElement(xpathOpenedPosterAge).getText();
        Assert.assertEquals("Не совпадает цена у открытой афиши", agePlus, openedPosterAge);

        //Проверка локации в открытой афише
        String openedPosterLocation = driver.findElement(xpathOpenedPosterLocation).getText();
        Assert.assertEquals("Не совпадает локация у открытой афиши", posterLocation, openedPosterLocation);

        //Проверка ссылки в открытой афише
        String openedPosterUrl = driver.findElement(xpathOpenedPosterUrl).getAttribute("href");
        Assert.assertEquals("Не совпадает ссылка у открытой афиши", schedulePoster, openedPosterUrl);

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
