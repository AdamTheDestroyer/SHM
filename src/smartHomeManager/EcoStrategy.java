package smartHomeManager;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

/**
 * Created by Adambo on 26.12.2014.
 */

public class EcoStrategy implements StrategieIF {
    private double klimawert, heizwert, lichtwert;
    private long aufgang, abgang, aktuelleZeit;
    private int temperature;
    private Change change;
    private Analemma analemma;
    private ListIterator smartHomeComponentIterator1;

    public void execute(SmartHomeComponent shc) {
        calcRandTemperature();
        setSunriseAndSunSet();
        changeStatus(shc, smartHomeComponentIterator1);
        printComponent(shc, 1);
        iterate(shc);
    }

    //Berechnung vom Sonnenuntergang und Sonnenaufgang durch Hilfsklasse Analemma
    //Link:https://github.com/jeancaffou/Analemma
    //Es wird auf korrekte Zeitdarstellung (mit Joda-Time) keinen Wert gelegt,
    //da Sekunden ausreichen um Werte mit einander zu vergleichen.
    public void setSunriseAndSunSet() {
        // latitude für Reutlingen
        double latitude = 48.4833333;
        Calendar cal;
        Date date = new Date();

        cal = Calendar.getInstance();
        cal.setTime(date);

        abgang = analemma.sunset(latitude, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH)).getTime();
        aufgang = analemma.sunrise(latitude, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH)).getTime();
        aktuelleZeit = date.getTime();
    }

    //Es wird eine random Temperatur erzeugt (von 0 - 32 Grad)
    public void calcRandTemperature() {
        temperature = 0 + (int) (Math.random() * ((32 - 0) + 1));
    }

    public void printComponent(SmartHomeComponent shc, int ebene) {
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

    public void changeStatus(SmartHomeComponent shc, ListIterator actIterator) {

        change = new StartStatus(shc.getStatus());

        if (temperature >= 18) {
            klimawert = 0.30;
            heizwert = 0.00;
        } else {
            klimawert = 0.00;
            heizwert = 0.40;
        }
        //Wenn es nach Sonnenuntergang ist oder vor Sonnenaufgang, soll das Licht an sein
        //Andernfalls, soll das Licht aus sein
        if (aktuelleZeit > abgang || aktuelleZeit < aufgang) {
            lichtwert = 1.0;
        } else {
            lichtwert = 0.0;
        }

        if (shc.getComponentArt().equals("Lampe") || shc.getComponentArt().equals("Hintergrund-Licht")) {
            change = new Reducing(change, 0.00);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), 0.00));
        }

        if (shc.getComponentArt().equals("Energiesparlampe")) {
            change = new Reducing(change, lichtwert);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), lichtwert));
        }

        if (shc.getComponentArt().equals("Heizkoerper")) {
            change = new Reducing(change, heizwert);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), heizwert));
        }

        if (shc.getComponentArt().equals("Klimaanlage")) {
            change = new Reducing(change, klimawert);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), klimawert));
        }
    }

    public void iterate(SmartHomeComponent shc) {

        ListIterator smartHomeComponentIterator1 = shc.getArraylist().listIterator();
        while (smartHomeComponentIterator1.hasNext()) {
            SmartHomeComponent nextRecord1 = (SmartHomeComponent) smartHomeComponentIterator1.next();
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
        }

        while (smartHomeComponentIterator1.hasNext()) {
            SmartHomeComponent nextRecord4 = (SmartHomeComponent) smartHomeComponentIterator1.next();
            iterate(nextRecord4);
        }

    }

}