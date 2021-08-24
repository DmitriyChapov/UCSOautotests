package alltest.user;

import org.junit.Test;

public class CheckCreatedPoster extends login.user_portal.posters.CreateAndPublicPoster {

    @Test
    public void testCheckCreatedPoster() {
        createAndPublicPoster();
        loginPortal();
        sectionPosters();
        getUserPosters();
        openCreatedPosterCard();
    }
}
