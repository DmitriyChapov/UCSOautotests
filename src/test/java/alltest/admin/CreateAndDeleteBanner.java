package alltest.admin;

import login.main.site_settings.banners.BannersPage;
import org.junit.Test;

public class CreateAndDeleteBanner extends BannersPage {

    @Test
    public void testCreateAndDeleteBanner() {
        loginAdmin();            // Авторизация под пользователем с правами "Администратор"
        sectionSiteSettings();   // Переход в раздел "Настройки сайта"
        subsectionBanners();     // Переход в подраздел "Баннеры", раздела "Настройки сайта"
        openBannerCard();        // Открываем карточку Баннера
        createBanner();          // Создаем Баннер
        checkBannerCard();       // Проверяем заполненность карточки Баннера
        deleteBanner();          // Удаляем Баннер
    }
}
