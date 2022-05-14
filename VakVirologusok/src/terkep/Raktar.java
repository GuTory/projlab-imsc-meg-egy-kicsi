package terkep;

import util.Anyagok;
import virologus.Virologus;

import java.awt.*;

/**
 * Raktár mező amiben anyagok vannak
 */
public class Raktar extends Mezo{

    /**
     * A raktárban lévő anyagok
     */
    private Anyagok anyagok =  new Anyagok(0,0);

    /**
     * anyagok settere
     * @param a anyag
     */
    public void setAnyagok(Anyagok a){ anyagok = a; }

    /**
     * anyagok gettere
     * @return anyagok
     */
    public Anyagok getAnyagok(){ return anyagok; }

    /**
     * A raktárban megtehető extra tevékenység: anyag felvétel.
     */
    public void akcio(Virologus virologus) {
        if(virologus.getTaska().anyagBerak(anyagok))
            anyagok.clear();
    }

    /**
     * medvevírusos tombol az adott mezőn, azaz elpusztítja az összes anyagot ami a raktárban volt
     */
    @Override
    public void tombol() {
        anyagok = null;
    }

    /**
     * szöveggé alakított raktár a teszteléshez
     * @return Mezo: ID
     * benne lévő anyagok
     */
    @Override
    public String toString(){
        String s ="Raktar: " + TestNev;
        return s;
    }

    @Override
    public String objektumok(){
        String s = "";
        if(anyagok != null && anyagok.meret() > 0) s +=  "\n" + anyagok.toString();
        return s;
    }

    @Override
    public Color color(){
        return new Color(31, 51, 32);
    }

}
