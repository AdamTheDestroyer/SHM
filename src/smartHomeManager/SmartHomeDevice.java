package smartHomeManager;

/**
 * Created by Adam Kozma Master Wirtschaftsinformatik 1 on 25.12.2014.
 * Beschreibung: Composite der Abstrakten Component Klasse
 * In diesem Composite wird ein Device definiert.
 */
public class SmartHomeDevice extends SmartHomeComponent {

    public SmartHomeDevice(String name, String componentArt, String description, double status) {
        super(name, componentArt, description, status);

    }

}
