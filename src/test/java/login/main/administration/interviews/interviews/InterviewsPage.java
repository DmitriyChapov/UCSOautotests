package login.main.administration.interviews.interviews;

import login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Collections.*;
import static variables.admin.Numbers.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.portal.Collections.surveyOneVarVariants;

import java.util.List;

public class InterviewsPage extends Login {

    public void sectionContentInterview() throws InterruptedException {
        loginAdmin();
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathInterviews);
        Actions actionchange = new Actions(driver);
        actionchange.moveToElement(sectionAdmin);
        Thread.sleep(2000);
        actionchange.moveToElement(subsectionContent).click();
        actionchange.perform();
        System.out.println("Go to section: Interviews");
    }

    public void openInterviewCard() throws InterruptedException {
        sectionContentInterview();                 // Переход в подраздел "Опросы", раздела "Опросы"
        Thread.sleep(2000);
        driver.findElement(xpathButtonAdd).click();
        System.out.println("Open Interview Card");
    }

    public void tabPropertiesInterviewCard() {
        List<WebElement> datepicker = driver.findElements(dateFields);
        List<WebElement> timepicker = driver.findElements(timeFields);
        driver.findElement(xpathPortal).click();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        driver.findElement(xpathMobile).click();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        driver.findElement(selectorSelectInterviewResults).click();
        driver.findElement(xpathResultInRealTime).click();
        driver.findElement(selectorSelectInterviewAccess).click();
        driver.findElement(xpathAccessAll).click();
        driver.findElement(xpathLocationForContent).click();
    }

    public void tabConstructorInterviewCard() throws InterruptedException {
        driver.findElement(xpathTabConstructor).click();
        Thread.sleep(2000);
        driver.findElement(selectorFieldInterviewHeading).sendKeys(interviewHeading);
        driver.findElement(selectorFieldInterviewDescription).sendKeys(interviewDescription);
    }

    public void qestionShortAnswerNumber() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        driver.findElement(xpathShortAnswer).click();
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathValidationTypeNumber).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionShortNumberName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionShortNumberDescription);
        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortNumber));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortNumberA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Short Answer - Number");
    }

    public void qestionShortAnswerDouble() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathShortAnswer).click();
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathValidationTypeDouble).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionShortDoubleName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionShortDoubleDescription);
        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortDouble));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortDoubleA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Short Answer - Double");
    }

    public void qestionShortAnswerPhone() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathShortAnswer).click();
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathValidationTypePhone).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionShortPhoneName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionShortPhoneDescription);
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortPhoneA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Short Answer - Phone");
    }

    public void qestionShortAnswerSymbol() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathShortAnswer).click();
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathValidationTypeSymbol).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionShortSymbolName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionShortSymbolDescription);
        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortSymbol));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortSymbolA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Short Answer - Symbol");
    }

    public void qestionShortAnswerNoValid() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathShortAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionShortNoValidName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionShortNoValidDescription);
        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortNoValid));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortNoValidA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Short Answer - No valid");
    }

    public void qestionLongAnswer() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathLongAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionLongName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionLongDescription);
        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolLong));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionLongA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Long Answer");
    }

    public void qestionOneVar() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathOneVarAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionOneVarName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionOneVarDescription);
        for (int i = 0; i < nmbOneVar; i++) {
            String nameVar = "Вариант " + (i + 1);
            String idAnswer = "answer-" + i;
            driver.findElement(xpathButtonAddAnswer).click();
            String imageQuestionVarName = "D:\\ImageForAutoTests\\Questions\\Options\\Option" + (i + 1) + ".jpg";
            List<WebElement> imageIcon = driver.findElements(selectorFieldImage);
            imageIcon.get(imageIcon.size() - 1).sendKeys(imageQuestionVarName);
            Thread.sleep(2000);
            driver.findElement(By.id(idAnswer)).sendKeys(nameVar);
        }
        Thread.sleep(2000);
        questionOneVarVariants = driver.findElements(xpathCreatedSurveyOneVarVariants);         //Получение списка вариантов
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion One Variant");

        for (int i = 0; i < questionOneVarVariants.size(); i++) {                   //Получение списка наименований вариантов
            questionOneVarVariantsNames.add(questionOneVarVariants.get(i).getAttribute("value"));
        }
    }

    public void qestionSomeVar() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathSomeVarAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionSomeVarName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionSomeVarDescription);
        for (int i = 0; i < nmbSomeVar; i++) {
            String nameVar = "Вариант " + (i + 1);
            String idAnswer = "answer-" + i;
            driver.findElement(xpathButtonAddAnswer).click();
            String imageQuestionVarName = "D:\\ImageForAutoTests\\Questions\\Options\\Option" + (i + 1) + ".jpg";
            List<WebElement> imageIcon = driver.findElements(selectorFieldImage);
            imageIcon.get(imageIcon.size() - 1).sendKeys(imageQuestionVarName);
            Thread.sleep(2000);
            driver.findElement(By.id(idAnswer)).sendKeys(nameVar);
        }
        Thread.sleep(2000);
        questionSomeVarVariants = driver.findElements(xpathCreatedSurveySomeVarVariants);       //Получение списка вариантов
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Some Variant");

        for (int i = 0; i < questionSomeVarVariants.size(); i++) {                   //Получение списка наименований вариантов
            questionSomeVarVariantsNames.add(questionSomeVarVariants.get(i).getAttribute("value"));
        }
    }

    public void qestionDropDown() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDropDownAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDropDownName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDropDownDescription);
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDropDownA);
        Thread.sleep(2000);
        for (int i = 0; i < nmbDropDown; i++) {
            String nameVar = "Вариант " + (i + 1);
            String idAnswer = "answer-" + i;
            driver.findElement(xpathButtonAddAnswer).click();
            Thread.sleep(2000);
            driver.findElement(By.id(idAnswer)).sendKeys(nameVar);
        }
        Thread.sleep(2000);
        questionDropDownVariants = driver.findElements(xpathCreatedSurveyDropDownVariants);       //Получение списка вариантов
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Drop Down");

        for (int i = 0; i < questionDropDownVariants.size(); i++) {                      //Получение списка наименований вариантов
            questionDropDownVariantsNames.add(questionDropDownVariants.get(i).getAttribute("value"));
        }
    }

    public void qestionScale() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathScaleAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionScaleName);
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionScaleA);
        Thread.sleep(2000);
        if (rndScale == 1) {
            questionScaleDescription = questionScaleDescription + 5;
        } else {
            driver.findElement(selectorSelectValidationType).click();
            driver.findElement(xpathScale10).click();
            questionScaleDescription = questionScaleDescription + 10;
        }
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionScaleDescription);
        Thread.sleep(2000);
        scaleCount = driver.findElement(xpathCreatedSurveyScaleCount).getText();
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Scale");
    }

    public void qestionDownloadFilesJPEG() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadJPEGName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadJPEGDescription);
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathDownloadFilesJPEG).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesJPEG));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadJPEGA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - JPEG");
    }

    public void qestionDownloadFilesPNG() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadPNGName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadPNGDescription);
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathDownloadFilesPNG).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadPNGA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - PNG");
    }

    public void qestionDownloadFilesPDF() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadPDFName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadPDFDescription);
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathDownloadFilesPDF).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadPDFA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - PDF");
    }

    public void qestionDownloadFilesDOC() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadDOCName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadDOCDescription);
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathDownloadFilesDOC).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesDOC));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadDOCA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - DOC");
    }

    public void qestionDownloadFilesXLS() throws InterruptedException {

        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadXLSName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadXLSDescription);
        driver.findElement(selectorSelectValidationType).click();
        driver.findElement(xpathDownloadFilesXLS).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesXLS));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadXLSA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - XLS");
    }

    public void qestionDownloadFilesALL() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionDownloadALLName);
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionDownloadALLDescription);
        driver.findElement(selectorSelectValidationType).click();
        Thread.sleep(1000);
        driver.findElement(xpathDownloadFilesJPEG).click();
        driver.findElement(xpathDownloadFilesPNG).click();
        driver.findElement(xpathDownloadFilesPDF).click();
        driver.findElement(xpathDownloadFilesDOC).click();
        driver.findElement(xpathDownloadFilesXLS).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesALL));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadALLA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Download Files - ALL");
    }

    public void qestionText() throws InterruptedException {
        driver.findElement(xpathButtonAddQuestion).click();
        Thread.sleep(1000);
        driver.findElement(selectorSelectTypeQuestion).click();
        Thread.sleep(1000);
        driver.findElement(xpathTextAnswer).click();
        driver.findElement(selectorFieldQuestion).sendKeys(questionTextName.repeat(10));
        driver.findElement(selectorFieldQuestionDescription).sendKeys(questionTextDescription);
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionTextA);
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Create qestion Text");
    }

    public void createInterview() throws InterruptedException {
        openInterviewCard();                 // Открываем Карточку опроса
        Thread.sleep(2000);
        tabPropertiesInterviewCard();           //Заполняем вкладку "Свойства"
        Thread.sleep(2000);
        tabConstructorInterviewCard();          //Заполняем вкладку "Конструктор"
        Thread.sleep(2000);
        qestionShortAnswerNumber();          //Создаем вопрос "Короткий ответ" - Числовая форма
        Thread.sleep(2000);
        qestionShortAnswerDouble();          //Создаем вопрос "Короткий ответ" - Дробные числа
        Thread.sleep(2000);
        qestionShortAnswerPhone();           //Создаем вопрос "Короткий ответ" - Формат телефона
        Thread.sleep(2000);
        qestionShortAnswerSymbol();          //Создаем вопрос "Короткий ответ" - Кириллические символы
        Thread.sleep(2000);
        qestionShortAnswerNoValid();         //Создаем вопрос "Короткий ответ" - Без валидации
        Thread.sleep(2000);
        qestionLongAnswer();                 //Создаем вопрос "Длинный ответ"
        Thread.sleep(2000);
        qestionOneVar();                     //Создаем вопрос "Один вариант"
        Thread.sleep(2000);
        qestionSomeVar();                    //Создаем вопрос "Несколько вариантов"
        Thread.sleep(2000);
        qestionDropDown();                   //Создаем вопрос "Выпадающий список"
        Thread.sleep(2000);
        qestionScale();                      //Создаем вопрос "Шкала"
        Thread.sleep(2000);
        qestionDownloadFilesJPEG();          //Создаем вопрос "Загрузка файла" - JPEG
        Thread.sleep(2000);
        qestionDownloadFilesPNG();           //Создаем вопрос "Загрузка файла" - PNG
        Thread.sleep(2000);
        qestionDownloadFilesPDF();           //Создаем вопрос "Загрузка файла" - PDF
        Thread.sleep(2000);
        qestionDownloadFilesDOC();           //Создаем вопрос "Загрузка файла" - DOC
        Thread.sleep(2000);
        qestionDownloadFilesXLS();           //Создаем вопрос "Загрузка файла" - XLS
        Thread.sleep(2000);
        qestionDownloadFilesALL();           //Создаем вопрос "Загрузка файла" - Все типы
        Thread.sleep(1000);
        qestionText();                       //Создаем вопрос "Текс"
        Thread.sleep(2000);
        driver.findElement(xpathButtonSave).click();
        System.out.println("Create Interview");
    }

    public void getSurveyId() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpathCreatedSurveyId)));
        String tempSurvey = driver.findElement(xpathCreatedSurveyId).getText();
        surveyId = tempSurvey.substring(4, tempSurvey.length());
        System.out.println("ID созданного опроса: " + surveyId);
    }

    public void publicInterview() throws InterruptedException {
        createInterview();                 // Создаем Опрос
        Thread.sleep(2000);
        getSurveyId();
        driver.findElement(xpathButtonPublic).click();
        Thread.sleep(2000);
        driver.findElement(xpathButtonSaveInWindow).click();
        System.out.println("Public Interview");
    }
}
