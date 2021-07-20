package alltest.admin;

import login.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Test;

public class PublicInterview extends InterviewsPage {
    @Test
    public void testPublicInterview() throws InterruptedException {
        publicInterview();
        Thread.sleep(2000);
    }
}
