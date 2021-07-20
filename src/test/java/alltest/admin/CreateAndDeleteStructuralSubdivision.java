package alltest.admin;

import login.main.reference_books.structural_subdivisions.StructuralSubdivisionsPage;
import org.junit.Test;

public class CreateAndDeleteStructuralSubdivision extends StructuralSubdivisionsPage {
    @Test
    public void testCreateAndDeleteStructuralSubdivision() throws InterruptedException {
        deleteStructuralSubdivision();
        Thread.sleep(2000);
    }
}
