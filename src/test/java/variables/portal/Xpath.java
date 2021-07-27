package variables.portal;

import org.openqa.selenium.By;

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

}
