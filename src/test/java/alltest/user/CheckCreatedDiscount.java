package alltest.user;

import org.junit.Test;

import java.text.ParseException;

public class CheckCreatedDiscount extends login.user_portal.discounts.CheckCreatedDiscount {

    @Test
    public void testCreatedDiscount() throws ParseException {
        loginAdmin();   // Авторизация под пользователем с правами "Администратор"
        sectionTSP();   // Переход в раздел "Торгово-сервисные предприятия"
        sectionCreationTSP();   // Создание и заполнение ТСП
        compareTSP();   // Проверка правильности заполнения ТСП
        publicDiscount();  // Создание скидки
        compareDiscount();  //Проверка правильности заполнения скидки
        loginPortal();  //Авторизация на портале
        openDiscountsAndPromotions(); //Открытие раздела 'Скидки и Акции'
        findCreatedDiscount();  //Поиск созданной скидки
        checkOpenedDiscount();  //Проверка созданной скидки
    }
}
