package terkep;

import felszereles.Felszereles;
import lombok.Getter;
import lombok.Setter;
import virologus.Virologus;

public class Ovohely extends Mezo {

    /**
     * Az óvóhelyen lévő felszerelés
     */
    @Setter
    @Getter
    private Felszereles felszereles;


    /**
     * Az óvóhelyen elvégezhető akció (felszerelés felvétel)
     */
    public void akcio(Virologus virologus){
        virologus.beFelszereles(felszereles); //TODO: esetleg kérdezni?
    }
}
