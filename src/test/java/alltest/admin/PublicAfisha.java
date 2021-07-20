package alltest.admin;

import login.main.administration.content.afisha.AfishaPage;
import org.junit.Test;

public class PublicAfisha extends AfishaPage {

    @Test
    public void testPublicAfisha() throws InterruptedException {
        publicAfisha();
        Thread.sleep(2000);
    }
}
