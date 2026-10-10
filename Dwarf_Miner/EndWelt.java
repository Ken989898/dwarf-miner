import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWelt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndWelt extends World
{
    private boolean hatGewonnen;
    private int endPunktzahl;

    public EndWelt(boolean ergebnis, int punkte)
    {    
        super(1920, 1080, 1); 
        hatGewonnen = ergebnis;
        endPunktzahl = punkte;
        zeigeErgebnis();
    }

    public void act()
    {
        // Hier könnte man späeter per Tastendruck zurück ins Intro springen
    }

    private void zeigeErgebnis()
    {
        // Überprüfung des Spielzustands
        if (hatGewonnen == true)
        {
            showText("Herzlichen Glueckwunsch! Du hast gewonnen!", 960, 450);
        }
        else
        {
            showText("BOOM! Eine Bombe hat dich erwischt. Verloren!", 960, 450);
        }
        showText("Dein Endstand: " + endPunktzahl + " Punkte", 960, 550);
    }
}