package smartHomeManagerTest;

import org.junit.Ignore;
import org.junit.Test;
import smartHomeManager.SmartHomeComponent;
import smartHomeManager.SmartHomeDevice;
import smartHomeManager.SwitchOffStrategy;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class SwitchOffStrategyTest {
	/**
	 * Run the void execute(SmartHomeComponent) method test.
	 */
	@Test
	public void testExecute_1()
		throws Exception {
		SwitchOffStrategy switchOffStrategy = new SwitchOffStrategy();
		SmartHomeComponent shc = new SmartHomeDevice("", "", "", 1.0);
		switchOffStrategy.execute(shc);
	}
}