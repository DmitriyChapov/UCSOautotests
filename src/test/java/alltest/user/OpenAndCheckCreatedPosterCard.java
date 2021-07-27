package alltest.user;

import org.junit.Test;

public class OpenAndCheckCreatedPosterCard extends login.user_portal.posters.OpenAndCheckCreatedPosterCard {

    @Test
    public void testPosterCard() throws InterruptedException {
        publicAfisha();
        loginPortal();
        userToPosterCard();
        getUserPosters();
        openCreatedPosterCard();
    }
}
