package alltest.admin;

import login.main.site_settings.logo.LogoPage;
import org.junit.Test;

public class CreateAndDeleteLogo extends LogoPage {

    @Test
    public void testCreateAndDeleteLogo() {
        loginAdmin();            // Авторизация под пользователем с правами "Администратор"
        sectionSiteSettings();   // Переход в раздел "Настройки сайта"
        subsectionLogo();        // Переход в подраздел "Управление логотипом", раздела "Настройки сайта"
        openLogoWindow();        // Открываем окно создания логотипа
        createLogo();            // Создаем Логотип
        checkLogo();             // Проверяем заполненность Логотипа
        deleteLogo();            // Удаляем Логотип
    }
}
