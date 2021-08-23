package alltest.user;

import org.junit.Test;

public class CheckCreatedInterview extends login.user_portal.interviews.CheckCreatedSurvey {

    @Test
    public void testCheckCreatedInterview() {
        publicInterview();
        loginPortal();
        userToSurveyCard();
        getAllUserSurveys();
        findCreatedSurvey();
        surveyMainAttributesAssert();
        surveyQuestionsAssert();
    }
}
