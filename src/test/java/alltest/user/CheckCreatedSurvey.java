package alltest.user;

import org.junit.Test;

public class CheckCreatedSurvey extends login.user_portal.interviews.CheckCreatedSurvey {

    @Test
    public void testInterviews() {
        publicInterview();
        loginPortal();
        userToSurveyCard();
        getAllUserSurveys();
        findCreatedSurvey();
        surveyMainAttributesAssert();
        surveyQuestionsAssert();
    }
}
