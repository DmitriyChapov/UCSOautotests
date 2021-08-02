package alltest.admin;

import login.main.administration.content.afisha.PostersPage;
import org.junit.Test;

public class PublicPoster extends PostersPage {

    @Test
    public void testPublicPoster() {
        createAndPublicPoster();
    }
}
