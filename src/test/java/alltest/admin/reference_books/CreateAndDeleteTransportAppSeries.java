package alltest.admin.reference_books;

import login.main.reference_books.transport_app_series.TransportAppSeriesPage;
import org.junit.Test;

public class CreateAndDeleteTransportAppSeries extends TransportAppSeriesPage {
    @Test
    public void testCreateAndDeleteTransportAppSeries() {
        loginAdmin();                              // Авторизация под пользователем с правами "Администратор"
        sectionReferenceBooks();                   // Переход в раздел "Справочники"
        createDescriptionsTransportCard();         // Создаем Описание транспортной карты
        createUserType();                          // Создаем Тип пользователя
        createLocationTransportApp();              // Создаем Локацию транспортного приложения
        subSectionTransportAppSeries();            // Переход в подраздел "Серии транспортного приложения", раздела "Справочники"
        openTransportAppSeriesCard();              //Открываем карточку Серии транспортного приложения
        createTransportAppSeries();                // Создаем Серию транспортного приложения
        checkTransportAppSeriesCard();             // Проверяем заполненность карточки Серии транспортного приложения
        deleteTransportAppSeries();                // Удаляем Серию транспортного приложения
        deleteRelatedDirectories();                // Удаляем остальные задействованные атрибуты
    }
}
