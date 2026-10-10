# Dwarf Miner

Ein 2D-Geschicklichkeitsspiel in Java, umgesetzt mit Greenfoot.

Entstanden als Klausurersatzleistung im Informatik-Kurs der 12. Klasse.
Bewertung: **14 Notenpunkte**.
Entwicklungszeit 4 Doppelstunden (Unterricht), allein umgesetzt.

---

### Worum geht es

Der Spieler steuert einen Bergarbeiter nach links und rechts. Von oben fallen
Objekte mit unterschiedlicher Wirkung:

| Objekt          | Wirkung              | Spawn-Wahrscheinlichkeit |
|-----------------|----------------------|--------------------------|
| Stein           | −50 Punkte           | 40 % |
| Edelstein       | +100 Punkte          | 25 % |
| Roter Edelstein | +500 Punkte          |  5 % |
| Magnet          | +30 Ticks Spielzeit  |  5 % |
| Bombe           | Spiel sofort verloren | 25 % |

Ziel ist, die 3000 Ticks Spielzeit zu überstehen und dabei möglichst viele
Punkte zu sammeln. Eine einzige Bombe beendet das Spiel.

**Steuerung:** Pfeiltaste links / rechts

---

## Technischer Aufbau

### Vererbungshierarchie

Alle fallenden Objekte erben von der Oberklasse `FallendesObjekt`, die
`fallen()` und `istAmBoden()` bereitstellt. Die Unterklassen überschreiben
nur `act()` und definieren dort, was bei Berührung mit dem Spieler passiert.

```
FallendesObjekt
├── Stein
├── Bombe
├── Edelstein
├── Edelstein_rot
└── Magnet
```

### Drei Spielzustände

Das Spiel wechselt zwischen drei `World`-Klassen:

```
IntroWelt  ──►  SpieleWelt  ──►  EndWelt
```

Ergebnis und Punktzahl werden über den Konstruktor
`EndWelt(boolean ergebnis, int punkte)` an die Endwelt übergeben.

### Spawn-System

`generiereObjekte()` erzeugt alle 25 Frames ein Objekt an einer zufälligen
X-Position. Welcher Typ entsteht, entscheidet eine Zufallszahl zwischen 0 und
99 über kumulative Schwellenwerte — so lassen sich die Häufigkeiten aus der
Tabelle oben direkt einstellen. Jedes Objekt bekommt zusätzlich eine zufällige
Fallgeschwindigkeit zwischen 3 und 7 Pixeln pro Frame.

### Animation

Der Spieler-Sprite besteht aus fünf Einzelbildern, die alle sechs Frames
wechseln. Die Blickrichtung wird über `mirrorHorizontally()` gespiegelt,
statt einen zweiten Bildersatz vorzuhalten.

### Kapselung

Die Punktzahl ist `private` und wird ausschließlich über
`aenderePunkte(int anzahl)` verändert.
