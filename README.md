# SHM
Smart Home Manager mit Strategy, Composite und Decorator Pattern

Mit dieser Obejkorientierten Programmierung werden drei verschiedene Design Pattern in Ihrer vollen Effizienz gezeigt.
Das Ziel ist eine erweiterare, saubere, unvermischte, effiziente Benutzung der Pattern.

Es geht hier um ein Smart Projekt.

Es werden für das Composite folgende Strukturen und Hierarchien erstellt:
Ein Haus  besitzt
          dasWohnzimmer, dieKueche, dasBad besitzt
            Einstellmöglichkeiten: Security, Klima, Entertainment und Licht besitzt
                die Leafs: Lampe1 - LampeN, Hintergrund-Licht, Herd, TV, Musikanlage, Ueberwachungskamera, Schließanlage

Für das Strategy Pattern werden Fälle der Statusveränderungen der einzelenen Leafs konstruiert, 
so dass es zum Beispiel eine "SwitchOffStrategie" gibt, bei der alle Geräte ausgeschaltet werden.
Zusätzlich gibt es noch eine LeavingStrategy, EcoStrategy, EntertainmentStrategy.

Innerhalb der Strategien findet das Decorator Pattern Anklang.
Die Stauswerte werden zum einen in ein Objekt des DecoratorInterfaces (Change) gespeichert, und bei jeder Veränderung wird ein neues Objekt Change erstellt, wobei das bisherige Change mit in die Decorator Methode übergeben wird.
Dies bedeutet dass man zur String Ausgabe zunächst den Startwert bekommt und dann der String bei einer gewollten Statusänderung das Change mit dem Stratwert überschrieben wird mit dem neuen Wert. 
Es wird Quasie auf den alten Wert mit String Message der neue Wert übergestülpt ohne den alten Wert zu löschen.

Es wird in dieser Dreierkombination somit die Wartbarkeit durch die logisch getrennten Pattern gewehrleistet.
Die Erweiterbarkeit wird unterstützt durch das beliebige Anbringen von neuen Leafs und Components im Composite Pattern.

Beliebige Strategien können angebaut werden.
