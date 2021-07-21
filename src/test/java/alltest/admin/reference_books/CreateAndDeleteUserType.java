package alltest.admin.reference_books;

import login.main.reference_books.user_type.UserTypePage;
import org.junit.Test;

public class CreateAndDeleteUserType extends UserTypePage {
    @Test
    public void testCreateAndDeleteUsersType() {
        loginAdmin();                // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();     // Переход в раздел "Справочники"
        subSectionUsersType();       // Переход в подраздел "Типы пользователей", раздела "Справочники"
        openUserTypeCard();          // Открываем карточку Типа пользователя
        createUserType();            // Создаем Тип пользователя
        checkUserTypeCard();         // Проверяем заполненность карточки Типа пользователя
        deleteUserType();            // Удаляем Тип пользователя
    }
}
