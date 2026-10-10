import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Edelstein_rot.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Edelstein_rot extends FallendesObjekt
{
    /**
     * Act - tut, was auch immer Edelstein_rot tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    public void act() 
    {
        fallen();
        
        if (istAmBoden())
        {
            getWorld().removeObject(this);
        }
        else if (isTouching(Spieler.class))
        {
            SpieleWelt Welt = (SpieleWelt)getWorld();
            Welt.aenderePunkte(500); // 100 Pluspunkte
            Welt.removeObject(this);
        }
    }    
}