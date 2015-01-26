package smartHomeManagerTest;

import org.junit.Test;
import smartHomeManager.LeavingStrategy;
import smartHomeManager.SmartHomeComponent;
import smartHomeManager.SmartHomeDevice;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class LeavingStrategyTest {
	/**
	 * Run the void execute(SmartHomeComponent) method test.
	 */
	@Test
	public void testExecute_1()
		throws Exception {
		LeavingStrategy leavingStrategy = new LeavingStrategy();
		SmartHomeComponent shc = new SmartHomeDevice("", "", "", 1.0);
		leavingStrategy.execute(shc);
	}

}