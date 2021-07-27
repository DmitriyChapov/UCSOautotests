package variables.admin;

import static variables.admin.Numbers.*;
import static variables.admin.Selector.*;
import static variables.admin.Xpath.xpathNotifier;
import static variables.common.Numbers.*;

public class Strings {

    //Авторизация
    public static String loginInUser = "AutoTest";
    public static String passwordInUser = "123QWEqwe";

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
    public static String newsAnnouncement = "Анонс новости, созданной автотестом. Этот анонс содержит максимальное количество знаков, равное 150 символов. Номер генерируется рандомно и равен " + nmbAutoTest;
    public static String newsText = "Текст новости, созданной автотестом номер " + nmbAutoTest + ". ";
    public static String newsCardSaveNotification = "Публикация \"" + newsHeading + "\" успешно сохранена";
    public static String newsCardPublicNotification = "Карточка новости \"" + newsHeading + "\" успешно опубликована";

    public static String posterHeading = "Заголовок афиши, созданной автотестом. Заголовок содержит максимальное количество знаков равное 150 символов. Номер генерируется рандомно и равен " + nmbAutoTest;
    public static String posterAnnouncement = "Анонс афиши, созданной автотестом. Анонс афиши содержит максимальное количество знаков равное 150 символов. Номер генерируется рандомно и равен № " + nmbAutoTest;
    public static String posterText = "Текст афиши, созданной автотестом номер " + nmbAutoTest + ". ";
    public static String posterDate = "C 1 по 8 марта, начало в 19:00";
    public static String posterLocation = "Локация для автотеста";
    public static String posterCost = "Бесплатно";
    public static String newsCardId;
    public static String newsCardCategory;
    public static String posterCardId;
    public static String posterCategory;

    //Опросы
    public static String interviewHeading = "Заголовок свежего опроса, созданного автотестом. В опросе присутствуют все типы вопросов и они необязательные номер " + nmbAutoTest;
    public static String interviewDescription = "Краткое описание опроса, созданного автотестом № " + nmbAutoTest + ". В данном опросе присутствуют вопросы с типом: Короткий ответ, Длинный ответ, Один вариант, Несколько вариантов, Выпадающий список, Шкала, Загрузка файла, Текст";
    public static String questionShortNumberName = "Вопрос \"Короткий ответ\" - Числовая форма";
    public static String questionShortNumberDescription = "Максимальное кол-во символов: " + maxSymbolShortNumber;
    public static String questionShortDoubleName = "Вопрос \"Короткий ответ\" - Дробные числа";
    public static String questionShortDoubleDescription = "Максимальное кол-во символов: " + maxSymbolShortDouble;
    public static String questionShortPhoneName = "Вопрос \"Короткий ответ\" - Формат телефона";
    public static String questionShortPhoneDescription = "Кол-во символов: 11";
    public static String questionShortSymbolName = "Вопрос \"Короткий ответ\" - Кириллические символы";
    public static String questionShortSymbolDescription = "Максимальное кол-во символов: " + maxSymbolShortSymbol;
    public static String questionShortNoValidName = "Вопрос \"Короткий ответ\" - Без валидации";
    public static String questionShortNoValidDescription = "Максимальное кол-во символов: " + maxSymbolShortNoValid;
    public static String questionLongName = "Вопрос \"Длинный ответ\"";
    public static String questionLongDescription = "Максимальное кол-во символов: " + maxSymbolLong;
    public static String questionOneVarName = "Вопрос \"Один вариант\"";
    public static String questionOneVarDescription = "Кол-во вариантов ответа: " + nmbOneVar;
    public static String questionSomeVarName = "Вопрос \"Несколько вариантов\"";
    public static String questionSomeVarDescription = "Кол-во вариантов ответа: " + nmbSomeVar;
    public static String questionDropDownName = "Вопрос \"Выпадающий список\"";
    public static String questionDropDownDescription = "Кол-во вариантов ответа: " + nmbDropDown;
    public static String questionScaleName = "Вопрос \"Шкала\"";
    public static String questionScaleDescription = "Кол-во делений: ";
    public static String questionDownloadJPEGName = "Вопрос \"Загрузка файла\" - JPEG";
    public static String questionDownloadJPEGDescription = "Допустимый формат загружаемый файлов - JPEG, JPG. Максимальное кол-во файлов: " + maxFilesJPEG;
    public static String questionDownloadPNGName = "Вопрос \"Загрузка файла\" - PNG";
    public static String questionDownloadPNGDescription = "Допустимый формат загружаемый файлов - PNG. Максимальное кол-во файлов: " + maxFilesPNG;
    public static String questionDownloadPDFName = "Вопрос \"Загрузка файла\" - PDF";
    public static String questionDownloadPDFDescription = "Допустимый формат загружаемый файлов - PDF. Максимальное кол-во файлов: " + maxFilesPDF;
    public static String questionDownloadDOCName = "Вопрос \"Загрузка файла\" - DOC";
    public static String questionDownloadDOCDescription = "Допустимый формат загружаемый файлов - DOC, DOCX, ODT, RTF. Максимальное кол-во файлов: " + maxFilesDOC;
    public static String questionDownloadXLSName = "Вопрос \"Загрузка файла\" - XLS";
    public static String questionDownloadXLSDescription = "Допустимый формат загружаемый файлов - XLS, XLSX. Максимальное кол-во файлов: " + maxFilesXLS;
    public static String questionDownloadALLName = "Вопрос \"Загрузка файла\" - Все типы";
    public static String questionDownloadALLDescription = "Допустимый формат загружаемый файлов - JPG, JPEG,PNG, PDF, DOC, DOCX, ODT, RTF, XLS, XLSX. Максимальное кол-во файлов: " + maxFilesALL;
    public static String questionTextName = "Вопрос \"Текст.\" ";
    public static String questionTextDescription = "Просто текст";

    //ТСП, Скидки, Акции
    public static String tspNameAdmin = "AutoTest Сorporation";

    public static String promotionName = "Наименование Акции, с кол-вом символов 70, созданной автотестом № " + nmbAutoTest;
    public static String descriptionAndConditionPromotion = "Описание и условия действия акции , созданной автотестом № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForPromotionAdmin + ". ";
    public static String discountName = "Наименование Скидки с кол-вом символов 70, созданной автотестом № " + nmbAutoTest;
    public static String descriptionAndConditionDiscount = "Описание и условия действия скидки , созданной автотестом № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForDiscountAdmin + ". ";
    public static String discount = nmbDiscountAdmin + "%";

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
    public static String notificationBannerSave = "Баннер \"" + bannerName + "\" успешно сохранен";

    //Логотип
    public static String logoPageName = "Управление логотипом";
    public static String logoWindowName = "Редактирование варианта логотипа";
    public static String logoName = "Наименование Логотипа созданного автотестом " + nmbAutoTest;

}


