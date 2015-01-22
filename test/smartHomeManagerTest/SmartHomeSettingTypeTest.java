package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeSettingType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adambo
 */
public class SmartHomeSettingTypeTest {
	/**
	 * Run the SmartHomeSettingType(String,String,String,double,boolean) constructor test.
	 */
	@Test
	public void testSmartHomeSettingType_1()
		throws Exception {
		String name = "mickey mouse";
		String componentArt = "zeichentrick";
		String description = "Disney-Trickfilm-Figur";
		double status = 1.0;
		boolean kindersicherung = true;

		SmartHomeSettingType result = new SmartHomeSettingType(name, componentArt, description, status, kindersicherung);

		// add additional test code here
		assertNotNull(result);
		assertEquals("mickey mouse", result.getName());
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("Disney-Trickfilm-Figur", result.getDescription());
		assertEquals("zeichentrick", result.getComponentArt());
	}
}