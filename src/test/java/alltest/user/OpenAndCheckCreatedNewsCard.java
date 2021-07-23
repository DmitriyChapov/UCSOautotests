package alltest.user;

import login.Login;
import login.main.administration.content.news.NewsPage;
import login.main.administration.content.news.NewsPage.*;
import org.junit.Test;

public class OpenAndCheckCreatedNewsCard extends login.user_portal.OpenAndCheckCreatedNewsCard {

    @Test
    public void testNewsCard() throws InterruptedException{
        createAndPublicNews();
        loginPortal();
        userMainPageToNews();
        getUserNews();
        openCreatedNewsCard();
    }


}