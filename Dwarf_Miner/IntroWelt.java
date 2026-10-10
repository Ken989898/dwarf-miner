import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IntroWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWelt extends World
{
    private int zeitZaehler;

    public IntroWelt()
    {    
        super(1920, 1080, 1);
        zeitZaehler = 0;
        prepare();
    }

    public void act()
    {
        showText("Das Spiel startet jetzt!!!", 960, 450);
        zeitZaehler++;
        if(zeitZaehler == 150)
        {
            starteSpiel();
        }
    }

    private void starteSpiel()
    {
        SpieleWelt neueWelt = new SpieleWelt();
        Greenfoot.setWorld(neueWelt);
    }

    
    /**
     * Bereite die Welt für den Programmstart vor.
     * Das heißt: Erzeuge die Anfangs-Objekte und füge sie der Welt hinzu.
     */
    private void prepare()
    {
        
    }
}
