package alltest.admin;

import login.main.registers.card_holders_registry.CardHoldersRegistryPage;
import org.junit.Test;

public class OpenCardHoldersRegistry extends CardHoldersRegistryPage {

    @Test
    public void testOpenCardHoldersRegistry() {
        loginAdmin();
        sectionCardHoldersRegisters();
    }
}
