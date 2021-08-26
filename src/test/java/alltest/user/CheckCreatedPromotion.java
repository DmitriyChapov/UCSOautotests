package alltest.user;

import org.junit.Test;


public class CheckCreatedPromotion extends code.user_portal.promotions.CheckCreatedPromotion {

    @Test
    public void testCheckCreatedPromotion()  {
        createAndCheckTSP();            // Создаем ТСП
        createAndCheckPromotion();      // Создаем и публикуем Акцию
        loginPortal();                  // Авторизация на портале
        openDiscountsAndPromotions();   // Открытие раздела 'Скидки и Акции'
        openPromotions();               // Открытие раздела 'Скидки и Акции'
        findCreatedPromotion();         // Поиск созданной Акции
        checkOpenedPromotion();         // Проверка созданной Акции
    }


}
