package alltest.user;

import org.junit.Test;

public class CheckCreatedSurvey extends login.user_portal.interviews.CheckCreatedSurvey {

    @Test
    public void testInterviews() throws InterruptedException {
        publicInterview();
        loginPortal();
        userToSurveyCard();
        getAllUserSurveys();
        findCreatedSurvey();
        surveyMainAttributesAssert();
        surveyShortAnswerNumberAssert();
        surveyShortAnswerDoubleAssert();
        surveyShortAnswerPhoneAssert();
        surveyShortAnswerSymbolAssert();
        surveyShortAnswerNoValidAssert();
        surveyLongAnswerAssert();
        surveyOneVarAssert();
        surveySomeVarAssert();
        surveyDropDownAssert();
        surveyScaleAssert();
        surveyDownloadJPEGAssert();
        surveyDownloadPNGAssert();
        surveyDownloadPDFAssert();
        surveyDownloadDOCAssert();
        surveyDownloadXLSAssert();
        surveyDownloadALLAssert();
        surveyTextAssert();
    }
}
