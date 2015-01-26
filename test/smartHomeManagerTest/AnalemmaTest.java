package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.Analemma;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Adambo
 */
public class AnalemmaTest {

	/**
	 * Run the Analemma() constructor test.
	 */
	@Test
	public void testAnalemma_1()
		throws Exception {
		Analemma result = new Analemma();
		assertNotNull(result);
	}

	/**
	 * Run the double dayLength(double,int,int,int) method test.
	 */
	@Test
	public void testDayLength_1()
		throws Exception {
		double latitude = 48.4833333;
		int year = 2015;
		int month = 1;
		int day = 21;
		double result = Analemma.dayLength(latitude, year, month, day);
		assertEquals(10.91294416379812, result, 0.1);
	}

	/**
	 * Run the Date getDate(int,int,int) method test.
	 */
	@Test
	public void testGetDate_1()
		throws Exception {
		int year = 2016;
		int month = 0;
		int day = 21;
		Date result = Analemma.getDate(year, month, day);
		assertNotNull(result);
		assertEquals("Thu Jan 21 00:00:00 CET 2016", result.toString());
	}

	/**
	 * Run the void main(String[]) method test.
	 */
	@Test
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};
		Analemma.main(args);
	}

	/**
	 * Run the Date sunrise(double,int,int,int) method test.
	 */
	@Test
	public void testSunrise_1()
		throws Exception {
		double latitude = 1.0;
		int year = 2015;
		int month = 0;
		int day = 21;
		Date result = Analemma.sunrise(latitude, year, month, day);
		assertNotNull(result);
        assertEquals("Wed Jan 21 06:01:04 CET 2015", result.toString());
	}

	/**
	 * Run the Date sunset(double,int,int,int) method test.
	 */
	@Test
	public void testSunset_1()
		throws Exception {
		double latitude = 1.0;
		int year = 2015;
		int month = 0;
		int day = 21;
		Date result = Analemma.sunset(latitude, year, month, day);
		assertNotNull(result);
		assertEquals("Wed Jan 21 17:58:55 CET 2015", result.toString());
	}
}