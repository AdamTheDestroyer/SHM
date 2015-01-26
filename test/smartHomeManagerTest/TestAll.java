package smartHomeManagerTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	SmartHomeLocationTest.class,
	ReducingTest.class,
	LeavingStrategyTest.class,
	EcoStrategyTest.class,
	SmartHomeComponentTest.class,
	EntertainmentStrategyTest.class,
	AnalemmaTest.class,
	SmartHomeDeviceTest.class,
	SwitchOffStrategyTest.class,
	SmartHomeSettingTypeTest.class,
	StartStatusTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
