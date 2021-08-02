package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Test;
import static variables.admin.Strings.*;

public class PublicPromotion extends TSPPage {

    @Test
    public void testPublicPromotion() {
        openTSPCard(tspNameAdmin);
        publicPromotion();
        comparePromotion();

    }
}
