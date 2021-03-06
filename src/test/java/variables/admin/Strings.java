package variables.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

import static variables.admin.Numbers.*;
import static variables.common.Numbers.*;

public class Strings {

    //Авторизация
    public static String loginInUser = "AutoTest";
    public static String passwordInUser = "123qweQWE";

    //Справочники
    public static String referenceBooksPageName = "Справочники";
    public static String codeOTK = "Code_OTK_" + nmbAutoTest;

    public static String mss_CodesPageName = "Справочник MCC-кодов";
    public static String mss_CodeCardPageName = "Карточка MCC-кода";
    public static String mss_CodeName ="Новый МСС-код, созданный автотестом № " + nmbAutoTest;
    public static String mss_CodeCardSaveNotification = "MCC-код \"" + mss_CodeName + "\" успешно сохранен";

    public static String banksPageName = "Справочник банков";
    public static String bankCardPageName = "Карточка банка";
    public static String bankName ="Новый Банк, созданный автотестом № " + nmbAutoTest;
    public static String bankAddress = "г.Автотестово, ул. Автотестовая " + nmbAutoTest;
    public static String bankSaveNotification = "Банк \"" + bankName + "\" успешно сохранен";
    public static String nameBranch(int i)
    { String nameBranch = "Новое отделение Банка, созданное автотестом № " + nmbAutoTest+ " № " + (i+1);
        return nameBranch;}
    public static String branchAddress(int i)
    { String branchAddress = "г. Автотестово, ул. Автотестовая " + (i+1);
        return branchAddress;}
    public static String branchHoursWork = "9:00 - 18:00";
    public static String nameDesign(int i)
    { String nameDesign = "Новый дизайн Банка, созданный автотестом " + nmbAutoTest + " № " + (i+1);
        return nameDesign;}
    public static String branchCoordinates(){
        String branchCoordinates= bankNmbLatitudeXX() + "." + bankNmbLatitudexx() + ", " + bankNmbLatitudeYY() + "." + bankNmbLatitudeyy();
        return branchCoordinates;}

    public static String positionsPageName = "Справочник должностей";
    public static String positionCardPageName = "Карточка должности";
    public static String positionName ="Новая должность, созданная автотестом № " + nmbAutoTest;
    public static String positionCardSaveNotification = "Карточка должности \"" + positionName + "\" успешно сохранена";

    public static String locationsPageName = "Справочник локаций контента";
    public static String pathLocation(int i)
    { String pathLocation = "Локация " + i + "-го уровня автотеста № " + nmbAutoTest;
        return pathLocation;}
    public static String notificationLocationSave(int i)
    { String notificationLocationSave = "Запись \"" + pathLocation(i) + "\" успешно сохранена.";
        return notificationLocationSave;}
    public static String notificationLocationDelete(int i)
    { String notificationLocationDelete = "Запись \"" + pathLocation(i) + "\" успешно удалена.";
        return notificationLocationDelete;}

    public static String locationTransportAppPageName = "Справочник локаций транспортного приложения";
    public static String locationTransportAppCardPageName = "Карточка локаций транспортного приложения";
    public static String locationTransportAppName = "Локация транспортного приложения, автотест № " + nmbAutoTest;
    public static String locationTransportAppCardSaveNotification = "Запись \"" + locationTransportAppName + "\" успешно добавлена.";

    public static String descriptionsTransportCardPageName = "Справочник описаний карты";
    public static String descriptionsTransportCardCardPageName = "Карточка описаний карты";
    public static String descriptionsTransportCardName ="Новое описание транспортной карты автотест № " + nmbAutoTest;
    public static String descriptionsTransportCardSaveNotification = "Карточка описаний карты \"" + descriptionsTransportCardName + "\" успешно сохранена";

    public static String transportAppSeriesPageName = "Справочник серий транспортного приложения";
    public static String transportAppSeriesCardPageName = "Карточка серии транспортного приложения";
    public static String transportAppSeries = "OK";
    public static String socialCode = "Код " + nmbSocialCode;
    public static String transportAppSeriesCardSaveNotification = "Карточка серии \"" + transportAppSeries + "\" успешно сохранена";

    public static String structuralSubdivisionsPageName = "Справочник структурных подразделений";
    public static String structuralSubdivisionCardPageName = "Структурное подразделение";
    public static String structuralSubdivisionName ="Новое структурное подразделение, созданное автотестом № " + nmbAutoTest;
    public static String structuralSubdivisionCardSaveNotification = "Структурное подразделение \"" + structuralSubdivisionName + "\" успешно сохранено";

    public static String tagsPageName = "Справочник тегов рубрик";
    public static String tagCardPageName = "Карточка тега рубрики";
    public static String tagName ="Новый тег рубрики, созданный автотестом № " + nmbAutoTest;
    public static String tagCardSaveNotification = "Новая рубрика \"" + tagName + "\" успешно сохранена";

    public static String usersTypePageName = "Справочник типов пользователей";
    public static String userTypeCardPageName = "Карточка типа пользователя";
    public static String userTypeName ="Новый тип пользователя, созданный автотестом " + nmbAutoTest;
    public static String userTypeCardSaveNotification = "Карточка типа пользователя \"" + userTypeName + "\" успешно сохранена";

    public static String eventPlacesPageName = "Справочник учреждений для проведения мероприятий";
    public static String eventPlaceCardPageName = "Карточка учреждения для проведения мероприятий";
    public static String eventPlaceName = "Новое учреждение для проведения мероприятий, созданное автотестом № " + nmbAutoTest;
    public static String eventPlaceAddress = "г. Автотесто, ул. Автотестовая " + nmbAutoTest;
    public static String eventPlaceCardSaveNotification = "Карточка учреждения для проведения мероприятий \"" + eventPlaceName + "\" успешно сохранена";

    //Новости и Афиши
    public static String newsPageName = "Новости";
    public static String newsCardPageName = "Карточка новости";
    public static String newsHeading =  "Заголовок новости, созданной автотестом. Этот заголовок содержит максимальное количество символов равное 150. Номер генерируется рандомно и равен " + nmbAutoTest;
    public static String newsTeaser = "Анонс новости, созданной автотестом. Этот анонс содержит максимальное количество знаков, равное 150 символов. Номер генерируется рандомно и равен " + nmbAutoTest;
    public static String newsText = "Текст новости, созданной автотестом номер " + nmbAutoTest + ". ";
    public static String newsCardSaveNotification = "Публикация \"" + newsHeading + "\" успешно сохранена";
    public static String newsCardPublicNotification = "Карточка новости \"" + newsHeading + "\" успешно опубликована";

    public static String postersPageName = "Афиши";
    public static String posterCardPageName = "Карточка афиши";
    public static String posterHeading = "Заголовок афиши, созданной автотестом. Заголовок содержит максимальное количество знаков равное 150 символов. Номер генерируется рандомно и равен " + nmbAutoTest;
    public static String posterTeaser = "Анонс афиши, созданной автотестом. Анонс афиши содержит максимальное количество знаков равное 150 символов. Номер генерируется рандомно и равен № " + nmbAutoTest;
    public static String posterText = "Текст афиши, созданной автотестом номер " + nmbAutoTest + ". ";
    public static String posterEventDate = "C 1 по 8 марта, начало в 19:00";
    public static String posterEventLocation = "Локация для автотеста";
    public static String posterEventCost = "Бесплатно";
    public static String posterCardSaveNotification = "Публикация \"" + posterHeading + "\" успешно сохранена";
    public static String posterCardPublicNotification = "Карточка афиши \"" + posterHeading + "\" успешно опубликована";
    public static String newsCardId;
    public static String newsCategory;
    public static String posterCardId;
    public static String posterCategory;

    //Опросы
    public static String interviewPageName = "Опросы";
    public static String interviewCardPageName = "Карточка опроса";
    public static String interviewHeading = "Заголовок свежего опроса, созданного автотестом. В опросе присутствуют все типы вопросов и они необязательные номер " + nmbAutoTest;
    public static String interviewDescription = "Краткое описание опроса, созданного автотестом № " + nmbAutoTest + ". В данном опросе присутствуют вопросы с типом: ";
    public static String interviewCardSaveNotification = "Карточка опроса \"" + interviewHeading + "\" успешно сохранена";
    public static String interviewCardPublicNotification = "Опрос \"" + interviewHeading + "\" успешно опубликован";
    public static String questionTypeShort = "Короткий ответ";
    public static String questionTypeLong = "Длинный ответ";
    public static String questionTypeOneVar = "Один вариант";
    public static String questionTypeSomeVar = "Несколько вариантов";
    public static String questionTypeDropDown = "Выпадающий список";
    public static String questionTypeScale = "Шкала";
    public static String questionTypeDownload = "Загрузка файла";
    public static String questionTypeText = "Текст";
    public static String questionShortValidTypeNumbers = "Числовая форма";
    public static String questionShortValidTypeDoubles = "Дробные числа";
    public static String questionShortValidTypePhone = "Формат телефона";
    public static String questionShortValidTypeSymbol = "Кириллические символы";
    public static String questionShortValidTypeNoValid = "Без валидации";
    public static String questionDownloadFilesTypeJPEG = "JPEG";
    public static String questionDownloadFilesTypePNG = "PNG";
    public static String questionDownloadFilesTypePDF = "PDF";
    public static String questionDownloadFilesTypeDOC = "DOC";
    public static String questionDownloadFilesTypeXLS = "XLS";

    public static String questionShortNumberName = "Вопрос \"Короткий ответ\" - Числовая форма";
    public static String questionShortNumberComment = "Максимальное кол-во символов: " + maxSymbolShortNumber;
    public static String questionShortDoubleName = "Вопрос \"Короткий ответ\" - Дробные числа";
    public static String questionShortDoubleComment = "Максимальное кол-во символов: " + maxSymbolShortDouble;
    public static String questionShortPhoneName = "Вопрос \"Короткий ответ\" - Формат телефона";
    public static String questionShortPhoneComment = "Кол-во символов: 11";
    public static String questionShortSymbolName = "Вопрос \"Короткий ответ\" - Кириллические символы";
    public static String questionShortSymbolComment = "Максимальное кол-во символов: " + maxSymbolShortSymbol;
    public static String questionShortNoValidName = "Вопрос \"Короткий ответ\" - Без валидации";
    public static String questionShortNoValidComment = "Максимальное кол-во символов: " + maxSymbolShortNoValid;
    public static String questionLongName = "Вопрос \"Длинный ответ\"";
    public static String questionLongComment = "Максимальное кол-во символов: " + maxSymbolLong;
    public static String questionOneVarName = "Вопрос \"Один вариант\"";
    public static String questionOneVarComment = "Кол-во вариантов ответа: " + nmbOneVar;
    public static String nameVar(int i) {
        String nameVar = "Вариант " + (i + 1);
        return nameVar;
    }
    public static String questionSomeVarName = "Вопрос \"Несколько вариантов\"";
    public static String questionSomeVarComment = "Кол-во вариантов ответа: " + nmbSomeVar;
    public static String questionDropDownName = "Вопрос \"Выпадающий список\"";
    public static String questionDropDownComment = "Кол-во вариантов ответа: " + nmbDropDown;
    public static String questionScaleName = "Вопрос \"Шкала\"";
    public static String questionScaleComment = "Кол-во делений: ";
    public static String questionDownloadJPEGName = "Вопрос \"Загрузка файла\" - JPEG";
    public static String questionDownloadJPEGComment = "Допустимый формат загружаемый файлов - JPEG, JPG. Максимальное кол-во файлов: " + maxFilesJPEG;
    public static String questionDownloadPNGName = "Вопрос \"Загрузка файла\" - PNG";
    public static String questionDownloadPNGComment = "Допустимый формат загружаемый файлов - PNG. Максимальное кол-во файлов: " + maxFilesPNG;
    public static String questionDownloadPDFName = "Вопрос \"Загрузка файла\" - PDF";
    public static String questionDownloadPDFComment = "Допустимый формат загружаемый файлов - PDF. Максимальное кол-во файлов: " + maxFilesPDF;
    public static String questionDownloadDOCName = "Вопрос \"Загрузка файла\" - DOC";
    public static String questionDownloadDOCComment = "Допустимый формат загружаемый файлов - DOC, DOCX, ODT, RTF. Максимальное кол-во файлов: " + maxFilesDOC;
    public static String questionDownloadXLSName = "Вопрос \"Загрузка файла\" - XLS";
    public static String questionDownloadXLSComment = "Допустимый формат загружаемый файлов - XLS, XLSX. Максимальное кол-во файлов: " + maxFilesXLS;
    public static String questionDownloadALLName = "Вопрос \"Загрузка файла\" - Все типы";
    public static String questionDownloadALLComment = "Допустимый формат загружаемый файлов - JPG, JPEG,PNG, PDF, DOC, DOCX, ODT, RTF, XLS, XLSX. Максимальное кол-во файлов: " + maxFilesALL;
    public static String questionTextName = "Вопрос \"Текст.\" ";
    public static String questionTextComment = "Просто текст";
    public static String interviewId;
    public static String scaleCount;
    public static String questionType;
    public static String interviewResultsType;
    public static String interviewAccess;

    //ТСП, Скидки, Акции
    public static String tspPageName = "Торгово-сервисные предприятия";
    public static String tspCardPageName = "Карточка торгово-сервисного предприятия";
    public static String tspID;
    public static String email = "yojiwit265@activesniper.com";
    public static String mss_code = "9999";
    public static String adminTSPName = "Новая организация, созданная автотестом из кабинета администратора №" + nmbAutoTest;
    public static String adminTSPDescription = "Описание организации, созданной автотестом из кабинета администратора";
    public static String adminTSPAddress = "г. Автотестово, ул. Администратора, д. " + nmbAutoTest;
    public static String adminTSPEmailPublic = "Email@email.com";
    public static String adminTSPPhonePublic = "9270000000";
    public static String adminTSPOptionalText = "Дополнительная информация по ТСП, созданного администратором. ";
    public static String tspSaveNotification = "ТСП \"" + adminTSPName + "\" успешно сохранено";

    public static String promotionName = "Наименование Акции, с кол-вом символов 70, созданной автотестом № " + nmbAutoTest;
    public static String descriptionAndConditionPromotion = "Описание и условия действия акции , созданной автотестом № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForPromotionAdmin + ". ";
    public static String promotionID;
    public static String promotionSaveNotification = "Предложение \"" + promotionName + "\" успешно сохранено";
    public static String promotionPublicNotification = "Предложение \"" + promotionName + "\" успешно опубликовано";

    public static String discountName = "Наименование Скидки с кол-вом символов 70, созданной автотестом № " + nmbAutoTest;
    public static String descriptionAndConditionDiscount = "Описание и условия действия скидки , созданной автотестом № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForDiscountAdmin + ". ";
    public static String discount = nmbDiscountAdmin + "%";
    public static String discountID;
    public static String discountSaveNotification = "Предложение \"" + discountName + "\" успешно сохранено";

    public static String tspNameAdmin = "AutoTest Сorporation";

    //Даты
    public static String dateDiscountFrom;
    public static String dateDiscountTo;

    //Реестры
    public static String cardHoldersRegistryPageName = "Реестр держателей карты";
    public static String electronicCasesRegisterPageName = "Реестр электронных дел";

    //Руководства и Регламенты
    public static String guidelinesAndRegulationsUrlNow;
    public static String guidelinesAndRegulationsPageNameNow;
    public static String guidelinesAndRegulationsPageName = "Руководства и регламенты";
    public static String guidelinesAndRegulationsCardUrlNow;
    public static String guidelinesAndRegulationsCardPageNameNow;
    public static String guidelinesAndRegulationsCardPageName = "Карточка документа";
    public static String documentName ="Новый документ, созданный автотестом № " + nmbAutoTest;
    public static String guidelinesAndRegulationsCardSaveNotificationNow;
    public static String guidelinesAndRegulationsCardSaveNotification = "Карточка документа \"" + documentName + "\" успешно сохранена";
    public static boolean documentPortalAvailable;
    public static boolean documentMobileAvailable;
    public static String guidelinesAndRegulationsCardNameForCheck;
    public static boolean documentPortalAvailableForCheck;
    public static boolean documentMobileAvailableForCheck;

    //Баннеры
    public static String bannersPageName = "Управление баннерами";
    public static String bannerCardPageName = "Карточка баннера ID:";
    public static String bannerName = "Наименование Баннера, с кол-вом знаков 70, созданный автотестом № " + nmbAutoTest;
    public static String firstLineName = "Автотест заполнения 1 строки";
    public static String secondLineName = "Автотест заполнения 2 строки";
    public static String notificationBannerSave = "Баннер \"" + bannerName + "\" успешно сохранен.";

    //Логотип
    public static String logoPageName = "Управление логотипом";
    public static String logoWindowName = "Редактирование варианта логотипа";
    public static String logoName = "Наименование Логотипа созданного автотестом " + nmbAutoTest;

    //Общее
    public static String contentCreationDate;
    public static String contentCreationDateInCard;
    public static String contentUnPublicDate;
    public static String contentDeleteDate;
    public static String stateCreate = "Создано";
    public static String statePublic = "Размещено";
    public static String stateDelete = "Удалено";
    public static String stateUnPublic = "Снято с публикации";
    public static boolean contentPortalAvailable;
    public static boolean contentMobileAvailable;
    public static boolean contentLocationAvailable;
    public static String waitSearch(List<WebElement> a) {
        String waitSearch = ((RemoteWebElement) a.get(0)).getId();
        return waitSearch;
    }

}


