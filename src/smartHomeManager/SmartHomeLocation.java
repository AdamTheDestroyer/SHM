package smartHomeManager;

/**
 * Created by Adambo on 25.12.2014.
 * Beschreibung: Composite der Abstrakten Component Klasse
 * In diesem Composite wird eine Location definiert.
 */
public class SmartHomeLocation extends SmartHomeComponent {

    final String ortzugehoerigkeit;
    public SmartHomeLocation(String name, String componentArt, String description, double status, String ortzugehoerigkeit) {
        super(name, componentArt, description, status);
        this.ortzugehoerigkeit=ortzugehoerigkeit;
    }
}