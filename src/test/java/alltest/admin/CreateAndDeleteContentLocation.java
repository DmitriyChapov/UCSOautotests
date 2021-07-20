package alltest.admin;

import login.main.reference_books.content_location.ContentLocationPage;
import org.junit.Test;

public class CreateAndDeleteContentLocation extends ContentLocationPage {
    @Test
    public void testCreateAndDeleteContentLocations() {
        loginAdmin();                 // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();      // Переход в раздел "Справочники"
        subSectionContentLocations(); // Переход в подраздел "Локации контента", раздела "Справочники"
        createContentLocations();     // Создаем Локации контента
        checkContentLocations();      // Проверяем созданные Локации контента
        deleteContentLocations();     // Удаляем Локации контента
    }
}
