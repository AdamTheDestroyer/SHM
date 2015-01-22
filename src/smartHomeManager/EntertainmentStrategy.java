package smartHomeManager;

import java.util.ListIterator;

/**
 * Created by Adambo on 03.01.2015.
 */
public class EntertainmentStrategy implements StrategieIF {
    private Change change;
    private final String ort;
    public EntertainmentStrategy(String ort) {
        this.ort = ort;
    }
    public ListIterator smartHomeComponentIterator1;

    public void execute(SmartHomeComponent shc) {
        changeStatus(shc, smartHomeComponentIterator1);
        printComponent(shc, 1);
        iterate(shc);
    }

    private void printComponent(SmartHomeComponent shc, int ebene) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (ebene == 1) {
            System.out.println("\n" + "************************************~~~~~~~~~~~~~~~************************************");
            System.out.println("\n" + shc.getName() + ": " + shc.getDescription());
        } else if (ebene == 2) {
            System.out.println("\n\t" + "Setting: " + shc.getName() + "\n\t" + "Description: " + shc.getDescription());
        } else if (ebene == 3) {
            System.out.println("\n\t\t" + shc.getName() + " " + shc.getDescription() + ". " + change.getChangeText());
        }
    }

    private void changeStatus(SmartHomeComponent shc, ListIterator actIterator) {
        change = new StartStatus(shc.getStatus());

        if (shc.getComponentArt().equals("TV") || shc.getComponentArt().equals("Musikanlage")) {
            change = new Reducing(change, 1.00);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), 1.00));
        }
        if (shc.getComponentArt().equals("Hintergrund-Licht")) {
            change = new Reducing(change, 1.00);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), 1.00));
        }
        if (shc.getComponentArt().equals("Lampe") || shc.getComponentArt().equals("Energiesparlampe")) {
            change = new Reducing(change, 0.30);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), 0.30));
        }

    }

    private void keepStatus(SmartHomeComponent shc) {
        change = new StartStatus(shc.getStatus());
    }


    private void iterate(SmartHomeComponent shc) {

        ListIterator smartHomeComponentIterator1 = shc.getArraylist().listIterator();

        while (smartHomeComponentIterator1.hasNext()) {
            SmartHomeComponent nextRecord1 = (SmartHomeComponent) smartHomeComponentIterator1.next();
            if (nextRecord1.getName().equals(getOrt())) {
                changeStatus(nextRecord1, smartHomeComponentIterator1);
                printComponent(nextRecord1, 1);

                ListIterator smartHomeComponentIterator2 = nextRecord1.getArraylist().listIterator();
                while (smartHomeComponentIterator2.hasNext()) {
                    SmartHomeComponent nextRecord2 = (SmartHomeComponent) smartHomeComponentIterator2.next();
                    changeStatus(nextRecord2, smartHomeComponentIterator2);
                    printComponent(nextRecord2, 2);

                    ListIterator smartHomeComponentIterator3 = nextRecord2.getArraylist().listIterator();
                    while (smartHomeComponentIterator3.hasNext()) {
                        SmartHomeComponent nextRecord3 = (SmartHomeComponent) smartHomeComponentIterator3.next();
                        changeStatus(nextRecord3, smartHomeComponentIterator3);
                        printComponent(nextRecord3, 3);

                    }
                }

            } else {
                keepStatus(nextRecord1);
                printComponent(nextRecord1, 1);

                ListIterator smartHomeComponentIterator2 = nextRecord1.getArraylist().listIterator();
                while (smartHomeComponentIterator2.hasNext()) {
                    SmartHomeComponent nextRecord2 = (SmartHomeComponent) smartHomeComponentIterator2.next();
                    keepStatus(nextRecord2);
                    printComponent(nextRecord2, 2);

                    ListIterator smartHomeComponentIterator3 = nextRecord2.getArraylist().listIterator();
                    while (smartHomeComponentIterator3.hasNext()) {
                        SmartHomeComponent nextRecord3 = (SmartHomeComponent) smartHomeComponentIterator3.next();
                        keepStatus(nextRecord3);
                        printComponent(nextRecord3, 3);

                    }
                }
            }
        }

        while (smartHomeComponentIterator1.hasNext()) {
            SmartHomeComponent nextRecord4 = (SmartHomeComponent) smartHomeComponentIterator1.next();
            iterate(nextRecord4);
        }

    }

    //Getter und Setter
    public String getOrt() {
        return ort;
    }
    public Change getChange() {
        return change;
    }

}