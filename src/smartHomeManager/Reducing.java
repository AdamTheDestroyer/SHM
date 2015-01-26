package smartHomeManager;

/**
 * Created by Adambo on 01.01.2015.
 * Beschreibung: Dekoratorklasse, die den neuen Wert setzt und als Change-Objekt zurückgibt.
 */
public class Reducing implements Change {

    protected final Change change;
    protected final double reducingRate;


    public Reducing(Change change, double reducingRate) {
        this.change = change;
        this.reducingRate = reducingRate;
    }

    //Paramter reducingRate wird hier zurückgegeben.
    @Override
    public double getStatus() {
        return reducingRate;
    }

    //Abhängig davon ob der Status des aktuellen Leafs, bereits den Zielstatus erreicht hat, wird hier eine Nachricht zurückgegeben
    //und das aktuelle ChangeObjekt überschrieben.
    @Override
    public String getChangeText() {
        if (change.getStatus() == getStatus()) {
            return change.getChangeText() + "\n\t\t\t" + "Der Status ändert sich nicht, da Start-Status und Ziel-Status identisch sind";
        } else
            return change.getChangeText() + "\n\t\t\t" + "Der Status nach der Änderung ist: " + getStatus();
    }
}