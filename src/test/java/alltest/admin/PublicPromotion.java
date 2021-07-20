package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Test;

public class PublicPromotion extends TSPPage {

    @Test
    public void testPublicPromotion() throws InterruptedException {
        publicPromotion();
        Thread.sleep(2000);
    }
}
