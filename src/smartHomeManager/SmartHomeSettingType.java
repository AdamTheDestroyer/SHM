package smartHomeManager;

/**
 * Created by Adam Kozma Master Wirtschaftsinformatik 1 on 25.12.2014.
 * Beschreibung: Composite der Abstrakten Component Klasse
 * In diesem Component wird ein Setting Type definiert.
 */
public class SmartHomeSettingType extends SmartHomeComponent {

    final boolean kindersicherung;

    public SmartHomeSettingType(String name, String componentArt, String description, double status, boolean kindersicherung) {
        super(name, componentArt, description, status);
        this.kindersicherung = kindersicherung;

    }
}
