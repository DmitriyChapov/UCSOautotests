package login.user_portal.interviews;

import login.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.portal.Selector.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;
import static variables.admin.Strings.*;

public class CheckCreatedSurvey extends InterviewsPage {

    public void userToSurveyCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathUserToSurveryCard));
        driver.findElement(xpathUserToSurveryCard).click();
    }

    public void getAllUserSurveys() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathUserSurveys));
        userSurveys = driver.findElements(xpathUserSurveys);
    }

    public void findCreatedSurvey() throws InterruptedException {
        for (int i = 0; i < userSurveys.size(); i++) {

            String temp = userSurveys.get(i).getAttribute("href");
            String userSurveyId = temp.substring(50, temp.length());

            if (userSurveyId.equals(surveyId)) {
                String surveyHeadingMainSNow = driver.findElement(xpathSurveyMainSHeading).getText();

                if (interviewHeading.length() > 77) {
                    Assert.assertEquals("Не совпадает заголовок опроса в разделе 'Опросы'", interviewHeading.substring(0, 77), surveyHeadingMainSNow.substring(0, 77));
                } else {
                    Assert.assertEquals("Не совпадает заголовок опроса в разделе 'Опросы'", interviewHeading, surveyHeadingMainSNow);
                }

                userSurveys.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
    }


    public void surveyMainAttributesAssert() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveyElements));
        String openedSurveyHeading = driver.findElement(xpathOpenedSurveyHeading).getText();
        Assert.assertEquals("Не совпадает заголовок в открытом опросе", interviewHeading, openedSurveyHeading);

        String openedSurveyDescription = driver.findElement(xpathOpenedSurveyDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание в открытом опросе", interviewDescription, openedSurveyDescription);
    }

    //1. Вопрос "Короткий ответ" - Числовая форма

    public void surveyShortAnswerNumberAssert(){

    }
}
