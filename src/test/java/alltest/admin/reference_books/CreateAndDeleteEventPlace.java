package alltest.admin.reference_books;

import login.main.reference_books.event_places.EventPlacesPage;
import org.junit.Test;

public class CreateAndDeleteEventPlace extends EventPlacesPage {

    @Test
    public void testCreateAndDeleteEventPlace() {
        loginAdmin();                  // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();       // Переход в раздел "Справочники"
        subSectionEventPlaces();       // Переход в подраздел "Учреждения для проведения мероприятий", раздела "Справочники"
        openEventPlaceCard();          // Открываем карточку Учреждения для проведения мероприятий
        createEventPlace();            // Создаем Учреждение для проведения мероприятий
        checkEventPlaceCard();         // Проверяем заполненность карточки Учреждения для проведения мероприятий
        deleteEventPlace();            // Удаляем Учреждение для проведения мероприятий

    }
}
