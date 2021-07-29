package variables.portal;

import org.openqa.selenium.By;

import static variables.admin.Strings.surveyId;

public class Selector {

    //Кабинет ТСП
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


    //Опросы
    public static By selectorCreatedSurveyHref = By.cssSelector("a[href = '#/info/polls/" + surveyId + "']");
}
