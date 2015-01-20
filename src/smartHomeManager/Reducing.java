package smartHomeManager;

/**
 * Created by Adambo on 01.01.2015.
 */
public class Reducing implements Change {

    protected final Change change;
    protected final double reducingRate;


    public Reducing(Change change, double reducingRate) {
        this.change = change;
        this.reducingRate = reducingRate;
    }

    @Override
    public double getStatus() {
        return reducingRate;
    }

    @Override
    public String getChangeText() {
        if (change.getStatus() == getStatus()) {
            return change.getChangeText() + "\n\t\t\t" + "Der Status ändert sich nicht, da Start-Status und Ziel-Status identisch sind";
        } else
            return change.getChangeText() + "\n\t\t\t" + "Der Status nach der Änderung ist: " + getStatus();
    }
}