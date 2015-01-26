package smartHomeManagerTest;

import org.junit.Ignore;
import org.junit.Test;
import smartHomeManager.Change;
import smartHomeManager.EntertainmentStrategy;
import smartHomeManager.SmartHomeComponent;
import smartHomeManager.SmartHomeDevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class EntertainmentStrategyTest {
	/**
	 * Run the EntertainmentStrategy(String) constructor test.
	 */
	@Test
	public void testEntertainmentStrategy_1()
		throws Exception {
		String ort = "Wohnzimmer";
		EntertainmentStrategy entertainmentStrategy = new EntertainmentStrategy(ort);
		assertNotNull(entertainmentStrategy);
        assertEquals(ort,entertainmentStrategy.getOrt());
        assertEquals(null, entertainmentStrategy.getChange());
	}

    /**
     * Run the Change getChange() method test.
     */
    @Test
    public void testGetChange_1()
            throws Exception {
        EntertainmentStrategy entertainmentStrategy = new EntertainmentStrategy("");
        entertainmentStrategy.smartHomeComponentIterator1 = null;
        Change result = entertainmentStrategy.getChange();
        assertEquals(null, result);
    }

    /**
     * Run the String getOrt() method test.
     */
    @Test
    public void testGetOrt_1()
            throws Exception {
        EntertainmentStrategy entertainmentStrategy = new EntertainmentStrategy("Bad");
        entertainmentStrategy.smartHomeComponentIterator1 = null;
        String result = entertainmentStrategy.getOrt();
        assertEquals("Bad", result);
    }

	/**
	 * Run the void execute(SmartHomeComponent) method test.
	 */
	@Test
	public void testExecute_1()
		throws Exception {
		EntertainmentStrategy entertainmentStrategy = new EntertainmentStrategy("");
		SmartHomeComponent shc = new SmartHomeDevice("", "", "", 1.0);
		entertainmentStrategy.execute(shc);
	}

}