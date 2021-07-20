package alltest.admin;

import login.main.guidelines_and_regulations.GuidelinesAndRegulations;
import org.junit.Test;

public class CreateAndDeleteDocument extends GuidelinesAndRegulations {

    @Test
    public void testCreateAndDeleteDocument() {
        loginAdmin();                                 // Авторизация под пользователем с правами "Администратор"
        sectionGuidelinesAndRegulations();            // Переход в раздел "Руководства и регламенты"
        openDocumentCard();                           // Открываем карточку Документа
        createDocument();                             // Создаем Документ
        checkDocumentCard();                          // Проверяем заполненность карточки Документа
        deleteDocument();                             // Удаляем Документ
    }
}
