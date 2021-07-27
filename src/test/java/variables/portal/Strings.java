package variables.portal;

import static variables.portal.Numbers.*;
import static variables.common.Numbers.*;

public class Strings {

    //Авторизация
    public static String loginOutUser = "00000060021";
    public static String passwordOutUser = "11111111";

    //Кабинет ТСП
    public static String email = "mailfortestpetrov@yandex.ru";
    public static String mss_code = "9999";
    public static String userTSPName = "Новая организация, созданная автотестом из Личного кабинета пользователя";
    public static String userTSPDescription = "Описание организации, созданной автотестом из Личного кабинета пользователя";
    public static String userTSPAddress = "г. Автотестово, ул. Пользователя, д. " + nmbAutoTest;
    public static String userTSPEmailPublic = "Email@email.com";
    public static String userTSPPhonePublic = "89270000000";
    public static String userTSPOptionalText = "Дополнительная информация по ТСП, созданного пользователем. ";

    public static String userTSPPromotionName = "Наименование Акции, созданной внешним пользователем, автотест № " + nmbAutoTest;
    public static String userTSPDescriptionAndConditionPromotion = "Описание и условия действия акции, созданной внешним пользователем, автотест № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForPromotionPortal + ". ";
    public static String userTSPDiscountName = "Наименование Скидки, созданной внешним пользователем, автотест № " + nmbAutoTest;
    public static String userTSPDescriptionAndConditionDiscount = "Описание и условия действия скидки, созданной внешним пользователем, автотест № " + nmbAutoTest + " и кол-вом адресов предоставления: " + nmbAddressForDiscountPortal + ". ";
    public static String userTSPDiscount = nmbDiscountPortal + "%";
}
