package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Test;

public class PublicDiscount extends TSPPage {

    @Test
    public void testPublicDiscount() throws InterruptedException {
        publicDiscount();
        Thread.sleep(2000);
    }
}
