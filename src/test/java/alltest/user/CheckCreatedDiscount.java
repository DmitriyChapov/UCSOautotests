package alltest.user;

import org.junit.Test;

import java.text.ParseException;

public class CheckCreatedDiscount extends login.user_portal.discounts.CheckCreatedDiscount {

    @Test
    public void testCheckCreatedDiscount() {
        CreateAndCheckTSP();           // Создаем ТСП
        CreateAndCheckDiscount();      // Создаем и публикуем Скидку
        loginPortal();                 // Авторизация на портале
        openDiscountsAndPromotions();  // Открываем подраздел 'Акции'
        findCreatedDiscount();         // Поиск созданной скидки
        checkOpenedDiscount();         // Проверка созданной скидки
    }
}
