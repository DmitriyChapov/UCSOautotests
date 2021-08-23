package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Before;
import org.junit.Test;

public class CreateTSP_Promotion_Discount extends TSPPage {

    @Test
    public void testCreateTSP() {
        CreateAndCheckTSP();
        CreateAndCheckPromotion();
        CreateAndCheckDiscount();
    }
}
