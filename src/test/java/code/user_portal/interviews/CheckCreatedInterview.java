package code.user_portal.interviews;

import code.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.ArrayList;
import java.util.List;

import static variables.admin.Collections.*;
import static variables.portal.Xpath.*;
import static variables.portal.Collections.*;
import static variables.admin.Strings.*;
import static variables.portal.Numbers.*;

public class CheckCreatedInterview extends InterviewsPage {

    public void sectionInterviews() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathUserInterviewsSection));
        driver.findElement(xpathUserInterviewsSection).click();
    }

    public void getAllUserInterviews() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpathAllUserInterview));
        userInterview = driver.findElements(xpathAllUserInterview);
    }

    public void checkInterviewInSection() {
        for (int i = 0; i < userInterview.size(); i++) {

            String temp = userInterview.get(i).getAttribute("href");
            String userInterviewId = temp.substring(50);

            if (userInterviewId.equals(interviewId)) {
                String interviewSectionHeadingNow = driver.findElement(xpathInterviewSectionHeading).getText();

                if (interviewHeading.length() > 77) {
                    Assert.assertEquals("Не совпадает заголовок опроса в разделе 'Опросы'", interviewHeading.substring(0, 77), interviewSectionHeadingNow.substring(0, 77));
                } else {
                    Assert.assertEquals("Не совпадает заголовок опроса в разделе 'Опросы'", interviewHeading, interviewSectionHeadingNow);
                }
                userInterview.get(i).click();
                break;
            }
        }
    }

    public void surveyMainAttributesAssert() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveyElements));
        openedSurveyNamesNow = driver.findElements(xpathOpenedQuestionName);
        openedSurveyDescriptionsNow = driver.findElements(xpathOpenedQuestionDescription);

        String openedSurveyHeading = driver.findElement(xpathOpenedSurveyHeading).getText();
        Assert.assertEquals("Не совпадает заголовок в открытом опросе", interviewHeading, openedSurveyHeading);

        String openedSurveyDescription = driver.findElement(xpathOpenedSurveyDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание в открытом опросе", interviewDescription.substring(0, interviewDescription.length() - 1), openedSurveyDescription);
    }

    //Проверка вопроса в зависимости от его типа
    public void surveyQuestionsAssert() {
        for (counter = 0; counter < questionTypes.size(); counter++) {
            questionType = questionTypes.get(counter);

            beginTitle = (counter >= 9) ? 4 : 3;

            if (questionType.equals("Короткий ответ")) {
                surveyShortAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Длинный ответ")) {
                surveyLongAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Один вариант")) {
                surveyOneVarAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Несколько вариантов")) {
                surveySomeVarAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Выпадающий список")) {
                surveyDropDownAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Шкала")) {
                surveyScaleAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Загрузка файла")) {
                surveyDownloadFileAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            } else if (questionType.equals("Текст")) {
                surveyTextAnswerAssert(openedSurveyNamesNow, openedSurveyDescriptionsNow, questionNames, questionComments);
            }
        }
    }

    //Проверка вопроса с коротким ответом
    public void surveyShortAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyShortAnswerNameNow = namesNow.get(counter).getText();
        String questionShortAnswerName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом в открытом опроснике", questionShortAnswerName, openedSurveyShortAnswerNameNow.substring(beginTitle, openedSurveyShortAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом в открытом опроснике", questionShortAnswerName, openedSurveyShortAnswerNameNow);
        }
        String openedSurveyShortAnswerDescriptionNow = descriptionsNow.get(counter).getText();
        String questionShortAnswerDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом в открытом опроснике", questionShortAnswerDescription, openedSurveyShortAnswerDescriptionNow);
    }

    //Проверка вопроса с длинным ответом
    public void surveyLongAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyLongAnswerNameNow = namesNow.get(counter).getText();
        String questionLongAnswerName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с длинным ответом в открытом опроснике", questionLongAnswerName, openedSurveyLongAnswerNameNow.substring(beginTitle, openedSurveyLongAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с длинным ответом в открытом опроснике", questionLongAnswerName, openedSurveyLongAnswerNameNow);
        }

        String openedSurveyLongAnswerDescriptionNow = descriptionsNow.get(counter).getText();
        String questionLongAnswerDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (числовая форма) в открытом опроснике", questionLongAnswerDescription, openedSurveyLongAnswerDescriptionNow);
    }

    //Проверка вопроса 'Один вариант'
    public void surveyOneVarAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyOneVarAnswerNameNow = namesNow.get(counter).getText();
        String questionOneVarName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с одним вариантом ответа в открытом опроснике", questionOneVarName, openedSurveyOneVarAnswerNameNow.substring(beginTitle, openedSurveyOneVarAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с одним вариантом ответа в открытом опроснике", questionOneVarName, openedSurveyOneVarAnswerNameNow);
        }

        String openedSurveyOneVarDescriptionNow = descriptionsNow.get(counter).getText();
        String questionOneVarDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с одним вариантом ответа в открытом опроснике", questionOneVarDescription, openedSurveyOneVarDescriptionNow);
    }

    //Проверка вопроса 'Несколько вариантов'
    public void surveySomeVarAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveySomeVarAnswerNameNow = namesNow.get(counter).getText();
        String questionSomeVarName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с несколькими вариантами ответа в открытом опроснике", questionSomeVarName, openedSurveySomeVarAnswerNameNow.substring(beginTitle, openedSurveySomeVarAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с несколькими вариантами ответа в открытом опроснике", questionSomeVarName, openedSurveySomeVarAnswerNameNow);
        }

        String openedSurveySomeVarDescriptionNow = descriptionsNow.get(counter).getText();
        String questionSomeVarDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с несколькими вариантами ответа в открытом опроснике", questionSomeVarDescription, openedSurveySomeVarDescriptionNow);
    }

    //Проверка вопроса 'Выпадающий список'
    public void surveyDropDownAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyDropDownAnswerNameNow = namesNow.get(counter).getText();
        String questionDropDownName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с выпадающим списком в открытом опроснике", questionDropDownName, openedSurveyDropDownAnswerNameNow.substring(beginTitle, openedSurveyDropDownAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с выпадающим списком в открытом опроснике", questionDropDownName, openedSurveyDropDownAnswerNameNow);
        }

        String openedSurveyDropDownDescriptionNow = descriptionsNow.get(counter).getText();
        String questionDropDownDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с выпадающим списком в открытом опроснике", questionDropDownDescription, openedSurveyDropDownDescriptionNow);
    }

    //Проверка вопроса 'Шкала'
    public void surveyScaleAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyScaleAnswerNameNow = namesNow.get(counter).getText();
        String questionScaleName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса с вариантом ответа 'Шкала' в открытом опроснике", questionScaleName, openedSurveyScaleAnswerNameNow.substring(beginTitle, openedSurveyScaleAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса с вариантом ответа 'Шкала' в открытом опроснике", questionScaleName, openedSurveyScaleAnswerNameNow);
        }

        String openedSurveyScaleDescriptionNow = descriptionsNow.get(counter).getText();
        String questionScaleDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса с вариантом ответа 'Шкала' в открытом опроснике", questionScaleDescription, openedSurveyScaleDescriptionNow);
    }

    //Проверка вопроса 'Загрузить файл'
    public void surveyDownloadFileAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyFileNameNow = namesNow.get(counter).getText();
        String questionFileName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса 'Загрузка файла' в открытом опроснике", questionFileName, openedSurveyFileNameNow.substring(beginTitle, openedSurveyFileNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса 'Загрузка файла' в открытом опроснике", questionFileName, openedSurveyFileNameNow);
        }

        String openedSurveyFileDescriptionNow = descriptionsNow.get(counter).getText();
        String questionFileDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса 'Загрузка файла' в открытом опроснике", questionFileDescription, openedSurveyFileDescriptionNow);
    }

    //Проверка вопроса 'Текст'
    public void surveyTextAnswerAssert(List<WebElement> namesNow, List<WebElement> descriptionsNow, ArrayList<String> namesExpected, ArrayList<String> descriptionsExpected) {
        String openedSurveyTextAnswerNameNow = namesNow.get(counter).getText();
        String questionTextAnswerFileName = namesExpected.get(counter);

        if (questionTypes.size() > 1) {
            Assert.assertEquals("Не совпадает наименование вопроса 'Текст' в открытом опроснике", questionTextAnswerFileName, openedSurveyTextAnswerNameNow.substring(beginTitle, openedSurveyTextAnswerNameNow.length()));
        } else {
            Assert.assertEquals("Не совпадает наименование вопроса 'Текст' в открытом опроснике", questionTextAnswerFileName, openedSurveyTextAnswerNameNow);
        }

        String openedSurveyTextAnswerDescriptionNow = descriptionsNow.get(counter).getText();
        String questionTextAnswerDescription = descriptionsExpected.get(counter);
        Assert.assertEquals("Не совпадает краткое описание вопроса 'Текст' в открытом опроснике", questionTextAnswerDescription, openedSurveyTextAnswerDescriptionNow);
    }
}

