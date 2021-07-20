package variables;

import org.openqa.selenium.By;

public class Selector {

    //Портал

    //Главная страница
    public static By selectorLogin = By.cssSelector("[name= 'login']");
    public static By selectorPassword =By.cssSelector("[name= 'password']");

    //ЛК ТСП
    public static By selectorUserTSPName = By.cssSelector("[name = 'name']");
    public static By selectorUserTSPDescription = By.cssSelector("[name = 'description']");
    public static By selectorUserTSPAddress = By.cssSelector("[name = 'address']");
    public static By selectorUserTSPLogo = By.cssSelector("[name = '#logo']");
    public static By selectorUserTSPOGRN = By.cssSelector("[name = 'ogrn']");
    public static By selectorUserTSPEmail = By.cssSelector("[name = 'email']");
    public static By selectorUserTSPMSS_code = By.cssSelector("[name = '#classifiers']");
    public static By selectorUserTSPWebPublic = By.cssSelector("[name = 'contacts.webSite']");
    public static By selectorUserTSPEmailPublic = By.cssSelector("[name = 'contacts.contactEmail']");
    public static By selectorUserTSPPhonePublic = By.cssSelector("[name = 'contacts.phone']");
    public static By selectorUserTSPVK = By.cssSelector("[name = 'contacts.vk']");
    public static By selectorUserTSPFB = By.cssSelector("[name = 'contacts.fb']");
    public static By selectorUserTSPIG = By.cssSelector("[name = 'contacts.ig']");
    public static By selectorUserTSPOK = By.cssSelector("[name = 'contacts.ok']");
    public static By selectorUserTSPAdditional = By.cssSelector("[name = 'contacts.additional']");
    public static By selectorUserTSPButtonAddDiscount = By.cssSelector("[id = 'tsp-add-discount']");
    public static By selectorUserTSPButtonAddPromotion = By.cssSelector("[id = 'tsp-add-action']");
    public static By selectorUserTSPOfferName = By.cssSelector("[name = 'detailTitle']");
    public static By selectorUserTSPOfferFromDate = By.cssSelector("[name = 'fromDate']");
    public static By selectorUserTSPOfferToDate = By.cssSelector("[name = 'toDate']");
    public static By selectorUserTSPOfferDescription = By.cssSelector("[name = 'description']");
    public static By selectorUserTSPOfferImage = By.cssSelector("[name = '#image']");
    public static By TSPOfferAddress(int i) { By selectorUserTSPOfferAddress = By.cssSelector("[name = 'addresses" + "["+ i + "]']");
        return selectorUserTSPOfferAddress;
    }
    public static By selectorUserTSPOfferDiscount = By.cssSelector("[name = 'value']");
    public static By selectorUserTSPOfferButtonSave = By.cssSelector("[type = 'submit']");




    //Админка

    //Справочники
    public static By selectorFieldMSSCodeName = By.cssSelector("[name = 'classifierName']");
    public static By selectorFieldMSSCode = By.cssSelector("[name = 'classifierCod']");
    public static By selectorFieldBankName = By.cssSelector("[name = 'bankName']");
    public static By selectorFieldBankBic = By.cssSelector("[name = 'bankBic']");
    public static By selectorFieldBankAddress = By.cssSelector("[name = 'bankAddress']");
    public static By selectorBankAvailable = By.cssSelector("[name = 'bankAvailable']");
    public static By selectorFieldBranchName = By.cssSelector("[name = 'branchName']");
    public static By selectorFieldBranchNumber = By.cssSelector("[name = 'branchNumber']");
    public static By selectorFieldBranchWorkingHours = By.cssSelector("[name = 'workingHours']");
    public static By selectorFieldBranchAddress = By.cssSelector("[name = 'address']");
    public static By selectorFieldDesignCode = By.cssSelector("[name = 'code']");
    public static By selectorDesignAvailable = By.cssSelector("[name = 'cardAvailable']");
    public static By selectorFieldContentLocationName = By.cssSelector("[data-placeholder = 'Введите наименование']");
    public static By selectorSelectLocationTransportApp = By.cssSelector("[name = 'location']");
    public static By selectorSelectCardDescription = By.cssSelector("[name = 'cardDescription']");
    public static By selectorSelectSocialCode = By.cssSelector("[name = 'cardUserSocialCode']");
    public static By selectorSelectUserType = By.cssSelector("[name = 'cardUser']");
    public static By selectorEventPlacesSameAddress = By.cssSelector("[name = 'addressesSame']");

    //Новости и Афиши
    public static By selectorFieldAge = By.cssSelector("[name = 'ageRestrictions']");
    public static By selectorFieldEventDate = By.cssSelector("[name = 'eventTimePicker']");
    public static By selectorFieldEventLocation = By.cssSelector("[name = 'placeSelectorInput']");
    public static By selectorFieldEventCost = By.cssSelector("[name = 'costInput']");
    public static By selectorFieldEventShedule = By.cssSelector("[data-placeholder = 'Ссылка должна содержать \"http://\" или \"https://\"']");
    public static By selectorSelectTags = By.cssSelector("[name = 'postRubricsSelect']");

    //Опросы
    public static By selectorFieldInterviewHeading = By.cssSelector("[name = 'poll-name']");
    public static By selectorFieldInterviewDescription = By.cssSelector("[name = 'description']");
    public static By selectorFieldQuestion =  By.cssSelector("[name = 'question']");
    public static By selectorFieldQuestionDescription =  By.cssSelector("[name = 'questionDescription']");
    public static By selectorFieldAnswerMaxLength =  By.cssSelector("[name = 'answerMaxLength']");
    public static By selectorFieldAnswerMaxFiles = By.cssSelector("[name = 'filesToUploadMaxCount']");
    public static By selectorSelectInterviewResults = By.cssSelector("[name = 'resultsAutoPublishMode']");
    public static By selectorSelectInterviewAccess = By.cssSelector("[name = 'accessModeInMobile']");
    public static By selectorSelectTypeQuestion = By.cssSelector("[name = 'type']");
    public static By selectorSelectValidationType = By.cssSelector("[name = 'answerValidationType']");

    //Скидки и Акции
    public static By selectorFieldAddressOffer = By.cssSelector("[name = 'addressName']");
    public static By selectorAddAddressOffer = By.cssSelector("[title = 'Добавить адрес']");
    public static By selectorFieldOfferDateFrom = By.cssSelector("[name = 'fromDatePicker']");
    public static By selectorFieldOfferDateTo = By.cssSelector("[name = 'toDatePicker']");
    public static By selectorFieldDiscount = By.cssSelector("[name = 'discountInput']");

    //Руководства и Регламенты
    public static By selectorDocumentPortal = By.cssSelector("[name = 'publishInMobile']");
    public static By selectorDocumentMobile = By.cssSelector("[name = 'publishInDesktop']");

    //Баннеры
    public static By selectorFieldBannerFirstLine = By.cssSelector("[name = 'first-string-text']");
    public static By selectorFieldBannerSecondLine = By.cssSelector("[name = 'second-string-text']");
    public static By selectorSelectBannerColor = By.cssSelector("[name = 'color']");
    public static By selectorFieldBannerColors = By.cssSelector("[class = 'mat-option-text']");

    //Логотип

    //Общие Поля
    public static By selectorFieldCodeOTK = By.cssSelector("[name = 'type']");
    public static By selectorFieldName = By.cssSelector("[name = 'name']");
    public static By selectorFieldEventPlacesActAddress = By.cssSelector("[name = 'actualAddress']");
    public static By selectorFieldContentTitle = By.cssSelector("[name = 'titleInput']");
    public static By selectorFieldContentTeaser = By.cssSelector("[name = 'teaserTextInput']");
    public static By selectorFieldContentText = By.cssSelector("[class = 'ace_text-input']");
    public static By timeFields = By.cssSelector("[type = 'time']");
    public static By selectorFieldImage = By.cssSelector("[name = 'fileInput']");
    public static By selectorFieldSearch = By.cssSelector("[name = 'search']");

    //Общие Иконки
    public static By selectorIconAddLocation = By.cssSelector("[title='Добавить локацию']");

    //Общие Чек-боксы
    public static By selectorAvailable = By.cssSelector("[name = 'available']");

    //Общие кнопки
    public static By selectorCloseWindow = By.cssSelector("[title = 'Закрыть диалог']");

    //Заголовки
    public static By headingReferenceBooks = By.className("main-nav__header");
    public static By headingBanks = By.className("banks__title");
    public static By headingPositionsPage = By.className("positions__title");
    public static By headingLocations = By.className("locations__title");
    public static By headingTags = By.className("rubrics__title");
    public static By headingContentsPage = By.className("news__title");
    public static By headingInterviewsPage = By.className("polls__title");
    public static By headingElectronicCasesPage = By.className("cases__title");
    public static By headingCardHoldersPage = By.className("cardholder-registry__title");
    public static By headingTSPPage = By.className("partners__title");
    public static By headingSettingsPage = By.className("settings__title");
    public static By headingLogoWindow = By.xpath("//app-logo-card//h2");

    //Общие заголовки
    public static By headingPage = By.className("series__title");
    public static By headingCard = By.className("card__title");
    public static By headingContentCard = By.className("content-card__title");
}
