package alltest.user;

import org.junit.Test;

public class CheckCreatedDiscount extends code.user_portal.discounts.CheckCreatedDiscount {

    @Test
    public void testCheckCreatedDiscount() {
        createAndCheckTSP();           // Создаем ТСП
        createAndCheckDiscount();      // Создаем и публикуем Скидку
        loginPortal();                 // Авторизация на портале
        openDiscountsAndPromotions();  // Открываем подраздел 'Акции'
        findCreatedDiscount();         // Поиск созданной скидки
        checkOpenedDiscount();         // Проверка созданной скидки
    }
}
