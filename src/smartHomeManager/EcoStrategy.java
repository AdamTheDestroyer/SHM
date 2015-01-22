package smartHomeManager;

import java.util.Calendar;
import java.util.Date;
import java.util.ListIterator;

/**
 * Created by Adambo on 26.12.2014.
 */

public class EcoStrategy implements StrategieIF {

    private double klimawert;
    private double heizwert;
    private double lichtwert;
    private long aufgang;
    private long abgang;
    private long aktuelleZeit;
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
    private void setSunriseAndSunSet() {
        // latitude für Reutlingen
        double latitude = 48.4833333;
        Calendar cal;
        Date date = new Date();
        cal = Calendar.getInstance();
        cal.setTime(date);

        setAbgang(analemma.sunset(latitude, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH)).getTime());
        setAufgang(analemma.sunrise(latitude, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH)).getTime());
        setAktuelleZeit(date.getTime());
    }

    //Es wird eine random Temperatur erzeugt (von 0 - 32 Grad)
    private void calcRandTemperature() {
        setTemperature(0 + (int) (Math.random() * ((32 - 0) + 1)));
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

        if (getTemperature()>=20) {
            setKlimawert(0.30);
            setHeizwert(0.00);
        } else {
            setKlimawert(0.00);
            setHeizwert(0.40);
        }
        //Wenn es nach Sonnenuntergang ist oder vor Sonnenaufgang, soll das Licht an sein
        //Andernfalls, soll das Licht aus sein
        if (getAktuelleZeit() > getAbgang() || getAktuelleZeit() < getAufgang()) {
            setLichtwert(1.0);
        } else {
            setLichtwert(0.0);
        }

        if (shc.getComponentArt().equals("Lampe") || shc.getComponentArt().equals("Hintergrund-Licht")) {
            change = new Reducing(change, 0.00);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), 0.00));
        }

        if (shc.getComponentArt().equals("Energiesparlampe")) {
            change = new Reducing(change, getLichtwert());
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), getLichtwert()));
        }

        if (shc.getComponentArt().equals("Heizkoerper")) {
            change = new Reducing(change, getLichtwert());
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), getHeizwert()));
        }

        if (shc.getComponentArt().equals("Klimaanlage")) {
            change = new Reducing(change, klimawert);
            actIterator.set(new SmartHomeDevice(shc.getName(), shc.getComponentArt(), shc.getDescription(), getKlimawert()));
        }
    }

    private void iterate(SmartHomeComponent shc) {

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

    //Getter und Setter

    public double getKlimawert() {
        return klimawert;
    }

    public void setKlimawert(double klimawert) {
        this.klimawert = klimawert;
    }

    public double getHeizwert() {
        return heizwert;
    }

    public void setHeizwert(double heizwert) {
        this.heizwert = heizwert;
    }

    public double getLichtwert() {
        return lichtwert;
    }

    public void setLichtwert(double lichtwert) {
        this.lichtwert = lichtwert;
    }

    public long getAufgang() {
        return aufgang;
    }

    public void setAufgang(long aufgang) {
        this.aufgang = aufgang;
    }

    public long getAbgang() {
        return abgang;
    }

    public void setAbgang(long abgang) {
        this.abgang = abgang;
    }

    public long getAktuelleZeit() {
        return aktuelleZeit;
    }

    public void setAktuelleZeit(long aktuelleZeit) {
        this.aktuelleZeit = aktuelleZeit;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

}