package alltest.user;

import org.junit.Test;

public class CheckCreatedInterview extends code.user_portal.interviews.CheckCreatedInterview {

    @Test
    public void testCheckCreatedInterview() {
        publicInterview();
        loginPortal();
        sectionInterviews();
        getAllUserInterviews();
        checkInterviewInSection();
        surveyMainAttributesAssert();
        surveyQuestionsAssert();
    }
}
