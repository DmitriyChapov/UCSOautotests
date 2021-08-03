package alltest.user;

import org.junit.Test;

public class CreateAndPublicPoster extends login.user_portal.posters.CreateAndPublicPoster {

    @Test
    public void testPosterCard() {
        publicPoster();
        loginPortal();
        userToPosterCard();
        getUserPosters();
        openCreatedPosterCard();
    }
}
