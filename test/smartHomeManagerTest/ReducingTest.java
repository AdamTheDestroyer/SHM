package smartHomeManagerTest;

import org.junit.Before;
import org.junit.Test;
import smartHomeManager.Change;
import smartHomeManager.Reducing;
import smartHomeManager.StartStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class ReducingTest {
	/**
	 * Run the Reducing(Change,double) constructor test.
	 */
	@Test
	public void testReducing_1()
		throws Exception {
		Change change = new Reducing(new StartStatus(1.0), 1.0);
		double reducingRate = 1.0;

		Reducing result = new Reducing(change, reducingRate);
		assertNotNull(result);
		assertEquals(1.0, result.getStatus(), 0.0);
		assertEquals("\n\t\t\tDer Start-Status ist: 1.0\n\t\t\tDer Status ändert sich nicht, da Start-Status und Ziel-Status identisch sind\n\t\t\tDer Status ändert sich nicht, da Start-Status und Ziel-Status identisch sind", result.getChangeText());
	}

	/**
	 * Run the String getChangeText() method test.
	 */
	@Test
	public void testGetChangeText_1()
		throws Exception {
		Reducing reducing = new Reducing(new StartStatus(1.0), 1.0);
		String result = reducing.getChangeText();
		assertEquals("\n\t\t\tDer Start-Status ist: 1.0\n\t\t\tDer Status ändert sich nicht, da Start-Status und Ziel-Status identisch sind", result);
	}

	/**
	 * Run the String getChangeText() method test.
	 */
	@Test
	public void testGetChangeText_2()
		throws Exception {
		Reducing reducing = new Reducing(new StartStatus(1.0), 0.0);
		String result = reducing.getChangeText();
		assertEquals("\n\t\t\tDer Start-Status ist: 1.0\n\t\t\tDer Status nach der Änderung ist: 0.0", result);
	}

	/**
	 * Run the double getStatus() method test.
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		Reducing reducing = new Reducing(new StartStatus(1.0), 1.0);
		double result = reducing.getStatus();
		assertEquals(1.0, result, 0.1);
	}

}