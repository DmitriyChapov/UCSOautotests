package alltest.admin;

import login.main.administration.content.news.NewsPage;
import org.junit.Test;

public class PublicNews extends NewsPage {

    @Test
    public void testPublicNews() throws InterruptedException {
        publicNews();
        Thread.sleep(2000);
    }
}
