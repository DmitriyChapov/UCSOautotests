package alltest.admin;

import login.main.reference_books.tags.TagsPage;
import org.junit.Test;

public class CreateAndDeleteTag extends TagsPage {
    @Test
    public void testCreateAndDeleteTag() throws InterruptedException {
        deleteTag();
        Thread.sleep(2000);
    }
}
