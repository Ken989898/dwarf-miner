import greenfoot.*;  

public class FallendesObjekt extends Actor
{
    public int fallGeschwindigkeit;
    
    public FallendesObjekt()
    {
        // Jedes Objekt fällt zufällig schnell (zwischen 3 und 7 Pixel pro Frame)
        fallGeschwindigkeit = Greenfoot.getRandomNumber(5) + 3;
        
    }

    public void fallen()
    {
        setLocation(getX(), getY() + fallGeschwindigkeit);
    }

    public boolean istAmBoden()
    {
        // Wenn das Objekt ganz unten angekommen ist (Spielfeldhoehe - 280 Pixel) oder (Höhe - 700 und Breite < 250px) oder (Höhe - 700 und Breite zwischen 800 und 1100)
        if (getY() >= getWorld().getHeight() - 280)
        {
            return true;
        }
        else if (getY() >= getWorld().getHeight() - 700 && getX() <= getWorld().getWidth() - 1670)
        {
            return true;
        }
        
        else if ((getY() >= getWorld().getHeight() - 700 && (getX() >= 800 && getX() <= 1100)))
        {
            return true;
        }
     
        return false;
    }

}

