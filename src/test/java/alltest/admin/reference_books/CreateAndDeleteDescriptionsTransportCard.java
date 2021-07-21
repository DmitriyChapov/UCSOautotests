package alltest.admin.reference_books;

import login.main.reference_books.description_transport_card.DescriptionTransportCardPage;
import org.junit.Test;

public class CreateAndDeleteDescriptionsTransportCard extends DescriptionTransportCardPage {

    @Test
    public void testCreateAndDeleteDescriptionsTransportCard() {
        loginAdmin();                                 // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                      // Переход в раздел "Справочники"
        subSectionDescriptionsTransportCard();        // Переход в подраздел "Описания транспортной карты", раздела "Справочники"
        openDescriptionsTransportCardCard();          // Открываем карточку Описания транспортной карты
        createDescriptionsTransportCard();            // Создаем Описание транспортной карты
        checkDescriptionsTransportCardCard();         // Проверяем заполненность карточки Описание транспортной карты
        deleteDescriptionsTransportCard();            // Удаляем Описание транспортной карты
    }
}
