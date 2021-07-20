package variables;

import org.openqa.selenium.By;
import static variables.Strings.*;

public class Xpath {
    //Портал
    public static By xpathCookieYes = By.xpath("//button[contains(text(), 'Хорошо')]");
    public static By xpathESIAuthorize = By.xpath("//span[contains(text(), 'Войти через')]");
    public static By xpathCheckBoxDate = By.xpath("//input/../span");
    public static By xpathConfirmDateButton = By.xpath("//button[contains(text(), 'Подтвердить')]");
    public static By xpathPartner = By.xpath("//p[contains(text(), 'Партнерам')]");
    public static By xpathPartnersAdd = By.xpath("//button[contains(text(), 'Стать партнером')]");
    public static By xpathPartnersOpen = By.xpath("//button[contains(text(), 'Перейти в кабинет')]");
    public static By xpathConfirmButton = By.xpath("//button[contains(text(), 'Готово')]");
    public static By xpathMSS_CodeConfirm = By.xpath("//li[contains(text(), '9999 Название')]");
    public static By xpathTSPSendButton = By.xpath("//button[contains(text(), 'Отправить заявку')]");
    public static By xpathTSPUserAddress = By.xpath("//span[contains(text(), 'Добавить адрес')]");

    //Админка

    //Разделы и подразделы
    public static By xpathReferenceBooks =By.xpath("//li[contains(text(), 'Справочники')]");
    public static By xpathMSSCodes = By.xpath("//a[contains(text(), 'MCC-коды')]");
    public static By xpathBanks = By.xpath("//a[contains(text(), 'Банки')]");
    public static By xpathBankTabDesign = By.xpath("//div[contains(text(), 'Дизайн карт')]");
    public static By xpathPositions = By.xpath("//a[contains(text(), 'Должности')]");
    public static By xpathContentLocations = By.xpath("//a[contains(text(), 'Локации контента')]");
    public static By xpathLocationTransportApps = By.xpath("//a[contains(text(), 'Локации транспортного приложения')]");
    public static By xpathDescriptionsTransportCards = By.xpath("//a[contains(text(), 'Описания транспортной карты')]");
    public static By xpathTransportAppSeries = By.xpath("//a[contains(text(), 'Серии транспортного приложения')]");
    public static By xpathStructuralSubdivisions = By.xpath("//a[contains(text(), 'Структурные подразделения')]");
    public static By xpathTags = By.xpath("//a[contains(text(), 'Теги рубрик')]");
    public static By xpathUserTypes = By.xpath("//a[contains(text(), 'Типы пользователей')]");
    public static By xpathEventPlaces = By.xpath("//a[contains(text(), 'Учреждения для проведения мероприятий')]");
    public static By xpathAdministration = By.xpath("//li[contains(text(), 'Администрирование')]");
    public static By xpathContent = By.xpath("//a[contains(text(), 'Контент')]");
    public static By xpathPoster = By.xpath("//a[contains(text(), 'Афиши')]");
    public static By xpathInterviews = By.xpath("//a[contains(text(), 'Опросы')]");
    public static By xpathInterviewsArchive = By.xpath("//a[contains(text(), 'Архив')]");
    public static By xpathUsers = By.xpath("//a[contains(text(), 'Пользователи')]");
    public static By xpathRegisters = By.xpath("//li[contains(text(), 'Реестры')]");
    public static By xpathElectronicCases = By.xpath("//a[contains(text(), 'Реестр электронных дел')]");
    public static By xpathCardHolders = By.xpath("//a[contains(text(), 'Реестр держателей КЖСО')]");
    public static By xpathTSP = By.xpath("//li[contains(text(), 'Торгово-сервисные предприятия')]");
    public static By xpathTabPromotions = By.xpath("//div[contains(text(), 'Акции')]");
    public static By xpathTabDiscount = By.xpath("//div[contains(text(), 'Скидки')]");
    public static By xpathDocument = By.xpath("//li[contains(text(), 'Документация')]");
    public static By xpathGuidelinesAndRegulations = By.xpath("//a[contains(text(), 'Руководства и регламенты')]");
    public static By xpathSectionGuidelinesAndRegulations = By.xpath("//nav/ul/li/a[contains(text(), 'Руководства и регламенты')]");
    public static By xpathSiteSettings = By.xpath("//li[contains(text(), 'Настройки сайта')]");
    public static By xpathBanners = By.xpath("//a[contains(text(), 'Баннеры')]");
    public static By xpathLogo = By.xpath("//a[contains(text(), 'Логотип')]");

    // Справочники
    public static By xpathBankSite = By.xpath("//app-url-input-field//input");
    public static By xpathBankNameForSearch = By.xpath(".//td[2]/span/a");
    public static By xpathNmbBranch = By.xpath("//tbody//tr");
    public static By xpathNmbDesign = By.xpath("//mat-card");
    public static By xpathLocationPathAdd(int i) {
        By xpathLocationPathAdd = By.xpath("//div[contains(text(), '" + pathLocation(i) + "')]/../*[3]");
        return xpathLocationPathAdd;
    }
    public static By xpathLocationPathDelete(int i) {
        By xpathLocationPathDelete = By.xpath("//div[contains(text(), '" + pathLocation(i) + "')]/../*[5]");
        return xpathLocationPathDelete;
    }
    public static By xpathLocationPathForCheck = By.xpath("//mat-tree-node");
    public static By xpathLocationWithLevel (int i) {
        By xpathLocationWithLevel = By.xpath("//mat-tree-node[@aria-level = '" + i + "']");
        return xpathLocationWithLevel;
    }

    // Новости и Афиши
    public static By xpathTagForContents = By.xpath("//span[contains(text(), 'Автотест')]");
    public static By xpathRadioButtonPrevImage = By.xpath("//div[contains(text(), ' Превью (главная страница) ')]/../..");
    public static By xpathRadioButtonMainImage = By.xpath("//div[contains(text(), ' Основное изображение (в списке публикаций) ')]/../..");
    public static By xpathRadioButtonGalleryImage = By.xpath("//div[contains(text(), ' Галерея (детальное, внутри публикации) ')]/../..");
    public static By xpathLocationForEvent = By.xpath("//span[contains(text(), 'Локация для автотеста')]");

    // Опросы
    public static By xpathAccessAll = By.xpath("//span[contains(text(),'Всем')]");
    public static By xpathTabConstructor = By.xpath("//div[contains(text(), 'Конструктор')]");
    public static By xpathButtonAddQuestion = By.xpath("//span[contains(text(), 'Добавить вопрос')]");
    public static By xpathButtonAddAnswer = By.xpath("//span[contains(text(), 'Добавить ответ')]");
    public static By xpathResultInRealTime = By.xpath("//span[contains(text(),'в реальном времени')]");
    public static By xpathShortAnswer = By.xpath("//span[contains(text(), 'Короткий ответ')]");
    public static By xpathValidationTypeNumber = By.xpath("//span[contains(text(), 'Числовая форма')]");
    public static By xpathValidationTypeDouble = By.xpath("//span[contains(text(), 'Дробные числа')]");
    public static By xpathValidationTypePhone = By.xpath("//span[contains(text(), 'Формат телефона')]");
    public static By xpathValidationTypeSymbol = By.xpath("//span[contains(text(), 'Кириллические символы')]");
    public static By xpathLongAnswer = By.xpath("//span[contains(text(), 'Длинный ответ')]");
    public static By xpathOneVarAnswer = By.xpath("//span[contains(text(), 'Один вариант')]");
    public static By xpathSomeVarAnswer = By.xpath("//span[contains(text(), 'Несколько вариантов')]");
    public static By xpathDropDownAnswer = By.xpath("//span[contains(text(), 'Выпадающий список')]");
    public static By xpathScaleAnswer = By.xpath("//span[contains(text(), 'Шкала')]");
    public static By xpathScale5 = By.xpath("//span[text()='5']");
    public static By xpathScale10 = By.xpath("//span[text()='10']");
    public static By xpathDownloadFilesAnswer = By.xpath("//span[contains(text(), 'Загрузка файла')]");
    public static By xpathDownloadFilesJPEG =  By.xpath("//span[contains(text(), 'JPEG')]");
    public static By xpathDownloadFilesPNG =  By.xpath("//span[contains(text(), 'PNG')]");
    public static By xpathDownloadFilesPDF =  By.xpath("//span[contains(text(), 'PDF')]");
    public static By xpathDownloadFilesDOC =  By.xpath("//span[contains(text(), 'DOC')]");
    public static By xpathDownloadFilesXLS =  By.xpath("//span[contains(text(), 'XLS')]");
    public static By xpathTextAnswer = By.xpath("//span[contains(text(), 'Текст')]");

    // Скидки и Акции
    public static By xpathTSPAvailableSlide = By.xpath("//mat-slide-toggle[@name='available']");

    // Баннеры
    public static By xpathBannerNameForSearch = By.xpath("//tbody/tr/td[3]");

    // Логотип
    public static By xpathLogoNameForSearch = By.xpath(".//h3");

    // Руководства и регламенты
    public static By xpathDocumentNameForSearch = By.xpath(".//td[3]");

    // Общие Поля
    public static By dateFields= By.xpath("//mat-datepicker/../input");
    public static By xpathTabContent = By.xpath("//div[contains(text(), 'Содержимое')]");
    public static By xpathNotifier = By.xpath("//notifier-notification/p");

    // Общие Иконки
    public static By xpathIconDelete = By.xpath(".//mat-icon[contains(text(), 'delete')]");
    public static By xpathIconSaveLocation = By.xpath("//mat-icon[contains(text(), 'save')]");
    public static By xpathIconEdit = By.xpath(".//mat-icon[contains(text(), 'edit')]");

    // Общие Чек-боксы
    public static By xpathPortal = By.xpath("//span[contains(text(), 'Портал')]");
    public static By xpathMobile = By.xpath("//span[contains(text(), 'Мобильное приложение')]");
    public static By xpathLocationForContent = By.xpath("//span[contains(text(), 'Самарская область')]");

    //Общие кнопки
    public static By xpathButtonSave = By.xpath("//span[contains(text(), 'Сохранить')]");
    public static By xpathButtonPublic = By.xpath("//span[contains(text(), 'Разместить')]");
    public static By xpathButtonSaveInWindom = By.xpath("//mat-dialog-actions/button[2]/span[1]");
    public static By xpathButtonSaveImage = By.xpath("//app-image-cropper/div[2]/button[2]");
    public static By xpathButtonAdd = By.xpath("//span[contains(text(), 'Добавить')]");
    public static By xpathButtonDownloadImage = By.xpath("//span[contains(text(),'Загрузить изображение')]");
    public static By xpathButtonAccept = By.xpath("//span[contains(text(), 'Подтвердить')]");
    public static By xpathButtonDelete = By.xpath("//span[contains(text(), 'Удалить')]");
    public static By xpathButtonIn = By.xpath("//span[contains(text(), 'Войти')]");

    //Общие
    public static By xpathSpinner = By.xpath("//mat-spinner");
    public static By xpathListInTable = By.xpath("//tbody/tr");
    public static By xpathListBlocks = By.xpath("//mat-card");
    public static By xpathReferenceBookNameForSearch = By.xpath(".//td[2]");

}


