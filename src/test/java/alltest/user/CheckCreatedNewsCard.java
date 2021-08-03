package alltest.user;

//import login.user_portal.news.CheckCreatedNewsCard;
import org.junit.Test;

public class CheckCreatedNewsCard extends login.user_portal.news.CheckCreatedNewsCard {

    @Test
    public void testNewsCard() {
        createAndPublicNews();
        loginPortal();
        userMainPageToNews();
        getUserNews();
        openCreatedNewsCard();
    }

}