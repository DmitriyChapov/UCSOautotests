package alltest.admin.administration.Interviews;

import code.main.administration.interviews.interviews.InterviewsPage;
import org.junit.Test;

public class CreateAndDeleteInterview extends InterviewsPage {
    @Test
    public void testCreateAndDeleteInterview() {
        createAndDeleteInterview();
        clearCollections();
    }
}
