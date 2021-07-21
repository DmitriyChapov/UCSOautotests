package alltest.admin.reference_books;

import login.main.reference_books.mss_codes.MSS_codesPage;
import org.junit.Test;

public class CreateAndDeleteMSSCode extends MSS_codesPage {
    @Test
    public void testCreateAndDeleteMSSCode() {
        loginAdmin();               // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();    // Переход в раздел "Справочники"
        subSectionMSSCodes();       // Переход в подраздел "МСС-коды", раздела "Справочники"
        openMSSCodeCard();          // Открываем карточку МСС-кода
        createMSSCode();            // Создаем МСС-код
        checkMSSCodeCard();         // Проверяем заполненность карточки МСС-кода
        deleteMSSCode();            // Удаляем МСС-код
    }
}
