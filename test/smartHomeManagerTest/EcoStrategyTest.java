package smartHomeManagerTest;

import org.junit.Assert;
import org.junit.Test;
import smartHomeManager.EcoStrategy;
import smartHomeManager.SmartHomeComponent;
import smartHomeManager.SmartHomeDevice;

/**
 * @author Adam Kozma Master Wirtschaftsinformatik 1
 */
public class EcoStrategyTest {
	/**
	 * Run the void execute(SmartHomeComponent) method test.
	 */
	@Test
	public void testExecute_1()
		throws Exception {
		EcoStrategy ecoStrategy = new EcoStrategy();
		SmartHomeComponent shc = new SmartHomeDevice("", "", "", 1.0);
		ecoStrategy.execute(shc);
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getTemperature());
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getAbgang());
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getAufgang());
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getTemperature());
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getAbgang());
        Assert.assertNotNull("Test ob not NULL", ecoStrategy.getAufgang());
	}

}