package alltest.admin;

import code.main.tsp.TSPPage;
import org.junit.Test;

public class CreateTSP_Promotion_Discount extends TSPPage {

    @Test
    public void testCreateTSP() {
        createAndCheckTSP();
        createAndCheckPromotion();
        createAndCheckDiscount();
    }
}
