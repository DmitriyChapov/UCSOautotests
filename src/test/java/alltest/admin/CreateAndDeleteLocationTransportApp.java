package alltest.admin;

import login.main.reference_books.location_transport_app.LocationTransportAppPage;
import org.junit.Test;

public class CreateAndDeleteLocationTransportApp extends LocationTransportAppPage {

    @Test
    public void testCreateAndDeleteLocationTransportApp() {
        loginAdmin();                            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                 // Переход в раздел "Справочники"
        subSectionLocationTransportApp();        // Переход в подраздел "Учреждения для проведения мероприятий", раздела "Справочники"
        openLocationTransportAppCard();          // Открываем карточку Учреждения для проведения мероприятий
        createLocationTransportApp();            // Создаем Учреждение для проведения мероприятий
        checkLocationTransportAppCard();         // Проверяем заполненность карточки Учреждения для проведения мероприятий
        deleteLocationTransportApp();            // Удаляем Учреждение для проведения мероприятий
    }
}
