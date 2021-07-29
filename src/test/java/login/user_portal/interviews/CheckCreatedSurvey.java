package login.user_portal.interviews;

import login.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Collections.*;
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

    public void findCreatedSurvey() {
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
    }


    public void surveyMainAttributesAssert() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveyElements));
        String openedSurveyHeading = driver.findElement(xpathOpenedSurveyHeading).getText();
        Assert.assertEquals("Не совпадает заголовок в открытом опросе", interviewHeading, openedSurveyHeading);

        String openedSurveyDescription = driver.findElement(xpathOpenedSurveyDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание в открытом опросе", interviewDescription, openedSurveyDescription);
    }

    //Вопрос "Короткий ответ" - Числовая форма
    public void surveyShortAnswerNumberAssert() {
        String openedSurveyShortAnswerNumberNameNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом (числовая форма) в открытом опроснике", questionShortNumberName, openedSurveyShortAnswerNumberNameNow);

        String openedSurveyShortAnswerNumberDescriptionNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (числовая форма) в открытом опроснике", questionShortNumberDescription, openedSurveyShortAnswerNumberDescriptionNow);
    }

    //Вопрос "Короткий ответ" - Дробные числа
    public void surveyShortAnswerDoubleAssert() {
        String openedSurveyShortAnswerDoubleNameNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом (дробные числа) в открытом опроснике", questionShortDoubleName, openedSurveyShortAnswerDoubleNameNow);

        String openedSurveyShortAnswerDoubleDescriptionNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (дробные числа) в открытом опроснике", questionShortDoubleDescription, openedSurveyShortAnswerDoubleDescriptionNow);
    }

    //Вопрос "Короткий ответ" - Формат телефона
    public void surveyShortAnswerPhoneAssert() {
        String openedSurveyShortAnswerPhoneNameNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом (формат телефона) в открытом опроснике", questionShortPhoneName, openedSurveyShortAnswerPhoneNameNow);

        String openedSurveyShortAnswerPhoneDescriptionNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (формат телефона) в открытом опроснике", questionShortPhoneDescription, openedSurveyShortAnswerPhoneDescriptionNow);
    }

    //Вопрос "Короткий ответ" - Кириллические символы
    public void surveyShortAnswerSymbolAssert() {
        String openedSurveyShortAnswerSymbolNameNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом (кириллические символы) в открытом опроснике", questionShortSymbolName, openedSurveyShortAnswerSymbolNameNow);

        String openedSurveyShortAnswerSymbolDescriptionNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (кириллические символы) в открытом опроснике", questionShortSymbolDescription, openedSurveyShortAnswerSymbolDescriptionNow);
    }

    //Вопрос "Короткий ответ" - Без валидации
    public void surveyShortAnswerNoValidAssert() {
        String openedSurveyShortAnswerNoValidNameNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с коротким ответом (без валидации) в открытом опроснике", questionShortNoValidName, openedSurveyShortAnswerNoValidNameNow);

        String openedSurveyShortAnswerNoValidDescriptionNow = driver.findElement(xpathOpenedSurveyShortAnswerNumberDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с коротким ответом (без валидации) в открытом опроснике", questionShortNoValidDescription, openedSurveyShortAnswerNoValidDescriptionNow);
    }

    //Вопрос "Длинный ответ"
    public void surveyLongAnswerAssert() {
        String openedSurveyLongAnswerNameNow = driver.findElement(xpathOpenedSurveyLongAnswerName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с длинным в открытом опроснике", questionLongName, openedSurveyLongAnswerNameNow);

        String openedSurveyLongAnswerDescriptionNow = driver.findElement(xpathOpenedSurveyLongAnswerDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с длинным ответом в открытом опроснике", questionLongDescription, openedSurveyLongAnswerDescriptionNow);
    }

    //Вопрос "Один вариант ответа"
    public void surveyOneVarAssert() {
        String openedSurveyOneVarNameNow = driver.findElement(xpathOpenedSurveyOneVarName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с одним вариантом ответа в открытом опроснике", questionOneVarName, openedSurveyOneVarNameNow);

        String openedSurveyOneVarDescriptionNow = driver.findElement(xpathOpenedSurveyOneVarDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с одним вариантом ответа в открытом опроснике", questionOneVarDescription, openedSurveyOneVarDescriptionNow);

        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveyOneVarVariants));
        surveyOneVarVariants = driver.findElements(xpathOpenedSurveyOneVarVariants);

        for (int i = 0; i < surveyOneVarVariants.size(); i++) {
            Assert.assertEquals("Не совпадает вариант ответа в вопросе с одним вариантом ответа", questionOneVarVariantsNames.get(i), surveyOneVarVariants.get(i).getText());
        }
    }

    //Вопрос "Несколько вариантов ответа"
    public void surveySomeVarAssert() {
        String openedSurveySomeVarNameNow = driver.findElement(xpathOpenedSurveySomeVarName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с несколькими вариантами ответа в открытом опроснике", questionSomeVarName, openedSurveySomeVarNameNow);

        String openedSurveySomeVarDescriptionNow = driver.findElement(xpathOpenedSurveySomeVarDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с несколькими вариантами ответа в открытом опроснике", questionSomeVarDescription, openedSurveySomeVarDescriptionNow);

        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveySomeVarVariants));
        surveySomeVarVariants = driver.findElements(xpathOpenedSurveySomeVarVariants);

        for (int i = 0; i < surveySomeVarVariants.size(); i++) {
            Assert.assertEquals("Не совпадает вариант ответа в вопросе с несколькими вариантами ответа", questionSomeVarVariantsNames.get(i), surveySomeVarVariants.get(i).getText());
        }
    }

    //Вопрос "Выпадающий список"
    public void surveyDropDownAssert() {
        String openedSurveyDropDownNameNow = driver.findElement(xpathOpenedSurveyDropDownName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса с выпадающим списком в открытом опроснике", questionDropDownName, openedSurveyDropDownNameNow);

        String openedSurveyDropDownDescription = driver.findElement(xpathOpenedSurveyDropDownDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса с выпадающим список в открытом опроснике", questionDropDownDescription, openedSurveyDropDownDescription);

        wait.until(ExpectedConditions.elementToBeClickable(xpathOpenedSurveyShowDropDown));
        driver.findElement(xpathOpenedSurveyShowDropDown).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(xpathOpenedSurveyDropDownVariants));
        surveyDropDownVariants = driver.findElements(xpathOpenedSurveyDropDownVariants);

        for (int i = 0; i < surveyDropDownVariants.size(); i++) {
            Assert.assertEquals("Не совпадает вариант ответа в вопросе с выпадающим списком", questionDropDownVariantsNames.get(i), surveyDropDownVariants.get(i).getText());
        }
    }

    //Вопрос "Шкала"
    public void surveyScaleAssert() {
        String openedSurveyScaleAnswerNameNow = driver.findElement(xpathOpenedSurveyScaleName).getText();
        Assert.assertEquals("Не совпадает наименование вопроса 'Шкала' открытом опроснике", questionScaleName, openedSurveyScaleAnswerNameNow);

        String openedSurveyScaleAnswerDescriptionNow = driver.findElement(xpathOpenedSurveyScaleDescription).getText();
        Assert.assertEquals("Не совпадает краткое описание вопроса 'Шкала' в открытом опроснике", questionScaleDescription, openedSurveyScaleAnswerDescriptionNow);

        surveyScaleStars = driver.findElements(xpathOpenedSurveyScaleStar);
        String openedSurveyStarsCount = String.valueOf(surveyScaleStars.size());
        Assert.assertEquals("Не совпадает количество шкал в вопросе 'Шкала'", scaleCount, openedSurveyStarsCount);
    }

    //Вопрос "Загрузка файла" – JPEG
    public void surveyDownloadJPEGAssert() {
        String openedSurveyDownloadJPEGName = driver.findElement(xpathOpenedSurveyDownloadJPEGName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка JPEG' в открытом опроснике", questionDownloadJPEGName, openedSurveyDownloadJPEGName);

        String openedSurveyDownloadPNGDescription = driver.findElement(xpathOpenedSurveyDownloadJPEGDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка JPEG' в открытом опроснике", questionDownloadJPEGDescription, openedSurveyDownloadPNGDescription);
    }

    //Вопрос "Загрузка файла" – PNG
    public void surveyDownloadPNGAssert() {
        String openedSurveyDownloadPNGName = driver.findElement(xpathOpenedSurveyDownloadPNGName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка PNG' в открытом опроснике", questionDownloadPNGName, openedSurveyDownloadPNGName);

        String openedSurveyDownloadPNGDescription = driver.findElement(xpathOpenedSurveyDownloadPNGDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка PNG' в открытом опроснике", questionDownloadPNGDescription, openedSurveyDownloadPNGDescription);
    }

    //Вопрос "Загрузка файла" – PDF
    public void surveyDownloadPDFAssert() {
        String openedSurveyDownloadPDFName = driver.findElement(xpathOpenedSurveyDownloadPDFName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка PDF' в открытом опроснике", questionDownloadPDFName, openedSurveyDownloadPDFName);

        String openedSurveyDownloadPDFDescription = driver.findElement(xpathOpenedSurveyDownloadPDFDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка PDF' в открытом опроснике", questionDownloadPDFDescription, openedSurveyDownloadPDFDescription);
    }

    //Вопрос "Загрузка файла" – DOC
    public void surveyDownloadDOCAssert() {
        String openedSurveyDownloadDOCName = driver.findElement(xpathOpenedSurveyDownloadDOCName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка DOC' в открытом опроснике", questionDownloadDOCName, openedSurveyDownloadDOCName);

        String openedSurveyDownloadDOCDescription = driver.findElement(xpathOpenedSurveyDownloadDOCDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка DOC' в открытом опроснике", questionDownloadDOCDescription, openedSurveyDownloadDOCDescription);
    }

    //Вопрос "Загрузка файла" – XLS
    public void surveyDownloadXLSAssert() {
        String openedSurveyDownloadXLSName = driver.findElement(xpathOpenedSurveyDownloadXLSName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка XLS' в открытом опроснике", questionDownloadXLSName, openedSurveyDownloadXLSName);

        String openedSurveyDownloadXLSDescription = driver.findElement(xpathOpenedSurveyDownloadXLSDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка XLS' в открытом опроснике", questionDownloadXLSDescription, openedSurveyDownloadXLSDescription);
    }

    //Вопрос "Загрузка файла" – Все файлы
    public void surveyDownloadALLAssert() {
        String openedSurveyDownloadAllName = driver.findElement(xpathOpenedSurveyDownloadALLName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка всех файлов' в открытом опроснике", questionDownloadALLName, openedSurveyDownloadAllName);

        String openedSurveyDownloadAllDescription = driver.findElement(xpathOpenedSurveyDownloadALLDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Загрузка всех файлов' в открытом опроснике", questionDownloadALLDescription, openedSurveyDownloadAllDescription);
    }

    //Вопрос "Текст"
    public void surveyTextAssert() {
        /*String openedSurveyTextName = driver.findElement(xpathOpenedSurveyTextName).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Текст' в открытом опроснике", questionTextName, openedSurveyTextName);*/

        String openedSurveyTextDescription = driver.findElement(xpathOpenedSurveyTextDescription).getText();
        Assert.assertEquals("Не совпадет наименование вопроса 'Текст' в открытом опроснике", questionTextDescription, openedSurveyTextDescription);
    }
}

