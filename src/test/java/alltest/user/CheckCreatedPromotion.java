package alltest.user;

import org.junit.Test;

import static variables.admin.Strings.*;

public class CheckCreatedPromotion extends login.user_portal.promotions.CheckCreatedPromotion {

    @Test
    public void testCreatedPromotion() {
        openTSPCard(tspNameAdmin);
        publicPromotion();
        loginPortal();
        openDiscountsAndPromotions();
        openPromotions();
        findCreatedPromotion();
        checkOpenedPromotion();
    }


}
