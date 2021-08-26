package alltest.admin.registries;

import code.main.registers.electronic_cases_registry.ElectronicCasesRegistryPage;
import org.junit.Test;

public class OpenElectronicCasesRegistry extends ElectronicCasesRegistryPage {

    @Test
    public void testOpenElectronicCasesRegistry() {
        loginAdmin();
        sectionRegistersElectronicCases();
    }
}
