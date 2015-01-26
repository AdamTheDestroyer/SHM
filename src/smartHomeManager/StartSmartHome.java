package smartHomeManager;

import org.junit.Test;

/**
 * Created by Adambo on 25.12.2014.
 * Beschreibung: In dieser Klasse werden die Elemente des Composite Patterns definiert
 * und anschließend wird eine Strategie gewählt und ausgeführt.
 * Es wird hier auf die klassische Main-Methode verzichtet.
 * Stattdessen wird hier ein Junit test verwendet um die SmartHome Definition und Ausführung zu starten.
 * Wenn mehrere Strategien nacheinander gestartet werden, so wird der zuletzt eingestelle Status gespeichert und verwendet.
 */


public class StartSmartHome {

        /*Leafarten: Licht: Lampe, Hintergrund-Licht, Energiesparlampe
        *            Klima: Heizkoerper, Klimaanlage, Luftfilter
        *            Security: Schließanlage, Ueberwachungskamera, Hitzequelle
        *            Entertainment: Musikanlage, TV*/

    @Test
    public void generateSmartHome() throws Exception {

        StrategieIF strategy;

        //Hier werden Räume definiert
        SmartHomeLocation wohnraum = new SmartHomeLocation("Haus", "Haus", "Beinhaltet alle Locations und Settings und Devices", 1, "Haus1");


        //**************************************************Hiert wird der Ort Wohnzimmer definiert**************************************************\\
        SmartHomeLocation wohnzimmer = new SmartHomeLocation("Wohnzimmer", "Raum", "Ist der Hauptaufenthaltsraum", 1, "Wohnzimmer im Haus1");

        //Hier wird die Einstellungsmöglichkeit definiert
        SmartHomeSettingType klima1 = new SmartHomeSettingType("Klima", "KlimaSetting", "Reguliert alle Geräte bezüglich der Temperatur im Wohnzimmer", 1, false);
        SmartHomeSettingType licht1 = new SmartHomeSettingType("Licht", "LichtSetting", "Reguliert alle Geräte bezüglich des Lichts im Wohnzimmer", 1, false);
        SmartHomeSettingType security1 = new SmartHomeSettingType("Security", "SecuritySetting", "Reguliert alle Geräte bezüglich der Sicherheit im Wohnzimmer", 1, false);
        SmartHomeSettingType entertainment1 = new SmartHomeSettingType("Entertainment", "EntertainmentSetting", "Reguliert alle Geräte bezüglich der Unterhaltung im Wohnzimmer", 1, false);

        //Hier werden die ansteuerbaren Geräte (Leafs) definiert
        SmartHomeDevice lampe1 = new SmartHomeDevice("Lampe 1", "Hintergrund-Licht", "ist eine Hintergrundbeleuchtung hinter dem Fernseher", 0.0);
        SmartHomeDevice lampe2 = new SmartHomeDevice("Lampe 2", "Lampe", "ist eine dimmbare indirekte Lampe", 1.0);
        SmartHomeDevice lampe3 = new SmartHomeDevice("Lampe 3", "Lampe", "ist eine dimmbare Hauptlampe im Zimmer", 1.0);
        SmartHomeDevice energiesparlampe1 = new SmartHomeDevice("Energiesparlicht 1", "Energiesparlampe", "ist eine dimmbare Energiesparlampe", 1.0);
        SmartHomeDevice heizung1 = new SmartHomeDevice("Heizung 1", "Heizkoerper", "ist eine Heizung", 0.0);
        SmartHomeDevice heizung2 = new SmartHomeDevice("Heizung 2", "Heizkoerper", "ist eine Heizung", 0.0);
        SmartHomeDevice heizung3 = new SmartHomeDevice("Heizung 3", "Heizkoerper", "ist eine Heizung", 0.0);
        SmartHomeDevice klimaanlage1 = new SmartHomeDevice("Klimaanlage 1", "Klimaanlage", "ist ein kühlendes Klimagerät", 0.0);
        SmartHomeDevice schliessanlage1 = new SmartHomeDevice("Schließanlage 1", "Schließanlage", "ist ein verschließbares Fenster zum Süden", 0.0);
        SmartHomeDevice schliessanlage2 = new SmartHomeDevice("Schließanlage 2", "Schließanlage", "ist ein verschließbares Fenster zum Süden", 0.0);
        SmartHomeDevice schliessanlage3 = new SmartHomeDevice("Überwachungskamera 1", "Ueberwachungskamera", "ist eine Wohnzimmerkamera", 0.0);
        SmartHomeDevice musik1 = new SmartHomeDevice("Bose Soundlink 1000W", "Musikanlage", "ist eine Musikbox mit Funkübertragung", 0.0);
        SmartHomeDevice tv1 = new SmartHomeDevice("Samsung LH75MECPLGC/EN", "TV", "ist ein 75 Zoll Flachbildfernseher", 0.0);
        SmartHomeDevice musik2 = new SmartHomeDevice("Teufel LT 5 Digital HD 5.1", "Musikanlage", "ist eine 5.1 Surroundanlage", 0.0);

        //Bildung der Struktur des Wohnzimmers
        wohnraum.add(wohnzimmer);
        wohnzimmer.add(klima1);
        wohnzimmer.add(licht1);
        wohnzimmer.add(security1);
        wohnzimmer.add(entertainment1);
        klima1.add(heizung1);
        klima1.add(heizung2);
        klima1.add(heizung3);
        klima1.add(klimaanlage1);
        licht1.add(lampe1);
        licht1.add(lampe2);
        licht1.add(lampe3);
        licht1.add(energiesparlampe1);
        security1.add(schliessanlage1);
        security1.add(schliessanlage2);
        security1.add(schliessanlage3);
        entertainment1.add(musik1);
        entertainment1.add(tv1);
        entertainment1.add(musik2);


        //**************************************************Hiert wird der Ort Küche definiert**************************************************\\
        SmartHomeLocation kueche = new SmartHomeLocation("Küche", "Raum", "Ein Raum zum Kochen", 1, "Küche im Haus1");

        //Hier wird die Einstellungsmöglichkeit definiert
        SmartHomeSettingType klima2 = new SmartHomeSettingType("Klima", "KlimaSetting", "Reguliert alle Geräte bezüglich der Temperatur in der Küche", 1, false);
        SmartHomeSettingType licht2 = new SmartHomeSettingType("Licht", "LichtSetting", "Reguliert alle Geräte bezüglich des Lichts in der Küche", 1, false);
        SmartHomeSettingType security2 = new SmartHomeSettingType("Security", "SecuritySetting", "Reguliert alle Geräte bezüglich der Sicherheit in der Küche", 1, false);
        SmartHomeSettingType entertainment2 = new SmartHomeSettingType("Entertainment", "EntertainmentSetting", "Reguliert alle Geräte bezüglich der Unterhaltung in der Küche", 1, false);

        //Hier werden die ansteuerbaren Geräte (Leafs) definiert
        SmartHomeDevice lampe4 = new SmartHomeDevice("Lampe 4", "Hintergrund-Licht", "ist ein indirektes Licht über der Arbeitsplattte", 0.0);
        SmartHomeDevice lampe5 = new SmartHomeDevice("Lampe 5", "Lampe", "ist eine Stehlampe", 0.0);
        SmartHomeDevice lampe6 = new SmartHomeDevice("Lampe 6", "Lampe", "ist das Hauptlicht", 0.0);
        SmartHomeDevice heizung4 = new SmartHomeDevice("Heizung 4", "Heizkoerper", "ist ein Heizkörper", 0.0);
        SmartHomeDevice heizung5 = new SmartHomeDevice("Heizung 5", "Heizkoerper", "ist ein Heizkörper", 0.0);
        SmartHomeDevice heizung6 = new SmartHomeDevice("Heizung 6", "Heizkoerper", "ist ein Heizkörper", 0.0);
        SmartHomeDevice schliessanlage4 = new SmartHomeDevice("Schließanlage 4", "Schließanlage", "ist eine verschließbare Balkontüre", 0.0);
        SmartHomeDevice schliessanlage5 = new SmartHomeDevice("Schließanlage 5", "Schließanlage", "ist ein verschließbares Fenster", 0.0);
        SmartHomeDevice schliessanlage6 = new SmartHomeDevice("Überwachungskamera 2", "Ueberwachungskamera", "ist eine Küchenkamera", 0.0);
        SmartHomeDevice musik3 = new SmartHomeDevice("SONORO Stereo schwarz CD Küchenradio", "Musikanlage", "ist ein Küchenradio mir Funkübertragung", 0.0);
        SmartHomeDevice tv2 = new SmartHomeDevice("EverVue LT320 Küchenfernseher", "TV", "ist ein 32 Zoll Einbaufernseher", 0.0);
        SmartHomeDevice herd1 = new SmartHomeDevice("Herd 1", "Hitzequelle", "ist ein Herd in der Küche", 0.0);

        //Bildung der Struktur der Küche
        wohnraum.add(kueche);
        kueche.add(klima2);
        kueche.add(licht2);
        kueche.add(security2);
        kueche.add(entertainment2);
        klima2.add(heizung4);
        klima2.add(heizung5);
        klima2.add(heizung6);
        licht2.add(lampe4);
        licht2.add(lampe5);
        licht2.add(lampe6);
        security2.add(schliessanlage4);
        security2.add(schliessanlage5);
        security2.add(schliessanlage6);
        security2.add(herd1);
        entertainment2.add(musik3);
        entertainment2.add(tv2);


        //**************************************************Hiert wird der Ort Bad definiert**************************************************\\
        SmartHomeLocation bad = new SmartHomeLocation("Bad", "Raum", "Ein Raum zum ausruhen und entspannen", 1, "Bad im Haus1");

        //Hier wird die Einstellungsmöglichkeit definiert
        SmartHomeSettingType klima3 = new SmartHomeSettingType("Klima", "KlimaSetting", "Reguliert alle Geräte bezüglich der Temperatur im Bad", 1, false);
        SmartHomeSettingType licht3 = new SmartHomeSettingType("Licht", "LichtSetting", "Reguliert alle Geräte bezüglich des Lichts im Bad", 1, false);
        SmartHomeSettingType security3 = new SmartHomeSettingType("Security", "SecuritySetting", "Reguliert alle Geräte bezüglich der Sicherheit im Bad", 1, false);
        SmartHomeSettingType entertainment3 = new SmartHomeSettingType("Entertainment", "EntertainmentSetting", "Reguliert alle Geräte bezüglich der Unterhaltung im Bad", 1, false);

        //Hier werden die ansteuerbaren Geräte (Leafs) definiert
        SmartHomeDevice lampe7 = new SmartHomeDevice("Lampe 7", "Lampe", "ist eine Badschrankleuchte", 0.0);
        SmartHomeDevice lampe8 = new SmartHomeDevice("Lampe 8", "Lampe", "ist das Hauptlicht im Bad", 0.0);
        SmartHomeDevice lampe9 = new SmartHomeDevice("Lampe 9", "Lampe", "ist ein Licht im Whirlpool", 0.0);
        SmartHomeDevice heizung7 = new SmartHomeDevice("Heizung 7", "Heizkoerper", "ist ein Heizkörper im Bad", 0.0);
        SmartHomeDevice heizung8 = new SmartHomeDevice("Heizung 8", "Heizkoerper", "ist ein Heitkörper im Bad", 0.0);
        SmartHomeDevice heizung9 = new SmartHomeDevice("Heizung 9", "Heizkoerper", "ist ein Heizstrahler im Bad", 0.0);
        SmartHomeDevice schliessanlage7 = new SmartHomeDevice("Schließanlage 7", "Schließanlage", "ist ein verschließbares Fenster im Bad", 0.0);
        SmartHomeDevice schliessanlage8 = new SmartHomeDevice("Schließanlage 8", "Schließanlage", "ist ein verschließbares Fenster im Bad", 0.0);
        SmartHomeDevice schliessanlage9 = new SmartHomeDevice("Überwachungskamera 3", "Ueberwachungskamera", "ist eine versteckte Voyeurkamera", 0.0);
        SmartHomeDevice musik4 = new SmartHomeDevice("Roberts Stream 93i", "Musikanlage", "ist ein Internetradio im Bad", 0.0);
        SmartHomeDevice tv3 = new SmartHomeDevice("Sony Bravia Kdl-55hx755 ", "TV", "ist ein Flachbildfernseher", 0.0);

        //Bildung der Struktur des Bades
        wohnraum.add(bad);
        bad.add(klima3);
        bad.add(licht3);
        bad.add(security3);
        bad.add(entertainment3);
        klima3.add(heizung7);
        klima3.add(heizung8);
        klima3.add(heizung9);
        licht3.add(lampe7);
        licht3.add(lampe8);
        licht3.add(lampe9);
        security3.add(schliessanlage7);
        security3.add(schliessanlage8);
        security3.add(schliessanlage9);
        entertainment3.add(musik4);
        entertainment3.add(tv3);

        //Auswahl der Leaving Stregie
        strategy = new LeavingStrategy();
        strategy.execute(wohnraum);

        //Auswahl der Switch Off Strategy
        strategy = new SwitchOffStrategy();
        strategy.execute(wohnraum);

        //Auswahl der Entertainment Strategy
        strategy = new EntertainmentStrategy("Wohnzimmer");
        strategy.execute(wohnraum);

        //Auswahl der Eco Strategie
        strategy = new EcoStrategy();
        strategy.execute(wohnraum);
    }


}