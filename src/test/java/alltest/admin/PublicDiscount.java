package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Test;

import static variables.admin.Strings.tspNameAdmin;

public class PublicDiscount extends TSPPage {

    @Test
    public void testPublicDiscount() throws InterruptedException {
        openTSPCard(tspNameAdmin);
        publicDiscount();
        compareDiscount();
    }
}
