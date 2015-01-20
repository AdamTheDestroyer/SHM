package smartHomeManagerTest;
import org.junit.Test;
import smartHomeManager.StartSmartHome;

import static org.junit.Assert.assertNotNull;

public class StartSmartHomeTest {

	@Test
	public void testGenerateSmartHome() throws Exception {
		StartSmartHome startSmartHome= new StartSmartHome();
		assertNotNull("Test ob Startobjekt funktioniert", startSmartHome);
	}

}
