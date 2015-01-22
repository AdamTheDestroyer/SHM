package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeLocation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adambo
 */
public class SmartHomeLocationTest {
	/**
	 * Run the SmartHomeLocation(String,String,String,double,String) constructor test.
	 */
	@Test
	public void testSmartHomeLocation_1()
		throws Exception {
		String name = "Michaela Schaffrath";
		String componentArt = "erotisch";
		String description = "Erotikdarsteller in Altersteilzeit";
		double status = 1.0;
		String ortzugehoerigkeit = "VHS";
		SmartHomeLocation result = new SmartHomeLocation(name, componentArt, description, status, ortzugehoerigkeit);
		assertNotNull(result);
		assertEquals("Michaela Schaffrath", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Erotikdarsteller in Altersteilzeit", result.getDescription());
		assertEquals("erotisch", result.getComponentArt());
	}
}