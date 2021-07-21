package alltest.admin.reference_books;

import login.main.reference_books.structural_subdivisions.StructuralSubdivisionsPage;
import org.junit.Test;

public class CreateAndDeleteStructuralSubdivision extends StructuralSubdivisionsPage {
    @Test
    public void testCreateAndDeleteStructuralSubdivision() {
        loginAdmin();                            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                 // Переход в раздел "Справочники"
        subSectionStructuralSubdivisions();      // Переход в подраздел "Структурные подразделения", раздела "Справочники"
        openStructuralSubdivisionCard();         // Открываем карточку Структурное подразделение
        createStructuralSubdivision();           // Создаем Структурное подразделение
        checkStructuralSubdivisionCard();        // Проверяем заполненность карточки Структурного подразделения
        deleteStructuralSubdivision();           // Удаляем Структурное подразделение
    }
}
