package alltest.user;

import org.junit.Test;

public class CheckCreatedUserTSP extends code.user_portal.cabinetTSP.CreateTSP {

    @Test
    public void testCheckCreatedUserTSP() throws InterruptedException {
        openPartnersPage();
        Thread.sleep(1000);
        createTSPofUser();
        Thread.sleep(2000);
        tspUserAvailable();
        Thread.sleep(2000);
        tspUserOpenCabinet();
        Thread.sleep(2000);
        tspUserAddPromotion();
        Thread.sleep(2000);
        tspUserAddDiscount();
    }






}
