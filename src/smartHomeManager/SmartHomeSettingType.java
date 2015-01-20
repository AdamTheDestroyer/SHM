package smartHomeManager;

/**
 * Created by Adambo on 25.12.2014.
 */
public class SmartHomeSettingType extends SmartHomeComponent {

    final boolean kindersicherung;

    public SmartHomeSettingType(String name, String componentArt, String description, double status, boolean kindersicherung) {
        super(name, componentArt, description, status);
        this.kindersicherung = kindersicherung;

    }
}
