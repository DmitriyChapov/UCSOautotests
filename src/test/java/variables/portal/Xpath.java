package variables.portal;

import org.openqa.selenium.By;

import static variables.admin.Strings.interviewId;

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
    public static By xpathUserTSPMSS_code = By.xpath("//label[contains(@for, 'classifiers')]/..//input");
    public static By xpathMSS_CodeConfirm = By.xpath("//li[contains(text(), '9999 Название')]");
    public static By xpathTSPSendButton = By.xpath("//button[contains(text(), 'Отправить заявку')]");
    public static By xpathTSPUserAddress = By.xpath("//span[contains(text(), 'Добавить адрес')]");

    //Новости и Афиши
    public static By xpathUserNewsSection = By.xpath("//span[contains(text(), 'Новости')]");
    public static By xpathAllUserNews = By.xpath("//a[contains(@href, 'news/')]");
    public static By xpathNewsSectionHeading = By.xpath("./div/div[1]");
    public static By xpathNewsSectionDates = By.xpath("./div/div[2]");
    public static By xpathOpenedNewsDates = By.xpath("//main//section/div/p[1]");
    public static By xpathOpenedNewsHeading = By.xpath("//main//section//h1");
    public static By xpathOpenedNewsTeaser = By.xpath("//main//section/div/p[2]");
    public static By xpathOpenedNewsText = By.xpath("//main//section//div//div//p");
    public static By xpathOpenedNewsCategory = By.xpath("//main//section//span");

    public static By xpathUserPostersSection = By.xpath("//span[contains(text(), 'Афиши')]");
    public static By xpathAllUserPosters = By.xpath("//a[contains(@href, 'posters/')]");
    public static By xpathPosterSectionDates = By.xpath("./div[1]/div[2]/div[1]//div");
    public static By xpathPosterSectionCost = By.xpath("./div[1]//div[2]//div[2]//div[1]");
    public static By xpathPosterSectionAge = By.xpath("./div[1]//div[2]//div[2]//div[2]");
    public static By xpathPosterSectionHeading = By.xpath("./div[2]/div[1]/div[1]");
    public static By xpathPosterSectionTeaser = By.xpath("./div[2]/div[1]/div[2]");
    public static By xpathPosterSectionLocation = By.xpath("./div[2]/div[2]/span");
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
    public static By xpathUserInterviewsSection = By.xpath("//span[contains(text(), 'Опросы')]");
    public static By xpathAllUserInterview = By.xpath("//a[contains(@href, 'polls/')]");
    public static By xpathInterviewSectionHeading = By.xpath("//a[contains(@href, '" + interviewId + "')]/div[1]");
    public static By xpathOpenedSurveyElements = By.xpath("//main//section");
    public static By xpathOpenedSurveyHeading = By.xpath("//h1[contains(text(), '')]");
    public static By xpathOpenedSurveyDescription = By.xpath("//form//article[1]");
    public static By xpathOpenedQuestionName = By.xpath("//form//article//p[1]");
    public static By xpathOpenedQuestionDescription = By.xpath("//form//article//p[2]");

    //Акции
    public static By xpathToPromotionsAndDiscounts = By.xpath("//span[contains(text(), 'Скидки и акции')]");
    public static By xpathToPromotions = By.xpath("//a[contains(text(), 'Акции')]");
    public static By xpathAllPromotions = By.xpath("//a[contains(@href, 'permanent/')]");
    public static By xpathAllPromotionsMainSNames = By.xpath("//a//div[2]//span[1]");
    public static By xpathAllPromotionsMainSCorp = By.xpath("//a//div[2]//span[2]");
    public static By xpathAllPromotionElements = By.xpath("//main//article[2]");
    public static By xpathOpenedPromotionHeading = By.xpath("//div//h1");
    public static By xpathOpenedPromotionCorporation = By.xpath("//div//h3");
    public static By xpathOpenedPromotionEmailCorp = By.xpath("//p[contains(text(), '@')]");
    public static By xpathOpenedPromotionPhoneCorp = By.xpath("//p[contains(text(), '+')]");
    public static By xpathOpenedPromotionCorpWebsite = By.xpath("//main//a[contains(@href, '')]");
    public static By xpathOpenedPromotionCorpVk = By.xpath("//main//a[contains(@href, 'vk')]");
    public static By xpathOpenedPromotionCorpFacebook = By.xpath("//main//a[contains(@href, 'face')]");
    public static By xpathOpenedPromotionCorpInst = By.xpath("//main//a[contains(@href, 'inst')]");
    public static By xpathOpenedPromotionCorpOdnkl = By.xpath("//main//a[contains(@href, 'ok.ru')]");
    public static By xpathOpenedPromotionAdditionalInfo = By.xpath("//article//div[2]//pre[contains(text(), '')]");
    public static By xpathOpenedShowPromotionAddresses = By.xpath("//span[contains(text(), 'Все адреса')]");
    public static By xpathOpenedPromotionAllAddresses = By.xpath("//article/div[2]/div[2]/div/ul/li");
    public static By xpathOpenedPromotionConditions = By.xpath("//div[3]//pre");
    public static By xpathOpenedPromotionDate = By.xpath("//div/h2");

    //Скидки
    public static By xpathMainSDiscounts = By.xpath("//a[contains(@href, 'general/')]");
    public static By xpathMainSDiscountPercentage = By.xpath("//span[contains(text(), '%')]");
    public static By xpathMainSDiscountName = By.xpath("//article/div[2]/span[2]");
    public static By xpathMainSDiscountCorp = By.xpath("//article/div[2]/span[3]");
    public static By xpathAllDiscountElements = By.xpath("//main//article[2]");
    public static By xpathOpenedDiscountHeading = By.xpath("//div//h1");
    public static By xpathOpenedDiscountPercentage = By.xpath("//span[contains(text(), '%')]");
    public static By xpathOpenedDiscountCorporation = By.xpath("//div//h3");
    public static By xpathOpenedDiscountEmailCorp = By.xpath("//p[contains(text(), '@')]");
    public static By xpathOpenedDiscountPhoneCorp = By.xpath("//p[contains(text(), '+')]");
    public static By xpathOpenedDiscountCorpWebsite = By.xpath("//main//a[contains(@href, '')]");
    public static By xpathOpenedDiscountCorpVk = By.xpath("//main//a[contains(@href, 'vk')]");
    public static By xpathOpenedDiscountCorpFacebook = By.xpath("//main//a[contains(@href, 'face')]");
    public static By xpathOpenedDiscountCorpInst = By.xpath("//main//a[contains(@href, 'inst')]");
    public static By xpathOpenedDiscountCorpOdnkl = By.xpath("//main//a[contains(@href, 'ok.ru')]");
    public static By xpathOpenedDiscountAdditionalInfo = By.xpath("//article//div[2]//pre[contains(text(), '')]");
    public static By xpathShowDiscountAddresses = By.xpath("//span[contains(text(), 'Все адреса')]");
    public static By xpathOpenedDiscountAllAddresses = By.xpath("//article/div[2]/div[2]/div/ul/li");
    public static By xpathOpenedDiscountConditions = By.xpath("//div[3]//pre");
    public static By xpathOpenedDiscountDate = By.xpath("//div[2]/h2");

}
