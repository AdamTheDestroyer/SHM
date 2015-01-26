package smartHomeManager;

import java.util.ArrayList;

/**
 * Created by Adambo on 25.12.2014.
 * Beschreibung: Abstrakte Klasse (Component) des Composite Patterns, die die Ausgangs variablen und Methoden definiert.
 */

public abstract class SmartHomeComponent implements SmartHomeComponentIF {
    private final String name;
    private ArrayList<SmartHomeComponentIF> smartHomeArray;
    private final String componentArt;
    private double status;
    private final String description;


    public SmartHomeComponent(String name, String componentArt, String description, double status) {
        smartHomeArray = new ArrayList<SmartHomeComponentIF>();
        this.name = name;
        this.componentArt = componentArt;
        this.description = description;
        this.status = status;
    }

    @Override
    public double getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void add(SmartHomeComponentIF shcIF) {
        smartHomeArray.add(shcIF);
    }

    public ArrayList<SmartHomeComponentIF> getArraylist() {
        return this.smartHomeArray;
    }

    public String getComponentArt() {
        return componentArt;
    }

    public String getDescription() {
        return description;
    }

}

