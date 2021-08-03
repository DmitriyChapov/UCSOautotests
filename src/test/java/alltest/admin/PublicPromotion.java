package alltest.admin;

import login.main.tsp.TSPPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static variables.admin.Strings.*;
import static variables.admin.Xpath.xpathSpinner;

public class PublicPromotion extends TSPPage {

    @Test
    public void testPublicPromotion() {
        openTSPCard(tspNameAdmin);
        publicPromotion();
        comparePromotion();

    }
}
