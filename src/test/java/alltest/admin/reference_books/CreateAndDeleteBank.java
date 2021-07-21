package alltest.admin.reference_books;

import login.main.reference_books.banks.BanksPage;
import org.junit.Test;

public class CreateAndDeleteBank extends BanksPage {

    @Test
    public void testCreateAndDeleteBank() {
        loginAdmin();            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks(); // Переход в раздел "Справочники"
        subSectionBanks();       // Переход в подраздел "Банки", раздела "Справочники"
        openBankCard();          // Открываем карточку Банка
        createBank();            // Создаем Банк
        createBranch();          // Создаем отделения банка
        tabDesignCreate();       // Создаем дизайны банковских карт
        checkBankCard();         // Проверяем заполненность карточки Банка
        deleteBank();            // Удаляем банк
    }
}
