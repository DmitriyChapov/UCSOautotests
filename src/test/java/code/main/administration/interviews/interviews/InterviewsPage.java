package code.main.administration.interviews.interviews;

import code.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Collections.*;
import static variables.admin.Numbers.*;
import static variables.admin.Urls.*;
import static variables.admin.Xpath.*;
import static variables.admin.Selector.*;
import static variables.admin.Strings.*;
import static variables.admin.FilesForAdd.*;
import static variables.admin.Xpath.xpathQuestionName;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewsPage extends Login {

    public void sectionContentInterview() {
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathInterviews);
        actionChange.moveToElement(sectionAdmin);
        actionChange.moveToElement(subsectionContent).click();
        actionChange.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingInterviewsPage));
        String interviewsUrlNow = driver.getCurrentUrl();
        String interviewsPageNameNow = driver.findElement(headingInterviewsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Опросы'",
                interviewsUrl, interviewsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Опросы'", interviewPageName, interviewsPageNameNow);
        System.out.println("Go to section: Interviews");
    }

    public void openInterviewCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingInterviewsPage));
        driver.findElement(xpathButtonAdd).click();
        String interviewCardUrlNow = driver.getCurrentUrl();
        String interviewCardPageNameNow = driver.findElement(headingContentCard).getText();
        Assert.assertEquals("Некорректный Url страницы 'Карточка опроса'",
                interviewCardUrl, interviewCardUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Карточка опроса'",
                interviewCardPageName, interviewCardPageNameNow);
        System.out.println("Open Interview Card");
    }

    public void tabPropertiesInterviewCard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentCard));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        dateAndTime(); // Создаем текущую дату и время
        driver.findElement(xpathPortal).click();
        contentPortalAvailable = driver.findElement(xpathPortal).isSelected();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathMobile));
        driver.findElement(xpathMobile).click();
        contentMobileAvailable = driver.findElement(xpathMobile).isSelected();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectInterviewResults));
        driver.findElement(selectorSelectInterviewResults).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathResultInRealTime));
        driver.findElement(xpathResultInRealTime).click();
        interviewResultsType = driver.findElement(selectorSelectInterviewResults).getText();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectInterviewAccess));
        driver.findElement(selectorSelectInterviewAccess).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathAccessAll));
        driver.findElement(xpathAccessAll).click();
        interviewAccess = driver.findElement(selectorSelectInterviewAccess).getText();
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForContent));
        driver.findElement(xpathLocationForContent).click();
        contentLocationAvailable = driver.findElement(xpathLocationForContent).isSelected();
    }

    public void tabConstructorInterviewCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabConstructor));
        driver.findElement(xpathTabConstructor).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldInterviewHeading));
        driver.findElement(selectorFieldInterviewHeading).sendKeys(interviewHeading);
    }

    public void questionShortAnswerNumber() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathShortAnswer));
        driver.findElement(xpathShortAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathValidationTypeNumber));
        driver.findElement(xpathValidationTypeNumber).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAnswerMaxLength));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionShortNumberName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionShortNumberComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortNumber));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortNumber);
        waitingSpinner();
        addQuestionAttributesInArr(); // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else { interviewDescription = interviewDescription + "Короткий ответ; "; }
        System.out.println("Question successfully Added: Short Answer - Number");
    }

    public void questionShortAnswerDouble() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathShortAnswer));
        driver.findElement(xpathShortAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathValidationTypeDouble));
        driver.findElement(xpathValidationTypeDouble).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAnswerMaxLength));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionShortDoubleName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionShortDoubleComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortDouble));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortDouble);
        waitingSpinner();
        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else { interviewDescription = interviewDescription + "Короткий ответ; "; }
        System.out.println("Question successfully Added: Short Answer - Double");
    }

    public void questionShortAnswerPhone() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathShortAnswer));
        driver.findElement(xpathShortAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathValidationTypePhone));
        driver.findElement(xpathValidationTypePhone).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionShortPhoneName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionShortPhoneComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortPhone);
        waitingSpinner();
        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else { interviewDescription = interviewDescription + "Короткий ответ; "; }
        System.out.println("Question successfully Added: Short Answer - Phone");
    }

    public void questionShortAnswerSymbol() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathShortAnswer));
        driver.findElement(xpathShortAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathValidationTypeSymbol));
        driver.findElement(xpathValidationTypeSymbol).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAnswerMaxLength));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionShortSymbolName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionShortSymbolComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortSymbol));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortSymbol);
        waitingSpinner();
        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else { interviewDescription = interviewDescription + "Короткий ответ; "; }
        System.out.println("Question successfully Added: Short Answer - Symbol");
    }

    public void questionShortAnswerNoValid() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathShortAnswer));
        driver.findElement(xpathShortAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAnswerMaxLength));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionShortNoValidName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionShortNoValidComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolShortNoValid));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionShortNoValid);
        waitingSpinner();
        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else { interviewDescription = interviewDescription + "Короткий ответ; "; }
        System.out.println("Question successfully Added: Short Answer - No valid");
    }

    public void questionLongAnswer() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathLongAnswer));
        driver.findElement(xpathLongAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldAnswerMaxLength));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionLongName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionLongComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldAnswerMaxLength).sendKeys(String.valueOf(maxSymbolLong));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionLong);
        waitingSpinner();
        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Длинный ответ; ")) {
        } else { interviewDescription = interviewDescription + "Длинный ответ; "; }
        System.out.println("Question successfully Added: Long Answer");
    }

    public void questionOneVar() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathOneVarAnswer));
        driver.findElement(xpathOneVarAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionOneVarName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionOneVarComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        for (int i = 0; i < nmbOneVar; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
            driver.findElement(xpathButtonAddAnswer).click();
            List<WebElement> imageIcon = driver.findElements(selectorFieldImage);
            imageIcon.get(imageIcon.size() - 1).sendKeys(imageQuestionVarName(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(idAnswer(i)));
            driver.findElement(idAnswer(i)).sendKeys(nameVar(i));
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));

        questionOneVarVariants = driver.findElements(xpathInterviewQuestionVariantName);
        for (int i = 0; i < questionOneVarVariants.size(); i++) {
            questionOneVarVariantsNames.add(questionOneVarVariants.get(i).getAttribute("value"));
        }

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Один вариант; ")) {
        } else { interviewDescription = interviewDescription + "Один вариант; "; }
        System.out.println("Question successfully Added: One Variant");
    }

    public void questionSomeVar() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathSomeVarAnswer));
        driver.findElement(xpathSomeVarAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionSomeVarName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionSomeVarComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        for (int i = 0; i < nmbSomeVar; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
            driver.findElement(xpathButtonAddAnswer).click();
            List<WebElement> imageIcon = driver.findElements(selectorFieldImage);
            imageIcon.get(imageIcon.size() - 1).sendKeys(imageQuestionVarName(i));
            waitingSpinner();
            wait.until(ExpectedConditions.elementToBeClickable(idAnswer(i)));
            driver.findElement(idAnswer(i)).sendKeys(nameVar(i));
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));

        questionSomeVarVariants = driver.findElements(xpathInterviewQuestionVariantName);
        for (int i = 0; i < questionSomeVarVariants.size(); i++) {
            questionSomeVarVariantsNames.add(questionSomeVarVariants.get(i).getAttribute("value"));
        }

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Несколько вариантов; ")) {
        } else { interviewDescription = interviewDescription + "Несколько вариантов; "; }
        System.out.println("Question successfully Added: Some Variant");
    }

    public void questionDropDown() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownAnswer));
        driver.findElement(xpathDropDownAnswer).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDropDownName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDropDownComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDropDown);
        waitingSpinner();
        for (int i = 0; i < nmbDropDown; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddAnswer));
            driver.findElement(xpathButtonAddAnswer).click();
            wait.until(ExpectedConditions.elementToBeClickable(idAnswer(i)));
            driver.findElement(idAnswer(i)).sendKeys(nameVar(i));
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));

        questionDropDownVariants = driver.findElements(xpathInterviewQuestionVariantName);
        for (int i = 0; i < questionDropDownVariants.size(); i++) {
            questionDropDownVariantsNames.add(questionDropDownVariants.get(i).getAttribute("value"));
        }

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Выпадающий список; ")) {
        } else { interviewDescription = interviewDescription + "Выпадающий список; "; }
        System.out.println("Question successfully Added: Drop Down");
    }

    public void questionScale() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathScaleAnswer));
        driver.findElement(xpathScaleAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionScaleName);
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionScale);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        if (rndScale == 1) {
            questionScaleComment = questionScaleComment + 5;
        } else {
            driver.findElement(selectorSelectValidationType).click();
            wait.until(ExpectedConditions.elementToBeClickable(xpathScale10));
            driver.findElement(xpathScale10).click();
            questionScaleComment = questionScaleComment + 10;
        }
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionScaleComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));

        scaleCount = driver.findElement(xpathCreatedSurveyScaleCount).getText();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Шкала; ")) {
        } else { interviewDescription = interviewDescription + "Шкала; "; }
        System.out.println("Question successfully Added: Scale");
    }

    public void questionDownloadFilesJPEG() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadJPEGName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadJPEGComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesJPEG));
        driver.findElement(xpathDownloadFilesJPEG).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesJPEG));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadJPEG);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - JPEG");
    }

    public void questionDownloadFilesPNG() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadPNGName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadPNGComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesPNG));
        driver.findElement(xpathDownloadFilesPNG).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadPNG);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - PNG");
    }

    public void questionDownloadFilesPDF() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadPDFName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadPDFComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesPDF));
        driver.findElement(xpathDownloadFilesPDF).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadPDF);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - PDF");
    }

    public void questionDownloadFilesDOC() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadDOCName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadDOCComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesDOC));
        driver.findElement(xpathDownloadFilesDOC).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesDOC));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadDOC);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - DOC");
    }

    public void questionDownloadFilesXLS() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadXLSName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadXLSComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesXLS));
        driver.findElement(xpathDownloadFilesXLS).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesXLS));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadXLS);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - XLS");
    }

    public void questionDownloadFilesALL() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesAnswer));
        driver.findElement(xpathDownloadFilesAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionDownloadALLName);
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionDownloadALLComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectValidationType));
        driver.findElement(selectorSelectValidationType).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesJPEG));
        driver.findElement(xpathDownloadFilesJPEG).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesPNG));
        driver.findElement(xpathDownloadFilesPNG).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesPDF));
        driver.findElement(xpathDownloadFilesPDF).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesDOC));
        driver.findElement(xpathDownloadFilesDOC).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathDownloadFilesXLS));
        driver.findElement(xpathDownloadFilesXLS).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[3]")).click();
        driver.findElement(selectorFieldAnswerMaxFiles).clear();
        driver.findElement(selectorFieldAnswerMaxFiles).sendKeys(String.valueOf(maxFilesALL));
        driver.findElement(selectorFieldImage).sendKeys(imageQuestionDownloadALL);
        waitingSpinner();

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else { interviewDescription = interviewDescription + "Загрузка файлов; "; }
        System.out.println("Question successfully Added: Download Files - ALL");
    }

    public void questionText() {
        actionChange.moveToElement(driver.findElement(xpathButtonAddQuestion)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAddQuestion));
        driver.findElement(xpathButtonAddQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectTypeQuestion));
        driver.findElement(selectorSelectTypeQuestion).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathTextAnswer));
        driver.findElement(xpathTextAnswer).click();
        driver.findElement(selectorFieldQuestionName).sendKeys(questionTextName.repeat(10));
        driver.findElement(selectorFieldQuestionComment).sendKeys(questionTextComment);

        questionComments.add(driver.findElement(selectorQuestionComment).getAttribute("value"));

        driver.findElement(selectorFieldImage).sendKeys(imageQuestionText);
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));

        addQuestionAttributesInArr();   // Добавляем атрибуты вопроса в массив
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Текст; ")) {
        } else { interviewDescription = interviewDescription + "Текст; "; }
        System.out.println("Question successfully Added: Text");
    }

    public void addQuestion(String typeQuestion){
        switch (typeQuestion){
            case "All":{
                questionShortAnswerNumber();          //Создаем вопрос "Короткий ответ" - Числовая форма
                questionShortAnswerDouble();          //Создаем вопрос "Короткий ответ" - Дробные числа
                questionShortAnswerPhone();           //Создаем вопрос "Короткий ответ" - Формат телефона
                questionShortAnswerSymbol();          //Создаем вопрос "Короткий ответ" - Кириллические символы
                questionShortAnswerNoValid();         //Создаем вопрос "Короткий ответ" - Без валидации
                questionLongAnswer();                 //Создаем вопрос "Длинный ответ"
                questionOneVar();                     //Создаем вопрос "Один вариант"
                questionSomeVar();                    //Создаем вопрос "Несколько вариантов"
                questionDropDown();                   //Создаем вопрос "Выпадающий список"
                questionScale();                      //Создаем вопрос "Шкала"
                questionDownloadFilesJPEG();          //Создаем вопрос "Загрузка файла" - JPEG
                questionDownloadFilesPNG();           //Создаем вопрос "Загрузка файла" - PNG
                questionDownloadFilesPDF();           //Создаем вопрос "Загрузка файла" - PDF
                questionDownloadFilesDOC();           //Создаем вопрос "Загрузка файла" - DOC
                questionDownloadFilesXLS();           //Создаем вопрос "Загрузка файла" - XLS
                questionDownloadFilesALL();           //Создаем вопрос "Загрузка файла" - Все типы
                questionText();                       //Создаем вопрос "Текст"
                break;
            }
            case "ShortAnswerAll":{
                questionShortAnswerNumber();          //Создаем вопрос "Короткий ответ" - Числовая форма
                questionShortAnswerDouble();          //Создаем вопрос "Короткий ответ" - Дробные числа
                questionShortAnswerPhone();           //Создаем вопрос "Короткий ответ" - Формат телефона
                questionShortAnswerSymbol();          //Создаем вопрос "Короткий ответ" - Кириллические символы
                questionShortAnswerNoValid();         //Создаем вопрос "Короткий ответ" - Без валидации
                break;
            }
            case "ShortAnswerNumber":{
                questionShortAnswerNumber();          //Создаем вопрос "Короткий ответ" - Числовая форма
                break;
            }
            case "ShortAnswerDouble":{
                questionShortAnswerDouble();          //Создаем вопрос "Короткий ответ" - Дробные числа
                break;
            }
            case "ShortAnswerPhone":{
                questionShortAnswerPhone();           //Создаем вопрос "Короткий ответ" - Формат телефона
                break;
            }
            case "ShortAnswerSymbol":{
                questionShortAnswerSymbol();          //Создаем вопрос "Короткий ответ" - Кириллические символы
                break;
            }
            case "ShortAnswerNoValid":{
                questionShortAnswerNoValid();         //Создаем вопрос "Короткий ответ" - Без валидации
                break;
            }
            case "LongAnswer": {
                questionLongAnswer();                 //Создаем вопрос "Длинный ответ"
                break;
            }
            case "OneVar": {
                questionOneVar();                     //Создаем вопрос "Один вариант"
                break;
            }
            case "SomeVar":{
                questionSomeVar();                    //Создаем вопрос "Несколько вариантов"
                break;
            }
            case "DropDown": {
                questionDropDown();                   //Создаем вопрос "Выпадающий список"
                break;
            }
            case "Scale":{
                questionScale();                      //Создаем вопрос "Шкала"
                break;
            }
            case "DownloadFilesJPEG":{
                questionDownloadFilesJPEG();          //Создаем вопрос "Загрузка файла" - JPEG
                break;
            }
            case "DownloadFilesPNG":{
                questionDownloadFilesPNG();           //Создаем вопрос "Загрузка файла" - PNG
                break;
            }
            case "DownloadFilesPDF":{
                questionDownloadFilesPDF();           //Создаем вопрос "Загрузка файла" - PDF
                break;
            }
            case "DownloadFilesDOC":{
                questionDownloadFilesDOC();           //Создаем вопрос "Загрузка файла" - DOC
                break;
            }
            case "DownloadFilesXLS":{
                questionDownloadFilesXLS();           //Создаем вопрос "Загрузка файла" - XLS
            }
            case "DownloadFilesAll":{
                questionDownloadFilesALL();           //Создаем вопрос "Загрузка файла" - Все типы
                break;
            }
            case "Text":{
                questionText();                       //Создаем вопрос "Текст"
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
    }

    public void createInterview(String typeQuestion) {
        tabPropertiesInterviewCard();         // Заполняем вкладку "Свойства"
        tabConstructorInterviewCard();        // Заполняем вкладку "Конструктор"
        addQuestion(typeQuestion);            // Добавляем вопросы
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldInterviewDescription));
        driver.findElement(selectorFieldInterviewDescription).sendKeys(interviewDescription);
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        contentCreationDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;;
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationInterviewCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Опроса",
                interviewCardSaveNotification, textNotificationInterviewCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        contentCreationDateInCard = driver.findElement(selectorInterviewCreationDate).getText();
        Assert.assertEquals("Некорректная дата создания Опроса после сохранения",
                contentCreationDate, contentCreationDateInCard);
        String stateInterviewNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Опроса после создания",
                stateCreate.toUpperCase(), stateInterviewNow);
        System.out.println("Interview successfully Created");
    }

    public void getInterviewID() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathInterviewId));
        String tempInterview = driver.findElement(xpathInterviewId).getText();
        interviewId = tempInterview.substring(4);
    }

    public void publicInterview() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationInterviewCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при публикации Опроса",
                interviewCardPublicNotification, textNotificationInterviewCardSaveNow);
        String stateInterviewNow = driver.findElement(xpathContentCardState).getText();
        Assert.assertEquals("Некорректный статус Опроса после публикации",
                statePublic.toUpperCase(), stateInterviewNow);
        System.out.println("Interview ID: " + interviewId + " successfully Published");
    }

    public void getAllQuestions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathQuestionType));
        countQuestions = driver.findElements(xpathInterviewQuestions).size();
        questionTypesWeb = driver.findElements(xpathQuestionType);
        questionNamesWeb = driver.findElements(xpathQuestionName);
        //Получение названия и типа вопроса
        for (int i = 0; i < questionNamesWeb.size(); i++) {
            questionNames.add(questionNamesWeb.get(i).getText());
            questionTypes.add(questionTypesWeb.get(i).getText());
        }
    }

    public void checkInterviewBlock(String Status) {
        ((JavascriptExecutor) driver).executeScript("scroll(0,-1500);");
        wait.until(ExpectedConditions.elementToBeClickable(xpathInterviews2));
        driver.findElement(xpathInterviews2).click();
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(selectorInterviewsChangeStyle));
        driver.findElement(selectorInterviewsChangeStyle).click();
        waitingSpinner();
        driver.findElement(selectorFieldSearch).sendKeys(interviewHeading);
        waitingSpinner();
        interviewsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < interviewsList.size(); i++) {
            String interviewNameSearch = interviewsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (interviewNameSearch.equals(interviewHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(interviewsList.get(i).findElement(xpathIconEdit)));
                checkingInterviewBlock(i,Status);
                System.out.println("Interview ID: " + interviewId + " in Section 'Interviews - Administration' has been successfully Verified");
                interviewsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Interview Card for Check");
                break;
            }
        }
    }

    public void checkingInterviewBlock(int i, String Status) {
        String stateText2 = "0", date = "0", state = "0";
        switch (Status){
            case "Create": {
                state = stateCreate;
                date = contentCreationDate;
                stateText2 = "создания";
                break;
            }
            case "Delete": {
                stateText2 = "удаления";
                date = contentDeleteDate;
                state = stateDelete;
                break;
            }
            case "Public": {
                stateText2 = "создания";
                date = contentCreationDate;
                state = statePublic;
                break;
            }
            case "UnPublic": {
                stateText2 = "снятия с публикации";
                date = contentUnPublicDate;
                state = stateUnPublic;
                break;
            }
        }
        String interviewIDBlock = interviewsList.get(i).findElement(xpathContentIDInBlocks).getText();
        Assert.assertEquals("Некорректный ID Опроса в общем списке Опросов",
                interviewId, interviewIDBlock.substring(interviewIDBlock.length()-4));
        String interviewStateBlock = interviewsList.get(i).findElement(xpathContentStateInBlocks).getText();
        interviewStateBlock = interviewStateBlock.substring(0,interviewStateBlock.indexOf('\n'));
        Assert.assertEquals("Некорректный статус Опроса в общем списке Опросов",
                state.toUpperCase(), interviewStateBlock);
        String interviewCreationDateBlock = interviewsList.get(i).findElement(xpathInterviewCreationDateInBlocks).getText();
        Assert.assertEquals("Некорректная дата " + stateText2 + " Опроса в общем списке Опросов",
                date, interviewCreationDateBlock);
        String interviewHeadingBlock = interviewsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
        Assert.assertEquals("Некорректный заголовок Опроса в общем списке Опросов",
                interviewHeading, interviewHeadingBlock);
    }

    public void checkInterviewCard(String state){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingContentCard));
        datepicker = driver.findElements(dateFields);
        timepicker = driver.findElements(timeFields);
        String interviewIdForCheck = driver.findElement(xpathContentCardId).getText();
        String interviewStateForCheck = driver.findElement(xpathContentCardState).getText();
        boolean interviewPortalAvailableForCheck = driver.findElement(xpathPortal).isSelected();
        boolean interviewMobileAvailableForCheck = driver.findElement(xpathMobile).isSelected();
        String interviewPortalDateStartForCheck = datepicker.get(4).getAttribute("value");
        String interviewPortalTimeStartForCheck = timepicker.get(4).getAttribute("value");
        String interviewPortalDateFinishForCheck = datepicker.get(5).getAttribute("value");
        String interviewPortalTimeFinishForCheck = timepicker.get(5).getAttribute("value");
        String interviewMobileDateStartForCheck = datepicker.get(0).getAttribute("value");
        String interviewMobileTimeStartForCheck = timepicker.get(0).getAttribute("value");
        String interviewMobileDateFinishForCheck = datepicker.get(1).getAttribute("value");
        String interviewMobileTimeFinishForCheck = timepicker.get(1).getAttribute("value");
        String interviewResultsTypeForCheck = driver.findElement(selectorSelectInterviewResults).getText();
        String interviewAccessForCheck = driver.findElement(selectorSelectInterviewAccess).getText();
        boolean interviewLocationForCheck = driver.findElement(xpathLocationForContent).isSelected();
        Assert.assertEquals("Некорректный ID Опроса внутри карточки",
                interviewId, interviewIdForCheck.substring(interviewIdForCheck.length()-4));
        Assert.assertEquals("Некорректный статус Опроса внутри карточки",
                state.toUpperCase(), interviewStateForCheck);
        Assert.assertEquals("Изменился параметр доступности размещения Опроса на Портале",
                contentPortalAvailable, interviewPortalAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Опроса на Портале'",
                dateNow, interviewPortalDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Опроса на Портале'",
                timeNow, interviewPortalTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Опроса на Портале'",
                dateNow, interviewPortalDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Опроса на Портале'",
                "23:59", interviewPortalTimeFinishForCheck );
        Assert.assertEquals("Изменился параметр доступности размещения Опроса в Мобильном Приложении",
                contentMobileAvailable, interviewMobileAvailableForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Дата начала размещения Опроса в Мобильном Приложении'",
                dateNow, interviewMobileDateStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время начала размещения Опроса в Мобильном Приложении'",
                timeNow, interviewMobileTimeStartForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Дата окончания размещения Опроса в Мобильном Приложении'",
                dateNow, interviewMobileDateFinishForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Время окончания размещения Опроса в Мобильном Приложении'",
                "23:59", interviewMobileTimeFinishForCheck );
        Assert.assertEquals("Изменился параметр 'Тип публикации ответов' Опроса",
                interviewResultsType, interviewResultsTypeForCheck );
        Assert.assertEquals("Изменился параметр 'Доступности' Опроса",
                interviewAccess, interviewAccessForCheck );
        Assert.assertEquals("Изменился параметр доступности локации Опроса",
                contentLocationAvailable, interviewLocationForCheck);
        wait.until(ExpectedConditions.elementToBeClickable(xpathTabConstructor));
        driver.findElement(xpathTabConstructor).click();
        waitingSpinner();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class = 'mat-ripple-element']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldInterviewHeading));
        String interviewHeadingForCheck = driver.findElement(selectorFieldInterviewHeading).getAttribute("value");
        String interviewDescriptionForCheck = driver.findElement(selectorFieldInterviewDescription).getAttribute("value");
        String interviewCreationDateForCheck = driver.findElement(selectorInterviewCreationDate).getText();
        Assert.assertEquals("Некорректная дата создания Опроса в карточке Опроса",
                contentCreationDate, interviewCreationDateForCheck);
        Assert.assertEquals("Некорректно заполнено поле 'Заголовок' в карточке Опроса",
                interviewHeading, interviewHeadingForCheck );
        Assert.assertEquals("Некорректно заполнено поле 'Краткое описание' в карточке Опроса",
                interviewDescription, interviewDescriptionForCheck );
        checkQuestions();  // Проверяем каждый вопрос в Опросе
        System.out.println("Interview ID: " + interviewId + " Card has been successfully Verified");
    }

    public void checkQuestions(){
        questionsList = driver.findElements(xpathInterviewQuestions);
        int countQuestionsForCheck = questionsList.size();
        Assert.assertEquals("Некорректное кол-во 'Вопросов' в карточке Опроса",
                countQuestions, countQuestionsForCheck );
        for (int i=0; i < countQuestionsForCheck; i++ ){
            String questionNameForCheck = questionsList.get(i).findElement(xpathQuestionName).getText();
            String questionTypeForCheck = questionsList.get(i).findElement(xpathQuestionType).getText();
            Assert.assertEquals(("Не совпадает наименования " + (i+1) + " -го вопроса в списке вопросов"),
                    questionNames.get(i), questionNameForCheck );
            Assert.assertEquals(("Не совпадает Тип " + (i+1) + " -го вопроса  в списке вопросов"),
                    questionTypes.get(i), questionTypeForCheck );
            if (questionNameForCheck.equals(questionNames.get(i))) {
                wait.until(ExpectedConditions.elementToBeClickable(questionsList.get(i).findElement(xpathIconEdit)));
                questionsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Question № " + (i+1) + " for Check");
                checkingQuestion(i);  //Проверка атрибутов вопроса
                System.out.println("Question № " + (i+1) + " has been successfully Verified");
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
        System.out.println("All Questions has been successfully Verified");
    }

    public void checkingQuestion(int i) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldQuestionName));
        addQuestionAttributeInArrForCheck();
        Assert.assertEquals(("Некорректное 'Название вопроса' в вопросе № " + (i + 1)),
                questionNameArr.get(i), contentOfQuestionForCheck[0].get(0));
        Assert.assertEquals(("Некорректный 'Комментарий' в вопросе № " + (i + 1)),
                questionCommentArr.get(i), contentOfQuestionForCheck[1].get(0));
        Assert.assertEquals(("Некорректный 'Тип вопроса' в вопросе № " + (i + 1)),
                questionTypeArr.get(i), contentOfQuestionForCheck[2].get(0));
        Assert.assertEquals(("Некорректный 'Метод валидации' в вопросе № " + (i + 1)),
                questionValidationArr.get(i), contentOfQuestionForCheck[3].get(0));
        Assert.assertEquals(("Некорректное 'Максимальное кол-во символов в ответе' в вопросе № " + (i + 1)),
                questionMaxSymbolArr.get(i), contentOfQuestionForCheck[4].get(0));
        switch (questionTypeForCheck.get(0)) {
            case "Один вариант": {
                Assert.assertEquals(("Некорректное 'Кол-во Ответов' в вопросе № " + (i + 1)),
                        questionAnswerArr.get(i).size(), countVariantsForCheck);
                for (int j = 0; j < questionAnswerArr.get(i).size(); j++) {
                    String varNameForCheck = questionVariantsNameForCheck.get(j).getAttribute("value");
                    Assert.assertEquals(("Некорректное 'Наименование варианта ответа' в вопросе № " + (i + 1)),
                            questionAnswerArr.get(i).get(j), varNameForCheck);
                }
                break;
            }

            case "Несколько вариантов": {
                Assert.assertEquals(("Некорректное 'Кол-во Ответов' в вопросе № " + (i + 1)),
                        questionAnswerArr.get(i).size(), countVariantsForCheck);
                for (int j = 0; j < questionAnswerArr.get(i).size(); j++) {
                    String varNameForCheck = questionVariantsNameForCheck.get(j).getAttribute("value");
                    Assert.assertEquals(("Некорректное 'Наименование варианта ответа' в вопросе № " + (i + 1)),
                            questionAnswerArr.get(i).get(j), varNameForCheck);
                }
                break;
            }

            case "Выпадающий список": {
                Assert.assertEquals(("Некорректное 'Кол-во Ответов' в вопросе № " + (i + 1)),
                        questionAnswerArr.get(i).size(), countVariantsForCheck);
                for (int j = 0; j < questionAnswerArr.get(i).size(); j++) {
                    String varNameForCheck = questionVariantsNameForCheck.get(j).getAttribute("value");
                    Assert.assertEquals(("Некорректное 'Наименование варианта ответа' в вопросе № " + (i + 1)),
                            questionAnswerArr.get(i).get(j), varNameForCheck);
                }
                break;
            }
        }
            Assert.assertEquals(("Некорректное 'Кол-во делений' в вопросе № " + (i + 1)),
                    questionScaleArr.get(i), contentOfQuestionForCheck[6].get(0));
            Assert.assertEquals(("Некорректный 'Тип файла' в вопросе № " + (i + 1)),
                    questionFilesTypeArr.get(i), contentOfQuestionForCheck[7].get(0));
            Assert.assertEquals(("Некорректное 'Максимальное кол-во файлов' в вопросе № " + (i + 1)),
                    questionNmbFilesArr.get(i), contentOfQuestionForCheck[8].get(0));
            wait.until(ExpectedConditions.elementToBeClickable(selectorCloseWindow));
            driver.findElement(selectorCloseWindow).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
    }

    public void addQuestionAttributesInArr(){
        questionAllNames.clear();
        questionNameArr.add(driver.findElement(selectorFieldQuestionName).getAttribute("value"));
        questionCommentArr.add(driver.findElement(selectorQuestionComment).getAttribute("value"));
        questionTypeArr.add(driver.findElement(selectorSelectTypeQuestion).getText());
        contentOfQuestion[0] = questionNameArr;
        contentOfQuestion[1] = questionCommentArr;
        contentOfQuestion[2] = questionTypeArr;
        contentOfQuestion[3] = questionValidationArr;
        contentOfQuestion[4] = questionMaxSymbolArr;
        contentOfQuestion[5] = questionAnswerArr;
        contentOfQuestion[6] = questionScaleArr;
        contentOfQuestion[7] = questionFilesTypeArr;
        contentOfQuestion[8] = questionNmbFilesArr;
        switch (driver.findElement(selectorSelectTypeQuestion).getText()){
            case "Короткий ответ":{
                if ((driver.findElement(selectorSelectValidationType).getText()).equals("Формат телефона")){
                    questionValidationArr.add(driver.findElement(selectorSelectValidationType).getText());
                    questionMaxSymbolArr.add("Отсутствует");
                    questionAllNames.add("Отсутствует");
                    questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                    questionScaleArr.add("Отсутствует");
                    questionFilesTypeArr.add("Отсутствует");
                    questionNmbFilesArr.add("Отсутствует");
                }
                else{
                    questionValidationArr.add(driver.findElement(selectorSelectValidationType).getText());
                    questionMaxSymbolArr.add(driver.findElement(selectorFieldAnswerMaxLength).getAttribute("value"));;
                    questionAllNames.add("Отсутствует");
                    questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                    questionScaleArr.add("Отсутствует");
                    questionFilesTypeArr.add("Отсутствует");
                    questionNmbFilesArr.add("Отсутствует");
                }
                break;
            }

            case "Длинный ответ":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add(driver.findElement(selectorFieldAnswerMaxLength).getAttribute("value"));
                //questionAnswerArr.add(questionAllNames);
                questionAllNames.add("Отсутствует");
                questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }

            case "Один вариант":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionOneVarVariants = driver.findElements(xpathInterviewQuestionVariantName);
                for (int i = 0; i < questionOneVarVariants.size(); i++) {
                    questionAllNames.add(questionOneVarVariants.get(i).getAttribute("value"));
                }
                //questionAnswerArr.add(questionAllNames);
                questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }

            case "Несколько вариантов":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionSomeVarVariants = driver.findElements(xpathInterviewQuestionVariantName);
                for (int i = 0; i < questionSomeVarVariants.size(); i++) {
                    questionAllNames.add(questionSomeVarVariants.get(i).getAttribute("value"));
                }
                questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }

            case "Выпадающий список":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionDropDownVariants = driver.findElements(xpathInterviewQuestionVariantName);
                for (int i = 0; i < questionDropDownVariants.size(); i++) {
                    questionAllNames.add(questionDropDownVariants.get(i).getAttribute("value"));
                }
                questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }

            case "Шкала":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionAllNames.add("Отсутствует");
                questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionScaleArr.add(driver.findElement(selectorSelectValidationType).getText());
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }

            case "Загрузка файла":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionAllNames.add("Отсутствует");
                questionAnswerArr.add(questionAllNames);
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add(driver.findElement(selectorSelectValidationType).getText());
                questionNmbFilesArr.add(driver.findElement(selectorFieldAnswerMaxFiles).getAttribute("value"));
                break;
            }

            case "Текст":{
                questionValidationArr.add("Отсутствует");
                questionMaxSymbolArr.add("Отсутствует");
                questionAllNames.add("Отсутствует");
                //questionAnswerArr.add((ArrayList<String>) questionAllNames.clone());
                questionAnswerArr.add(questionAllNames);
                questionScaleArr.add("Отсутствует");
                questionFilesTypeArr.add("Отсутствует");
                questionNmbFilesArr.add("Отсутствует");
                break;
            }
        }
    }

    public void addQuestionAttributeInArrForCheck(){
        questionNameForCheck.clear();
        questionCommentForCheck.clear();
        questionTypeForCheck.clear();
        questionValidationForCheck.clear();
        questionMaxSymbolForCheck.clear();
        questionAnswerForCheck.clear();
        questionScaleForCheck.clear();
        questionFilesTypeForCheck.clear();
        questionNmbFilesForCheck.clear();
        questionNameForCheck.add(driver.findElement(selectorFieldQuestionName).getAttribute("value"));
        questionCommentForCheck.add(driver.findElement(selectorQuestionComment).getAttribute("value"));
        questionTypeForCheck.add(driver.findElement(selectorSelectTypeQuestion).getText());
        contentOfQuestionForCheck[0] = questionNameForCheck;
        contentOfQuestionForCheck[1] = questionCommentForCheck;
        contentOfQuestionForCheck[2] = questionTypeForCheck;
        contentOfQuestionForCheck[3] = questionValidationForCheck;
        contentOfQuestionForCheck[4] = questionMaxSymbolForCheck;
        contentOfQuestionForCheck[5] = questionAnswerForCheck;
        contentOfQuestionForCheck[6] = questionScaleForCheck;
        contentOfQuestionForCheck[7] = questionFilesTypeForCheck;
        contentOfQuestionForCheck[8] = questionNmbFilesForCheck;
        switch (driver.findElement(selectorSelectTypeQuestion).getText()) {
            case "Короткий ответ": {
                if ((driver.findElement(selectorSelectValidationType).getText()).equals("Формат телефона")) {
                    questionValidationForCheck.add(driver.findElement(selectorSelectValidationType).getText());
                    questionMaxSymbolForCheck.add("Отсутствует");
                    questionAnswerForCheck.add("Отсутствует");
                    questionScaleForCheck.add("Отсутствует");
                    questionFilesTypeForCheck.add("Отсутствует");
                    questionNmbFilesForCheck.add("Отсутствует");
                } else {
                    questionValidationForCheck.add(driver.findElement(selectorSelectValidationType).getText());
                    questionMaxSymbolForCheck.add(driver.findElement(selectorFieldAnswerMaxLength).getAttribute("value"));
                    questionAnswerForCheck.add("Отсутствует");
                    questionScaleForCheck.add("Отсутствует");
                    questionFilesTypeForCheck.add("Отсутствует");
                    questionNmbFilesForCheck.add("Отсутствует");
                }
                break;
            }

            case "Длинный ответ": {
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add(driver.findElement(selectorFieldAnswerMaxLength).getAttribute("value"));
                questionAnswerForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
            }

            case "Один вариант": {
                questionVariantsNameForCheck = driver.findElements(xpathInterviewQuestionVariantName);
                countVariantsForCheck = questionVariantsNameForCheck.size();
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
                for (int j = 0; j < countVariantsForCheck; j++) {
                    questionAnswerForCheck.add(questionVariantsNameForCheck.get(j).getAttribute("value"));
                }
                break;
            }

            case "Несколько вариантов": {
                questionVariantsNameForCheck = driver.findElements(xpathInterviewQuestionVariantName);
                countVariantsForCheck = questionVariantsNameForCheck.size();
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
                for (int j = 0; j < countVariantsForCheck; j++) {
                    questionAnswerForCheck.add(questionVariantsNameForCheck.get(j).getAttribute("value"));
                }
                break;
            }

            case "Выпадающий список": {
                questionVariantsNameForCheck = driver.findElements(xpathInterviewQuestionVariantName);
                countVariantsForCheck = questionVariantsNameForCheck.size();
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
                for (int j = 0; j < countVariantsForCheck; j++) {
                    questionAnswerForCheck.add(questionVariantsNameForCheck.get(j).getAttribute("value"));
                }
                break;
            }

            case "Шкала": {
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionAnswerForCheck.add("Отсутствует");
                questionScaleForCheck.add(driver.findElement(selectorSelectValidationType).getText());
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
                break;
            }

            case "Загрузка файла": {
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionAnswerForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add(driver.findElement(selectorSelectValidationType).getText());
                questionNmbFilesForCheck.add(driver.findElement(selectorFieldAnswerMaxFiles).getAttribute("value"));
                break;
            }

            case "Текст": {
                questionValidationForCheck.add("Отсутствует");
                questionMaxSymbolForCheck.add("Отсутствует");
                questionAnswerForCheck.add("Отсутствует");
                questionScaleForCheck.add("Отсутствует");
                questionFilesTypeForCheck.add("Отсутствует");
                questionNmbFilesForCheck.add("Отсутствует");
                break;
            }
        }
    }

    public void deleteInterview(){
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonDelete));
        driver.findElement(xpathButtonDelete).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentDeleteDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;;
        System.out.println("Interview ID: " + interviewId + " successfully Deleted");
    }

    public void checkModifiedInterviewBlock(String Status){
        String stateText1 = "0";
        switch (Status){
            case "Delete":
                stateText1 = "Удаленный";
                break;
            case "UnPublic":
                stateText1 = "Снятый с публикации";
                break;
        }
        waitingSpinner();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectorFieldSearch));
        driver.findElement(selectorFieldSearch).sendKeys(interviewHeading);
        waitingSpinner();
        interviewsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < interviewsList.size(); i++) {
            String interviewNameSearch = interviewsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (interviewNameSearch.equals(interviewHeading)) {
                Assert.assertNotEquals(stateText1 +" Опрос отображается в разделе 'Опросы'",
                        interviewHeading, interviewNameSearch);
            }
        }
        driver.findElement(xpathInterviewsArchive).click();
        waitingSpinner();
        wait.until(ExpectedConditions.elementToBeClickable(selectorInterviewsChangeStyle));
        driver.findElement(selectorInterviewsChangeStyle).click();
        waitingSpinner();
        driver.findElement(selectorFieldSearch).sendKeys(interviewHeading);
        waitingSpinner();
        interviewsList = driver.findElements(xpathListBlocks);
        for (int i = 0; i < interviewsList.size(); i++) {
            String interviewNameSearch = interviewsList.get(i).findElement(xpathContentHeadingInBlocks).getText();
            if (interviewNameSearch.equals(interviewHeading)) {
                wait.until(ExpectedConditions.elementToBeClickable(xpathIconEdit));
                checkingInterviewBlock(i,Status);  // Проверяем блок с Опросом
                System.out.println("Interview ID: " + interviewId + " in Section 'Administration - Archive' has been successfully Verified");
                interviewsList.get(i).findElement(xpathIconEdit).click();
                System.out.println("Open Interview Card for Check in Archive");
                break;
            }
            else{
                Assert.assertEquals(stateText1 + " Опрос  не отображается в разделе 'Архив'",
                        interviewHeading, interviewNameSearch);
            }
        }
    }

    public void unPublicInterview() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonUnPublic));
        driver.findElement(xpathButtonUnPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        waitingSpinner();
        contentUnPublicDate = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDate.now()) + " " + DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) ;;
        System.out.println("Interview ID: " + interviewId + " successfully UnPublished");
    }

    public void createAndDeleteInterview(){
        loginAdmin();                                  // Авторизация под пользователем с правами "Администратор"
        sectionContentInterview();                     // Переход в подраздел "Опросы", раздела "Опросы"
        openInterviewCard();                           // Открываем карточку Опроса
        createInterview("All");             // Создаем Опрос
        getInterviewID();                              // Получаем ID Опроса
        getAllQuestions();                             // Получаем все вопросы в Опросе
        checkInterviewBlock("Create");           // Проверяем корректность блока Опроса - Информационный блок
        checkInterviewCard(stateCreate);               // Проверяем заполненность карточки Опроса
        deleteInterview();                             // Удаляем Опрос
        checkModifiedInterviewBlock("Delete");   // Проверяем корректность блока Опроса - Архив
        checkInterviewCard(stateDelete);               // Проверяем заполненность карточки Опроса - Архив
    }

    public void publicAndUnPublicInterview() {
        loginAdmin();                                  // Авторизация под пользователем с правами "Администратор"
        sectionContentInterview();                     // Переход в подраздел "Опросы", раздела "Опросы"
        openInterviewCard();                           // Открываем карточку Опроса
        createInterview("All");             // Создаем Опрос
        getInterviewID();                              // Получаем ID Опроса
        getAllQuestions();                             // Получаем все вопросы в Опросе
        publicInterview();                             // Публикуем Опрос
        checkInterviewBlock("Public");           // Проверяем корректность блока Опроса - Информационный блок
        checkInterviewCard(statePublic);               // Проверяем заполненность карточки Опроса
        unPublicInterview();                           // Удаляем Опрос
        checkModifiedInterviewBlock("UnPublic"); // Проверяем корректность блока Опроса - Архив
        checkInterviewCard(stateUnPublic);             // Проверяем заполненность карточки Опроса - Архив
    }

    public void clearCollections(){
       questionOneVarVariantsNames.clear();
       questionSomeVarVariantsNames.clear();
        questionDropDownVariantsNames.clear();
        questionTypes.clear();
        questionNames.clear();
        questionComments.clear();
        questionNameForCheck.clear();
        questionCommentForCheck.clear();
        questionTypeForCheck.clear();
        questionValidationForCheck.clear();
        questionMaxSymbolForCheck.clear();
        questionAnswerForCheck.clear();
        questionScaleForCheck.clear();
        questionFilesTypeForCheck.clear();
        questionNmbFilesForCheck.clear();
        questionNameArr.clear();
        questionCommentArr.clear();
        questionTypeArr.clear();
        questionValidationArr.clear();
        questionMaxSymbolArr.clear();
        questionAnswerArr.clear();
        questionScaleArr.clear();
        questionFilesTypeArr.clear();
        questionNmbFilesArr.clear();
        questionAllNames.clear();
    }
}
