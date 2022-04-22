package terkep;

import util.Anyagok;
import virologus.Virologus;

/**
 * Raktár mező amiben anyagok vannak
 */
public class Raktar extends Mezo{

    /**
     * A raktárban lévő anyagok
     */
    private Anyagok anyagok;

    public void setAnyagok(Anyagok a){ anyagok = a; }

    public Anyagok getAnyagok(){ return anyagok; }

    /**
     * A raktárban megtehető extra tevékenység: anyag felvétel.
     */
    public void akcio(Virologus virologus) {
        if(virologus.getTaska().anyagBerak(anyagok))
            anyagok = null;
    }

    @Override
    public void tombol() {
        anyagok = null;
    }
}
