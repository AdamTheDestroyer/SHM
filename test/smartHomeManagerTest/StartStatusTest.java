package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.StartStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class StartStatusTest {
	/**
	 * Run the StartStatus(double) constructor test.
	 */
	@Test
	public void testStartStatus_1()
		throws Exception {
		double startStatus = 1.0;
		StartStatus result = new StartStatus(startStatus);
		assertNotNull(result);
		assertEquals(1.0, result.getStatus(), 1.0);
		assertEquals("\n\t\t\tDer Start-Status ist: 1.0", result.getChangeText());
	}

	/**
	 * Run the String getChangeText() method test.
	 */
	@Test
	public void testGetChangeText_1()
		throws Exception {
		StartStatus fixture = new StartStatus(1.0);
		String result = fixture.getChangeText();
		assertEquals("\n\t\t\tDer Start-Status ist: 1.0", result);
	}

	/**
	 * Run the double getStatus() method test.
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		StartStatus startStatus = new StartStatus(1.0);
		double result = startStatus.getStatus();
		assertEquals(1.0, result, 0.1);
	}
}