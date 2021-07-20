package alltest.admin;

import login.main.reference_books.transport_app_series.TransportAppSeriesPage;
import org.junit.Test;

public class CreateAndDeleteTransportAppSeries extends TransportAppSeriesPage {
    @Test
    public void testCreateAndDeleteTransportAppSeries() throws InterruptedException {
        deleteTransportAppSeries();
        Thread.sleep(2000);
    }
}
