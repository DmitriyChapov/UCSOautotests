package alltest.user;

import org.junit.Test;

public class CheckCreatedPoster extends code.user_portal.posters.CreateAndPublicPoster {

    @Test
    public void testCheckCreatedPoster() {
        publicAndUnPublicPoster();
        loginPortal();
        sectionPosters();
        getUserPosters();
        checkPosterInSection();
        checkOpenedPoster();
    }
}
