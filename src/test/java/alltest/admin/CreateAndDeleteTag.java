package alltest.admin;

import login.main.reference_books.tags.TagsPage;
import org.junit.Test;

public class CreateAndDeleteTag extends TagsPage {
    @Test
    public void testCreateAndDeleteTag() {
        loginAdmin();               // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();    // Переход в раздел "Справочники"
        subSectionTags();           // Переход в подраздел "Теги рубрик", раздела "Справочники"
        openTagCard();              // Открываем карточку Тега рубрики
        createTag();                // Создаем Тег рубрики
        checkTagCard();             // Проверяем заполненность карточки Тега рубрики
        deleteTag();                // Удаляем Тег рубрики
    }
}
