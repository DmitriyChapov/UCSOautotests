package alltest.admin.reference_books;

import login.main.reference_books.location_transport_app.LocationTransportAppPage;
import org.junit.Test;

public class CreateAndDeleteLocationTransportApp extends LocationTransportAppPage {

    @Test
    public void testCreateAndDeleteLocationTransportApp() {
        loginAdmin();                            // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                 // Переход в раздел "Справочники"
        subSectionLocationTransportApp();        // Переход в подраздел "Локации транспортного приложения", раздела "Справочники"
        openLocationTransportAppCard();          // Открываем карточку Локация транспортного приложения
        createLocationTransportApp();            // Создаем Локацию транспортного приложения
        checkLocationTransportAppCard();         // Проверяем заполненность карточки Локации транспортного приложения
        deleteLocationTransportApp();            // Удаляем Локацию транспортного приложения
    }
}
