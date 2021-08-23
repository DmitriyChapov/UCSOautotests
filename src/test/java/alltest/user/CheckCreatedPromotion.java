package alltest.user;

import org.junit.Test;

import java.text.ParseException;


public class CheckCreatedPromotion extends login.user_portal.promotions.CheckCreatedPromotion {

    @Test
    public void testCheckCreatedPromotion()  {
        CreateAndCheckTSP();            // Создаем ТСП
        CreateAndCheckPromotion();      // Создаем и публикуем Акцию
        loginPortal();                  // Авторизация на портале
        openDiscountsAndPromotions();   // Открытие раздела 'Скидки и Акции'
        openPromotions();               // Открытие раздела 'Скидки и Акции'
        findCreatedPromotion();         // Поиск созданной Акции
        checkOpenedPromotion();         // Проверка созданной Акции
    }


}
