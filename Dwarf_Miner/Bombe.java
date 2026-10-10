import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bombe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bombe extends FallendesObjekt
{
    public void act()
    {
        fallen();
        
        if (istAmBoden())
        {
            getWorld().removeObject(this);
        }
        
        else if (isTouching(Spieler.class))
        {
            setImage("bombe_2.png"); //animiert bei Berührung die Bombe bzw. die Explosion
            Greenfoot.delay(4);
            setImage("bombe_3.png");
            Greenfoot.delay(4);
            setImage("bombe_4.png");
            Greenfoot.delay(4);
            
            SpieleWelt Welt = (SpieleWelt)getWorld();
            // ruft das Spielende auf mit 'false' für "Verloren"
            Welt.beendeSpiel(false);
        }
    }
}
