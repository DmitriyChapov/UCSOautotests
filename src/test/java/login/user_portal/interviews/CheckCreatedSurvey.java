package login.user_portal.interviews;

import login.main.administration.interviews.interviews.InterviewsPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        surveysHeadings = driver.findElements(xpathSurveyMainSHeading);
        System.out.println(userSurveys.size());
        System.out.println(surveysHeadings.size());
    }

    public void findCreatedSurvey() throws InterruptedException {
        for (int i = 0; i < userSurveys.size(); i++) {
            String temp = userSurveys.get(i).getAttribute("href");
            String userSurveyId = temp.substring(50, temp.length());

            if (surveyId.equals(userSurveyId)) {

                userSurveys.get(i).click();
                break;
            }
        }
        Thread.sleep(2000);
    }


}
