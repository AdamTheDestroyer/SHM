package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeSettingType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class SmartHomeSettingTypeTest {
	/**
	 * Run the SmartHomeSettingType(String,String,String,double,boolean) constructor test.
	 */
	@Test
	public void testSmartHomeSettingType_1()
		throws Exception {
		String name = "Sauerstoffturbine";
		String componentArt = "Sauerstoffmaschine";
		String description = "Spendet frischen Sauerstoff";
		double status = 1.0;
		boolean kindersicherung = true;

		SmartHomeSettingType result = new SmartHomeSettingType(name, componentArt, description, status, kindersicherung);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Sauerstoffturbine", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Spendet frischen Sauerstoff", result.getDescription());
		assertEquals("Sauerstoffmaschine", result.getComponentArt());
	}
}