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

import java.util.List;

public class InterviewsPage extends Login {

    public void sectionContentInterview() {
        WebElement sectionAdmin = driver.findElement(xpathAdministration);
        WebElement subsectionContent = driver.findElement(xpathInterviews);
        actionChange.moveToElement(sectionAdmin);
        actionChange.moveToElement(subsectionContent).click();
        actionChange.perform();
        String interviewsUrlNow = driver.getCurrentUrl();
        String interviewsPageNameNow = driver.findElement(headingInterviewsPage).getText();
        Assert.assertEquals("Некорректный Url страницы 'Опросы'",
                interviewsUrl, interviewsUrlNow);
        Assert.assertEquals("Не совпадают заголовки на странице 'Опросы'", interviewPageName, interviewsPageNameNow);
        System.out.println("Go to section: Interviews");
    }

    public void openInterviewCard() {
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAdd));
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
        List<WebElement> datepicker = driver.findElements(dateFields);
        List<WebElement> timepicker = driver.findElements(timeFields);
        wait.until(ExpectedConditions.elementToBeClickable(xpathPortal));
        driver.findElement(xpathPortal).click();
        datepicker.get(4).sendKeys(dateNow);
        timepicker.get(4).sendKeys(timeNow);
        datepicker.get(5).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(xpathMobile));
        driver.findElement(xpathMobile).click();
        datepicker.get(0).sendKeys(dateNow);
        timepicker.get(0).sendKeys(timeNow);
        datepicker.get(1).sendKeys(dateNow);
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectInterviewResults));
        driver.findElement(selectorSelectInterviewResults).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathResultInRealTime));
        driver.findElement(xpathResultInRealTime).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectorSelectInterviewAccess));
        driver.findElement(selectorSelectInterviewAccess).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathAccessAll));
        driver.findElement(xpathAccessAll).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathLocationForContent));
        driver.findElement(xpathLocationForContent).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Короткий ответ; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Короткий ответ; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Короткий ответ; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Короткий ответ; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Короткий ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Короткий ответ; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Длинный ответ; ")) {
        } else {
            interviewDescription = interviewDescription + "Длинный ответ; ";
        }
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
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Один вариант; ")) {
        } else {
            interviewDescription = interviewDescription + "Один вариант; ";
        }
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
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Несколько вариантов; ")) {
        } else {
            interviewDescription = interviewDescription + "Несколько вариантов; ";
        }
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
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Выпадающий список; ")) {
        } else {
            interviewDescription = interviewDescription + "Выпадающий список; ";
        }
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
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Шкала; ")) {
        } else {
            interviewDescription = interviewDescription + "Шкала; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSaveInWindow));
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Загрузка файлов; ")) {
        } else {
            interviewDescription = interviewDescription + "Загрузка файлов; ";
        }
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
        driver.findElement(xpathButtonSaveInWindow).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("mat-dialog-container")));
        if (interviewDescription.contains("Текст; ")) {
        } else {
            interviewDescription = interviewDescription + "Текст; ";
        }
        System.out.println("Question successfully Added: Text");
    }

    public void createInterview() {
        loginAdmin();                         // Авторизация под пользователем с правами "Администратор"
        sectionContentInterview();            // Переход в подраздел "Опросы", раздела "Опросы"
        openInterviewCard();                  // Открываем Карточку опроса
        tabPropertiesInterviewCard();         //Заполняем вкладку "Свойства"
        tabConstructorInterviewCard();        //Заполняем вкладку "Конструктор"
            questionShortAnswerNumber();          //Создаем вопрос "Короткий ответ" - Числовая форма
            questionShortAnswerDouble();          //Создаем вопрос "Короткий ответ" - Дробные числа
            questionShortAnswerPhone();           //Создаем вопрос "Короткий ответ" - Формат телефона
            questionShortAnswerSymbol();          //Создаем вопрос "Короткий ответ" - Кириллические символы
            questionShortAnswerNoValid();         //Создаем вопрос "Короткий ответ" - Без валидации*/
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
            questionText();                       //Создаем вопрос "Текс"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(selectorFieldInterviewDescription));
        wait.until(ExpectedConditions.elementToBeClickable(selectorFieldInterviewDescription));
        driver.findElement(selectorFieldInterviewDescription).sendKeys(interviewDescription);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(xpathButtonSave));
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonSave));
        driver.findElement(xpathButtonSave).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationInterviewCardSaveNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при сохранении Опроса",
                interviewCardSaveNotification, textNotificationInterviewCardSaveNow);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathNotifier));
        System.out.println("Interview successfully Created");
    }

    public void getInterviewId() {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathInterviewId));
        String tempInterview = driver.findElement(xpathInterviewId).getText();
        interviewId = tempInterview.substring(4, tempInterview.length());
    }


    public void getAllQuestionsType() {
        wait.until(ExpectedConditions.presenceOfElementLocated(selectorQuestionType));
        questionTypesWeb = driver.findElements(selectorQuestionType);
        questionNamesWeb = driver.findElements(selectorQuestionName);
        //Получение названия и типа вопроса
        for (int i = 0; i < questionNamesWeb.size(); i++) {
            questionNames.add(questionNamesWeb.get(i).getText());
            questionTypes.add(questionTypesWeb.get(i).getText());
        };
    }

    public void publicInterview() {
        createInterview();                 // Создаем Опрос
        getInterviewId();
        getAllQuestionsType();
        actionChange.moveToElement(driver.findElement(xpathButtonPublic)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonPublic));
        driver.findElement(xpathButtonPublic).click();
        wait.until(ExpectedConditions.elementToBeClickable(xpathButtonAccept));
        driver.findElement(xpathButtonAccept).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathNotifier));
        String textNotificationInterviewCardPublicNow = driver.findElement(xpathNotifier).getText();
        Assert.assertEquals("Не совпадают тексты нотификации при публикации Опроса",
                interviewCardPublicNotification, textNotificationInterviewCardPublicNow);
        System.out.println("Interview ID: " + interviewId + " successfully Published");
    }
}