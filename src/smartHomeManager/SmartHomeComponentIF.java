package smartHomeManager;

import java.util.ArrayList;

/**
 * Created by Adam Kozma Master Wirtschaftsinformatik 1 on 29.12.2014.
 * Bechreibung: Interface für das Composite Pattern.
 */
public interface SmartHomeComponentIF {
    public String getName();

    public void add(SmartHomeComponentIF shcIF);

    public ArrayList<SmartHomeComponentIF> getArraylist();

    public String getComponentArt();

    public double getStatus();

    public String getDescription();
}
