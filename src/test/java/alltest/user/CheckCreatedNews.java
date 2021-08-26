package alltest.user;

import org.junit.Test;

public class CheckCreatedNews extends code.user_portal.news.CheckCreatedNewsCard {

    @Test
    public void testCheckCreatedNews() {
        publicAndUnPublicNews();
        loginPortal();
        sectionNews();
        getUserNews();
        checkNewsInSection();
        checkOpenedNews();
    }

}