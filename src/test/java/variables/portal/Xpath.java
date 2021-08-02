package variables.portal;

import org.openqa.selenium.By;

import static variables.admin.Strings.surveyId;

public class Xpath {

    //Авторизация
    public static By xpathCookieYes = By.xpath("//button[contains(text(), 'Хорошо')]");
    public static By xpathESIAuthorize = By.xpath("//span[contains(text(), 'Войти через')]");
    public static By xpathCheckBoxDate = By.xpath("//input/../span");
    public static By xpathConfirmDateButton = By.xpath("//button[contains(text(), 'Подтвердить')]");

    //Кабинет ТСП
    public static By xpathPartner = By.xpath("//p[contains(text(), 'Партнерам')]");
    public static By xpathPartnersAdd = By.xpath("//button[contains(text(), 'Стать партнером')]");
    public static By xpathPartnersOpen = By.xpath("//button[contains(text(), 'Перейти в кабинет')]");
    public static By xpathConfirmButton = By.xpath("//button[contains(text(), 'Готово')]");
    public static By xpathMSS_CodeConfirm = By.xpath("//li[contains(text(), '9999 Название')]");
    public static By xpathTSPSendButton = By.xpath("//button[contains(text(), 'Отправить заявку')]");
    public static By xpathTSPUserAddress = By.xpath("//span[contains(text(), 'Добавить адрес')]");
    public static By xpathUserNewsSection = By.xpath("//span[contains(text(), 'Новости')]");

    //Новости и Афиши
    public static By xpathAllUserNews = By.xpath("//a[contains(@href, 'news/')]");
    public static By xpathNewsCardMainSectionHeading = By.xpath("//main//section/a/div/div[1]");
    public static By xpathNewsCardMainSectionDates = By.xpath("//main//section/a/div/div[2]");
    public static By xpathOpenedNewsCardHeading = By.xpath("//main//section//h1");
    public static By xpathOpenedNewsCardAttributes = By.xpath("//main//section//p");
    public static By xpathOpenedNewsCardCategory = By.xpath("//main//section//span");

    public static By xpathPosterSection = By.xpath("//span[contains(text(), 'Афиши')]");
    public static By xpathAllUserPosters = By.xpath("//a[contains(@href, 'posters/')]");
    public static By xpathMainSPosterDates = By.xpath("//main//a//div[1]/div[2]/div[1]//div");
    public static By xpathMainSPosterCost = By.xpath("//main//a//div[1]//div[2]//div[2]//div[1]");
    public static By xpathMainSPosterAge = By.xpath("//main//a//div[1]//div[2]//div[2]//div[2]");
    public static By xpathMainSPosterHeading = By.xpath("//a/div[2]/div[1]/div[1]");
    public static By xpathMainSPosterTeaser = By.xpath("//a/div[2]/div[1]/div[2]");
    public static By xpathMainSPosterLocation = By.xpath("//a/div[2]/div[2]/span");
    public static By xpathOpenedPosterHeader = By.xpath("//main//header");
    public static By xpathOpenedPosterHeading = By.xpath("//h1[contains(text(), '')]");
    public static By xpathOpenedPosterDate = By.xpath("//main//div//div[1]//p");
    public static By xpathOpenedPosterCost = By.xpath("//main//div//div[1]//div[2]");
    public static By xpathOpenedPosterAge = By.xpath("//div[contains(text(), '+')]");
    public static By xpathOpenedPosterLocation = By.xpath("//div/div[2]/p");
    public static By xpathOpenedPosterUrl = By.xpath("//a[contains(@href, 'http')]");
    public static By xpathOpenedPosterCategory = By.xpath("//main//section//span");
    public static By xpathOpenedPosterTeaser = By.xpath("//main/section/p");
    public static By xpathOpenedPosterText = By.xpath("//main/section/div/div/p");


    //Опросы
    public static By xpathUserToSurveryCard = By.xpath("//span[contains(text(), 'Опросы')]");
    public static By xpathUserSurveys = By.xpath("//a[contains(@href, 'polls/')]");
    public static By xpathSurveyMainSHeading = By.xpath("//a[contains(@href, '"+ surveyId +"')]/div[1]");
    public static By xpathOpenedSurveyElements = By.xpath("//main//section");
    public static By xpathOpenedSurveyHeading = By.xpath("//h1[contains(text(), '')]");
    public static By xpathOpenedSurveyDescription = By.xpath("//form//article[1]");
    //Вопрос "Короткий ответ"
    public static By xpathOpenedSurveyShortAnswerNumberName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyShortAnswerNumberDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Длинный ответ"
    public static By xpathOpenedSurveyLongAnswerName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyLongAnswerDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Один вариант"
    public static By xpathOpenedSurveyOneVarName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyOneVarDescription = By.xpath("//form//article//p[2]");
    public static By xpathOpenedSurveyOneVarVariants = By.xpath("//label//div[contains(text(), '')]");
    //Вопрос "Несколько вариантов"
    public static By xpathOpenedSurveySomeVarName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveySomeVarDescription = By.xpath("//form//article//p[2]");
    public static By xpathOpenedSurveySomeVarVariants = By.xpath("//label//div[contains(text(), '')]");
    //Вопрос "Выпадающий список"
    public static By xpathOpenedSurveyDropDownName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDropDownDescription = By.xpath("//form//article//p[2]");
    public static By xpathOpenedSurveyShowDropDown = By.xpath("//div[contains(@aria-labelledby, 'Выпадающий')]");
    public static By xpathOpenedSurveyDropDownVariants = By.xpath("//div[contains(@id, 'Выпадающий')]//li[contains(text(), '')]");
    //Вопрос "Шкала"
    public static By xpathOpenedSurveyScaleName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyScaleDescription = By.xpath("//form//article//p[2]");
    public static By xpathOpenedSurveyScaleStar = By.xpath("//section//div//button");
    //Вопрос "Загрузка файла" - JPEG
    public static By xpathOpenedSurveyDownloadJPEGName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadJPEGDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Загрузка файла" - PNG
    public static By xpathOpenedSurveyDownloadPNGName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadPNGDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Загрузка файла" - PDF
    public static By xpathOpenedSurveyDownloadPDFName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadPDFDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Загрузка файла" - DOC
    public static By xpathOpenedSurveyDownloadDOCName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadDOCDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Загрузка файла" - XLS
    public static By xpathOpenedSurveyDownloadXLSName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadXLSDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Загрузка файла" - Все файлы
    public static By xpathOpenedSurveyDownloadALLName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDownloadALLDescription = By.xpath("//form//article//p[2]");
    //Вопрос "Текст"
    public static By xpathOpenedSurveyTextName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyTextDescription = By.xpath("//form//article//p[2]");

    public static By xpathOpenedSurveyNames = By.xpath("//form//article//p[1]");
    public static By xpathOpenedSurveyDescriptions = By.xpath("//form//article//p[2]");
}
