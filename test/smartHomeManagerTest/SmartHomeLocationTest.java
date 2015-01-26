package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeLocation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class SmartHomeLocationTest {
	/**
	 * Run the SmartHomeLocation(String,String,String,double,String) constructor test.
	 */
	@Test
	public void testSmartHomeLocation_1()
		throws Exception {
		String name = "Panic Room";
		String componentArt = "Schutzraum";
		String description = "Hier schließt man sich ein, falls Einbrecher im Haus sind";
		double status = 1.0;
		String ortzugehoerigkeit = "VHS";
		SmartHomeLocation result = new SmartHomeLocation(name, componentArt, description, status, ortzugehoerigkeit);
		assertNotNull(result);
		assertEquals("Panic Room", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Hier schließt man sich ein, falls Einbrecher im Haus sind", result.getDescription());
		assertEquals("Schutzraum", result.getComponentArt());
	}
}