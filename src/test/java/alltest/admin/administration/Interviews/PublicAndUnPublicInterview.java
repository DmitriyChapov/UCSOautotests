package alltest.admin.administration.Interviews;

import code.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Test;

public class PublicAndUnPublicInterview extends InterviewsPage {
    @Test
    public void testPublicInterview() {
            publicAndUnPublicInterview();
            clearCollections();
    }
}
