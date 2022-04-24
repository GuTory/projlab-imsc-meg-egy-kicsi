package terkep;

import util.Anyagok;
import util.Taska;
import virologus.Virologus;

import java.util.Scanner;

/**
 * Raktár mező amiben anyagok vannak
 */
public class Raktar extends Mezo{

    /**
     * A raktárban lévő anyagok
     */
    private Anyagok anyagok =  new Anyagok(0,0);

    public void setAnyagok(Anyagok a){ anyagok = a; }

    public Anyagok getAnyagok(){ return anyagok; }

    /**
     * A raktárban megtehető extra tevékenység: anyag felvétel.
     */
    public void akcio(Virologus virologus) {
        virologus.getTaska().anyagBerak(anyagok);
    }

    @Override
    public void tombol() {
        anyagok = null;
    }

    @Override
    public String toString(){
        String s ="Raktar: " + TestNev;
        if(anyagok != null && anyagok.meret() > 0) s +=  "\n" + anyagok.toString();
        return s;
    }
}
