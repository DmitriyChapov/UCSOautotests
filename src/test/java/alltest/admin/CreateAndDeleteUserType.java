package alltest.admin;

import login.main.reference_books.user_type.UserTypePage;
import org.junit.Test;

public class CreateAndDeleteUserType extends UserTypePage {
    @Test
    public void testCreateAndDeleteUsersType() throws InterruptedException {
        deleteUserType();
        Thread.sleep(2000);
    }
}
