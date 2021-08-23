package alltest.user;

//import login.user_portal.news.CheckCreatedNewsCard;
import org.junit.Test;

public class CheckCreatedNews extends login.user_portal.news.CheckCreatedNewsCard {

    @Test
    public void testCheckCreatedNews() {
        createAndPublicNews();
        loginPortal();
        userMainPageToNews();
        getUserNews();
        openCreatedNewsCard();
    }

}