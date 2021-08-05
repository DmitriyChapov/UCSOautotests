package alltest.user;

import org.junit.Test;

import java.text.ParseException;


public class CheckCreatedPromotion extends login.user_portal.promotions.CheckCreatedPromotion {

    @Test
    public void testCreatedPromotion() throws ParseException {
        loginAdmin(); // Авторизация под пользователем с правами "Администратор"
        sectionTSP(); // Переход в раздел "Торгово-сервисные предприятия"
        sectionCreationTSP(); // Создание и заполнение ТСП
        compareTSP(); // Проверка правильности заполнения ТСП
        publicPromotion(); // Создание акции
        comparePromotion();
        loginPortal(); //Авторизация на портале
        openDiscountsAndPromotions(); //Открытие раздела 'Скидки и Акции'
        openPromotions(); //Переход в подраздел 'Акции'
        findCreatedPromotion(); //Поиск созданной акции
        checkOpenedPromotion(); //Проверка созданной акции
    }


}
