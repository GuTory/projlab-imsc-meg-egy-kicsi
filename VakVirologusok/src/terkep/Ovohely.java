package terkep;

import felszereles.Felszereles;
import virologus.Virologus;

public class Ovohely extends Mezo {

    /**
     * Az óvóhelyen lévő felszerelés
     */
    private Felszereles felszereles;

    public void setFelszereles(Felszereles f){ felszereles = f; }

    public Felszereles getFelszereles(){ return felszereles; }

    /**
     * Az óvóhelyen elvégezhető akció (felszerelés felvétel)
     */
    public void akcio(Virologus virologus){
        if(felszereles != null){ //TODO: esetleg kérdezni?
            virologus.beFelszereles(felszereles);
            felszereles = null;
        }
    }
}
