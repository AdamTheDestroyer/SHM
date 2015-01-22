package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeDevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adambo
 */
public class SmartHomeDeviceTest {
	/**
	 * Run the SmartHomeDevice(String,String,String,double) constructor test.
	 */
	@Test
	public void testSmartHomeDevice_1()
		throws Exception {
		String name = "AdamK";
		String componentArt = "Strongman";
		String description = "Groß und stark";
		double status = 1.0;
		SmartHomeDevice result = new SmartHomeDevice(name, componentArt, description, status);
		assertNotNull(result);
		assertEquals("AdamK", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Groß und stark", result.getDescription());
		assertEquals("Strongman", result.getComponentArt());
	}
}