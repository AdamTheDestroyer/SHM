package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeDevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class SmartHomeDeviceTest {
	/**
	 * Run the SmartHomeDevice(String,String,String,double) constructor test.
	 */
	@Test
	public void testSmartHomeDevice_1()
		throws Exception {
		String name = "Waschmaschine";
		String componentArt = "Device";
		String description = "Wäscht verdreckte Klamotten";
		double status = 1.0;
		SmartHomeDevice result = new SmartHomeDevice(name, componentArt, description, status);
		assertNotNull(result);
		assertEquals("Waschmaschine", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Wäscht verdreckte Klamotten", result.getDescription());
		assertEquals("Device", result.getComponentArt());
	}
}