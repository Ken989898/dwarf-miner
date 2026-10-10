import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse Magnet.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Magnet extends FallendesObjekt
{
    /**
     * Act - tut, was auch immer Magnet tun will. Diese Methode wird aufgerufen, 
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
            Welt.verbleibendeZeit = Welt.verbleibendeZeit + 30;
            
        }
        
    }    
}