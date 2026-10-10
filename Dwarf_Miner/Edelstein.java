import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Edelstein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Edelstein extends FallendesObjekt
{
    /**
     * Act - do whatever the Edelstein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
            Welt.aenderePunkte(100); // 100 Pluspunkte
            Welt.removeObject(this);
        }
    }
}
