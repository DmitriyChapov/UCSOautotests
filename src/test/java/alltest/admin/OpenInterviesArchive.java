package alltest.admin;

import code.main.administration.interviews.archive.InterviewsArchivePage;
import org.junit.Test;

public class OpenInterviesArchive extends InterviewsArchivePage {
    @Test
    public void testOpenInterviewArchive() throws InterruptedException {
        sectionInterviewsArchive();
        Thread.sleep(2000);
    }
}
