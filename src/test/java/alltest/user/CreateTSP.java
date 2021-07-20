package alltest.user;

import org.junit.Test;

import static variables.Urls.*;

public class CreateTSP extends login.user_portal.CreateTSP {

    @Test
    public void testCreateTSP() throws InterruptedException {
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
