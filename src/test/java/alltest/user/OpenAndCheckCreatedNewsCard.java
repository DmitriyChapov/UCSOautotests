package alltest.user;

import org.junit.Test;

public class OpenAndCheckCreatedNewsCard extends login.user_portal.news.OpenAndCheckCreatedNewsCard {

    @Test
    public void testNewsCard() {
        createAndPublicNews();
        loginPortal();
        userMainPageToNews();
        getUserNews();
        openCreatedNewsCard();
    }

}