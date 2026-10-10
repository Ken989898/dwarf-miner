import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpieleWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpieleWelt extends World
{

    private int punktzahl;
    public int verbleibendeZeit;
    private int erscheinungsZaehler;
    
    public SpieleWelt()
    {    
        super(1920, 1080, 1);
        punktzahl = 0;
        verbleibendeZeit = 3000;
        erscheinungsZaehler = 0;
        prepare();
    }
    
    private void prepare()
    {
        Spieler spieler1 = new Spieler();
        addObject(spieler1, 960, 790);
    }
    
    public void act()
    {
        verbleibendeZeit--;
        showText("Punkte: " + punktzahl, 150, 50);
        showText("Zeit: " + verbleibendeZeit, 1750, 50);
        generiereObjekte();
        if(verbleibendeZeit <= 0)
        {
            beendeSpiel(true);
        }
        
    }
    
    public void aenderePunkte(int anzahl)
    {
        punktzahl = punktzahl + anzahl;
    }

    public void beendeSpiel(boolean istGewonnen)
    {
        // Wechselt zur EndWelt und übergibt den Status sowie die erreichte Punktzahl
        Greenfoot.setWorld(new EndWelt(istGewonnen, punktzahl));
    }

    
    private void generiereObjekte()
    {
        erscheinungsZaehler++;
        // Alle 25 Frames (jede halbe Sekunde) kann ein Objekt fallen
        if (erscheinungsZaehler >= 25)
        {
            // Zufällige X-Koordinate zwischen 50 und 1870 Pixeln
            int zufallX = Greenfoot.getRandomNumber(1820) + 50;
            // Zufälliger Wert zwischen 0 und 99 zur Bestimmung des Objekttyps
            int wahrscheinlichkeit = Greenfoot.getRandomNumber(100);
            if (wahrscheinlichkeit < 40)
            {
                
                addObject(new Stein(), zufallX, 0);
            }
            else if (wahrscheinlichkeit < 65)
            {
                
                addObject(new Edelstein(), zufallX, 0);
            }
            else if (wahrscheinlichkeit < 70)
            {
                
                addObject(new Edelstein_rot(), zufallX, 0);
            }
            else if (wahrscheinlichkeit < 75)
            {
                
                addObject(new Magnet(), zufallX, 0);
            }
            else
            {
                
                addObject(new Bombe(), zufallX, 0);
            }
    
            erscheinungsZaehler = 0;
        }
    }
}
