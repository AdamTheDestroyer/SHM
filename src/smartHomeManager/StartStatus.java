package smartHomeManager;

/**
 * Created by Adambo on 01.01.2015.
 * Beschreibung: In dieser Dekoration Klasse wird der Start Status übergeben und in das Dekorator Objekt Change zurückgegeben.
 */
public class StartStatus implements Change {
    final double startStatus;

    public StartStatus(double startStatus) {
        this.startStatus = startStatus;
    }

    @Override
    public double getStatus() {
        return startStatus;
    }

    @Override
    public String getChangeText() {
    return "\n\t\t\t" + "Der Start-Status ist: " + getStatus();
}
}

