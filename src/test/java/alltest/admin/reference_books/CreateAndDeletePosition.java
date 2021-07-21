package alltest.admin.reference_books;

import login.main.reference_books.position.PositionsPage;
import org.junit.Test;

public class CreateAndDeletePosition extends PositionsPage {

    @Test
    public void testCreateAndDeletePosition() {
        loginAdmin();               // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();    // Переход в раздел "Справочники"
        subSectionPositions();      // Переход в подраздел "Должности", раздела "Справочники"
        openPositionCard();         // Открываем карточку Должности
        createPosition();           // Создаем Должность
        checkPositionCard();        // Проверяем заполненность карточки Должности
        deletePosition();           // Удаляем Должность
    }
}
