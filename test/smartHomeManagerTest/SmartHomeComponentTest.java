package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.SmartHomeComponentIF;
import smartHomeManager.SmartHomeDevice;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class SmartHomeComponentTest {
	/**
	 * Run the void add(SmartHomeComponentIF) method test.
	 */
	@Test
	public void testAdd_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("", "", "", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		SmartHomeComponentIF shcIF = new SmartHomeDevice("", "", "", 1.0);
		smartHomeDevice.add(shcIF);
        assertEquals(2,smartHomeDevice.getArraylist().size(),0);
	}

	/**
	 * Run the ArrayList<SmartHomeComponentIF> getArraylist() method test.
	 */
	@Test
	public void testGetArraylist_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("", "", "", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		ArrayList<SmartHomeComponentIF> result = smartHomeDevice.getArraylist();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the String getComponentArt() method test.
	 */
	@Test
	public void testGetComponentArt_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("", "testString", "", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		String result = smartHomeDevice.getComponentArt();
		assertEquals("testString", result);
	}

	/**
	 * Run the String getDescription() method test.
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("", "", "testString", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		String result = smartHomeDevice.getDescription();
		assertEquals("testString", result);
	}

	/**
	 * Run the String getName() method test.
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("testString", "", "", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		String result = smartHomeDevice.getName();
		assertEquals("testString", result);
	}

	/**
	 * Run the double getStatus() method test.
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		SmartHomeDevice smartHomeDevice = new SmartHomeDevice("", "", "", 1.0);
		smartHomeDevice.add(new SmartHomeDevice("", "", "", 1.0));
		double result = smartHomeDevice.getStatus();
		assertEquals(1.0, result, 0.0);
	}
}