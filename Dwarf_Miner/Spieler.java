import greenfoot.*;  

public class Spieler extends Actor
{
    
    private int geschwindigkeit;
    private int bildIndex;
    private int animationsZaehler;
    private boolean blickRichtungLinks;
    
    public void act()
    {
        bewegeLinksRechts();
    }
    
    public Spieler()
    {
        // Initialisierung der Attribute
        geschwindigkeit = 8;     // Pixelschritte nach links oder rechts
        bildIndex = 1;           // Startbild-Index
        animationsZaehler = 0;   // Tempo Bildwechsels
        blickRichtungLinks = false;
    }
    
    private void bewegeLinksRechts()
    {
        // Bewegung nach links
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - geschwindigkeit, getY());
            blickRichtungLinks = true;
            animiere(); // Animation abspielen bei Bewegung
        }
        
        // Bewegung nach rechts
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + geschwindigkeit, getY());
            blickRichtungLinks = false;
            animiere();
        }
    }

    private void animiere()
    {
        animationsZaehler++; // start Animation nach 6 frames
        if (animationsZaehler >= 6)
        {
            // Bild-Index für nächsten Frame immer ehroöhen
            bildIndex++;
            if (bildIndex > 5)
            {
                bildIndex = 1;
            }
            // Dateiname wird automatisch geändert
            setImage("spieler_lauf" + bildIndex + ".png");
            
            if(blickRichtungLinks == true)
            {
                getImage().mirrorHorizontally();
            }
            // Zähler für den nächsten Wechsel zurücksetzen
            animationsZaehler = 0;
        }
    }
}

